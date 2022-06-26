package edu.uade.proveedores.controller;

import edu.uade.proveedores.dao.DocumentoComercialDao;
import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.dto.DeudaDeProveedorDTO;
import edu.uade.proveedores.dto.DocumentoComercialDTO;
import edu.uade.proveedores.enumeration.TipoDocumentoComercial;
import edu.uade.proveedores.model.CuentaCorriente;
import edu.uade.proveedores.model.DocumentoComercial;
import edu.uade.proveedores.model.Proveedor;

import java.util.ArrayList;
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

    public DeudaDeProveedorDTO obtenerDeudaPorProveedor(Long cuitProveedor) {
        DeudaDeProveedorDTO deudaProveedor = new DeudaDeProveedorDTO(0L,0);

        for (Proveedor proveedor : proveedores) {
            if (proveedor.getCuit() == cuitProveedor) {
                deudaProveedor = new DeudaDeProveedorDTO(proveedor.getCuit(),
                        proveedor.getCuentaCorriente().calcularMontoTotalDeDeuda());
            }
        }

        return deudaProveedor;
    }

}