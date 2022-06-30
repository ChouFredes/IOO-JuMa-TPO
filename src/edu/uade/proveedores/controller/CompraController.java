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

    public ArrayList<DocumentoComercialDTO> getFacturaPorDiaPorProveedor(Date fecha, Long cuitProveedor) {

        ArrayList<DocumentoComercialDTO> documentos = new ArrayList<>();
        Date fechaDocumento;
        TipoDocumentoComercial tipoDocumento;
        DocumentoComercialDTO dto;

        for (DocumentoComercial documento : documentosComerciales) {
            fechaDocumento = documento.getFechaDeEmision();
            tipoDocumento = documento.getTipoDeDocumento();

            if (tipoDocumento == TipoDocumentoComercial.FACTURA) {
                if (fecha != null && cuitProveedor == null) {
                    if (fecha.equals(fechaDocumento)) {
                        dto = DocumentoComercialDTO.toDTO(documento);
                        documentos.add(dto);
                    }
                } else if (fecha == null && cuitProveedor != null) {
                    if (documento.getProveedor().getCuit().equals(cuitProveedor)) {
                        dto = DocumentoComercialDTO.toDTO(documento);
                        documentos.add(dto);
                    }
                } else if (fecha != null & cuitProveedor != null) {
                    if (fecha.equals(fechaDocumento) && documento.getProveedor().getCuit().equals(cuitProveedor)) {
                        dto = DocumentoComercialDTO.toDTO(documento);
                        documentos.add(dto);
                    }
                }
            }
        }

        return documentos;

    }

    public ArrayList<DocumentoComercialDTO> getFacturaPorFecha(Date fecha){

        ArrayList<DocumentoComercialDTO> documentos = new ArrayList<>();
        Date fechaDocumento;
        TipoDocumentoComercial tipoDocumento;
        DocumentoComercialDTO dto;

        for (DocumentoComercial documento: documentosComerciales ) {
            fechaDocumento = documento.getFechaDeEmision();
            tipoDocumento = documento.getTipoDeDocumento();

            if (fecha.equals(fechaDocumento) && tipoDocumento == TipoDocumentoComercial.FACTURA){
                dto = DocumentoComercialDTO.toDTO(documento);
                documentos.add(dto);
            }

        }

        return documentos;
    }

    public ArrayList<DocumentoComercialDTO> getFacturaPorProveedor(Long cuit){

        ArrayList<DocumentoComercialDTO> documentos = new ArrayList<>();
        TipoDocumentoComercial tipoDocumento;
        DocumentoComercialDTO dto;

        for (DocumentoComercial documento: documentosComerciales ) {
            tipoDocumento = documento.getTipoDeDocumento();

            if (tipoDocumento == TipoDocumentoComercial.FACTURA & documento.getProveedor().getCuit().equals(cuit)){
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

    public ArrayList<Date> obtenerListaFechasFacturas() throws Exception {
        ArrayList<Date> fechas = new ArrayList<>();
        actualizarDocumentosComerciales();
        for (DocumentoComercial documento : documentosComerciales) {
            TipoDocumentoComercial tipoDocumento = documento.getTipoDeDocumento();
            Date fechaDocumento = documento.getFechaDeEmision();
            if (!fechas.contains(fechaDocumento) && tipoDocumento == TipoDocumentoComercial.FACTURA) {
                fechas.add(fechaDocumento);
            }
        }
        return fechas;
    }
}