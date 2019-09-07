package Recursos.DAO;

import Clientes.entities.Cliente;
import SQL.core.IErrors;
import SQL.core.InterfazClienteDAO;
import SQL.core.SQLConnection;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para controlar las acciones con la BBDD de la tabla clientes
 *
 * @author yosua
 */
public class ClienteDAO implements InterfazClienteDAO<Cliente> {

    //Sentencias, campos y tablas
    private static final String TABLE = "clientes";
    private static final String INSERT_FIELDS = "nombre, apellidos, DNI,"
            + " telefono, descuento";
    private static final String SELECT_FIELDS = "id, " + INSERT_FIELDS;
    private static final String SQL_LOAD_ALL = "SELECT " + SELECT_FIELDS
            + " FROM " + TABLE;
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "("
            + INSERT_FIELDS + ") VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE " + TABLE + " SET "
            + "nombre = ?, apellidos = ?, DNI = ?, telefono = ?, descuento = ? "
            + "WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM " + TABLE
            + " WHERE id = ?";
    private PreparedStatement ps = null;
    private Connection connect = null;

    /**
     * Constructor base
     */
    public ClienteDAO() {
        super();
    }

    /**
     * Método implementado por InterfazClienteDAO para insertar un cliente
     *
     * @param nombre String nombre
     * @param apellidos String apellidos
     * @param DNI String DNI
     * @param telefono int telefono
     * @param descuento int descuento
     * @return
     */
    @Override
    public Cliente insert(String nombre, String apellidos, String DNI,
            int telefono, int descuento) {
        Cliente cliente = null;
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_INSERT,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, DNI);
            ps.setInt(4, telefono);
            ps.setInt(5, descuento);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            cliente = new Cliente(id, nombre, apellidos, DNI, telefono,
                    descuento);
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return cliente;
    }

    /**
     * Método implementado por InterfazClienteDAO para editar un cliente
     *
     * @param cliente Cliente cliente a editar
     * @return Cliente cliente editado
     */
    @Override
    public Cliente update(Cliente cliente) {
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_UPDATE);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getDNI());
            ps.setInt(4, cliente.getTelefono());
            ps.setInt(5, cliente.getDescuento());
            ps.setInt(6, cliente.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return cliente;
    }

    /**
     * Método implementado por InterfazClienteDAO para eliminar un cliente
     * 
     * @param cliente Cliente cliente a eliminar
     * @return Cliente cliente eliminado
     */
    @Override
    public Cliente delete(Cliente cliente) {
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_DELETE);
            ps.setInt(1, cliente.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return cliente;
    }

    /**
     * Métodod implementado por InterfazClienteDAO para cargar todos los 
     * clientes
     * 
     * @return ArrayList con todos los clientes
     */
    @Override
    public ArrayList<Cliente> loadAll() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try{
            connect = SQLConnection.getCon();
            ps=connect.prepareStatement(SQL_LOAD_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cliente cliente = bind(rs);
                clientes.add(cliente);
            }
        }catch(SQLException e){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        }finally{
            try{
                ps.close();
                connect.close();
            }catch(SQLException e){
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return clientes;
    }

    /**
     * Método implementado por InterfazClienteDAO para enlazar un ResultSet con
     * un objeto cliente
     * @param resultSet ResultSet con la consulta
     * @return Cliente cliente con los datos enlazados
     */
    @Override
    public Cliente bind(ResultSet resultSet) {
        try{
            return new Cliente(resultSet.getInt("id"),
            resultSet.getString("nombre"),
            resultSet.getString("apellidos"),
            resultSet.getString("DNI"),
            resultSet.getInt("telefono"),
            resultSet.getInt("descuento"));
        }catch(SQLException e){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_BINDING, e);
        }
        return null;
    }

}
