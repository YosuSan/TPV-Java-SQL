package Recursos.DAO;

import Empleados.entities.Empleado;
import SQL.core.IErrors;
import SQL.core.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import SQL.core.InterfazEmpleadoDAO;

/**
 * Clase para controlar las acciones con la BBDD de la tabla empleados
 * 
 * @author yosua
 */
public class EmpleadoDAO implements InterfazEmpleadoDAO<Empleado> {

    //Sentencias, tablas y campos
    private static final String TABLE = "empleados";
    private static final String INSERT_FIELDS = "nombre, apellido1, apellido2,"
            + " password";
    private static final String SELECT_FIELDS = "id," + INSERT_FIELDS;
    private static final String SQL_LOAD_ALL = "SELECT " + SELECT_FIELDS
            + " FROM " + TABLE;
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "("
            + INSERT_FIELDS + ") VALUES( ?, ?, ?, ?) ";
    private static final String SQL_UPDATE = "UPDATE " + TABLE + " SET "
            + "nombre = ?, apellido1 = ?, apellido2 = ?, password = ? "
            + "WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM " + TABLE
            + " WHERE id = ?";
    private PreparedStatement ps = null;
    private Connection connect = null;

    /**
     * Constructor base
     */
    public EmpleadoDAO() {
        super();
    }

    /**
     * Método implementado por InterfazEmpleadoDAO para insertar un empleado
     *
     * @param nombre String nombre
     * @param apellido1 String primer apellido
     * @param apellido2 String segundo apellido
     * @param password String password
     * @return Empleado empleado insertado
     */
    @Override
    public Empleado insert(String nombre, String apellido1, String apellido2,
            String password) {
        Empleado empleado = null;
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_INSERT,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, password);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            empleado = new Empleado(id, nombre, apellido1, apellido2, password);
        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return empleado;
    }

    /**
     * Método implementado por InterfazEmpleadoDAO para editar un empleado
     *
     * @param empleado Empleado empleado con los datos a editar
     * @return Empleado empleado
     */
    @Override
    public Empleado update(Empleado empleado) {
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_UPDATE);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido1());
            ps.setString(3, empleado.getApellido2());
            ps.setString(4, empleado.getPassword());
            ps.setInt(5, empleado.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return empleado;
    }

    /**
     * Método implementado por InterfazEmpleadoDAO para eliminar un empleado
     *
     * @param empleado Empleado empleado a eliminar
     * @return Empleado empleado eliminado
     */
    @Override
    public Empleado delete(Empleado empleado) {
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_DELETE);
            ps.setInt(1, empleado.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return empleado;
    }

    /**
     * Método implementado por InterfazEmpleadoDAO para cargar todos los 
     * empleados
     * 
     * @return ArrayList con todos los empleados
     */
    @Override
    public ArrayList<Empleado> loadAll() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_LOAD_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empleado empleado = bind(rs);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return empleados;
    }

    /**
     * Método implementado por InterfazEmpleadoDAO para enlazar un ResultSet con
     * un objeto empleado
     *
     * @param resultSet ResultSet con la consulta
     * @return Empleado empleado con los datos enlazados
     */
    @Override
    public Empleado bind(ResultSet resultSet) {
        try {
            return new Empleado(resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido1"),
                    resultSet.getString("apellido2"),
                    resultSet.getString("password"));
        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_BINDING, e);
        }
        return null;
    }

}
