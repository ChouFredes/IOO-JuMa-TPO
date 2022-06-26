package edu.uade.proveedores.model;

/**
 * @author Grupo 5
 */
public class OrdenDePago extends GenericModel {

    /**
     * Default constructor
     */
    public OrdenDePago() {
    }

    @Override
    public String toString() {
        return null;
    }

    /**
     * 
     */
    private Long numeroDeOrden;

    /**
     * 
     */
    private Float totalACancelar;

    /**
     * 
     */
    private Float totalDeRetenciones;

}