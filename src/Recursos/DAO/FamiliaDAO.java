package Recursos.DAO;

import Familias.entities.Familia;
import SQL.core.IErrors;
import SQL.core.InterfazFamiliaDAO;
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
 * Clase para controlar las acciones con la BBDD de la tabla familias
 *
 * @author yosua
 */
public class FamiliaDAO implements InterfazFamiliaDAO<Familia> {

    //Sentencias, tablas y campos
    private static final String TABLE = "familias";
    private static final String INSERT_FIELDS = "familia, icono";
    private static final String SELECT_FIELDS = "id," + INSERT_FIELDS;
    private static final String ORDER_BY = " ORDER BY familia";
    private static final String SQL_LOAD_ALL = "SELECT " + SELECT_FIELDS
            + " FROM " + TABLE + ORDER_BY;
    private static final String SQL_INSERT = "INSERT INTO " + TABLE + "("
            + INSERT_FIELDS + ") VALUES( ?, ?)";
    private static final String SQL_UPDATE = "UPDATE " + TABLE + " SET "
            + " familia = ?, icono = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM " + TABLE
            + " WHERE id = ?";
    private PreparedStatement ps = null;
    private Connection connect = null;

    /**
     * Constructor base
     */
    public FamiliaDAO() {
        super();
    }

    /**
     * Método implementado por InterfazFamiliaDAO para insertar una familia
     *
     * @param familia String familia
     * @param icono String icono
     * @return Familia familia insertada
     */
    @Override
    public Familia insert(String familia, String icono) {
        Familia family = null;
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_INSERT,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, familia);
            ps.setString(2, icono);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            family = new Familia(id, familia, icono);
        } catch (SQLException e) {
            Logger.getLogger(FamiliaDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(FamiliaDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return family;
    }

    /**
     * Método implementado por InterfazFamiliaDAO para editar una familia
     *
     * @param familia Familia familia con los datos a editar
     * @return Familia familia
     */
    @Override
    public Familia update(Familia familia) {
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_UPDATE);
            ps.setString(1, familia.getFamilia());
            ps.setString(2, familia.getIcono());
            ps.setInt(3, familia.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(FamiliaDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(FamiliaDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return familia;
    }

    /**
     * Método implementado por InterfazFamiliaDAO para eliminar una familia
     *
     * @param familia Familia familia a eliminar
     * @return Familia familia eliminada
     */
    @Override
    public Familia delete(Familia familia) {
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_DELETE);
            ps.setInt(1, familia.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(FamiliaDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        } finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException e) {
                Logger.getLogger(FamiliaDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return familia;
    }

    /**
     * Método implementado por InterfazFamiliaDAO para cargar todas las familias
     * 
     * @return ArrayList con todas las familias
     */
    @Override
    public ArrayList<Familia> loadAll() {
        ArrayList<Familia> familias = new ArrayList<>();
        try {
            connect = SQLConnection.getCon();
            ps = connect.prepareStatement(SQL_LOAD_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Familia familia = bind(rs);
                familias.add(familia);
            }
        } catch (SQLException e) {
            Logger.getLogger(FamiliaDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_STATEMENT, e);
        }finally{
            try{
                ps.close();
                connect.close();
            }catch(SQLException e){
                Logger.getLogger(FamiliaDAO.class.getName()).log(Level.SEVERE,
                        IErrors.ERROR_SQL_CLOSE_CONNECTION, e);
            }
        }
        return familias;
    }
    
    /**
     * Método implementado por InterfazFamiliaDAO para enlazar un ResultSet con
     * un objeto familia
     * 
     * @param resultSet ResultSet con la consulta
     * @return Familia familia con los datos enlazados
     */
    @Override
    public Familia bind(ResultSet resultSet) {
        try {
            return new Familia(resultSet.getInt("id"),
                    resultSet.getString("familia"),
                    resultSet.getString("icono"));
        } catch (SQLException e) {
            Logger.getLogger(FamiliaDAO.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_BINDING, e);
        }
        return null;
    }

}
