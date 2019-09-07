package SQL.core;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author yosua
 */
public interface InterfazFamiliaDAO<T> {
    
    /**
     * Método para insertar los empleados
     * 
     * @param familia String familia del producto
     * @param icono String con la ruta del icono 
     * @return Objeto del tipo declarado
     */
    T insert(String familia, String icono);

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
