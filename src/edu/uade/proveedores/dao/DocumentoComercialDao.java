package edu.uade.proveedores.dao;

import edu.uade.proveedores.model.DocumentoComercial;
import edu.uade.proveedores.model.Empleado;

import java.util.ArrayList;

/**
 * @author Grupo 5
 */
public class DocumentoComercialDao extends GenericDAO<DocumentoComercial>{

    public DocumentoComercialDao() throws Exception {
        super(DocumentoComercial.class, "DocumentoComercial.json");
    }

    public void save(DocumentoComercial documentoComercial) throws Exception {
        if (this.getById(documentoComercial.getId()) != null){
            super.update(documentoComercial);
        } else {
            super.save(documentoComercial);
        }
    }

}