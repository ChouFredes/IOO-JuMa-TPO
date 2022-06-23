package edu.uade.proveedores.dto;

import edu.uade.proveedores.enumeration.TipoResponsabilidad;
import edu.uade.proveedores.enumeration.TipoRubro;
import edu.uade.proveedores.model.DocumentoComercial;
import edu.uade.proveedores.model.Proveedor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProveedorDTO extends GenericDTO{

    public final String id;
    public final Date fechaDeCreacion;
    public final Long cuit;
    public final String razonSocial;
    public final String nombreDeFantasia;
    public final String direccion;
    public final String telefono;
    public final String correoElectronico;
    public final Long numeroIIBB;
    public final Date inicioDeActividades;
    public final TipoRubro rubro;
    public final TipoResponsabilidad responsabilidadIVA;

    public ProveedorDTO(String id, Long cuit, String razonSocial, String nombreDeFantasia, String direccion, String telefono,
                        String correoElectronico, Long numeroIIBB, Date inicioDeActividades, TipoRubro rubro,
                        TipoResponsabilidad responsabilidadIVA, Date fechaDeCreacion) {

        this.id = id;
        this.fechaDeCreacion = fechaDeCreacion;
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

    public static ProveedorDTO toDTO(Proveedor model) {
        return new ProveedorDTO(model.getId(), model.getCuit(), model.getRazonSocial(), model.getNombreDeFantasia(),
                model.getDireccion(), model.getTelefono(), model.getCorreoElectronico(), model.getNumeroIIBB(),
                model.getInicioDeActividades(), model.getRubro(), model.getResponsabilidadIVA(), model.getFechaDeCreacion());
    }

    public Proveedor toModel() {
        Proveedor model;

        if (this.id != null) {
            model = new Proveedor(this.id, this.cuit, this.razonSocial, this.nombreDeFantasia, this.direccion,
                    this.telefono, this.correoElectronico, this.numeroIIBB, this.inicioDeActividades, this.rubro,
                    this.responsabilidadIVA, this.fechaDeCreacion);
        } else {
            model = new Proveedor(this.cuit, this.razonSocial, this.nombreDeFantasia, this.direccion,
                    this.telefono, this.correoElectronico, this.numeroIIBB, this.inicioDeActividades, this.rubro,
                    this.responsabilidadIVA);
        }

        return model;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return "ProveedorDTO {" +
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
