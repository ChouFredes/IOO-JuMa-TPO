package edu.uade.proveedores.dto;

public class OrdenDePagoEmitidaDTO extends GenericDTO {
    public final Long numeroDeOrden;
    public final Long cuitDelProveedor;
    public final String razonSocialDelProveedor;
    public final int numeroDeCCDelProveedor;
    public final int cantidadDeFacturas;
    public final int cantidadDenotasDeCredito;
    public final int cantidadDenotasDeDebito;
    public final Float totalACancelar;
    public final Float totalDeRetenciones;
    public final boolean liquidada;

    public OrdenDePagoEmitidaDTO(Long numeroDeOrden, Long cuitDelProveedor, String razonSocialDelProveedor,
                                 int numeroDeCCDelProveedor, int cantidadDeFacturas, int cantidadDenotasDeCredito,
                                 int cantidadDenotasDeDebito, Float totalACancelar, Float totalDeRetenciones,
                                 boolean liquidada) {
        this.numeroDeOrden = numeroDeOrden;
        this.cuitDelProveedor = cuitDelProveedor;
        this.razonSocialDelProveedor = razonSocialDelProveedor;
        this.numeroDeCCDelProveedor = numeroDeCCDelProveedor;
        this.cantidadDeFacturas = cantidadDeFacturas;
        this.cantidadDenotasDeCredito = cantidadDenotasDeCredito;
        this.cantidadDenotasDeDebito = cantidadDenotasDeDebito;
        this.totalACancelar = totalACancelar;
        this.totalDeRetenciones = totalDeRetenciones;
        this.liquidada = liquidada;
    }

    @Override
    public String toString() {
        return null;
    }
}
