package edu.uade.proveedores.test;

import edu.uade.proveedores.dao.CuentaCorrienteDao;
import edu.uade.proveedores.dao.ProductoDao;
import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.enumeration.TipoIVA;
import edu.uade.proveedores.enumeration.TipoImpuesto;
import edu.uade.proveedores.enumeration.TipoImpuestoProducto;
import edu.uade.proveedores.enumeration.TipoProducto;
import edu.uade.proveedores.model.Producto;
import edu.uade.proveedores.model.Proveedor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductoTest {

    @Test
    public void creaProducto() throws Exception {
        ProveedorDao pDao = new ProveedorDao();
        Proveedor proveedor = pDao.getById("b85ab4c6-64db-4e30-bc37-6cc1e77a20e2");

        Producto producto = new Producto("UnProducto",1000.50f,1,proveedor.getRubro(), TipoImpuestoProducto.IVA_10_5);
        (new ProductoDao()).save(producto);

        List<Producto> productos = proveedor.getProductos();
        productos.add(producto);

        pDao.save(proveedor);

    }
}
