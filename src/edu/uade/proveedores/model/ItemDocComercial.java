package edu.uade.proveedores.model;

/**
 * @author Grupo 5
 */
public class ItemDocComercial extends GenericModel {

    /**
     * Default constructor
     */
    public ItemDocComercial() {
        super();
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
    private Float precioTotal;

    /**
     * 
     */
    private Float impuestoTotal;

    @Override
    public String toString() {
        return null;
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