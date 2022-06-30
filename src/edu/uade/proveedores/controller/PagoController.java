package edu.uade.proveedores.controller;

import edu.uade.proveedores.dao.OrdenDePagoDao;
import edu.uade.proveedores.dto.OrdenDePagoEmitidaDTO;
import edu.uade.proveedores.model.OrdenDePago;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grupo 5
 */
public class PagoController {

    private static PagoController instance;
    private List<OrdenDePago> ordenesDePago;

    private PagoController() throws Exception {
        actualizarOrdenesDePago();
    }

    public static synchronized PagoController getInstance() throws Exception {
        if (instance == null) {
            instance = new PagoController();
        }
        return instance;
    }

    private synchronized void actualizarOrdenesDePago() throws Exception {
        this.ordenesDePago = (new OrdenDePagoDao()).getAll();
    }

}