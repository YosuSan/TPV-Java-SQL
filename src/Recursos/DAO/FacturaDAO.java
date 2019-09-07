package Recursos.DAO;

import Facturas.entities.Factura;
import SQL.core.IErrors;
import SQL.core.InterfazFacturaDAO;
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
 * Clase que controla las acciones con la BBDD de las facturas
 *
 * @author yosua
 */
public class FacturaDAO implements InterfazFacturaDAO<Factura> {

    /**
     * Criterio por cliente
     */
    public static final int CLIENTE_CRITERIA = 0;
    /**
     * Criterio por fecha
     */
    public static final int FECHA_CRITERIA = 1;
    //Sentencias. tablas y campos
    private static final String TABLE = "facturas";
    private static final String INSERT_FIELDS = "vendedor, cliente, fecha,"
            + " factura";
    private static final String SELECT_FIELDS = "id, " + INSERT_FIELDS;
    private static final String ORDER_BY = " ORDER BY id";
    private static final String SQL_LOAD_ALL = "SELECT " + SELECT_FIELDS
            + " FROM " + TABLE + ORDER_BY;
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "("
            + INSERT_FIELDS + ") VALUES(?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM " + TABLE
            + " WHERE id = ?";
    private static final String SQL_SEARCH = "SELECT " + SELECT_FIELDS
            + " FROM " + TABLE + " WHERE ";
    private PreparedStatement ps = null;
    private Connection connect = null;

    /**
     * Constructor base
     */
    public FacturaDAO() {
        super();
    }

    /**
     * Método implementado por InterfazFacturaDAO para insertar un producto
     *
     * @param vendedor String vendedor
     * @param cliente String cliente
     * @param fecha String fecha
     * @param factura String factura
     * @return Factura fact insertada
     */
    @Override
    public Factura insert(String vendedor, String cliente, String fecha,
            String factura) {
        Factura fact = null;
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_INSERT,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, vendedor);
            ps.setString(2, cliente);
            ps.setString(3, fecha);
            ps.setString(4, factura);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            fact = new Factura(id, vendedor, cliente, fecha, factura);
        } catch (SQLException e) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return fact;
    }

    /**
     * Método implementado por InterfazFacturaDAO para eliminar una factura
     *
     * @param factura Factura factura a eliminar
     * @return Factura factura eliminada
     */
    @Override
    public Factura delete(Factura factura) {
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_DELETE);
            ps.setInt(1, factura.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return factura;
    }

    /**
     * Método implementado por InterfazFacturaDAO para cargar todas las facturas
     *
     * @return ArrayList con las facturas
     */
    @Override
    public ArrayList<Factura> loadAll() {
        ArrayList<Factura> facturas = new ArrayList<>();
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_LOAD_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Factura factura = bind(rs);
                facturas.add(factura);
            }
        } catch (SQLException e) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return facturas;
    }

    /**
     * Método implementado por InterfazFacturaDAO para enlazar un ResultSet con
     * un objeto factura
     *
     * @param resultSet ResultSet con la consulta
     * @return Factura factura con los datos enlazados
     */
    @Override
    public Factura bind(ResultSet resultSet) {
        try {
            return new Factura(resultSet.getInt("id"),
                    resultSet.getString("vendedor"),
                    resultSet.getString("cliente"),
                    resultSet.getString("fecha"),
                    resultSet.getString("factura"));
        } catch (SQLException e) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_BINDING, e);
        }
        return null;
    }

    /**
     * Método implementado por InterfazFacturaDAO para buscar facturas
     *
     * @param criteria int criterio de busqueda
     * @param value String volor de la busqueda
     * @return ArrayList con los resultados
     */
    @Override
    public ArrayList<Factura> search(int criteria, String value) {
        ArrayList<Factura> facturas = new ArrayList<>();
        try {
            connect = SQLConnection.getCon();
            ps = setCriteria(connect, criteria, value);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Factura factura = bind(rs);
                facturas.add(factura);
            }
        } catch (SQLException e) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return facturas;
    }

    /**
     * Método para establecer los criterios de busqueda en la BBDD
     *
     * @param connect Connection connect
     * @param criteria int criteria busqueda
     * @param value String value
     * @return PreparedStatement
     */
    private PreparedStatement setCriteria(Connection connect, int criteria,
            String value) {
        String query = SQL_SEARCH;
        try {
            switch (criteria) {
                case CLIENTE_CRITERIA:
                    query += "cliente = ?";
                    break;
                case FECHA_CRITERIA:
                    query += "fecha = ?";
                    break;
                default:
                    query += " 1 = 1 ";
                    break;
            }
            PreparedStatement sentence = connect.prepareStatement(query);
            sentence.setString(1, value);
            return sentence;
        } catch (SQLException e) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_SETTING_CRITERIA, e);
        }
        return null;
    }
}
