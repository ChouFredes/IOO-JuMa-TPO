package edu.uade.proveedores.controller;

import edu.uade.proveedores.dao.DocumentoComercialDao;
import edu.uade.proveedores.dao.OrdenDePagoDao;
import edu.uade.proveedores.dto.*;
import edu.uade.proveedores.enumeration.TipoDocumentoComercial;
import edu.uade.proveedores.model.DocumentoComercial;
import edu.uade.proveedores.model.OrdenDePago;

import java.util.ArrayList;
import java.util.Date;
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

    public ArrayList<OrdenDePagoEmitidaDTO> obtenerOrdenesDePagoEmitidas() {
        ArrayList<OrdenDePagoEmitidaDTO> ordenesEmitidas =  new ArrayList<>();

        for (OrdenDePago orden: ordenesDePago) {
            ordenesEmitidas.add(OrdenDePagoEmitidaDTO.toDTO(orden));
        }

        return ordenesEmitidas;
    }

}