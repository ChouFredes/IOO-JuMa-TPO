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
        ArrayList<ProductoDTO> productosDTO = new ArrayList<>();

        for (Proveedor proveedor: proveedores) {
            for (Producto producto: proveedor.getProductos()) {
                productosDTO.add(ProductoDTO.toDTO(proveedor,producto));
            }
        }
        return productosDTO;
    }

    public void actualizarProductoDeProveedor(ProductoDTO productoDTO) throws Exception {
        Producto producto = productoDTO.toModel();
        ProductoDao productoDao = (new ProductoDao());
        int indice = -1;

        for (Proveedor proveedor : proveedores) {
            if (proveedor.getCuit().equals(productoDTO.cuitDelProveedor)) {
                for (Producto prod: proveedor.getProductos()) {
                    if (prod.getId().equals(productoDTO.id)){
                        indice = proveedor.getProductos().indexOf(prod);
                    }
                }
                if (indice > -1) {
                    proveedor.getProductos().set(indice,producto);
                } else {
                    proveedor.getProductos().add(producto);
                }
                (new ProveedorDao()).save(proveedor);
                productoDao.save(producto);
            }
        }

        this.actualizarProveedores();
    }

    public void eliminarProductoDeProveedor(ProductoDTO productoDTO) throws Exception {
        int indiceDeProducto = -1;
        Proveedor proveedor = null;
        ProductoDao productoDao = (new ProductoDao());
        for (Proveedor prov:proveedores) {
            if (prov.getCuit().equals(productoDTO.cuitDelProveedor)) {
                for (Producto pr:prov.getProductos()){
                    if (pr.getId().equals(productoDTO.id)) {
                        indiceDeProducto = prov.getProductos().indexOf(pr);
                        proveedor = prov;
                    }
                }
            }
        }
        if (indiceDeProducto > -1 && proveedor != null) {
            proveedor.getProductos().remove(indiceDeProducto);
            (new ProveedorDao()).save(proveedor);
            productoDao.delete(productoDTO.id);
        }

        this.actualizarProveedores();
    }

 /*
    private void actualizarProductos(Long cuit) throws Exception {
        int indiceDeProveedor = -1;
        for (Proveedor proveedor:proveedores){
            if (proveedor.getCuit().equals(cuit)) {
                indiceDeProveedor = proveedores.indexOf(proveedor);
            }
        }
    }

  */
}
