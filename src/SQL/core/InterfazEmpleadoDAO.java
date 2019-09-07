package SQL.core;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author yosua
 */
public interface InterfazEmpleadoDAO<T> {

    /**
     * Método para insertar los empleados
     * 
     * @param nombre String nombre del empleado
     * @param apellido1 String primer apellido
     * @param apellido2 String segundo apellido
     * @param password String contraseña
     * @return Objeto del tipo declarado
     */
    T insert(String nombre, String apellido1, String apellido2, String password);

    /**
     * Método para actualizar un elemento
     * 
     * @param elemento Elemento con los datos a actualizar
     * @return T elemento actualizado
     */
    T update(T elemento);
    
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
    
    
}
