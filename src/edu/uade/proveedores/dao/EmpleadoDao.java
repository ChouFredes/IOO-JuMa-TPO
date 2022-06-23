package edu.uade.proveedores.dao;

import edu.uade.proveedores.model.Empleado;

import java.io.FileNotFoundException;

/**
 * @author Grupo 5
 * @members
 */
public class EmpleadoDao extends GenericDAO<Empleado> {

    public EmpleadoDao() throws Exception {
        super(Empleado.class, "Empleado.json");
    }

    public void save(Empleado empleado) throws Exception {
        if (this.getById(empleado.getId()) != null){
            super.update(empleado);
        } else {
            super.save(empleado);
        }
    }

}