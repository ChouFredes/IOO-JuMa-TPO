package edu.uade.proveedores.guiV2;
import edu.uade.proveedores.controller.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class FrmFacturasPorDia extends JDialog {

    ArrayList<Date> fechas = CompraController.getInstance().obtenerListaFechasFacturas();
    ArrayList<Long> cuits = ProveedorController.getInstance().obtenerCuitProveedores();
    private JPanel PnlPrincipal;
    private JComboBox cbProveedores;
    private JComboBox cbFechas;
    private JTable tableFacturas;

    public FrmFacturasPorDia(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setModal(true);
        this.setSize(320, 320);
        this.setContentPane(PnlPrincipal);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        DefaultComboBoxModel modelProveedores = new DefaultComboBoxModel();
        modelProveedores.addAll(cuits);
        cbProveedores.setModel(modelProveedores);

        DefaultComboBoxModel modelFechas = new DefaultComboBoxModel();
        modelProveedores.addAll(cuits);
        cbFechas.setModel(modelProveedores);
    }

}
