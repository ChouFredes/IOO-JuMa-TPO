package edu.uade.proveedores.dao;

import edu.uade.proveedores.model.OrdenDeCompra;

import java.util.Date;

/**
 * @author Grupo 5
 */
public class OrdenDeCompraDao extends GenericDAO<OrdenDeCompra> {

    public OrdenDeCompraDao(Class<OrdenDeCompra> clase, String file) throws Exception {
        super(clase, file);
    }
}