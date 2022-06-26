package edu.uade.proveedores.model;

import java.util.List;

/**
 * @author Grupo 5
 */
public class OrdenDePago extends GenericModel {

    List<DocumentoComercial> facturas;
    List<DocumentoComercial> notasDeCredito;
    List<DocumentoComercial> notasDeDebito;
    private Long numeroDeOrden;
    private Float totalACancelar;
    private Float totalDeRetenciones;

    public List<DocumentoComercial> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<DocumentoComercial> facturas) {
        this.facturas = facturas;
    }

    public List<DocumentoComercial> getNotasDeCredito() {
        return notasDeCredito;
    }

    public void setNotasDeCredito(List<DocumentoComercial> notasDeCredito) {
        this.notasDeCredito = notasDeCredito;
    }

    public List<DocumentoComercial> getNotasDeDebito() {
        return notasDeDebito;
    }

    public void setNotasDeDebito(List<DocumentoComercial> notasDeDebito) {
        this.notasDeDebito = notasDeDebito;
    }

    public Long getNumeroDeOrden() {
        return numeroDeOrden;
    }

    public void setNumeroDeOrden(Long numeroDeOrden) {
        this.numeroDeOrden = numeroDeOrden;
    }

    public Float getTotalACancelar() {
        return totalACancelar;
    }

    public void setTotalACancelar(Float totalACancelar) {
        this.totalACancelar = totalACancelar;
    }

    public Float getTotalDeRetenciones() {
        return totalDeRetenciones;
    }

    public void setTotalDeRetenciones(Float totalDeRetenciones) {
        this.totalDeRetenciones = totalDeRetenciones;
    }

    /**
     * Default constructor
     */
    public OrdenDePago() {
    }


    @Override
    public String toString() {
        return null;
    }

}