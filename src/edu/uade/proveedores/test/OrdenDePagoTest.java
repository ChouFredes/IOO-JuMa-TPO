package edu.uade.proveedores.test;

import edu.uade.proveedores.dao.CuentaCorrienteDao;
import edu.uade.proveedores.dao.DocumentoComercialDao;
import edu.uade.proveedores.dao.OrdenDePagoDao;
import edu.uade.proveedores.model.CuentaCorriente;
import edu.uade.proveedores.model.DocumentoComercial;
import edu.uade.proveedores.model.OrdenDePago;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrdenDePagoTest {
    //@Test
    public void generarOrdenDePagoTest() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        CuentaCorriente cc = (new CuentaCorrienteDao()).getById("c7bcc677-106c-4542-a2b6-a37d4fb1dd7f");
        DocumentoComercial dc = (new DocumentoComercialDao()).getById("14f836d1-3d7a-41cb-b126-48513771771a");
        OrdenDePago op = (new OrdenDePago(1L, cc, formatter.parse("01-06-2022")));
        ArrayList<DocumentoComercial> facturas = new ArrayList<>();
        facturas.add(dc);
        op.setFacturas(facturas);
        (new OrdenDePagoDao()).save(op);
    }
}
