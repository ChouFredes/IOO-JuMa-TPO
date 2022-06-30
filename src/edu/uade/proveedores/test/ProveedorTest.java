package edu.uade.proveedores.test;

import edu.uade.proveedores.controller.ProveedorController;
import edu.uade.proveedores.dao.*;
import edu.uade.proveedores.enumeration.TipoResponsabilidad;
import edu.uade.proveedores.enumeration.TipoRubro;
import edu.uade.proveedores.model.CuentaCorriente;
import edu.uade.proveedores.model.DocumentoComercial;
import edu.uade.proveedores.model.OrdenDePago;
import edu.uade.proveedores.model.Proveedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class ProveedorTest {

    ProveedorDao dao;

    @BeforeEach
    public void init() throws Exception {
        dao = new ProveedorDao();
    }

    //@Test
    void loadAndSaveDao() throws Exception{

        String id = "dfe7a747-02c6-426c-b3a5-2c7f0e4250d5";
        Proveedor proveedor = dao.getById(id);
        proveedor.setCuit(33333333333L);
        dao.save(proveedor);
        System.out.println(proveedor);

    }

    //@Test
    void saveDao() throws Exception {
        String IAteInString;
        Date inicioDeActividades;
        Proveedor proveedor;
        CuentaCorriente cuentaCorriente;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        IAteInString = "03-06-2022";
        inicioDeActividades = formatter.parse(IAteInString);

        proveedor = new Proveedor(11121314151L, "Augusto",
                "Augusto", "una direccion", "1112569874",
                "Augusto@proveedores.com", 1L, inicioDeActividades,
                TipoRubro.Productos_de_reventa, TipoResponsabilidad.Monotributista);

        proveedor.setCuentaCorriente((new CuentaCorrienteDao()).getById("56eefb5f-dcb9-4e4b-aaf0-1b724bac5e49"));

        dao.save(proveedor);

        IAteInString = "01-06-2022";
        inicioDeActividades = formatter.parse(IAteInString);

        proveedor = new Proveedor(99999998888L, "razon social",
                "nombre de fantasia", "una direccion", "1112569874",
                "uncorreo@proveedores.com", 1L, inicioDeActividades,
                TipoRubro.Productos_de_reventa, TipoResponsabilidad.Monotributista);

        proveedor.setCuentaCorriente((new CuentaCorrienteDao()).getById("503a6d5a-1fd9-467e-aabd-c5d93eb31217"));

        dao.save(proveedor);
        //System.out.println(proveedor.toString());
    }

    //@Test
    void getAllFromController() throws Exception {
        ProveedorController.getInstance();
    }

    //@Test
    void obtenerDeudaDeProveedorTest() throws Exception {

        ProveedorDao pDao = new ProveedorDao();
        CuentaCorrienteDao ccDao = new CuentaCorrienteDao();

        Proveedor proveedor = pDao.getById("b85ab4c6-64db-4e30-bc37-6cc1e77a20e2");
        CuentaCorriente cuentaCorriente = proveedor.getCuentaCorriente();

        System.out.println("Monto total de deuda en pesos $:" + cuentaCorriente.calcularMontoTotalDeDeuda());
        //proveedor.setCuentaCorriente(cuentaCorriente);
        //pDao.save(proveedor);

    }

    @Test
    public void obtenerOrdenesDePagoTest() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        Proveedor proveedor = (new ProveedorDao()).getById("1aeb593f-1108-4c48-8369-b6576c0da190");
        CuentaCorriente cc = (new CuentaCorrienteDao()).getById("56eefb5f-dcb9-4e4b-aaf0-1b724bac5e49");
        DocumentoComercial factura = (new DocumentoComercialDao()).getById("14f836d1-3d7a-41cb-b126-48513771771a");

        OrdenDePago op = (new OrdenDePago(2L,formatter.parse("01-01-2022")));

        factura.setProveedor(proveedor);

        cc.agregarFactura(factura);
        op.agregarFactura(factura);

        cc.agregarOrdeDePago(op);
        proveedor.setCuentaCorriente(cc);

        (new OrdenDePagoDao()).save(op);
        (new ProveedorDao()).save(proveedor);

        //OrdenDePago ordenDePago = (new OrdenDePagoDao()).getById("cbb77902-08d4-4b55-a457-760548ea8abf");
        //cc.agregarOrdeDePago(ordenDePago);
        //(new CuentaCorrienteDao()).save(cc);

        //DocumentoComercial dc = (new DocumentoComercialDao()).getById("14f836d1-3d7a-41cb-b126-48513771771a");
        //OrdenDePago op = (new OrdenDePago(1L, cc, formatter.parse("01-06-2022")));
        //ArrayList<DocumentoComercial> facturas = new ArrayList<>();
        //facturas.add(dc);
        //op.setFacturas(facturas);
        //(new OrdenDePagoDao()).save(op);

        //(new CuentaCorrienteDao()).save(cc);

        //Proveedor proveedor = (new ProveedorDao()).getById("1c017327-59fa-4cf7-b297-6f2fa170c4ab");
        //proveedor.setCuentaCorriente(cc);
        //(new ProveedorDao()).save(proveedor);
        //cc.setProveedor(proveedor);

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
