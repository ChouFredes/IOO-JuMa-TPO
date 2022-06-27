package edu.uade.proveedores.guiV2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    private JPanel PnlPrincipal;
    private JPanel PnlTitulo;
    private JPanel Cuerpo;
    private JButton totalDeFacturaPorButton;
    private JButton cuentaCorrienteProveedoresButton;
    private JButton totalDeImpuestosRetenidosButton;
    private JButton compulsaDePreciosButton;
    private JButton totalDeDeudaPorButton;
    private JButton consultaLibroIVAButton;
    private JButton ordenesDePagoEmitidasButton;

    private MenuPrincipal self;

    public MenuPrincipal(String titulo)
    {
        super(titulo);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        this.setSize(620,520);
        this.setContentPane(PnlPrincipal);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.self=this;

        compulsaDePreciosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCompulsaPrecios frame= new FrmCompulsaPrecios(self, "Compulsa de Precios");
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        MenuPrincipal frame = new MenuPrincipal("Menú Principal");
        frame.setVisible(true);

    }
}
