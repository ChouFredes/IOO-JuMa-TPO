package edu.uade.proveedores.test;

import edu.uade.proveedores.dao.CuentaCorrienteDao;
import edu.uade.proveedores.dao.DocumentoComercialDao;
import edu.uade.proveedores.dao.OrdenDePagoDao;
import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.enumeration.TipoResponsabilidad;
import edu.uade.proveedores.enumeration.TipoRubro;
import edu.uade.proveedores.model.CuentaCorriente;
import edu.uade.proveedores.model.DocumentoComercial;
import edu.uade.proveedores.model.OrdenDePago;
import edu.uade.proveedores.model.Proveedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CuentaCorrienteTest {
    CuentaCorrienteDao dao;

    @BeforeEach
    public void init() throws Exception {
        dao = new CuentaCorrienteDao();
    }

    @Test
    void loadAndSaveDao() throws Exception{

        //String id = "b85ab4c6-64db-4e30-bc37-6cc1e77a20e2";
        String id = "ab8e9def-5779-4f7f-ad9f-a33cff159d4a";
        CuentaCorriente cuentaCorriente = dao.getById(id);

        System.out.println(cuentaCorriente);

    }

    //@Test
    void saveDao() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        String IAteInString = "01-01-2022";
        Date inicioDeActividades = formatter.parse(IAteInString);

        String FCInString = "01-05-2022";
        Date fechaDeCreacion = formatter.parse(FCInString);

        CuentaCorriente cuentaCorriente;

        cuentaCorriente = new CuentaCorriente(2, 1000f,
                false, 1000f, false, 0, 0,
                0);

        dao.save(cuentaCorriente);

        System.out.println(cuentaCorriente);

        cuentaCorriente = new CuentaCorriente(3, 1000f,
                false, 1000f, false, 0, 0,
                0);

        dao.save(cuentaCorriente);

        System.out.println(cuentaCorriente);
    }

    @Test
    public void crearCuentaCorrienteTest() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        CuentaCorriente cc = (new CuentaCorrienteDao()).getById("c7bcc677-106c-4542-a2b6-a37d4fb1dd7f");
        (new CuentaCorrienteDao()).save(cc);

        //Proveedor proveedor = (new ProveedorDao()).getById("1c017327-59fa-4cf7-b297-6f2fa170c4ab");
        //proveedor.setCuentaCorriente(cc);
        //(new ProveedorDao()).save(proveedor);
        //cc.setProveedor(proveedor);

        //OrdenDePago ordenDePago = (new OrdenDePagoDao()).getById("cbb77902-08d4-4b55-a457-760548ea8abf");
        //ordenDePago.setCuentaCorriente(cc);
        //(new OrdenDePagoDao()).save(ordenDePago);

        /*
        DocumentoComercial dc = (new DocumentoComercialDao()).getById("14f836d1-3d7a-41cb-b126-48513771771a");
        cc.setProveedor(dc.getProveedor());
        OrdenDePago op = (new OrdenDePagoDao()).getById("cbb77902-08d4-4b55-a457-760548ea8abf");
        cc.setFacturasEntregadas(op.getFacturas());
        cc.agregarOrdeDePago(op);
        */
        //(new CuentaCorrienteDao()).save(cc);
    }
}
