package edu.uade.proveedores.model;

import edu.uade.proveedores.dto.DocumentoComercialDTO;
import edu.uade.proveedores.enumeration.TipoDocumentoComercial;
import edu.uade.proveedores.enumeration.TipoIVA;

import java.util.*;

/**
 * @author Grupo 5
 */
public class DocumentoComercial extends GenericModel{

    private String numeroDeComprobante;
    private Date fechaDeEmision;
    private TipoDocumentoComercial tipoDeDocumento;

    private TipoIVA iva;
    private Float precioTotal;
    private Float impuestoTotal;
    private Proveedor proveedor;
    private Empleado creador;
    private Empleado autorizador;

    public DocumentoComercial(String numeroDeComprobante, Date fechaDeEmision, TipoDocumentoComercial tipoDeDocumento,
                              TipoIVA iva, float precioTotal, float impuestoTotal, Proveedor proveedor, Empleado creador) {
        super();
        this.numeroDeComprobante = numeroDeComprobante;
        this.fechaDeEmision = fechaDeEmision;
        this.tipoDeDocumento = tipoDeDocumento;
        this.iva = iva;
        this.precioTotal = precioTotal;
        this.impuestoTotal = impuestoTotal;
        this.creador = creador;
        this.proveedor = proveedor;

    }

    public DocumentoComercial(String id, String numeroDeComprobante, Date fechaDeEmision, TipoDocumentoComercial tipoDeDocumento,
                              TipoIVA iva, float precioTotal, float impuestoTotal, Date fechaDeCreacion, Proveedor proveedor, Empleado creador) {

            super(id, fechaDeCreacion);
            this.numeroDeComprobante = numeroDeComprobante;
            this.fechaDeEmision = fechaDeEmision;
            this.tipoDeDocumento = tipoDeDocumento;
            this.iva = iva;
            this.precioTotal = precioTotal;
            this.impuestoTotal = impuestoTotal;
            this.creador = creador;
            this.proveedor = proveedor;

    }

    public String getNumeroDeComprobante() {
        return numeroDeComprobante;
    }
    public void setNumeroDeComprobante(String numeroDeComprobante) {
        this.numeroDeComprobante = numeroDeComprobante;
    }

    public Date getFechaDeEmision() {
        return fechaDeEmision;
    }
    public void setFechaDeEmision(Date fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }

    public TipoDocumentoComercial getTipoDeDocumento() {
        return tipoDeDocumento;
    }
    public void setTipoDeDocumento(TipoDocumentoComercial tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }
    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Float getImpuestoTotal() {
        return impuestoTotal;
    }
    public void setImpuestoTotal(Float impuestoTotal) {
        this.impuestoTotal = impuestoTotal;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Empleado getCreador() { return creador; }
    public void setCreador(Empleado creador) { this.creador = creador; }

    public Empleado getAutorizador() {
        return autorizador;
    }
    public void setAutorizador(Empleado autorizador) {
        this.autorizador = autorizador;
    }

    public TipoIVA getIva() {
        return iva;
    }
    public void setIva(TipoIVA iva) {
        this.iva = iva;
    }


    @Override
    public String toString() {
        return "DocumentoComercial {" +
                " id = '" + this.id + '\'' +
                ", numeroDeComprobante = '" + this.numeroDeComprobante + '\'' +
                ", fechaDeEmision = '" + this.fechaDeEmision + '\'' +
                ", tipoDeDocumento = '" + this.tipoDeDocumento + '\'' +
                ", precioTotal = '" + this.precioTotal + '\'' +
                ", impuestoTotal = '" + this.impuestoTotal + '\'' +
                ", fechaDeCreacion = '" + this.fechaDeCreacion + '\'' +
                " }";
    }

}