package edu.uade.proveedores.dao;

import edu.uade.proveedores.model.Proveedor;

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