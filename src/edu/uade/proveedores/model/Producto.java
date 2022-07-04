package edu.uade.proveedores.model;

import edu.uade.proveedores.enumeration.*;

import java.util.Date;

/**
 * @author Grupo 5
 */
public class Producto extends GenericModel{

    private String descripcion;
    private Float precioPorUnidad;
    private int detallePorUnidad;
    private TipoRubro rubro;
    private TipoImpuestoProducto IVA;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(Float precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public int getDetallePorUnidad() {
        return detallePorUnidad;
    }

    public void setDetallePorUnidad(int detallePorUnidad) {
        this.detallePorUnidad = detallePorUnidad;
    }

    public TipoRubro getRubro() {
        return rubro;
    }

    public void setRubro(TipoRubro rubro) {
        this.rubro = rubro;
    }

    public TipoImpuestoProducto getIVA() {
        return IVA;
    }

    public void setIVA(TipoImpuestoProducto IVA) {
        this.IVA = IVA;
    }

    public Producto(String descripcion, Float precioPorUnidad, int detallePorUnidad, TipoRubro rubro, TipoImpuestoProducto IVA) {
        super();
        this.descripcion = descripcion;
        this.precioPorUnidad = precioPorUnidad;
        this.detallePorUnidad = detallePorUnidad;
        this.rubro = rubro;
        this.IVA = IVA;
    }

    public Producto(String id, String descripcion, Float precioPorUnidad, int detallePorUnidad, TipoRubro rubro, TipoImpuestoProducto IVA, Date fechaDeCreacion) {
        super(id,fechaDeCreacion);
        this.descripcion = descripcion;
        this.precioPorUnidad = precioPorUnidad;
        this.detallePorUnidad = detallePorUnidad;
        this.rubro = rubro;
        this.IVA = IVA;
    }

    @Override
    public String toString() {
        return "Producto {" +
                " id = '" + this.id + '\'' +
                ", descripcion = '" + this.descripcion + '\'' +
                ", precionPorUnidad = '" + this.precioPorUnidad.toString() + '\'' +
                ", detallePorUnidad = '" + this.detallePorUnidad + '\'' +
                ", rubro = '" + this.rubro + '\'' +
                ", IVA = '" + this.IVA + '\'' +
                " }";
    }
}