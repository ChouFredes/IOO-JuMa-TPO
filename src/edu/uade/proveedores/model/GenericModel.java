package edu.uade.proveedores.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public abstract class GenericModel {

    protected UUID id;
    protected Date fechaDeCreacion;

    public GenericModel() {
        this.id = UUID.randomUUID();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        this.fechaDeCreacion = Calendar.getInstance().getTime();
    }

    public GenericModel(String id, Date fechaDeCreacion) {
        this.id = UUID.fromString(id);
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getId() {
        return id.toString();
    }


    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        return this.id.hashCode() == ((GenericModel) obj).id.hashCode();
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

}