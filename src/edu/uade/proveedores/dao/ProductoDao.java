package edu.uade.proveedores.dao;

import edu.uade.proveedores.enumeration.TipoProducto;
import edu.uade.proveedores.model.Empleado;
import edu.uade.proveedores.model.Producto;

/**
 * @author Grupo 5
 */
public class ProductoDao extends GenericDAO<Producto> {

    public ProductoDao() throws Exception {
        super(Producto.class, "Producto.json");
    }

    public void save(Producto producto) throws Exception {
        if (this.getById(producto.getId()) != null){
            super.update(producto);
        } else {
            super.save(producto);
        }
    }
}