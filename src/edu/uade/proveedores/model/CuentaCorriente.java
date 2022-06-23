package edu.uade.proveedores.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Grupo 5
 */
public class CuentaCorriente extends GenericModel{

    private int numeroDeCC;
    private Float limiteDeDeudaAcordado;
    private Boolean esDeudaSobrepasada;
    private Float limiteDeCredito;
    private Boolean esCreditoSobrepasado;
    private Float montoDeCredito;
    private Float montoDeDeuda;
    private Float montoTotal;
    private Proveedor proveedor;

    public CuentaCorriente(int numeroDeCC, Proveedor proveedor, float limiteDeDeudaAcordado, boolean esDeudaSobrepasada, float limiteDeCredito,
                           boolean esCreditoSobrepasado, float montoDeCredito, float montoDeDeuda, float montoTotal) {

        super();
        this.numeroDeCC = numeroDeCC;
        this.proveedor = proveedor;
        this.limiteDeDeudaAcordado = limiteDeDeudaAcordado;
        this.esDeudaSobrepasada = esDeudaSobrepasada;
        this.limiteDeCredito = limiteDeCredito;
        this.esCreditoSobrepasado = esCreditoSobrepasado;
        this.montoDeCredito = montoDeCredito;
        this.montoDeDeuda = montoDeDeuda;
        this.montoTotal = montoTotal;

    }

    public CuentaCorriente(String id, int numeroDeCC, Proveedor proveedor, float limiteDeDeudaAcordado, boolean esDeudaSobrepasada, float limiteDeCredito,
                           boolean esCreditoSobrepasado, float montoDeCredito, float montoDeDeuda, float montoTotal,
                           Date fechaDeCreacion) {

        super(id,fechaDeCreacion);
        this.numeroDeCC = numeroDeCC;
        this.proveedor = proveedor;
        this.limiteDeDeudaAcordado = limiteDeDeudaAcordado;
        this.esDeudaSobrepasada = esDeudaSobrepasada;
        this.limiteDeCredito = limiteDeCredito;
        this.esCreditoSobrepasado = esCreditoSobrepasado;
        this.montoDeCredito = montoDeCredito;
        this.montoDeDeuda = montoDeDeuda;
        this.montoTotal = montoTotal;

    }

    public int getNumeroDeCC() {
        return numeroDeCC;
    }
    public void setNumeroDeCC(int numeroDeCC) {
        this.numeroDeCC = numeroDeCC;
    }

    public Float getLimiteDeDeudaAcordado() {
        return limiteDeDeudaAcordado;
    }
    public void setLimiteDeDeudaAcordado(Float limiteDeDeudaAcordado) {
        this.limiteDeDeudaAcordado = limiteDeDeudaAcordado;
    }

    public Boolean getEsDeudaSobrepasada() {
        return esDeudaSobrepasada;
    }
    public void setEsDeudaSobrepasada(Boolean esDeudaSobrepasada) {
        this.esDeudaSobrepasada = esDeudaSobrepasada;
    }

    public Float getLimiteDeCredito() {
        return limiteDeCredito;
    }
    public void setLimiteDeCredito(Float limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public Boolean getEsCreditoSobrepasado() {
        return esCreditoSobrepasado;
    }
    public void setEsCreditoSobrepasado(Boolean esCreditoSobrepasado) {
        this.esCreditoSobrepasado = esCreditoSobrepasado;
    }

    public Float getMontoDeCredito() {
        return montoDeCredito;
    }
    public void setMontoDeCredito(Float montoDeCredito) {
        this.montoDeCredito = montoDeCredito;
    }

    public Float getMontoDeDeuda() {
        return montoDeDeuda;
    }
    public void setMontoDeDeuda(Float montoDeDeuda) {
        this.montoDeDeuda = montoDeDeuda;
    }

    public Float getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(Float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Proveedor getProveedor() { return proveedor; }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return "CuentaCorriente {" +
                " id = '" + this.id + '\'' +
                ", numeroDeCC = '" + this.numeroDeCC + '\'' +
                ", proveedor = '" + this.proveedor + '\'' +
                ", limiteDeDeudaAcordado = '" + this.limiteDeDeudaAcordado + '\'' +
                ", esDeudaSobrepasada = '" + this.esDeudaSobrepasada + '\'' +
                ", limiteDeCredito = '" + this.limiteDeCredito + '\'' +
                ", esCreditoSobrepasado = '" + this.esCreditoSobrepasado + '\'' +
                ", montoDeCredito = '" + this.montoDeCredito + '\'' +
                ", montoDeDeuda = '" + this.montoDeDeuda + '\'' +
                ", montoTotal = '" + this.montoTotal + '\'' +
                ", fechaDeCreacion = '" + formatter.format(this.fechaDeCreacion) + '\'' +
                " }";

    }
}