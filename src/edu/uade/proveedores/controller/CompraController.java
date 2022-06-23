package edu.uade.proveedores.controller;

import edu.uade.proveedores.dao.DocumentoComercialDao;
import edu.uade.proveedores.dto.DocumentoComercialDTO;
import edu.uade.proveedores.dto.EmpleadoDTO;
import edu.uade.proveedores.dto.ProveedorDTO;
import edu.uade.proveedores.enumeration.TipoDocumentoComercial;
import edu.uade.proveedores.model.DocumentoComercial;
import edu.uade.proveedores.model.Proveedor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Grupo 5
 */
public class CompraController {

    private static CompraController instance;
    private List<DocumentoComercial> documentosComerciales;

    private CompraController() throws Exception {
        actualizarDocumentosComerciales();
    }

    public static synchronized CompraController getInstance() throws Exception {
        if (instance == null) {
            instance = new CompraController();
        }
        return instance;
    }

    private synchronized void actualizarDocumentosComerciales() throws Exception {
        this.documentosComerciales = (new DocumentoComercialDao()).getAll();
    }

    public ArrayList<DocumentoComercialDTO> getFacturaPorDiaPorProveedor(Date fecha, ProveedorDTO proveedor){

        ArrayList<DocumentoComercialDTO> documentos = new ArrayList<DocumentoComercialDTO>();
        Date fechaDocumento;
        TipoDocumentoComercial tipoDocumento;
        DocumentoComercialDTO dto;

        for (DocumentoComercial documento: documentosComerciales ) {
            fechaDocumento = documento.getFechaDeEmision();
            tipoDocumento = documento.getTipoDeDocumento();

            if (fecha.equals(fechaDocumento) && tipoDocumento == TipoDocumentoComercial.FACTURA & documento.getProveedor().getCuit().equals(proveedor.cuit)){
                dto = DocumentoComercialDTO.toDTO(documento);
                documentos.add(dto);
            }

        }

        return documentos;
    }

    public void agregarFacturaConAutorizacion(DocumentoComercialDTO documentoDTO, ProveedorDTO proveedorDTO, EmpleadoDTO empleadoCargaDTO, EmpleadoDTO empleadoAutorizaDTO) throws Exception {

        DocumentoComercialDao daoDocumento = new DocumentoComercialDao();
        DocumentoComercial documento = documentoDTO.toModel();

        documento.setProveedor(proveedorDTO.toModel());
        documento.setCreador(empleadoCargaDTO.toModel());
        documento.setAutorizador(empleadoAutorizaDTO.toModel());

        daoDocumento.save(documento);
        this.actualizarDocumentosComerciales();

    }

    public void agregarFactura(DocumentoComercialDTO documentoDTO, ProveedorDTO proveedorDTO, EmpleadoDTO empleadoCargaDTO) throws Exception {

        DocumentoComercialDao daoDocumento = new DocumentoComercialDao();
        DocumentoComercial documento = documentoDTO.toModel();

        documento.setProveedor(proveedorDTO.toModel());
        documento.setCreador(empleadoCargaDTO.toModel());

        daoDocumento.save(documento);
        this.actualizarDocumentosComerciales();

    }

}