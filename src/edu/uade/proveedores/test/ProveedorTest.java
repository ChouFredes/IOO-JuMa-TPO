package edu.uade.proveedores.test;

import edu.uade.proveedores.dao.EmpleadoDao;
import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.enumeration.TipoResponsabilidad;
import edu.uade.proveedores.enumeration.TipoRubro;
import edu.uade.proveedores.model.Proveedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ProveedorTest {

    ProveedorDao dao;

    //@BeforeEach
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

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        String IAteInString = "01-01-2022";
        Date inicioDeActividades = formatter.parse(IAteInString);

        String FCInString = "01-05-2022";
        Date fechaDeCreacion = formatter.parse(FCInString);

        Proveedor proveedor = new Proveedor("b85ab4c6-64db-4e30-bc37-6cc1e77a20e2", 99999998888L, "razon social",
                "nombre de fantasia", "una direccion", "1112569874",
                "uncorreo@proveedores.com", 1L, inicioDeActividades,
                TipoRubro.Productos_de_reventa, TipoResponsabilidad.Monotributista, fechaDeCreacion);

        dao.save(proveedor);
        //System.out.println(proveedor.toString());
    }

}
