package SQL.core;

/**
 * 
 * @author yosua
 */
public interface IErrors {

    /**
     * Error en la sentencia
     */
    public static final String ERROR_SQL_STATEMENT
            = "Error al ejecutar la sentencia SQL.";

    /**
     * Error cerrar conexion
     */
    public static final String ERROR_SQL_CLOSE_CONNECTION
            = "Error al cerrar la sentencia o conexión.";

    /**
     * Error de asociación
     */
    public static final String ERROR_SQL_BINDING
            = "Error al asociar las propiedades con las columnas resultantes";

    /**
     * Error de criterio
     */
    public static final String ERROR_SQL_SETTING_CRITERIA
            = "Error estableciendo el criterio de búsqueda";

    /**
     * Error de driver
     */
    public static final String ERROR_SQL_DRIVER
            = "No se encontró la clase para inciar la conexión";

    /**
     * Error al abrir la conexión
     */
    public static final String ERROR_SQL_OPEN_CONNECTION
            = "Error al iniciar la conexión SQL";    

}
