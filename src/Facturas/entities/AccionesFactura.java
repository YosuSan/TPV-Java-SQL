package Facturas.entities;

import Recursos.DAO.FacturaDAO;
import Vistas.PanelFacturas;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que realiza las acciones asociadas al PanelFacturas
 * 
 * @author yosua
 */
public class AccionesFactura {

    private PanelFacturas panel;
    //Creamos la tabla y le asignamos los valores 
    private DefaultTableModel tabla
            = new DefaultTableModel(new String[]{"Nº FACTURA", "CLIENTE",
        "FECHA"}, 0) {
        /**
         * Sobrecarga del metodo isCellEditable para que no se pueda escribir
         * sobre la tabla de clientes
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

    /**
     * Constructor de la clase
     *
     * @param panel PanelFactura del que manejará los eventos
     */
    public AccionesFactura(PanelFacturas panel) {
        this.panel = panel;
    }

    /**
     * Método que carga la tabla donde aparecerán todas las facturas
     */
    public void cargarTabla() {
        vaciarTabla();
        //Cargamos la BBDD y la metemos en un ArrayList
        FacturaDAO dao = new FacturaDAO();
        ArrayList<Factura> facturas = dao.loadAll();
        //Recorremos el ArrayList y lo cargamos en la tabla
        for (Factura factura : facturas) {
            Object[] objeto = new Object[3];
            objeto[0] = factura.getId();
            objeto[1] = factura.getCliente();
            objeto[2] = factura.getFecha();
            tabla.addRow(objeto);
        }
        panel.getTablaFacturas().setModel(tabla);
        panel.getScpTablaFacturas().setViewportView(panel.getTablaFacturas());
    }

    /**
     * Método para vaciar la tabla
     */
    private void vaciarTabla() {
        while (tabla.getRowCount() > 0) {
            tabla.removeRow(0);
        }
    }

    /**
     * Método para eliminar un producto previamente seleccionado de la tabla
     */
    public void eliminarFactura() {
        //Cargamos la BBDD y la metemos en un ArrayList
        FacturaDAO dao = new FacturaDAO();
        ArrayList<Factura> facturas = dao.loadAll();
        int seleccion = panel.getTablaFacturas().getSelectedRow();
        //Comprobamos que haya un elemento seleccionado
        if (seleccion != -1) {
            int numero = (int) panel.getTablaFacturas().getValueAt(seleccion, 0);
            for (Factura factura : facturas) {
                if (numero == factura.getId()) {
                    int opcion = JOptionPane.showConfirmDialog(panel,
                            "¿Deseas eliminar la factura Nº " + numero + "?");
                    if (opcion == JOptionPane.YES_OPTION) {
                        dao.delete(factura);
                        cargarTabla();
                    }
                }
            }
        }
    }

    /**
     * Método para mostrar la factura seleccionada
     */
    public void mostrarFactura() {
        //Cargamos la BBDD y la cargamos en un ArrayList
        FacturaDAO dao = new FacturaDAO();
        ArrayList<Factura> facturas = dao.loadAll();
        int seleccion = panel.getTablaFacturas().getSelectedRow();

        //Comprobamos que haya un elemento seleccionado
        if (seleccion != -1) {
            int numero = (int) panel.getTablaFacturas().getValueAt(seleccion, 0);
            for (Factura factura : facturas) {
                if (numero == factura.getId()) {
                    panel.getTxtAreaFactura().setText("");
                    panel.getTxtAreaFactura().setText(factura.
                            getFactura());
                    panel.getTxtAreaFactura().setEditable(false);
                    panel.getScpTxtAreaFactura().setViewportView(panel.
                            getTxtAreaFactura());
                    panel.getFrameFactura().setTitle("Factura Nº "
                            + factura.getId());
                    panel.getFrameFactura().setLocationRelativeTo(null);
                    panel.getFrameFactura().setVisible(true);
                }
            }
        }
    }

    /**
     * Método para restablecer los valores de busqueda
     */
    public void resetearValoresBusqueda() {
        panel.getTxtNombreBuscar().setText("");
        panel.getTxtApellidosBuscar().setText("");
        panel.getSpnDia().setValue(1);
        panel.getSpnMes().setValue(1);
        panel.getSpnAnio().setValue(2019);
    }

    /**
     * Método que busca por el nombre del cliente sus facturas en la BBDD
     */
    public void buscarNombre() {
        //Cargamos la base de datos y creamos un ArrayList con los datos 
        //buscados
        FacturaDAO dao = new FacturaDAO();
        String nombre = panel.getTxtNombreBuscar().getText() + " ";
        nombre += panel.getTxtApellidosBuscar().getText();
        ArrayList<Factura> facturas = dao.search(FacturaDAO.CLIENTE_CRITERIA,
                nombre);
        vaciarTabla();
        //Recorremos el ArrayList y lo cargamos en la tabla
        for (Factura factura : facturas) {
            Object[] objeto = new Object[3];
            objeto[0] = factura.getId();
            objeto[1] = factura.getCliente();
            objeto[2] = factura.getFecha();
            tabla.addRow(objeto);
        }
        panel.getTablaFacturas().setModel(tabla);
        panel.getScpTablaFacturas().setViewportView(panel.getTablaFacturas());
    }

    /**
     * Método que busca las facturas emitidas en un día concreto
     */
    public void buscarFecha() {
        //Cargamos la base de datos y creamos un ArrayList con los datos 
        //buscados
        FacturaDAO dao = new FacturaDAO();
        String fecha = panel.getSpnDia().getValue().toString() + "/";
        fecha += panel.getSpnMes().getValue().toString() + "/";
        fecha += panel.getSpnAnio().getValue().toString();
        ArrayList<Factura> facturas = dao.search(FacturaDAO.FECHA_CRITERIA,
                fecha);
        vaciarTabla();
        //Recorremos el ArrayList y lo cargamos en la tabla
        for (Factura factura : facturas) {
            Object[] objeto = new Object[3];
            objeto[0] = factura.getId();
            objeto[1] = factura.getCliente();
            objeto[2] = factura.getFecha();
            tabla.addRow(objeto);
        }
        panel.getTablaFacturas().setModel(tabla);
        panel.getScpTablaFacturas().setViewportView(panel.getTablaFacturas());
    }

}
