package edu.uade.proveedores.model;

import edu.uade.proveedores.enumeration.TipoImpuesto;

import java.util.*;

/**
 * @author Grupo 5
 */
public class CertificadoNoRetencion extends GenericModel {

    private Long certificadoId;
    private Date fechaDeEmision;
    private Date fechaDeVencimiento;
    private TipoImpuesto impuesto;

    public CertificadoNoRetencion(Long numeroDeCertificado, Date fechaDeEmision, Date fechaDeVencimiento,
                                  TipoImpuesto impuesto) {
        super();
        this.certificadoId = numeroDeCertificado;
        this.fechaDeEmision = fechaDeEmision;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.impuesto = impuesto;

    }

    public CertificadoNoRetencion(String id, Long numeroDeCertificado, Date fechaDeEmision, Date fechaDeVencimiento,
                                  TipoImpuesto impuesto, Date fechaDeCreacion) {
        super(id,fechaDeCreacion);
        this.certificadoId = numeroDeCertificado;
        this.fechaDeEmision = fechaDeEmision;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.impuesto = impuesto;

    }

    public Long getCertificadoId() {
        return certificadoId;
    }
    public void setCertificadoId(Long certificadoId) {
        this.certificadoId = certificadoId;
    }

    public Date getFechaDeEmision() {
        return fechaDeEmision;
    }
    public void setFechaDeEmision(Date fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }

    public Date getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }
    public void setFechaDeVencimiento(Date fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public TipoImpuesto getImpuesto() {
        return impuesto;
    }
    public void setImpuesto(TipoImpuesto impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public String toString() {
        return "CertificadoNoRetencion {" +
                " id = '" + this.id + '\'' +
                ", certificadoId = '" + this.certificadoId + '\'' +
                ", fechaDeEmision = '" + this.fechaDeEmision + '\'' +
                ", fechaDeVencimiento = '" + this.fechaDeVencimiento + '\'' +
                ", impuesto = '" + this.impuesto + '\'' +
                ", fechaDeCreacion = '" + this.fechaDeCreacion + '\'' +
                " }";
    }

}