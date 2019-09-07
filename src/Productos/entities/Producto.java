package Productos.entities;

/**
 * Clase para construir los objetos de tipo Producto
 * 
 * @author yosua
 */
public class Producto {
    
    //Atributos
    private int id;
    private String familia;
    private String nombre;
    private float precio;
    private String icono;

    /**
     * Constructor parametrizado
     * 
     * @param id int id automático
     * @param familia String familia
     * @param nombre String nombre
     * @param precio float precio
     * @param icono String icono
     */
    public Producto(int id, String familia, String nombre, float precio,
            String icono) {
        this.id = id;
        this.familia = familia;
        this.nombre = nombre;
        this.precio = precio;
        this.icono = icono;
    }

    
    /**
     * Getter del id
     * 
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del id
     * 
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter de familia
     * 
     * @return String familia
     */
    public String getFamilia() {
        return familia;
    }

    /**
     * Setter de familia
     * 
     * @param familia String
     */
    public void setFamilia(String familia) {
        this.familia = familia;
    }

    /**
     * Getter de nombre
     * 
     * @return String nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter de nombre
     * 
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de precio
     * 
     * @return float precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Seeter de precio
     * 
     * @param precio float
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Getter de icono
     * 
     * @return String icono
     */
    public String getIcono() {
        return icono;
    }

    /**
     * Setter de icono
     * 
     * @param icono String
     */
    public void setIcono(String icono) {
        this.icono = icono;
    }
    
    
}
