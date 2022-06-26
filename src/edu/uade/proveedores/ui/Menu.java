package edu.uade.proveedores.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    public Menu(String title) {
        super(title);
        setBounds(40,40,600,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu file = new JMenu("File");
        JMenuItem totalFacturasPorDia = new JMenuItem("facturas por dia");
        JMenuItem ordenesDePagoEmitidas = new JMenuItem("ordenes emitidas");
        JMenuItem totalDeudaPorProveedor = new JMenuItem("deuda por proveedor");
        JMenuItem totalImpuestosRetenidos = new JMenuItem("impuestos retenidos");
        JMenuItem listadoIVACompras = new JMenuItem("IVA compras");
        JMenuItem ccProveedores = new JMenuItem("CC proveedores");
        JMenuItem compulsaDePrecios = new JMenuItem("compulsa de precios");

        JMenuItem exit = new JMenuItem("Exit");

        totalFacturasPorDia.addActionListener(this);
        ordenesDePagoEmitidas.addActionListener(this);
        totalDeudaPorProveedor.addActionListener(this);
        totalImpuestosRetenidos.addActionListener(this);
        listadoIVACompras.addActionListener(this);
        ccProveedores.addActionListener(this);
        compulsaDePrecios.addActionListener(this);
        exit.addActionListener(this);

        file.add(totalFacturasPorDia);
        file.add(ordenesDePagoEmitidas);
        file.add(totalDeudaPorProveedor);
        file.add(totalImpuestosRetenidos);
        file.add(listadoIVACompras);
        file.add(ccProveedores);
        file.add(compulsaDePrecios);

        file.add(exit);

        menuBar.add(file);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        if (choice.equals("Exit")) {
            System.exit(0);
        } else if (choice.equals("facturas por dia")) {
            FrmPlantilla_TotalFacturasPordia myApp = null;
            try {
                myApp = new FrmPlantilla_TotalFacturasPordia("Documentos Comerciales");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            myApp.setVisible(true);
        } else if (choice.equals("ordenes emitidas")) {
            FrmPlantilla_TotalFacturasPordia myApp = null;
            try {
                myApp = new FrmPlantilla_TotalFacturasPordia("ordenes emitidas");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            myApp.setVisible(true);
        } else if (choice.equals("deuda por proveedor")) {
            FrmPlantilla_TotalFacturasPordia myApp = null;
            try {
                myApp = new FrmPlantilla_TotalFacturasPordia("deuda por proveedor");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            myApp.setVisible(true);
        } else if (choice.equals("impuestos retenidos")) {
            FrmPlantilla_TotalFacturasPordia myApp = null;
            try {
                myApp = new FrmPlantilla_TotalFacturasPordia("impuestos retenidos");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            myApp.setVisible(true);
        } else if (choice.equals("IVA compras")) {
            FrmPlantilla_TotalFacturasPordia myApp = null;
            try {
                myApp = new FrmPlantilla_TotalFacturasPordia("IVA compras");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            myApp.setVisible(true);
        } else if (choice.equals("CC proveedores")) {
            FrmPlantilla_TotalFacturasPordia myApp = null;
            try {
                myApp = new FrmPlantilla_TotalFacturasPordia("CC proveedores");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            myApp.setVisible(true);
        } else if (choice.equals("compulsa de precios")) {
            FrmCompulsaDePrecios myApp = null;
            try {
                myApp = new FrmCompulsaDePrecios("compulsa de precios");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            myApp.setVisible(true);
        }

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Menu menu = new Menu("Este es el modulo de Proveedores");
        menu.setVisible(true);

    }

}
