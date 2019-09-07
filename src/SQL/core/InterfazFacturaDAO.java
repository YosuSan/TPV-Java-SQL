package SQL.core;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author yosua
 */
public interface InterfazFacturaDAO<T> {
    
    
    /**
     * Método para insertar las facturas
     * 
     * @param vendedor String vendedor
     * @param cliente String cliente
     * @param fecha String fecha
     * @param factura String factura
     * @return Object del tipo declarado
     */
    T insert(String vendedor, String cliente, String fecha, String factura);
        
    /**
     * Método para eliminar un elemento
     * 
     * @param elemento Elemento a eliminar
     * @return Elemento eliminado
     */
    T delete(T elemento);
    
    /**
     * Método para cargar todos los elementos
     * 
     * @return ArrayList con los objetos cargados
     */
    ArrayList<T> loadAll();
    
    /**
     * Método que enlaza un ResultSet con un objeto
     * 
     * @param resultSet ResultSet a enlazar
     * @return T elemento con los datos asociados
     */
    T bind(ResultSet resultSet);
    
    /**
     * Método para buscar por una característica
     * 
     * @param criteria int característica para filtrar
     * @param value String valor del filtro
     * @return ArrayList con los objetos que cumplan el criterio de busqueda
     */    
    ArrayList<T> search(int criteria, String value);
    
    
}
