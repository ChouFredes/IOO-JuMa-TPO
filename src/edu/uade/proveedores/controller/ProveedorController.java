package edu.uade.proveedores.controller;

import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.dto.DeudaDeProveedorDTO;
import edu.uade.proveedores.model.Proveedor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Grupo 5
 */
public class ProveedorController {

    private static ProveedorController instance;
    private List<Proveedor> proveedores;

    public ProveedorController() throws Exception {
        actualizarProveedores();
    }

    private void actualizarProveedores() throws Exception {
        this.proveedores = (new ProveedorDao()).getAll();
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
}
