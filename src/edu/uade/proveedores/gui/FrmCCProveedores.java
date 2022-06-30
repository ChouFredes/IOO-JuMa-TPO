package edu.uade.proveedores.gui;

import javax.swing.*;
import java.awt.*;

public class FrmCCProveedores extends JDialog{

    private JPanel PnlPrincipal;

    public FrmCCProveedores(Window owner, String titulo) {
        super(owner, titulo);
        this.setModal(true);
        this.setSize(320, 320);
        this.setContentPane(PnlPrincipal);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
