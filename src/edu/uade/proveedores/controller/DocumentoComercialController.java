package edu.uade.proveedores.controller;

import edu.uade.proveedores.dto.DocumentoComercialDTO;
import edu.uade.proveedores.enumeration.TipoDocumentoComercial;
import edu.uade.proveedores.model.DocumentoComercial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentoComercialController {

    DocumentoComercialController instance;
    List<DocumentoComercial> documentosRecibidos;

    private DocumentoComercialController(){}

    public DocumentoComercialController getInstance(){
        if (instance != null){
            instance = new DocumentoComercialController();
        }
        return instance;
    }

    public List<DocumentoComercialDTO> getFacturasPorDiaPorProveedor(Date fecha) {

        List<DocumentoComercialDTO> documentosDTO = new ArrayList<DocumentoComercialDTO>();

        for (DocumentoComercial doc : documentosRecibidos) {
            if (doc.getFechaDeEmision() == fecha && doc.getTipoDeDocumento() == TipoDocumentoComercial.FACTURA){
                documentosDTO.add(DocumentoComercialDTO.toDTO(doc));
            }
        }

        return documentosDTO;

    }
}
