package edu.uade.proveedores.controller;

import edu.uade.proveedores.dao.DocumentoComercialDao;
import edu.uade.proveedores.dto.DocumentoComercialDTO;
import edu.uade.proveedores.dto.EmpleadoDTO;
import edu.uade.proveedores.dto.ProveedorDTO;
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
    private List<OrdenDePago> ordenDePagoList;

    private PagoController() throws Exception {
        actualizarDocumentosComerciales();
    }

    public static synchronized PagoController getInstance() throws Exception {
        if (instance == null) {
            instance = new PagoController();
        }
        return instance;
    }

    private synchronized void actualizarOrdenesDePago() throws Exception {
        this.ordenDePagoList = (new DocumentoComercialDao()).getAll();
    }

    public ArrayList<DocumentoComercialDTO> getFacturaPorDiaPorProveedor(Date fecha, ProveedorDTO proveedor){

        ArrayList<DocumentoComercialDTO> documentos = new ArrayList<DocumentoComercialDTO>();
        Date fechaDocumento;
        TipoDocumentoComercial tipoDocumento;
        DocumentoComercialDTO dto;

        for (OrdenDePago odp: ordenDePagoList ) {
            fechaDocumento = odp.getFechaDeEmision();
            tipoDocumento = odp.getTipoDeDocumento();

            if (fecha.equals(fechaDocumento) && tipoDocumento == TipoDocumentoComercial.FACTURA & odp.getProveedor().getCuit().equals(proveedor.cuit)){
                dto = DocumentoComercialDTO.toDTO(odp);
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
        this.actualizarOrdenesDePago();

    }

    public void agregarFactura(DocumentoComercialDTO documentoDTO, ProveedorDTO proveedorDTO, EmpleadoDTO empleadoCargaDTO) throws Exception {

        DocumentoComercialDao daoDocumento = new DocumentoComercialDao();
        DocumentoComercial documento = documentoDTO.toModel();

        documento.setProveedor(proveedorDTO.toModel());
        documento.setCreador(empleadoCargaDTO.toModel());

        daoDocumento.save(documento);
        this.actualizarOrdenesDePago();

    }

}