package Familias.entities;

/**
 * Clase para construir los objetos de tipo Familia
 * 
 * @author yosua
 */
public class Familia {

    //Atributos
    private int id;
    private String familia;
    private String icono;

    /**
     * Constructor parametrizado
     *
     * @param id int id automático
     * @param familia String familia
     * @param icono String icono
     */
    public Familia(int id, String familia, String icono) {
        this.id = id;
        this.familia = familia;
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
