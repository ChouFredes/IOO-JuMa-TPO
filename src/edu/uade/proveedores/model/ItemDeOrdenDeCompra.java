package edu.uade.proveedores.model;

/**
 * @author Grupo 5
 */
public class ItemDeOrdenDeCompra {

    /**
     * Default constructor
     */
    public ItemDeOrdenDeCompra() {
    }

    /**
     * 
     */
    private int numeroDeItem;

    /**
     * 
     */
    private int cantidad;

    /**
     * 
     */
    private Float precioUnitario;

    /**
     * 
     */
    private Float precioUnitarioAcordado;

    /**
     * 
     */
    private Float precioTotal;

    /**
     * 
     */
    private Float impuestoTotal;

    @Override
    public String toString() {
        return "ItemDeOrdenDeCompra{" +
                " numeroDeItem ='" + this.numeroDeItem + '\'' +
                ", name='" + this.cantidad + '\'' +
                '}';

    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}