package edu.uade.proveedores.model;

import java.util.Date;
import java.util.UUID;

/**
 * @author Grupo 5
 * @members
 */
public class Empleado extends GenericModel {

    private Integer empleadoId;
    private String nombre;
    private String apellido;
    private Integer documento;

    public Empleado(Integer empleadoId, String nombre, String apellido, Integer documento) {

        super();
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }

    public Empleado(String id, Integer empleadoId, String nombre, String apellido, Integer documento, Date fechaDeCreacion) {

        super(id,fechaDeCreacion);
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;

    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }
    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDocumento() {
        return documento;
    }
    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Empleado {" +
                " id = '" + this.id + '\'' +
                ", empleadoId = '" + this.empleadoId + '\'' +
                ", nombre = '" + this.nombre + '\'' +
                ", apellido = '" + this.apellido + '\'' +
                ", documento = '" + this.documento + '\'' +
                " }";
    }

}