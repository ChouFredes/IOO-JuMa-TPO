package edu.uade.proveedores.test;

import edu.uade.proveedores.dao.EmpleadoDao;
import edu.uade.proveedores.model.Empleado;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EmpleadoTest {

    EmpleadoDao dao;

    @BeforeEach
    public void init() throws Exception {
        dao = new EmpleadoDao();
    }

    @Test
    void constructor(){

        Empleado empleado = new Empleado(1,"Alejandro","Romero",1);
        System.out.println(empleado);
    }


    @Test
    void saveDao() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        String FCInString = "01-06-2022";
        Date fechaDeCreacion = formatter.parse(FCInString);


        Empleado empleado = new Empleado("4e0e1056-2130-48b2-bc38-917e4e48c80b",1,"Alejandro","Romero",1,fechaDeCreacion);
        dao.save(empleado);

        empleado = new Empleado("2758d315-8779-4e62-ba6a-a8b80b69793b",2,"Alejandro","Romero",2,fechaDeCreacion);
        dao.save(empleado);

        empleado = new Empleado("8b8ae4a1-9d45-4c1a-9897-316200e2b54e",3,"Alejandro","Romero",3,fechaDeCreacion);
        dao.save(empleado);

        empleado = new Empleado("9703fbb3-5593-4197-b9bb-53af4b1155a8",4,"Alejandro","Romero",4,fechaDeCreacion);
        dao.save(empleado);

        empleado = new Empleado("048e2b28-e42d-465e-a125-61eed245bbd1",5,"Alejandro","Romero",5,fechaDeCreacion);
        dao.save(empleado);

        empleado = new Empleado("009da65a-f382-4f36-8fe8-b9b2b3e3b5b6",6,"Alejandro","Romero",6,fechaDeCreacion);
        dao.save(empleado);

        empleado = new Empleado("32c9b940-f361-4738-afba-51a53183d1df",7,"Alejandro","Romero",7,fechaDeCreacion);
        dao.save(empleado);

        empleado = new Empleado("eb752fde-7266-412d-82f4-47d57767cb5d",8,"Alejandro","Romero",8,fechaDeCreacion);
        dao.save(empleado);

        empleado = new Empleado("20b445e1-3b0f-4406-a702-ed8a51441881",9,"Alejandro","Romero",9,fechaDeCreacion);
        dao.save(empleado);

        empleado = new Empleado("4a06c6aa-1211-4a92-b275-81ffc59457d5",10,"Alejandro","Romero",10,fechaDeCreacion);
        dao.save(empleado);

    }
}
