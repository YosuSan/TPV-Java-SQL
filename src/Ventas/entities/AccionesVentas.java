package Ventas.entities;

import Clientes.entities.Cliente;
import Empleados.entities.Empleado;
import Facturas.entities.Factura;
import Familias.entities.Familia;
import Productos.entities.Producto;
import Recursos.DAO.ClienteDAO;
import Recursos.DAO.EmpleadoDAO;
import Recursos.DAO.FacturaDAO;
import Recursos.DAO.FamiliaDAO;
import Recursos.DAO.ProductoDAO;
import Vistas.PanelVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que realiza las acciones asociadas al PanelVentas
 *
 * @author yosua
 */
public class AccionesVentas {

    private PanelVentas panel;
    private DefaultTableModel tabla;

    /**
     * Constructor de la clase
     *
     * @param panel PanelVentas del que manejará los eventos
     */
    public AccionesVentas(PanelVentas panel) {
        this.panel = panel;
    }

    /**
     * Método que carga los la tabla donde aparecerán todos los productos que se
     * vayan añadiendo
     */
    public void cargarTablaCuenta() {
        tabla = new DefaultTableModel(new String[]{"CANTIDAD", "PRODUCTO",
            "PRECIO", "TOTAL"}, 0) {
            /**
             * Sobrecarga del metodo isCellEditable para que no se pueda
             * escribir sobre la tabla de clientes
             *
             * @param row int
             * @param column int
             * @return boolean false
             */
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        panel.getTablaCuenta().setModel(tabla);
        panel.getScpTablaCuenta().setViewportView(panel.getTablaCuenta());
    }

    /**
     * Método para cargar las familias y mostrarlas en botones
     */
    public void cargarFamilia() {
        //Cargamos la BBDD y la metemos en un ArrayList
        FamiliaDAO dao = new FamiliaDAO();
        ArrayList<Familia> familias = dao.loadAll();
        for (Familia familia : familias) {
            String nombre = familia.getFamilia();
            String icono = familia.getIcono();
            //Creamos un botón por cada familia, asignandole los iconos y/o 
            //texto y un listener
            JButton btnFamilia;
            if (!icono.isEmpty()) {
                btnFamilia = new JButton();
                btnFamilia.setIcon(new ImageIcon(icono));
                btnFamilia.setVerticalAlignment(AbstractButton.TOP);
                btnFamilia.setText(nombre);
                btnFamilia.setVerticalTextPosition(AbstractButton.BOTTOM);
                btnFamilia.setHorizontalTextPosition(AbstractButton.CENTER);
            } else {
                btnFamilia = new JButton(nombre);
            }
            btnFamilia.setSize(85, 85);
            btnFamilia.setToolTipText(nombre);
            btnFamilia.setVisible(true);
            btnFamilia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    cargarProductos(nombre);
                }
            });
            panel.getPanelBtnFamilia().add(btnFamilia);
        }
        //Rellenamos el panel restante con botones invisibles para dar 
        //apaciencia de cuadricula
        for (int i = familias.size(); i < 18; i++) {
            JButton btnVacio = new JButton();
            btnVacio.setVisible(false);
            panel.getPanelBtnFamilia().add(btnVacio);
        }
    }

    /**
     * Método para cargar los productos de la familia seleccionada
     *
     * @param familia String
     */
    private void cargarProductos(String familia) {
        //Limpiamos el panel
        panel.getPanelBtnProductos().removeAll();
        //Cargamos la BBDD y la metemos en un ArrayList
        ProductoDAO dao = new ProductoDAO();
        ArrayList<Producto> productos = dao.loadAll();
        int longitud = 0;
        //Recorremos el ArrayList buscando los productos de la familia        
        for (Producto producto : productos) {
            if (producto.getFamilia().equals(familia)) {
                String nombre = producto.getNombre();
                String icono = producto.getIcono();
                int id = producto.getId();
                //Creamos un botón por cada producto, asignandole los iconos y/o 
                //texto y un listener   
                JButton btnProducto;
                if (!icono.isEmpty()) {
                    btnProducto = new JButton(new ImageIcon(icono));
                    btnProducto.setVerticalAlignment(AbstractButton.TOP);
                    btnProducto.setText(nombre);
                    btnProducto.setVerticalTextPosition(AbstractButton.BOTTOM);
                    btnProducto.setHorizontalTextPosition(AbstractButton.CENTER);
                } else {
                    btnProducto = new JButton(nombre);
                }
                btnProducto.setSize(85, 85);
                btnProducto.setToolTipText(nombre);
                btnProducto.setVisible(true);
                btnProducto.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        introducirCantidad(id);
                    }
                });
                panel.getPanelBtnProductos().add(btnProducto);
                longitud++;
            }
        }
        //Rellenamos el panel restante con botones invisibles para dar 
        //apaciencia de cuadricula
        for (int i = longitud; i < 45; i++) {
            JButton btnVacio = new JButton();
            btnVacio.setVisible(false);
            panel.getPanelBtnProductos().add(btnVacio);
        }
        panel.getPanelBtnProductos().setVisible(false);
        panel.getPanelBtnProductos().setVisible(true);
    }

    /**
     * Método para añadir un producto a la tabla de ventas
     *
     * @param id int del producto
     */
    private void aniadirProducto(int id, float cantidad) {
        //Cargamos la BBDD y la metemos en un ArrayList
        ProductoDAO dao = new ProductoDAO();
        ArrayList<Producto> productos = dao.loadAll();
        //Recorremos el ArrayList buscando los productos de la familia        
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                float precio = (float) cantidad * producto.getPrecio();
                float redondeado = new BigDecimal(precio).
                        setScale(2, RoundingMode.HALF_EVEN).floatValue();
                Object[] objeto = new Object[4];
                objeto[0] = cantidad;
                objeto[1] = producto.getNombre();
                objeto[2] = producto.getPrecio();
                objeto[3] = redondeado;
                tabla.addRow(objeto);
            }
        }
        panel.getTablaCuenta().setModel(tabla);
        panel.getScpTablaCuenta().setViewportView(panel.getTablaCuenta());
    }

    /**
     * Método para capturar la cantidad de producto comprado
     *
     * @param id int
     */
    private void introducirCantidad(int id) {
        panel.getSpnCantidades().setValue(1);
        panel.getDiagCantidades().setLocationRelativeTo(panel);
        panel.getDiagCantidades().setVisible(true);
        panel.getBtnCantidadesAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel.getDiagCantidades().dispose();
                float cantidad = Float.valueOf(panel.getSpnCantidades()
                        .getValue().toString());
                aniadirProducto(id, cantidad);
                setTotal();
                panel.getBtnCantidadesAceptar().removeActionListener(this);
            }
        });
    }

    /**
     * Método para vaciar la cuenta
     */
    public void vaciarCuenta() {
        while (panel.getTablaCuenta().getRowCount() > 0) {
            tabla.removeRow(0);
        }
        setTotal();
    }

    /**
     * Método para mostrar el total de la cuenta
     */
    private void setTotal() {
        float total = 0;
        int descuento
                = Integer.valueOf(panel.getLblMostrarDescuento().getText());
        for (int i = 0; i < panel.getTablaCuenta().getRowCount(); i++) {
            total += (float) tabla.getValueAt(i, 3);
        }
        total = total - (total * descuento / 100);
        float redondeado = new BigDecimal(total).
                setScale(2, RoundingMode.HALF_EVEN).floatValue();
        panel.getLblPrecioTotal().setText("" + redondeado);
    }

    /**
     * Método para eliminar un producto de la cuenta
     */
    public void eliminarFila() {
        int seleccion = panel.getTablaCuenta().getSelectedRow();
        if (seleccion != -1) {
            tabla.removeRow(seleccion);
            setTotal();
        }
    }

    /**
     * Método para cargar todos los empleados e insertarlos en cmbVendedores
     */
    public void cargarVendedores() {
        //Cargamos la BBDD y la metemos en un ArrayList
        EmpleadoDAO dao = new EmpleadoDAO();
        ArrayList<Empleado> empleados = dao.loadAll();
        for (Empleado empleado : empleados) {
            String usuario = empleado.getNombre() + " "
                    + empleado.getApellido1() + " " + empleado.getApellido2();
            panel.getCmbVendedores().addItem(usuario);
        }
    }

    /**
     * Método para cargar los clientes en el cmbClientes
     */
    public void cargarClientes() {
        //Cargamos la BBDD y la metemos en un ArrayList
        ClienteDAO dao = new ClienteDAO();
        ArrayList<Cliente> clientes = dao.loadAll();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (Cliente cliente : clientes) {
            String nombre = cliente.getNombre() + " " + cliente.getApellidos();
            modelo.addElement(nombre);
        }
        panel.getCmbCliente().setModel(modelo);
        //Establecemos a "Cliente" como cliente por defecto
        panel.getCmbCliente().setSelectedItem("Cliente");
        cargarDescuento();
    }

    /**
     * Método para cargar y mostrar el descuento asigando al cliente
     */
    public void cargarDescuento() {
        //Cargamos la BBDD y la metemos en un ArrayList
        ClienteDAO dao = new ClienteDAO();
        ArrayList<Cliente> clientes = dao.loadAll();
        int seleccion = panel.getCmbCliente().getSelectedIndex();
        int descuento = clientes.get(seleccion).getDescuento();
        panel.getLblMostrarDescuento().setText("" + descuento);
        setTotal();
    }

    /**
     * Método para asignar si la venta es en barra o en una mesa
     */
    public void cargarBarraMesas() {
        panel.getLblBarraMesa().setText("BARRA");
        panel.getRbtnBarra().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel.getSpnMesas().setEnabled(false);
                panel.getLblBarraMesa().setText("BARRA");
            }
        });
        panel.getRbtnMesas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel.getSpnMesas().setEnabled(true);
                panel.getSpnMesas().setValue(1);
                panel.getLblBarraMesa().setText("MESA: " + panel.getSpnMesas().
                        getValue().toString());
            }
        });
        panel.getSpnMesas().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                panel.getLblBarraMesa().setText("MESA: " + panel.getSpnMesas().
                        getValue().toString());
            }
        });
    }

    /**
     * Método para cargar el último numero de factura y mostrarlo
     */
    public void cargarNumeroFactura() {
        FacturaDAO dao = new FacturaDAO();
        ArrayList<Factura> facturas = dao.loadAll();
        int numero = 1;
        if (!facturas.isEmpty()) {
            numero = facturas.get(facturas.size() - 1).getId() + 1;
        }
        panel.getLblFactura().setText("" + numero);
    }

    /**
     * Método para generar una factura con los datos actuales en el TPV
     *
     * @return String con la factura generada
     */
    public String generarFactura() {
        String factura = "";
        factura += "Factura Nº: " + panel.getLblFactura().getText() + "\n";
        factura += "Fecha: " + generarFecha() + "\n";
        factura += "Vendedor: " + panel.getCmbVendedores().getSelectedItem().
                toString() + "\n";
        factura += "Cliente: " + panel.getCmbCliente().getSelectedItem().
                toString() + "\n";
        factura += panel.getLblBarraMesa().getText() + "\n\n";
        factura += "Cantidad \t\t Producto \t\t Precio \t\t Total\n";
        factura += "------------------------\n";
        for (int i = 0; i < tabla.getRowCount(); i++) {
            factura += tabla.getValueAt(i, 0).toString() + "\t\t ";
            factura += tabla.getValueAt(i, 1).toString() + "\t\t ";
            factura += tabla.getValueAt(i, 2).toString() + "\t\t ";
            factura += tabla.getValueAt(i, 3).toString() + "\n\n";
        }
        factura += "------------------------\n";
        factura += "Descuento: " + panel.getLblMostrarDescuento().getText()
                + "%\n";
        factura += "Total: " + panel.getLblPrecioTotal().getText();

        return factura;
    }

    /**
     * Método para generar la fecha actual para la factura
     *
     * @return
     */
    public String generarFecha() {
        GregorianCalendar calendario = new GregorianCalendar();
        String fecha = "";
        fecha += calendario.get(GregorianCalendar.DAY_OF_MONTH) + "/";
        fecha += calendario.get(GregorianCalendar.MONTH) + 1 + "/";
        fecha += calendario.get(GregorianCalendar.YEAR);

        return fecha;
    }

    /**
     * Método para guardar la factura generada en la BBDD
     */
    public void guardarFactura() {
        String vendedor = panel.getCmbVendedores().getSelectedItem().toString();
        String cliente = panel.getCmbCliente().getSelectedItem().toString();
        String fecha = generarFecha();
        String factura = generarFactura();

        if (tabla.getRowCount() > 0) {
            FacturaDAO dao = new FacturaDAO();
            Factura fact = dao.insert(vendedor, cliente, fecha, factura);
            cargarNumeroFactura();
            vaciarCuenta();
            cargarClientes();
        }
    }

}
