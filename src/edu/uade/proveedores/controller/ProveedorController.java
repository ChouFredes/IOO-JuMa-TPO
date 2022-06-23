package edu.uade.proveedores.controller;

/**
 * @author Grupo 5
 */
public class ProveedorController {

    private ProveedorController instance;

    public ProveedorController() {
    }

    public ProveedorController getInstance(){
        if (instance != null){
            instance = new ProveedorController();
        }
        return instance;
    }

}