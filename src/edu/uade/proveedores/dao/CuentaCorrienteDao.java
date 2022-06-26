package edu.uade.proveedores.dao;

import edu.uade.proveedores.model.CuentaCorriente;

public class CuentaCorrienteDao extends GenericDAO<CuentaCorriente> {
    public CuentaCorrienteDao() throws Exception {
        super(CuentaCorriente.class, "CuentaCorriente.json");
    }

    public void save(CuentaCorriente cuentaCorriente) throws Exception {
        if (this.getById(cuentaCorriente.getId()) != null) {
            super.update(cuentaCorriente);
        } else {
            super.save(cuentaCorriente);
        }
    }
}