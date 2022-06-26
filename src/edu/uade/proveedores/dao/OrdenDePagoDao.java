package edu.uade.proveedores.dao;

import edu.uade.proveedores.model.OrdenDePago;

/**
 * @author Grupo 5
 */
public class OrdenDePagoDao extends GenericDAO<OrdenDePago>{

    public OrdenDePagoDao() throws Exception {
        super(OrdenDePago.class, "OrdenDePago.json");
    }

    public void save(OrdenDePago ordenDePago) throws Exception {
        if (this.getById(ordenDePago.getId()) != null){
            super.update(ordenDePago);
        } else {
            super.save(ordenDePago);
        }
    }

}