package edu.uade.proveedores.dao;

import edu.uade.proveedores.enumeration.*;
import edu.uade.proveedores.model.Empleado;
import edu.uade.proveedores.model.Proveedor;

import java.util.Date;

/**
 * @author Grupo 5
 */
public class ProveedorDao extends GenericDAO<Proveedor> {

    public ProveedorDao() throws Exception {
        super(Proveedor.class, "Proveedor.json");
    }

    public void save(Proveedor proveedor) throws Exception {
        if (this.getById(proveedor.getId()) != null){
            super.update(proveedor);
        } else {
            super.save(proveedor);
        }
    }

}