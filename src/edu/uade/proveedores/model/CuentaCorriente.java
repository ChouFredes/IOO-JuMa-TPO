package edu.uade.proveedores.model;

import edu.uade.proveedores.enumeration.TipoDocumentoComercial;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<OrdenDePago> pagosRealizados = new ArrayList<>();
    private List<DocumentoComercial> facturasEntregadas = new ArrayList<>();
    private List<DocumentoComercial> notasDeDebitoEntregadas = new ArrayList<>();
    private List<DocumentoComercial> notasDeCreditoEntregadas = new ArrayList<>();

    public List<OrdenDePago> getPagosRealizados() {
        return pagosRealizados;
    }

    public void setPagosRealizados(List<OrdenDePago> pagosRealizados) {
        this.pagosRealizados = pagosRealizados;
    }

    public List<DocumentoComercial> getFacturasEntregadas() {
        return facturasEntregadas;
    }

    public void setFacturasEntregadas(List<DocumentoComercial> facturasEntregadas) {
        this.facturasEntregadas = facturasEntregadas;
    }

    public List<DocumentoComercial> getNotasDeDebitoEntregadas() {
        return notasDeDebitoEntregadas;
    }

    public void setNotasDeDebitoEntregadas(List<DocumentoComercial> notasDeDebitoEntregadas) {
        this.notasDeDebitoEntregadas = notasDeDebitoEntregadas;
    }

    public List<DocumentoComercial> getNotasDeCreditoEntregadas() {
        return notasDeCreditoEntregadas;
    }

    public void setNotasDeCreditoEntregadas(List<DocumentoComercial> notasDeCreditoEntregadas) {
        this.notasDeCreditoEntregadas = notasDeCreditoEntregadas;
    }

    public CuentaCorriente(int numeroDeCC, float limiteDeDeudaAcordado, boolean esDeudaSobrepasada, float limiteDeCredito,
                           boolean esCreditoSobrepasado, float montoDeCredito, float montoDeDeuda, float montoTotal) {

        super();
        this.numeroDeCC = numeroDeCC;
        this.limiteDeDeudaAcordado = limiteDeDeudaAcordado;
        this.esDeudaSobrepasada = esDeudaSobrepasada;
        this.limiteDeCredito = limiteDeCredito;
        this.esCreditoSobrepasado = esCreditoSobrepasado;
        this.montoDeCredito = montoDeCredito;
        this.montoDeDeuda = montoDeDeuda;
        this.montoTotal = montoTotal;

    }

    public CuentaCorriente(String id, int numeroDeCC, float limiteDeDeudaAcordado, boolean esDeudaSobrepasada, float limiteDeCredito,
                           boolean esCreditoSobrepasado, float montoDeCredito, float montoDeDeuda, float montoTotal,
                           Date fechaDeCreacion) {

        super(id,fechaDeCreacion);
        this.numeroDeCC = numeroDeCC;
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

    public float calcularMontoTotalDeDeuda(){
        float totalMontoFacturas = calcularTotalMontoFacturas();
        float totalMontoNotasDeDebito = calculartotalMontoNotasDeDebito();
        float totalMontoNotasDeCredito = calcularTotalMontoNotasDeCredito();
        float totalPagosRealizados = calcularTotalMontoPagosRealizados();

        return (totalMontoFacturas + totalMontoNotasDeCredito) - (totalPagosRealizados + totalMontoNotasDeDebito) ;
    }

    private float calcularTotalMontoPagosRealizados() {
        float montoTotal = 0;

        if (pagosRealizados == null)
            pagosRealizados = new ArrayList<>();

        for (OrdenDePago op : pagosRealizados) {
            if (op.isLiquidada()){
                montoTotal += op.getTotalACancelar();
            }
        }

        return montoTotal;
    }

    private float calcularTotalMontoNotasDeCredito() {
        float montoTotal = 0;

        if (notasDeCreditoEntregadas == null)
            notasDeCreditoEntregadas = new ArrayList<>();

        for (DocumentoComercial nc : notasDeCreditoEntregadas) {
            montoTotal += nc.getPrecioTotal();
        }

        return montoTotal;
    }

    private float calculartotalMontoNotasDeDebito() {
        float montoTotal = 0;

        if (notasDeDebitoEntregadas == null)
            notasDeDebitoEntregadas = new ArrayList<>();

        for (DocumentoComercial nd : notasDeDebitoEntregadas) {
            montoTotal += nd.getPrecioTotal();
        }

        return montoTotal;
    }

    public float calcularTotalMontoFacturas(){
        float montoTotal = 0;

        if (facturasEntregadas == null)
            facturasEntregadas = new ArrayList<>();

        for (DocumentoComercial fac : facturasEntregadas) {
            montoTotal += fac.getPrecioTotal();
        }

        return montoTotal;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return "CuentaCorriente {" +
                " id = '" + this.id + '\'' +
                ", numeroDeCC = '" + this.numeroDeCC + '\'' +
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

    public void agregarOrdeDePago(OrdenDePago ordenDePago) {
        pagosRealizados.add(ordenDePago);
    }

    public void agregarFactura(DocumentoComercial factura) {
        if (factura.getTipoDeDocumento() == TipoDocumentoComercial.FACTURA)
            facturasEntregadas.add(factura);
    }
}