package edu.uade.proveedores.dao;

import edu.uade.proveedores.model.DocumentoComercial;

/**
 * @author Grupo 5
 */
public class OrdenDePagoDao extends GenericDAO<DocumentoComercial>{

    public OrdenDePagoDao() throws Exception {
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