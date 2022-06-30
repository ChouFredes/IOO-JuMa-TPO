package edu.uade.proveedores.test;

import edu.uade.proveedores.controller.CompraController;
import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.dto.ProveedorDTO;
import edu.uade.proveedores.model.Empleado;
import edu.uade.proveedores.model.MedioDePago;
import edu.uade.proveedores.model.Proveedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PagoControllerTest {

    ProveedorDao daoProveedor;

    //@BeforeEach
    public void init() throws Exception {
        daoProveedor = new ProveedorDao();
    }

    //@Test
    void constructor(){

        Empleado empleado = new Empleado(1,"Alejandro","Romero",1);
        System.out.println(empleado);
    }

    //@Test
    void compraController() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        String FCInString = "01-06-2022";
        Date fecha = formatter.parse(FCInString);

        Proveedor proveedor = daoProveedor.getById("dfe7a747-02c6-426c-b3a5-2c7f0e4250d5");
        ProveedorDTO proveedorDTO = ProveedorDTO.toDTO(proveedor);

        //mostar text
        //mostrar boton
        //el ususario inserta una fecha
        //el ususario presiona el boton buscarPorFecha

        System.out.println(CompraController.getInstance().getFacturaPorDiaPorProveedor(fecha, proveedorDTO.cuit));

        //el sistema presenta
    }

}
