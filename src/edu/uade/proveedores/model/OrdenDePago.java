package edu.uade.proveedores.model;
import java.util.Date;
import java.util.List;
/**
 * @author Grupo 5
 */
public class OrdenDePago extends GenericModel {
    List<DocumentoComercial> facturas;
    List<DocumentoComercial> notasDeCredito;
    List<DocumentoComercial> notasDeDebito;
    private Long numeroDeOrden;
    public Date getFechaDeEmision() {
        return fechaDeEmision;
    }
    public OrdenDePago(long numeroDeOrden, CuentaCorriente cuentaCorriente, Date fechaDeEmision) {
        this.numeroDeOrden = numeroDeOrden;
        this.cuentaCorriente = cuentaCorriente;
        this.fechaDeEmision = fechaDeEmision;
    }
    public void setFechaDeEmision(Date fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }
    private Date fechaDeEmision;
    private Float totalACancelar;
    private Float totalDeRetenciones;
    private boolean liquidada;
    private CuentaCorriente cuentaCorriente;
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
    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }
    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }
    public OrdenDePago() {
    }
    @Override
    public String toString() {
        return null;
    }
    public int getCantidadDeFacturas() {
        return facturas.size();
    }
    public int getCantidadDeNC() {
        return notasDeCredito.size();
    }
    public int getCantidadDeND() {
        return notasDeDebito.size();
    }
}