package SQL.core;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author yosua
 */
public interface InterfazClienteDAO<T> {
    
    
    /**
     * Método para insertar los clientes
     * 
     * @param nombre String nombre del cliente
     * @param apellidos String apellidos del cliente
     * @param DNI String DNI del cliente
     * @param telefono int telefono del cliente
     * @param descuento int descuento aplicable
     * @return 
     */
    T insert(String nombre, String apellidos, String DNI, int telefono,
            int descuento);
    
    /**
     * Método para actualizar un elemento
     * 
     * @param elemento Elemento con los datos a actulizar
     * @return T elemento actualizado
     */
    T update(T elemento);
    
    /**
     * Método para eliminar un elemento
     * 
     * @param elemento Elemento a eliminar
     * @return Elemento elemento eliminado
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
    
    
}
