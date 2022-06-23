package edu.uade.proveedores.dao;

import edu.uade.proveedores.enumeration.TipoProducto;
import edu.uade.proveedores.model.Producto;

/**
 * @author Grupo 5
 */
public class ProductoDao extends GenericDAO<Producto> {

    public ProductoDao(Class<Producto> clase, String file) throws Exception {
        super(clase, file);
    }
}