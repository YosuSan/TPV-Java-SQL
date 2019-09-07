package Empleados.entities;

/**
 * Clase para construir los objetos de tipo Empleado
 * 
 * @author yosua
 */
public class Empleado {
    
    //Atributos
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String password;

    /**
     * Constructor parametrizado
     * 
     * @param id int id automático
     * @param nombre String nombre
     * @param apellido1 String primer apellido
     * @param apellido2 String segundo apellido
     * @param password String contraseña
     */
    public Empleado(int id, String nombre, String apellido1, String apellido2,
            String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.password = password;
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
     * Getter del primer apellido
     * 
     * @return String apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Setter del primer apellido
     * 
     * @param apellido1 String
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Getter del segundo apellido
     * 
     * @return String apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Setter del segundo apellido
     * 
     * @param apellido2 String
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Getter de la contraseña
     * 
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter de la contraseña
     * 
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
