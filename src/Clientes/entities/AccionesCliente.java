package Clientes.entities;

import Recursos.DAO.ClienteDAO;
import Vistas.FrameClientes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que realiza las acciones asociadas al FrameCliente
 *
 * @author yosua
 */
public class AccionesCliente {

    private FrameClientes frame;

    /**
     * Constructor de la clase
     *
     * @param frame FrameCliente del que manejará los eventos
     */
    public AccionesCliente(FrameClientes frame) {
        this.frame = frame;
    }

    /**
     * Método para cargar todos los clientes en una tabla
     */
    public void cargarTabla() {
        //Cargamos la BBDD y la metemos en un ArrayList
        ClienteDAO dao = new ClienteDAO();
        ArrayList<Cliente> clientes = dao.loadAll();
        //Creamos la tabla y le asginamos los valores
        DefaultTableModel tabla = new DefaultTableModel(new String[]{"NOMBRE",
            "APELLIDOS", "DNI", "TELEFONO", "DESCUENTO"}, 0) {
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
        //Recorremos el ArrayList y lo cargamos en la tabla menos el Cliente
        //por defecto
        for (int i = 1; i < clientes.size(); i++) {
            Object[] objeto = new Object[5];
            objeto[0] = clientes.get(i).getNombre();
            objeto[1] = clientes.get(i).getApellidos();
            objeto[2] = clientes.get(i).getDNI();
            objeto[3] = clientes.get(i).getTelefono();
            objeto[4] = clientes.get(i).getDescuento();
            tabla.addRow(objeto);
        }
        frame.getTablaClientes().setModel(tabla);
        frame.getScpTablaClientes().setViewportView(frame.getTablaClientes());
    }

    /**
     * Método para capturar el telefono y capturar posibles excepciones
     *
     * @param numeroString String numeroString
     * @return int telefono
     */
    private int capturaNumero(String numeroString) {
        int telefono = 0;
        if (!numeroString.isEmpty()) {
            try {
                telefono = Integer.parseInt(numeroString);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "El télefono debe estar "
                        + "formado solo por números");
            }
        }
        return telefono;
    }

    /**
     * Método que recupera los valores del formulario y los añade a la BBDD
     */
    public void guardarCliente() {
        String nombre = frame.getTxtNombre().getText().trim();
        String apellidos = frame.getTxtApellidos().getText().trim();
        String DNI = validarDNI(frame.getTxtDNI().getText().trim());
        int telefono = capturaNumero(frame.getTxtTelefono().getText().trim());
        int descuento = (int) frame.getSpnDescuento().getValue();
        if (!nombre.isEmpty() && !apellidos.isEmpty()) {
            if(!DNI.isEmpty()){
                ClienteDAO dao = new ClienteDAO();
            Cliente cliente = dao.insert(nombre, apellidos, DNI, telefono,
                    descuento);
            cargarTabla();
            frame.getDiagAddCliente().dispose();
            }            
        } else {
            JOptionPane.showMessageDialog(frame, "El cliente ha de tener "
                    + "nombre y apellidos");
        }
    }

    /**
     * Método para eliminar un cliente previamente seleccionado de la tabla
     */
    public void eliminarCliente() {
        //Cargamos la BBDD y la metemos en un ArrayList
        ClienteDAO dao = new ClienteDAO();
        ArrayList<Cliente> clientes = dao.loadAll();
        int seleccion = frame.getTablaClientes().getSelectedRow();
        //Comprobamos que haya un elemento seleccionado
        if (seleccion != -1) {
            //Añadimos 1 a la seleccion para asegurar al Cliente por defecto
            seleccion++;
            String nombre = clientes.get(seleccion).getNombre() + " "
                    + clientes.get(seleccion).getApellidos();
            int opcion = JOptionPane.showConfirmDialog(frame, "¿Deseas "
                    + "eliminar a:\n" + nombre + "?");
            if (opcion == JOptionPane.YES_OPTION) {
                dao.delete(clientes.get(seleccion));
                cargarTabla();
            }
        }
    }

    /**
     * Método para editar un cliente previamente seleccionado de la tabla
     */
    public void editarCliente() {
        //Cargamos la BBDD y la metemos en un ArrayList
        ClienteDAO dao = new ClienteDAO();
        ArrayList<Cliente> clientes = dao.loadAll();
        int seleccion = frame.getTablaClientes().getSelectedRow();
        //Comprobamos que haya un elemento seleccionado
        if (seleccion != -1) {
            //Añadimos 1 a la seleccion para asegurar al Cliente por defecto
            seleccion++;
            frame.getTxtNombreEditar().setText(clientes.
                    get(seleccion).getNombre());
            frame.getTxtApellidosEditar().setText(clientes.
                    get(seleccion).getApellidos());
            frame.getTxtDNIEditar().setText(clientes.get(seleccion).getDNI());
            frame.getTxtTelefonoEditar().setText("" + clientes.
                    get(seleccion).getTelefono());
            frame.getSpnDescuentoEditar().setValue(clientes.
                    get(seleccion).getDescuento());
            frame.getDiagEditarCliente().setLocationRelativeTo(this.frame);
            frame.getDiagEditarCliente().setVisible(true);
        }
    }

    /**
     * Método para guardar los datos modificados de un cliente
     */
    public void guardarModificacion() {
        //Cargamos la BBDD y la metemos en un ArrayList
        ClienteDAO dao = new ClienteDAO();
        ArrayList<Cliente> clientes = dao.loadAll();
        int seleccion = frame.getTablaClientes().getSelectedRow() + 1;
        String nombre = frame.getTxtNombreEditar().getText().trim();
        String apellidos = frame.getTxtApellidosEditar().getText().trim();
        String DNI = validarDNI(frame.getTxtDNIEditar().getText().trim());
        int telefono = capturaNumero(frame.getTxtTelefonoEditar().
                getText().trim());
        int descuento = (int) frame.getSpnDescuentoEditar().getValue();
        if (!nombre.isEmpty() && !apellidos.isEmpty()) {
            if(!DNI.isEmpty()){
                clientes.get(seleccion).setNombre(nombre);
                clientes.get(seleccion).setApellidos(apellidos);
                clientes.get(seleccion).setDNI(DNI);
                clientes.get(seleccion).setTelefono(telefono);
                clientes.get(seleccion).setDescuento(descuento);
                dao.update(clientes.get(seleccion));
                cargarTabla();
                frame.getDiagEditarCliente().dispose();
            }                    
        } else {
            JOptionPane.showMessageDialog(frame, "El cliente ha de tener "
                    + "nombre y apellidos");
        }
    }

    /**
     * Método para comprobar la validez del DNI introducido
     *
     * @param dni
     * @return
     */
    private String validarDNI(String dni) {
        if (dni.length() == 9) {
            String[] letra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D",
                "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
            int numero = 0;
            String numeroString = dni.substring(0, 8);
            try {
                numero = Integer.parseInt(numeroString);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Debe haber 8 números "
                        + "seguidos de su letra, ej: 12345678A");
                numero = 0;
            }
            numeroString += (letra[numero % 23]);
            if (numeroString.equals(dni)) {
                return dni;
            } else {
                JOptionPane.showMessageDialog(frame, "La letra no coincide "
                        + "con el DNI");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "El formato del DNI ha de ser"
                    + " 8 números seguidos de su letra, ej: 12345678A");
        }
        return "";
    }

}
