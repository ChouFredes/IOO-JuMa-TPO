package edu.uade.proveedores.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class MenuPrincipal extends JFrame {
    private JPanel PnlPrincipal;
    private JButton btnFacturas;
    private JButton btnODPago;
    private JButton btnABMProductos;
    private JButton btnCompulsa;
    private JButton btnLibroIVA;
    private JButton btnImpuestos;
    private JButton btnDeuda;
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

        btnCompulsa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCompulsaPrecios frame= new FrmCompulsaPrecios(self, "Compulsa de Precios");
                frame.setVisible(false);
            }
        });
        btnABMProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmABMProductos frame = new FrmABMProductos(self,"ABM de productos");
                frame.setVisible(true);
            }
        });
        btnLibroIVA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmConsultaLibroIVA frame= new FrmConsultaLibroIVA(self, "Consulta de Libro IVA");
                frame.setVisible(false);
            }
        });
        btnFacturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmFacturasPorFecha frame= null;
                try {
                    frame = new FrmFacturasPorFecha(self, "Total de facturas por día");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
        btnODPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmOrdenesPagoEmitidas frame = null;
                try {
                    frame = new FrmOrdenesPagoEmitidas(self, "Ordenes de pago emitidas");
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
        btnDeuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmTotalDeudaProveedor frame= null;
                try {
                    frame = new FrmTotalDeudaProveedor(self, "Total de deuda por proveedor");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
        btnImpuestos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmTotalImpuestosRet frame = new FrmTotalImpuestosRet(self, "Total de impuestos retenidos");
                frame.setVisible(false);
            }
        });

        btnCompulsa.setVisible(false);
        btnLibroIVA.setVisible(false);
        btnImpuestos.setVisible(false);
        btnODPago.setVisible(false);
    }

    public static void main(String[] args) {
        MenuPrincipal frame = new MenuPrincipal("Menú Principal");
        frame.setVisible(true);

    }
}
