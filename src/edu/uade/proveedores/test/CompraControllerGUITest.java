package edu.uade.proveedores.test;

import edu.uade.proveedores.controller.CompraController;
import edu.uade.proveedores.dao.DocumentoComercialDao;
import edu.uade.proveedores.dao.EmpleadoDao;
import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.dto.DocumentoComercialDTO;
import edu.uade.proveedores.dto.EmpleadoDTO;
import edu.uade.proveedores.dto.ProveedorDTO;
import edu.uade.proveedores.enumeration.TipoDocumentoComercial;
import edu.uade.proveedores.enumeration.TipoIVA;
import edu.uade.proveedores.enumeration.TipoResponsabilidad;
import edu.uade.proveedores.enumeration.TipoRubro;
import edu.uade.proveedores.model.Empleado;
import edu.uade.proveedores.model.Proveedor;
import edu.uade.proveedores.ui.FrmPlantilla_TotalFacturasPordia;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class CompraControllerGUITest {

    DocumentoComercialDao daoDocumento;
    ProveedorDao daoProveedor;
    EmpleadoDao daoEmpleado;

    //@BeforeAll
    public static void init() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        //creamos 3 empleados
        new EmpleadoDao().save(new Empleado("4e0e1056-2130-48b2-bc38-917e4e48c80b",1,"Alejandro","Romero", 247318816, formatter.parse("01-06-2005")));
        new EmpleadoDao().save(new Empleado("2758d315-8779-4e62-ba6a-a8b80b69793b",1,"Gonzalo","Navarte", 35999991, formatter.parse("24-10-2012")));
        new EmpleadoDao().save(new Empleado("8b8ae4a1-9d45-4c1a-9897-316200e2b54e",1,"Alejandro","Fredes", 35999992, formatter.parse("15-02-2016")));

        new ProveedorDao().save(new Proveedor("b85ab4c6-64db-4e30-bc37-6cc1e77a20e2", 99999998888L, "razon social",
                "nombre de fantasia", "una direccion", "1112569874",
                "uncorreo@proveedores.com", 1L, formatter.parse("01-01-2022"),
                TipoRubro.Productos_de_reventa, TipoResponsabilidad.Monotributista, formatter.parse("01-05-2022")));
    }

    //@AfterAll
    public static void teardown() throws Exception {
        new EmpleadoDao().delete("4e0e1056-2130-48b2-bc38-917e4e48c80b");
        new EmpleadoDao().delete("2758d315-8779-4e62-ba6a-a8b80b69793b");
        new EmpleadoDao().delete("8b8ae4a1-9d45-4c1a-9897-316200e2b54e");
        new ProveedorDao().delete("b85ab4c6-64db-4e30-bc37-6cc1e77a20e2");
    }

    //@BeforeEach
    public void initSingleTest() throws Exception {
        daoDocumento = new DocumentoComercialDao();
        daoProveedor = new ProveedorDao();
        daoEmpleado = new EmpleadoDao();
    }

    //@Test
    void compraControllerTest() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        //init test
        Proveedor proveedor = daoProveedor.getById("b85ab4c6-64db-4e30-bc37-6cc1e77a20e2");
        Empleado empleado = daoEmpleado.getById("4e0e1056-2130-48b2-bc38-917e4e48c80b");

        EmpleadoDTO empleadoCargaDTO = EmpleadoDTO.toDTO(empleado);
        ProveedorDTO proveedorDTO = ProveedorDTO.toDTO(proveedor);

        DocumentoComercialDTO documentoDTO = new DocumentoComercialDTO(null, "0001-00000001",
                formatter.parse("01-06-2022"), TipoDocumentoComercial.FACTURA, TipoIVA.C, 10000.00F,
                2100.00F, null);

        CompraController.getInstance().agregarFacturaConAutorizacion(documentoDTO, proveedorDTO, empleadoCargaDTO, empleadoCargaDTO);
        //init test

        //init pantalla de busque de factura por proveedor y fecha
        // Proveedor traeme todos los proveedores
        //gui, empleado se

        //test
        List<DocumentoComercialDTO> documentosDTO = CompraController.getInstance().getFacturaPorDiaPorProveedor(formatter.parse("01-06-2022"), proveedorDTO);
        for (DocumentoComercialDTO dto : documentosDTO) {
            System.out.println(dto.toString());
        }
        //test

        FrmPlantilla_TotalFacturasPordia myApp = new FrmPlantilla_TotalFacturasPordia("Documentos Comerciales");
        myApp.setVisible(true);

        //teardown test
        for (DocumentoComercialDTO dto : documentosDTO) {
            daoDocumento.delete(dto.id);
        }
        //teardown test

    }
}