package edu.uade.proveedores.dao;

import edu.uade.proveedores.model.OrdenDePago;

/**
 * @author Grupo 5
 */
public class OrdenDePagoDao extends GenericDAO<OrdenDePago> {

    public OrdenDePagoDao(Class<OrdenDePago> clase, String file) throws Exception {
        super(clase, file);
    }
}