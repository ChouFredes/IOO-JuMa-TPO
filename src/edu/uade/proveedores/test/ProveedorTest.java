package edu.uade.proveedores.test;

import edu.uade.proveedores.controller.ProveedorController;
import edu.uade.proveedores.dao.CuentaCorrienteDao;
import edu.uade.proveedores.dao.EmpleadoDao;
import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.enumeration.TipoResponsabilidad;
import edu.uade.proveedores.enumeration.TipoRubro;
import edu.uade.proveedores.model.CuentaCorriente;
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

    @Test
    void obtenerDeudaDeProveedorTest() throws Exception {

        ProveedorDao pDao = new ProveedorDao();
        CuentaCorrienteDao ccDao = new CuentaCorrienteDao();

        Proveedor proveedor = pDao.getById("b85ab4c6-64db-4e30-bc37-6cc1e77a20e2");
        CuentaCorriente cuentaCorriente = proveedor.getCuentaCorriente();

        System.out.println("Monto total de deuda en pesos $:" + cuentaCorriente.calcularMontoTotalDeDeuda());
        //proveedor.setCuentaCorriente(cuentaCorriente);
        //pDao.save(proveedor);

    }

}
