package SQL.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para la conexión con SQL
 *
 * @author yosua
 */
public class SQLConnection {

    //Sentencias
    private static final String NAME = "trabajo_tpv";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SERVER = "localhost";
    private static final String DATABASE = "jdbc:mysql://" + SERVER;
    private static final String PORT = "3306";
    private static final String URL = DATABASE + ":" + PORT + "/" + NAME;
    private static final String USER = "root";
    private static final String PASS = "";

    /**
     * Constructor de la clase
     */
    public SQLConnection() {
        super();
    }

    /**
     * Método para recuperar una conexión con la BBDD
     *
     * @return java.sql.Connection conexión o null
     */
    public static Connection getCon() {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        } catch (ClassNotFoundException e) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_DRIVER);
        } catch (SQLException e) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE,
                    IErrors.ERROR_SQL_OPEN_CONNECTION);
        }
        return null;
    }

}
