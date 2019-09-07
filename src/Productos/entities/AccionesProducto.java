package Productos.entities;

import Familias.entities.Familia;
import Recursos.DAO.FamiliaDAO;
import Recursos.DAO.ProductoDAO;
import Vistas.PanelProductos;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que realiza las acciones asociadas al PanelProductos
 *
 * @author yosua
 */
public class AccionesProducto {

    private PanelProductos panel;

    /**
     * Constructor de la clase
     *
     * @param panel PanelProductos del que manejara los eventos
     */
    public AccionesProducto(PanelProductos panel) {
        this.panel = panel;
    }

    /**
     * Método que carga la tabla donde aparecerán los productos para poder
     * editarlos
     */
    public void cargarTabla() {
        //Cargamos la BBDD y la metemos en un ArrayList
        ProductoDAO dao = new ProductoDAO();
        ArrayList<Producto> productos = dao.loadAll();
        //Creamos la tabla y le asignamos los valores
        DefaultTableModel tabla
                = new DefaultTableModel(new String[]{"FAMILIA", "PRODUCTO",
            "PRECIO"}, 0) {
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
        //Recorremos el ArrayList y lo cargamos en la tabla
        for (Producto producto : productos) {
            Object[] objeto = new Object[3];
            objeto[0] = producto.getFamilia();
            objeto[1] = producto.getNombre();
            objeto[2] = producto.getPrecio();
            tabla.addRow(objeto);
        }
        panel.getTablaProductos().setModel(tabla);
        panel.getScpTablaProductos().setViewportView(panel.getTablaProductos());
    }

    /**
     * Método para cargar las familias en cmbFamilias
     */
    public void cargarFamilias() {
        //Cargamos la BBDD y la metemos en un ArrayList
        FamiliaDAO dao = new FamiliaDAO();
        ArrayList<Familia> familias = dao.loadAll();

        for (Familia familia : familias) {
            panel.getCmbFamilia().addItem(familia.getFamilia());
            panel.getCmbFamiliaEditar().addItem(familia.getFamilia());
        }
    }

    /**
     * Método para buscar una imagen para el icono de la familia
     */
    public void buscarIcono() {
        JFileChooser buscar = new JFileChooser("./src/Iconos/imagenes");
        buscar.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, GIF "
                + "& PNG", "jpg", "gif", "png");
        buscar.setFileFilter(filtro);

        int resultado = buscar.showOpenDialog(panel);
        if (resultado != JFileChooser.CANCEL_OPTION) {
            String icono = buscar.getSelectedFile().getPath();
            panel.getTxtRutaIcono().setText(icono);
            panel.getLblMostrarIcono().setIcon(new ImageIcon(icono));
            panel.getTxtRutaIconoEditar().setText(icono);
            panel.getLblMostrarIconoEditar().setIcon(new ImageIcon(icono));
        }
    }

    /**
     * Método para capturar el precio y capturar posibles excepciones
     *
     * @param precioString String precioString
     * @return float precio
     */
    private float capturaPrecio(String precioString) {
        float precio = 0.0f;
        try {
            precio = Float.parseFloat(precioString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panel, "El precio ha de ser un valor"
                    + " númerico separado por un punto.");
        }
        return precio;
    }
    
    /**
     * Método que recupera los valores del formulario y los añade a la BBDD
     */
    public void guardarProducto() {
        String familia = panel.getCmbFamilia().getSelectedItem().toString();
        String nombre = panel.getTxtNombre().getText().trim();
        float precio = capturaPrecio(panel.getTxtPrecio().getText().trim());
        String icono = panel.getTxtRutaIcono().getText().trim();

        if (!nombre.isEmpty()) {
            if (precio > 0) {
                ProductoDAO dao = new ProductoDAO();
                Producto producto = dao.insert(familia, nombre, precio,
                        icono);
                cargarTabla();
                panel.getFrameAddProducto().dispose();
            } else {
                JOptionPane.showMessageDialog(panel, "El precio debe ser "
                        + "mayor que 0");
            }
        } else {
            JOptionPane.showMessageDialog(panel, "Debes introducir un "
                    + "nombre para el producto");
        }
    }

    /**
     * Método para eliminar un producto previamente seleccionado de la tabla
     */
    public void eliminarProducto() {
        //Cargamos la BBDD y la metemos en un ArrayList
        ProductoDAO dao = new ProductoDAO();
        ArrayList<Producto> productos = dao.loadAll();
        int seleccion = panel.getTablaProductos().getSelectedRow();
        //Comprobamos que haya un elemento seleccionado para eliminar
        if (seleccion != -1) {
            String producto = productos.get(seleccion).getNombre();
            int opcion = JOptionPane.showConfirmDialog(panel, "¿Deseas eliminar"
                    + " el producto:\n" + producto + "?");
            if (opcion == JOptionPane.YES_OPTION) {
                dao.delete(productos.get(seleccion));
                cargarTabla();
            }
        }
    }

    /**
     * Método para editar una familia previamente seleccionada de la tabla
     */
    public void editarProducto() {
        //Cargamos la BBDD y la metemos en un ArrayList
        ProductoDAO dao = new ProductoDAO();
        ArrayList<Producto> productos = dao.loadAll();
        int seleccion = panel.getTablaProductos().getSelectedRow();
        //Comprobamos si hay un elemento seleccionado para editar
        if (seleccion != -1) {
            panel.getCmbFamiliaEditar().setSelectedItem(productos.
                    get(seleccion).getFamilia());
            panel.getTxtNombreEditar().setText(productos.get(seleccion).
                    getNombre());
            panel.getTxtPrecioEditar().setText("" + productos.get(seleccion).
                    getPrecio());
            panel.getTxtRutaIconoEditar().setText(productos.get(seleccion).
                    getIcono());
            panel.getLblMostrarIconoEditar().setIcon(
                    new ImageIcon(productos.get(seleccion).getIcono()));
            panel.getFrameEditarProducto().setLocationRelativeTo(this.panel);
            panel.getFrameEditarProducto().setVisible(true);
        }
    }

    /**
     * Método para guardar los datos modificados de un producto
     */
    public void guardarModificacion() {
        //Cargamos la BBDD y la metemos en un ArrayList
        ProductoDAO dao = new ProductoDAO();
        ArrayList<Producto> productos = dao.loadAll();
        int seleccion = panel.getTablaProductos().getSelectedRow();
        String familia = panel.getCmbFamiliaEditar().getSelectedItem().
                toString();
        String nombre = panel.getTxtNombreEditar().getText().trim();
        float precio = capturaPrecio(panel.getTxtPrecioEditar().getText().
                trim());
        String icono = panel.getTxtRutaIconoEditar().getText().trim();

        if (!nombre.isEmpty()) {
            if (precio > 0) {
                productos.get(seleccion).setFamilia(familia);
                productos.get(seleccion).setNombre(nombre);
                productos.get(seleccion).setPrecio(precio);
                productos.get(seleccion).setIcono(icono);
                dao.update(productos.get(seleccion));
                cargarTabla();
                panel.getFrameEditarProducto().dispose();
            } else {
                JOptionPane.showMessageDialog(panel, "El precio debe ser "
                        + "mayor que 0");
            }
        } else {
            JOptionPane.showMessageDialog(panel, "Debes introducir un "
                    + "nombre para el producto");
        }

    }

}
