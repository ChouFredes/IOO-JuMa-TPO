package edu.uade.proveedores.gui;

import edu.uade.proveedores.controller.ProveedorController;
import edu.uade.proveedores.model.Proveedor;

import javax.swing.*;
import java.awt.*;

public class FrmABMProductos extends JDialog{

    private JPanel PnlPrincipal;

    public FrmABMProductos(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setModal(true);
        this.setSize(320, 320);
        this.setContentPane(PnlPrincipal);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ProveedorController.getInstance().getProductos();


    }
}
