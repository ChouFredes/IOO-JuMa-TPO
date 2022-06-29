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

    //@Test
    void saveDao() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        String IAteInString = "01-01-2022";
        Date inicioDeActividades = formatter.parse(IAteInString);

        String FCInString = "01-05-2022";
        Date fechaDeCreacion = formatter.parse(FCInString);

        CuentaCorriente cuentaCorriente;

        cuentaCorriente = new CuentaCorriente(2, null, 1000f,
                false, 1000f, false, 0, 0,
                0);

        dao.save(cuentaCorriente);

        System.out.println(cuentaCorriente);

        cuentaCorriente = new CuentaCorriente(3, null, 1000f,
                false, 1000f, false, 0, 0,
                0);

        dao.save(cuentaCorriente);

        System.out.println(cuentaCorriente);
    }
}
