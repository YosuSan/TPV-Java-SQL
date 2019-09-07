package Facturas.entities;

/**
 * Clase para construir los objetos de tipo Factura
 * 
 * @author yosua
 */
public class Factura {
    
    //Atributos
    private int id;
    private String vendedor;
    private String cliente;
    private String fecha;
    private String factura;

    /**
     * Constructor parametrizado
     * 
     * @param id int id automático
     * @param vendedor String vendedor
     * @param cliente String cliente
     * @param fecha String fecha
     * @param factura String factura
     */
    public Factura(int id, String vendedor, String cliente, String fecha, 
            String factura) {
        this.id = id;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.fecha = fecha;
        this.factura = factura;
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
     * Getter del vendedor
     * 
     * @return String vendedor
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * Setter del vendedor
     * 
     * @param vendedor String
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * Getter del cliente
     * 
     * @return String cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Setter del cliente
     * 
     * @param cliente String
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Getter de la fecha
     * 
     * @return String fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Setter de la fecha
     * 
     * @param fecha String
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Getter de la factura
     * 
     * @return String factura
     */
    public String getFactura() {
        return factura;
    }

    /**
     * Setter de la factura
     * 
     * @param factura String
     */
    public void setFactura(String factura) {
        this.factura = factura;
    }
    
    
    
}
