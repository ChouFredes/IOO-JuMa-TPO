package edu.uade.proveedores.gui;

import edu.uade.proveedores.controller.PagoController;
import edu.uade.proveedores.dto.OrdenDePagoEmitidaDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FrmOrdenesPagoEmitidas extends JDialog {
    private final Object[][] data;
    private DefaultTableModel tableModel;
    private JPanel PnlPrincipal;
    private JTable tableOrdenesEmitidas;


    //private String[] columnNames = {"nro","fechaEmision","cuit","razon social","CC","# Facturas"};
    private String[] columnNames = {"nro","fechaEmision","cuit","razon social","CC","# Facturas","# NC", "# ND",
    "Tot. a cancelar","Tot. retenciones","liquidada"};

    public FrmOrdenesPagoEmitidas(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setModal(true);
        this.setSize(320, 320);
        this.setContentPane(PnlPrincipal);
        //this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        data = convertDtoToData(PagoController.getInstance().obtenerOrdenesDePagoEmitidas());

        tableModel = new DefaultTableModel(data, columnNames);
        tableOrdenesEmitidas = new JTable(tableModel);
        tableOrdenesEmitidas.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(tableOrdenesEmitidas);
        //scrollPane.setPreferredSize(new Dimension(380,1280));
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);

    }

    public Object[][] convertDtoToData(List<OrdenDePagoEmitidaDTO> list) {
        Object[][] data = new Object[list.size()][12];
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");


        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).numeroDeOrden;
            data[i][1] = formatter.format(list.get(i).fechaDeEmision);
            data[i][2] = list.get(i).cuitDelProveedor;
            data[i][3] = list.get(i).razonSocialDelProveedor;
            data[i][4] = list.get(i).numeroDeCCDelProveedor;
            data[i][6] = list.get(i).cantidadDeFacturas;
            data[i][7] = list.get(i).cantidadDenotasDeCredito;
            data[i][7] = list.get(i).cantidadDenotasDeDebito;
            data[i][8] = list.get(i).totalACancelar;
            data[i][9] = list.get(i).totalDeRetenciones;
            data[i][10] = list.get(i).liquidada ? "Si" : "No";
        }
        return data;
    }
}
