package Empleados.entities;

import Vistas.PanelEmpleados;
import Recursos.DAO.EmpleadoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que realiza las acciones asociadas al PanelEmpleados
 *
 * @author yosua
 */
public class AccionesEmpleado {

    private PanelEmpleados panel;

    /**
     * Constructor de la clase
     *
     * @param panel PanelEmpleado del que manejará los eventos
     */
    public AccionesEmpleado(PanelEmpleados panel) {
        this.panel = panel;
    }

    /**
     * Método para cargar todos los empleados e insertarlos en cmbUsuarios
     */
    public void cargarLoging() {
        //Cargamos la BBDD y la metemos en un ArrayList
        EmpleadoDAO dao = new EmpleadoDAO();
        ArrayList<Empleado> empleados = dao.loadAll();

        for (Empleado empleado : empleados) {
            String usuario = empleado.getNombre() + " "
                    + empleado.getApellido1() + " " + empleado.getApellido2();
            panel.getCmbUsuarios().addItem(usuario);
        }
    }

    /**
     * Método para validar un usuario
     */
    public void usuarioValido() {
        //Cargamos la BBDD y la metemos en un ArrayList
        EmpleadoDAO dao = new EmpleadoDAO();
        ArrayList<Empleado> empleados = dao.loadAll();
        String selectUser = panel.getCmbUsuarios().getSelectedItem().toString();
        for (Empleado empleado : empleados) {
            String user = empleado.getNombre() + " " + empleado.getApellido1()
                    + " " + empleado.getApellido2();
            if (selectUser.equals(user)) {
                if (empleado.getPassword().equals(panel.
                        getPassPassword().getText())) {
                    panel.getPanelLoging().setVisible(false);
                    panel.getFrame().getBarraMenus().setVisible(true);
                    panel.getFrame().setTitle("Empleado=> " + user.trim());
                    panel.getFrame().getLblUsuarioActivo().setText(user.trim());
                } else {
                    JOptionPane.showMessageDialog(panel,
                            "Contraseña no valida");
                }
            }
        }
    }
    
    /**
     * Método para cargar la tabla donde podremos editar todos los empleados
     * menos el admin, que no aparece por seguridad
     */
    public void cargarTabla() {
        //Cargamos la BBDD y la metemos en un ArrayList
        EmpleadoDAO dao = new EmpleadoDAO();
        ArrayList<Empleado> empleados = dao.loadAll();
        //Creamos la tabla y le asignamos los valores
        DefaultTableModel tabla = new DefaultTableModel(new String[]{"NOMBRE",
            "APELLIDO 1", "APELLIDO 2"}, 0) {
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
        //Recorremos el ArrayList y cargamos los elementos en la tabla, menos
        //el usuario admin, que no se permitiran cambios en el
        for (int i = 1; i < empleados.size(); i++) {
            Object[] objeto = new Object[3];
            objeto[0] = empleados.get(i).getNombre();
            objeto[1] = empleados.get(i).getApellido1();
            objeto[2] = empleados.get(i).getApellido2();
            tabla.addRow(objeto);
        }        
        panel.getTablaEmpleados().setModel(tabla);
        panel.getScpTablaEmpleados().setViewportView(panel.getTablaEmpleados());
    }

    /**
     * Método que recupera los valores del formulario, confirma la contraseña y
     * lo añade en la BBDD
     */
    public void guardarEmpleado() {
        String nombre = panel.getTxtNombre().getText().trim();
        String apellido1 = panel.getTxtApellido1().getText().trim();
        String apellido2 = panel.getTxtApellido2().getText().trim();
        String password = panel.getPassPass().getText().trim();
        if (!nombre.isEmpty() && !apellido1.isEmpty() && !apellido2.isEmpty()
                && !password.isEmpty()) {
            if (password.equals(panel.getPassPassConfirm().getText())) {
                EmpleadoDAO dao = new EmpleadoDAO();
                Empleado empleado = dao.insert(nombre, apellido1, apellido2,
                        password);
                cargarTabla();
                panel.getFrameAddEmpleado().dispose();
            } else {
                JOptionPane.showMessageDialog(panel, "Las contraseñas no "
                        + "coinciden");
            }
        } else {
            JOptionPane.showMessageDialog(panel, "Debes rellenar todos los "
                    + "campos");
        }
    }

    /**
     * Método para eliminar a un empleado previamente seleccionado de la tabla
     */
    public void eliminarEmpleado() {
        //Cargamos la BBDD y la metemos en un ArrayList
        EmpleadoDAO dao = new EmpleadoDAO();
        ArrayList<Empleado> empleados = dao.loadAll();
        int seleccion = panel.getTablaEmpleados().getSelectedRow();
        //Comprobamos que haya un elemento selecionado para eliminar
        if (seleccion != -1) {
            //Añadimos 1 a la seleccion para asegurar la integridad de admin
            seleccion++;
            //Cargamos el nombre completo en un String
            String nombre = empleados.get(seleccion).getNombre();
            nombre += " " + empleados.get(seleccion).getApellido1();
            nombre += " " + empleados.get(seleccion).getApellido2();
            //Mostramos un panel de confirmación antes de eliminarlo
            int opcion = JOptionPane.showConfirmDialog(panel, "¿Deseas eliminar"
                    + " a:\n" + nombre + "?", "Eliminar",
                    JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                dao.delete(empleados.get(seleccion));
                cargarTabla();
            }
        }
    }

    /**
     * Método para editar un empleado previamente seleccionado en la tabla
     */
    public void editarEmpleado() {
        //Cargamos la BBDD y la metemos en un ArrayList
        EmpleadoDAO dao = new EmpleadoDAO();
        ArrayList<Empleado> empleados = dao.loadAll();
        int seleccion = panel.getTablaEmpleados().getSelectedRow();
        //Comprobamos que haya un elemento selecionado para eliminar
        if (seleccion != -1) {
            //Añadimos 1 a la seleccion para asegurar la integridad de admin
            seleccion++;
            panel.getTxtNombreEditar().setText(
                    empleados.get(seleccion).getNombre());
            panel.getTxtApellido1Editar().setText(
                    empleados.get(seleccion).getApellido1());
            panel.getTxtApellido2Editar().setText(
                    empleados.get(seleccion).getApellido2());
            panel.getPassPassEditarAntigua().setText("");
            panel.getPassPassEditar().setText("");
            panel.getPassPassEditarConfrim().setText("");
            panel.getFrameEditarEmpleado().setLocationRelativeTo(this.panel);
            panel.getFrameEditarEmpleado().setVisible(true);
        }
    }

    /**
     * Método para guardar los datos modificados de un empleado
     */
    public void guardarModificacion() {
        //Cargamos la BBDD y la metemos en un ArrayList
        EmpleadoDAO dao = new EmpleadoDAO();
        ArrayList<Empleado> empleados = dao.loadAll();
        //Añadimos 1 a la seleccion para asegurar la integridad de admin
        int seleccion = panel.getTablaEmpleados().getSelectedRow() + 1;
        //Creamos un nuevo empleado con los datos modificados
        String nombre = panel.getTxtNombreEditar().getText().trim();
        String apellido1 = panel.getTxtApellido1Editar().getText().trim();
        String apellido2 = panel.getTxtApellido2Editar().getText().trim();
        String passAntigua = panel.getPassPassEditarAntigua().getText().trim();
        String passNueva = panel.getPassPassEditar().getText().trim();
        String passConfirm = panel.getPassPassEditarConfrim().getText().trim();

        if (empleados.get(seleccion).getPassword().equals(passAntigua)) {
            if (!nombre.isEmpty() && !apellido1.isEmpty()
                    && !apellido2.isEmpty() && !passNueva.isEmpty()) {
                if (passNueva.equals(passConfirm)) {
                    empleados.get(seleccion).setNombre(nombre);
                    empleados.get(seleccion).setApellido1(apellido1);
                    empleados.get(seleccion).setApellido2(apellido2);
                    empleados.get(seleccion).setPassword(passConfirm);
                    dao.update(empleados.get(seleccion));
                    cargarTabla();
                    panel.getFrameEditarEmpleado().dispose();
                } else {
                    JOptionPane.showMessageDialog(panel,
                            "Las nuevas contraseñas no coinciden");
                }
            } else {
                JOptionPane.showMessageDialog(panel, "Debes rellenar todos los"
                        + " campos");
            }
        } else {
            JOptionPane.showMessageDialog(panel, "Contraseña antigua invalida");
        }
    }

}
