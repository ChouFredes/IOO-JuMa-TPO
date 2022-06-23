package edu.uade.proveedores.model;

import edu.uade.proveedores.enumeration.TipoCheque;

import java.util.*;

/**
 * @author Grupo 5
 */
public class Cheque {

    /**
     * Default constructor
     */
    public Cheque() {
    }

    /**
     * 
     */
    private Float monto;

    /**
     * 
     */
    private Date fechaDeEmision;

    /**
     * 
     */
    private Date fechaDeVencimiento;

    /**
     * 
     */
    private String firmante;

    /**
     * 
     */
    private TipoCheque tipo;

    /*
    @Override
    public String toString() {
        return "Model{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
     */
}