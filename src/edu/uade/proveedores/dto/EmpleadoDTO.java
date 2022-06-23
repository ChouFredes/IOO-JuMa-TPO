package edu.uade.proveedores.dto;

import edu.uade.proveedores.model.DocumentoComercial;
import edu.uade.proveedores.model.Empleado;
import edu.uade.proveedores.model.Proveedor;

import java.util.Date;

public class EmpleadoDTO extends GenericDTO{

    public final String id;
    public final Date fechaDeCreacion;
    public final Integer empleadoId;
    public final String nombre;
    public final String apellido;
    public final Integer documento;

    public EmpleadoDTO(String id, Integer empleadoId, String nombre, String apellido, Integer documento, Date fechaDeCreacion) {

        this.id = id;
        this.fechaDeCreacion = fechaDeCreacion;
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;

    }

    public static EmpleadoDTO toDTO(Empleado model) {
        return new EmpleadoDTO(model.getId(), model.getEmpleadoId(), model.getNombre(), model.getApellido(),
                model.getDocumento(), model.getFechaDeCreacion());
    }

    public Empleado toModel() {
        Empleado model;

        if (this.id != null) {
            model = new Empleado(this.id, this.empleadoId, this.nombre, this.apellido, this.documento, this.fechaDeCreacion);
        } else {
            model = new Empleado(this.empleadoId, this.nombre, this.apellido, this.documento);
        }

        return model;

    }

    @Override
    public String toString() {
        return "EmpleadoDTO {" +
                " id = '" + this.id + '\'' +
                ", empleadoId = '" + this.empleadoId + '\'' +
                ", nombre = '" + this.nombre + '\'' +
                ", apellido = '" + this.apellido + '\'' +
                ", documento = '" + this.documento + '\'' +
                " }";
    }
}
