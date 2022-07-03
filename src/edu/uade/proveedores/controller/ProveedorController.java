package edu.uade.proveedores.controller;

import edu.uade.proveedores.dao.ProductoDao;
import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.dto.DeudaDeProveedorDTO;
import edu.uade.proveedores.dto.OrdenDePagoEmitidaDTO;
import edu.uade.proveedores.dto.ProductoDTO;
import edu.uade.proveedores.model.OrdenDePago;
import edu.uade.proveedores.model.Producto;
import edu.uade.proveedores.model.Proveedor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grupo 5
 */
public class ProveedorController {

    private static ProveedorController instance;
    private List<Proveedor> proveedores;
    private List<Producto> productos;

    public ProveedorController() throws Exception {
        actualizarProveedores();
        actualizarProductos();
    }

    private void actualizarProveedores() throws Exception {
        this.proveedores = (new ProveedorDao()).getAll();
    }

    private void actualizarProductos() throws Exception {
        this.productos = (new ProductoDao()).getAll();
    }

    public static synchronized ProveedorController getInstance() throws Exception {
        if (instance == null){
            instance = new ProveedorController();
        }
        return instance;
    }

    public ArrayList<DeudaDeProveedorDTO> obtenerDeudaPorProveedor(Long cuitProveedor) {
        ArrayList<DeudaDeProveedorDTO> deudaDeProveedores = new ArrayList<DeudaDeProveedorDTO>();

        for (Proveedor proveedor : proveedores) {
            if (cuitProveedor == null || (cuitProveedor != null && proveedor.getCuit() == cuitProveedor)) {
                deudaDeProveedores.add(
                        new DeudaDeProveedorDTO(
                                proveedor.getCuit(),
                                proveedor.getCuentaCorriente().calcularMontoTotalDeDeuda()));
            }
        }

        return deudaDeProveedores;
    }
    public ArrayList<Long> obtenerCuitProveedores() throws Exception {
        ArrayList<Long> cuits = new ArrayList<Long>();
        actualizarProveedores();
        for (Proveedor proveedor : proveedores) {
            Long cuit = proveedor.getCuit();
            cuits.add(cuit);
            }
        return cuits;
    }

    public ArrayList<OrdenDePagoEmitidaDTO> obtenerOrdenesDePagoEmitidas() {
        ArrayList<OrdenDePagoEmitidaDTO> ordenesEmitidas =  new ArrayList<>();

        for (Proveedor proveedor: proveedores) {
            for (OrdenDePago orden : proveedor.getCuentaCorriente().getPagosRealizados()) {
                ordenesEmitidas.add(new OrdenDePagoEmitidaDTO(orden.getNumeroDeOrden(), orden.getFechaDeEmision(), proveedor.getCuit(),
                        proveedor.getRazonSocial(),
                        proveedor.getCuentaCorriente().getNumeroDeCC(), orden.getCantidadDeFacturas(), orden.getCantidadDeNC(),
                        orden.getCantidadDeND(), orden.getTotalACancelar(), orden.getTotalDeRetenciones(), orden.isLiquidada()));
            }
        }

        return ordenesEmitidas;
    }

    public ArrayList<ProductoDTO> obtenerProductos() {
        for (Producto producto: productos) {

        }
        return new ArrayList<>();
    }

    public void agregarProductoDeProveedor(ProductoDTO productoDTO) {
    }

    public void eliminarProductoDeProveedor(ProductoDTO remove) {
    }
}
