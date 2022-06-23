package edu.uade.proveedores.controller;

/**
 * @author Grupo 5
 */
public class EmpleadoController {

    private EmpleadoController instance;
    /**
     * Default constructor
     */
    private EmpleadoController() {
    }

    public EmpleadoController getInstance(){
        if (instance != null){
            instance = new EmpleadoController();
        }
        return instance;
    }

}