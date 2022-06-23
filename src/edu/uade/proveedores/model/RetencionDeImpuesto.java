package edu.uade.proveedores.model;

import edu.uade.proveedores.dao.GenericDAO;
import edu.uade.proveedores.enumeration.TipoImpuesto;

import java.util.Date;

/**
 * @author Grupo 5
 */
public class RetencionDeImpuesto extends GenericModel {

    private float porcentajeARetener;
    private TipoImpuesto impuesto;

    public RetencionDeImpuesto(Integer porcentajeARetener, TipoImpuesto impuesto) {
        super();
        this.porcentajeARetener = porcentajeARetener / 100;
        this.impuesto = impuesto;
    }

    public RetencionDeImpuesto(String id, Integer porcentajeARetener, TipoImpuesto impuesto, Date fechaCreacion) {
        super(id,fechaCreacion);
        this.porcentajeARetener = porcentajeARetener / 100;
        this.impuesto = impuesto;
    }

    public float getPorcentajeARetener() {
        return porcentajeARetener;
    }
    public void setPorcentajeARetener(float porcentajeARetener) {
        this.porcentajeARetener = porcentajeARetener;
    }

    public TipoImpuesto getImpuesto() {
        return impuesto;
    }
    public void setImpuesto(TipoImpuesto impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public String toString() {
        return "RetencionDeImpuesto {" +
                " id = '" + this.id + '\'' +
                ", porcentajeARetener = '" + this.porcentajeARetener + '\'' +
                ", impuesto = '" + this.impuesto + '\'' +
                ", fechaDeCreacion = '" + this.fechaDeCreacion + '\'' +
                " }";
    }

}