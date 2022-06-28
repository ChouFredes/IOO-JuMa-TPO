package edu.uade.proveedores.guiV2;

import javax.swing.*;
import java.awt.*;

public class FrmTotalDeudaProveedor extends  JDialog{
    private JPanel PnlPrincipal;

    public FrmTotalDeudaProveedor(Window owner, String titulo) {
        super(owner, titulo);
        this.setModal(true);
        this.setSize(320, 320);
        this.setContentPane(PnlPrincipal);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
