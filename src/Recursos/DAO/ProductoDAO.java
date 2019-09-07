package Recursos.DAO;

import Productos.entities.Producto;
import SQL.core.IErrors;
import SQL.core.InterfazProductosDAO;
import SQL.core.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para controlar las acciones con la BBDD de la tabla productos
 *
 * @author yosua
 */
public class ProductoDAO implements InterfazProductosDAO<Producto> {

    //Sentencias, tablas y campos
    private static final String TABLE = "productos";
    private static final String INSERT_FIELDS = "familia, nombre, precio,"
            + " icono";
    private static final String SELECT_FIELDS = "id, " + INSERT_FIELDS;
    private static final String ORDER_BY = " ORDER BY familia, nombre";
    private static final String SQL_LOAD_ALL = "SELECT " + SELECT_FIELDS
            + " FROM " + TABLE + ORDER_BY;
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "("
            + INSERT_FIELDS + ") VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE " + TABLE + " SET "
            + " familia = ?, nombre = ?, precio = ?, icono = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM " + TABLE
            + " WHERE id = ?";
    private PreparedStatement ps = null;
    private Connection connect = null;

    /**
     * Constructor base
     */
    public ProductoDAO() {
        super();
    }

    /**
     * Método implementado por InterfazProductoDAO para insertar un producto
     *
     * @param familia String familia
     * @param nombre String nombre
     * @param precio float precio
     * @param icono String icono
     * @return Producto producto insertado
     */
    @Override
    public Producto insert(String familia, String nombre, float precio,
            String icono) {
        Producto producto = null;
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_INSERT,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, familia);
            ps.setString(2, nombre);
            ps.setFloat(3, precio);
            ps.setString(4, icono);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            producto = new Producto(id, familia, nombre, precio, icono);
        } catch (SQLException e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return producto;
    }

    /**
     * Método implementado por InterfazProductoDAO para editar un producto
     *
     * @param producto Producto producto a editar
     * @return Producto producto
     */
    @Override
    public Producto update(Producto producto) {
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_UPDATE);
            ps.setString(1, producto.getFamilia());
            ps.setString(2, producto.getNombre());
            ps.setFloat(3, producto.getPrecio());
            ps.setString(4, producto.getIcono());
            ps.setInt(5, producto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return producto;
    }

    /**
     * Método implementado por InterfazProductoDAO para eliminar un producto
     *
     * @param producto Producto producto a eliminar
     * @return Producto producto eliminado
     */
    @Override
    public Producto delete(Producto producto) {
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_DELETE);
            ps.setInt(1, producto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return producto;
    }

    /**
     * Método implementado por InterfazProductoDAO para cargar todos los 
     * productos
     * 
     * @return ArrayList con todos los productos
     */
    @Override
    public ArrayList<Producto> loadAll() {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_LOAD_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = bind(rs);
                productos.add(producto);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return productos;
    }

    /**
     * Método implementado por InterfazProductoDAO para enlazar un ResultSet con
     * un objeto producto
     *
     * @param resultSet ResultSet con la consulta
     * @return Producto producto con los datos enlazados
     */
    @Override
    public Producto bind(ResultSet resultSet) {
        try {
            return new Producto(resultSet.getInt("id"),
                    resultSet.getString("familia"),
                    resultSet.getString("nombre"),
                    resultSet.getFloat("precio"),
                    resultSet.getString("icono"));
        } catch (SQLException e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_BINDING, e);
        }
        return null;
    }

}
