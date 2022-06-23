package edu.uade.proveedores.dto;

import edu.uade.proveedores.enumeration.TipoDocumentoComercial;
import edu.uade.proveedores.enumeration.TipoIVA;
import edu.uade.proveedores.model.DocumentoComercial;
import edu.uade.proveedores.model.Empleado;
import edu.uade.proveedores.model.GenericModel;
import edu.uade.proveedores.model.Proveedor;

import java.util.Date;

public class DocumentoComercialDTO extends GenericDTO {

    public final Date fechaDeCreacion;
    public final String id;
    public final String numeroDeComprobante;
    public final Date fechaDeEmision;
    public final TipoDocumentoComercial tipoDeDocumento;

    public final TipoIVA iva;
    public final Float precioTotal;
    public final Float impuestoTotal;

    public DocumentoComercialDTO(String id, String numeroDeComprobante, Date fechaDeEmision,
                                 TipoDocumentoComercial tipoDeDocumento, TipoIVA iva,
                                 float precioTotal, float impuestoTotal, Date fechaDeCreacion) {

        this.id = id;
        this.numeroDeComprobante = numeroDeComprobante;
        this.fechaDeEmision = fechaDeEmision;
        this.tipoDeDocumento = tipoDeDocumento;
        this.iva = iva;
        this.precioTotal = precioTotal;
        this.impuestoTotal = impuestoTotal;
        this.fechaDeCreacion = fechaDeCreacion;

    }

    public DocumentoComercial toModel() {
        DocumentoComercial model;

        if (this.id != null) {
            model = new DocumentoComercial(this.id, this.numeroDeComprobante, fechaDeEmision, this.tipoDeDocumento, this.iva,
                    this.precioTotal, this.impuestoTotal, this.fechaDeCreacion, null, null);
        } else {
            model = new DocumentoComercial(this.numeroDeComprobante, fechaDeEmision, this.tipoDeDocumento, this.iva,
                    this.precioTotal, this.impuestoTotal, null, null);
        }

        return model;
    }

    public static DocumentoComercialDTO toDTO(DocumentoComercial model) {
        return new DocumentoComercialDTO(model.getId(), model.getNumeroDeComprobante(),
                model.getFechaDeEmision(), model.getTipoDeDocumento(), model.getIva(),
                model.getPrecioTotal(), model.getImpuestoTotal(), model.getFechaDeCreacion());
    }

    @Override
    public String toString() {
        return "DocumentoComercialDTO {" +
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
