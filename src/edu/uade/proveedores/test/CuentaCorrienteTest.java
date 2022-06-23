package edu.uade.proveedores.test;

import edu.uade.proveedores.dao.CuentaCorrienteDao;
import edu.uade.proveedores.enumeration.TipoResponsabilidad;
import edu.uade.proveedores.enumeration.TipoRubro;
import edu.uade.proveedores.model.CuentaCorriente;
import edu.uade.proveedores.model.Proveedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
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

    void saveDao() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        String IAteInString = "01-01-2022";
        Date inicioDeActividades = formatter.parse(IAteInString);

        String FCInString = "01-05-2022";
        Date fechaDeCreacion = formatter.parse(FCInString);

        Proveedor proveedor = new Proveedor("b85ab4c6-64db-4e30-bc37-6cc1e77a20e2", 99999998888L, "razon social",
                "nombre de fantasia", "una direccion", "1112569874",
                "uncorreo@proveedores.com", 1L, inicioDeActividades,
                TipoRubro.Productos_de_reventa, TipoResponsabilidad.Monotributista, fechaDeCreacion);

        CuentaCorriente cuentaCorriente = new CuentaCorriente("ab8e9def-5779-4f7f-ad9f-a33cff159d4a",1, proveedor, 1000f,
                false, 1000f, false, 0, 0,
                0, fechaDeCreacion);

        dao.save(cuentaCorriente);

        System.out.println(cuentaCorriente);

    }
}
