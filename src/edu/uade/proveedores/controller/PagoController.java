package edu.uade.proveedores.controller;

/**
 * @author Grupo 5
 */
public class PagoController {

    private PagoController instance;

    public PagoController() {
    }

    public PagoController getInstance(){
        if (instance != null){
            instance = new PagoController();
        }
        return instance;
    }

}