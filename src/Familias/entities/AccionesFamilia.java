package Familias.entities;

import Recursos.DAO.FamiliaDAO;
import Vistas.PanelFamilias;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que realiza las acciones asociadas al PanelFamilias
 *
 * @author yosua
 */
public class AccionesFamilia {

    private PanelFamilias panel;

    /**
     * Constructor de la clase
     *
     * @param panel PanelFamilias del que manejará los eventos
     */
    public AccionesFamilia(PanelFamilias panel) {
        this.panel = panel;
    }

    /**
     * Método para cargar la tabla donde aparecerán las familias y poder
     * editarlas
     */
    public void cargarTabla() {
        //Cargamos la BBDD y la metemos en un ArrayList
        FamiliaDAO dao = new FamiliaDAO();
        ArrayList<Familia> familias = dao.loadAll();
        //Creamos la tabla y le asignamos los valores
        DefaultTableModel tabla
                = new DefaultTableModel(new String[]{"FAMILIA"}, 0) {
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
        for (Familia familia : familias) {
            Object[] objeto = new Object[1];
            objeto[0] = familia.getFamilia();
            tabla.addRow(objeto);
        }
        panel.getTablaFamilias().setModel(tabla);
        panel.getScpTablaFamilias().setViewportView(panel.getTablaFamilias());
    }

    /**
     * Método para buscar una imagen para el icono de la familia
     */
    public void buscarIcono() {
        //Creamos un JFileChooser y le establecemos una ruta por defecto
        //y añadimos los filtros para seleccionar solo imagenes
        JFileChooser buscar = new JFileChooser("./src/Iconos/imagenes");
        buscar.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, GIF "
                + "& PNG", "jpg", "gif", "png");
        buscar.setFileFilter(filtro);

        int resultado = buscar.showOpenDialog(panel);
        if (resultado != JFileChooser.CANCEL_OPTION) {
            String icono = buscar.getSelectedFile().getPath();
            panel.getTxtRutaIcono().setText(icono);
            panel.getLblMostrar().setIcon(new ImageIcon(icono));
            panel.getTxtRutaIconoEditar().setText(icono);
            panel.getLblMostrarEditar().setIcon(new ImageIcon(icono));
        }
    }

    /**
     * Método que recupera los valores del formulario y lo añade a la BBDD
     */
    public void guardarFamilia() {
        String familia = panel.getTxtNombre().getText().trim();
        String icono = panel.getTxtRutaIcono().getText().trim();

        if (!familia.isEmpty()) {
            FamiliaDAO dao = new FamiliaDAO();
            Familia family = dao.insert(familia, icono);
            cargarTabla();
            panel.getFrameAddFamilia().dispose();
        } else {
            JOptionPane.showMessageDialog(panel, "Debes introducir"
                    + " un nombre para la familia");
        }
    }

    /**
     * Método para eliminar una familia previamente seleccionada de la tabla
     */
    public void eliminarFamilia() {
        //Cargamos la BBDD y la metemos en un ArrayList
        FamiliaDAO dao = new FamiliaDAO();
        ArrayList<Familia> familias = dao.loadAll();
        int seleccion = panel.getTablaFamilias().getSelectedRow();
        //Comprobamos que haya un elemento seleccionado para eliminar
        if (seleccion != -1) {
            String familia = familias.get(seleccion).getFamilia();

            int opcion = JOptionPane.showConfirmDialog(panel, "¿Deseas eliminar"
                    + " la familia:\n" + familia + "?", "Eliminar",
                    JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                dao.delete(familias.get(seleccion));
                cargarTabla();
            }
        }
    }

    /**
     * Método para editar una familia previamente seleccionado en la tabla
     */
    public void editarFamilia() {
        //Cargamos la BBDD y la metemos en un ArrayList
        FamiliaDAO dao = new FamiliaDAO();
        ArrayList<Familia> familias = dao.loadAll();
        int seleccion = panel.getTablaFamilias().getSelectedRow();
        //Comprobamos que haya un elemento seleccionado para editar
        if (seleccion != -1) {
            panel.getTxtNombreEditar().setText(familias.get(seleccion).
                    getFamilia());
            panel.getTxtRutaIconoEditar().setText(familias.get(seleccion).
                    getIcono());
            panel.getLblMostrarEditar().setIcon(
                    new ImageIcon(familias.get(seleccion).getIcono()));
            panel.getFrameEditarFamilia().setLocationRelativeTo(this.panel);
            panel.getFrameEditarFamilia().setVisible(true);
        }
    }

    /**
     * Método para guardar los datos modificados de una familia
     */
    public void guardarModificacion() {
        //Cargamos la BBDD y la metemos en un ArrayList
        FamiliaDAO dao = new FamiliaDAO();
        ArrayList<Familia> familias = dao.loadAll();
        int seleccion = panel.getTablaFamilias().getSelectedRow();
        String familia = panel.getTxtNombreEditar().getText().trim();
        String icono = panel.getTxtRutaIconoEditar().getText().trim();
        if (!familia.isEmpty()) {
            familias.get(seleccion).setFamilia(familia);
            familias.get(seleccion).setIcono(icono);
            dao.update(familias.get(seleccion));
            cargarTabla();
            panel.getFrameEditarFamilia().dispose();
        } else {
            JOptionPane.showMessageDialog(panel, "Debes introducir un nombre "
                    + "para la familia");
        }
    }

}
