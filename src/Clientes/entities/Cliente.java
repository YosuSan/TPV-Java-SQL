package Clientes.entities;

/**
 * Clase para construir los objetos de tipo Cliente
 * 
 * @author yosua
 */
public class Cliente {

    //Atributos
    private int id;
    private String nombre;
    private String apellidos;
    private String DNI;
    private int telefono;
    private int descuento;

    /**
     * Constructor parametrizado
     *
     * @param id int id automático
     * @param nombre String nombre
     * @param apellidos String apellidos
     * @param DNI String DNI
     * @param telefono int telefono
     * @param descuento int descuento
     */
    public Cliente(int id, String nombre, String apellidos, String DNI,
            int telefono, int descuento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.telefono = telefono;
        this.descuento = descuento;
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
     * Getter del DNI
     *
     * @return String DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Setter del DNI
     *
     * @param DNI String
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Getter del telefono
     *
     * @return int telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Setter del telefono
     *
     * @param telefono int
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Getter del descuento
     *
     * @return int descuento
     */
    public int getDescuento() {
        return descuento;
    }

    /**
     * Setter del descuento
     *
     * @param descuento String
     */
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    /**
     * Getter del nombre
     * 
     * @return String nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre
     * 
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de los apellidos 
     * 
     * @return String apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Setter de los apellidos
     * 
     * @param apellidos String
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    

}
