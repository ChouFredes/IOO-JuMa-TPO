package edu.uade.proveedores.model;

import edu.uade.proveedores.enumeration.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Grupo 5
 */
public class Proveedor extends GenericModel {

    private Long cuit;
    private String razonSocial;
    private String nombreDeFantasia;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private Long numeroIIBB;
    private Date inicioDeActividades;
    private TipoRubro rubro;
    private TipoResponsabilidad responsabilidadIVA;


    public Proveedor(Long cuit, String razonSocial, String nombreDeFantasia, String direccion, String telefono,
                     String correoElectronico, Long numeroIIBB, Date inicioDeActividades, TipoRubro rubro,
                     TipoResponsabilidad responsabilidadIVA) {

        super();
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.nombreDeFantasia = nombreDeFantasia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.numeroIIBB = numeroIIBB;
        this.inicioDeActividades = inicioDeActividades;
        this.rubro = rubro;
        this.responsabilidadIVA = responsabilidadIVA;

    }

    public Proveedor(String id, Long cuit, String razonSocial, String nombreDeFantasia, String direccion, String telefono,
                     String correoElectronico, Long numeroIIBB, Date inicioDeActividades, TipoRubro rubro,
                     TipoResponsabilidad responsabilidadIVA, Date fechaDeCreacion) {

        super(id,fechaDeCreacion);
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.nombreDeFantasia = nombreDeFantasia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.numeroIIBB = numeroIIBB;
        this.inicioDeActividades = inicioDeActividades;
        this.rubro = rubro;
        this.responsabilidadIVA = responsabilidadIVA;

    }

    public Long getCuit() {
        return cuit;
    }
    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreDeFantasia() {
        return nombreDeFantasia;
    }
    public void setNombreDeFantasia(String nombreDeFantasia) {
        this.nombreDeFantasia = nombreDeFantasia;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Long getNumeroIIBB() {
        return numeroIIBB;
    }
    public void setNumeroIIBB(Long numeroIIBB) {
        this.numeroIIBB = numeroIIBB;
    }

    public Date getInicioDeActividades() {
        return inicioDeActividades;
    }
    public void setInicioDeActividades(Date inicioDeActividades) {
        this.inicioDeActividades = inicioDeActividades;
    }

    public TipoRubro getRubro() {
        return rubro;
    }
    public void setRubro(TipoRubro rubro) {
        this.rubro = rubro;
    }

    public TipoResponsabilidad getResponsabilidadIVA() {
        return responsabilidadIVA;
    }
    public void setResponsabilidadIVA(TipoResponsabilidad responsabilidadIVA) {
        this.responsabilidadIVA = responsabilidadIVA;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return "Proveedor {" +
                " id = '" + this.id + '\'' +
                ", cuit = '" + this.cuit + '\'' +
                ", razonSocial = '" + this.razonSocial + '\'' +
                ", nombreDeFantasia = '" + this.nombreDeFantasia + '\'' +
                ", direccion = '" + this.direccion + '\'' +
                ", telefono = '" + this.telefono + '\'' +
                ", correoElectronico = '" + this.correoElectronico + '\'' +
                ", numeroIIBB = '" + this.numeroIIBB + '\'' +
                ", inicioDeActividades = '" + formatter.format(this.inicioDeActividades) + '\'' +
                ", rubro = '" + this.rubro + '\'' +
                ", responsabilidadIVA = '" + this.responsabilidadIVA + '\'' +
                ", fechaDeCreacion = '" + formatter.format(this.fechaDeCreacion) + '\'' +
                " }";
    }

}