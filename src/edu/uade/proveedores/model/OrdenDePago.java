package edu.uade.proveedores.model;
import edu.uade.proveedores.enumeration.TipoDocumentoComercial;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author Grupo 5
 */
public class OrdenDePago extends GenericModel {
    List<DocumentoComercial> facturas = new ArrayList<>();
    List<DocumentoComercial> notasDeCredito = new ArrayList<>();
    List<DocumentoComercial> notasDeDebito = new ArrayList<>();
    private Long numeroDeOrden;
    public Date getFechaDeEmision() {
        return fechaDeEmision;
    }
    public void setFechaDeEmision(Date fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }
    private Date fechaDeEmision;
    private Float totalACancelar;
    private Float totalDeRetenciones;
    private boolean liquidada;
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
    public boolean isLiquidada() {
        return liquidada;
    }
    public void setLiquidada(boolean liquidada) {
        this.liquidada = liquidada;
    }

    public OrdenDePago(long numeroDeOrden, Date fechaDeEmision) {
        this.numeroDeOrden = numeroDeOrden;
        this.fechaDeEmision = fechaDeEmision;
        this.totalACancelar = 0f;
        this.totalDeRetenciones = 0f;
    }

    @Override
    public String toString() {
        return null;
    }

    public int getCantidadDeFacturas() {
        if (facturas == null)
            facturas = new ArrayList<>();

        return facturas.size();
    }
    public int getCantidadDeNC() {
        if (notasDeCredito == null)
            notasDeCredito = new ArrayList<>();

        return notasDeCredito.size();
    }
    public int getCantidadDeND() {
        if (notasDeDebito == null)
            notasDeDebito = new ArrayList<>();

        return notasDeDebito.size();
    }

    public void agregarFactura(DocumentoComercial factura) {
        if (factura.getTipoDeDocumento() == TipoDocumentoComercial.FACTURA)
            facturas.add(factura);
    }
}