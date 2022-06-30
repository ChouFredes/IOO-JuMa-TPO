package edu.uade.proveedores.gui;

import edu.uade.proveedores.dto.OrdenDePagoEmitidaDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FrmOrdenesPagoEmit extends JDialog {
    private final Object[][] data;
    private DefaultTableModel tableModel;
    private JPanel PnlPrincipal;
    private JTable tableOrdenesEmitidas;


    private String[] columnNames = {"nro","fechaEmision","cuit","razon social","CC","# Facturas"};
    /*
    private String[] columnNames = {"nro","fechaEmision","cuit","razon social","CC","# Facturas","# NC", "# ND",
    "Tot. a cancelar","Tot. retenciones","liquidada"};

     */

    public FrmOrdenesPagoEmit(Window owner, String titulo) throws ParseException {
        super(owner, titulo);
        this.setModal(true);
        this.setSize(320, 320);
        this.setContentPane(PnlPrincipal);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        OrdenDePagoEmitidaDTO dto = new OrdenDePagoEmitidaDTO(1L,formatter.parse("01-01-2022"),
                20247318160L,"una razon social",1000,1,
                0,0,10000.00f,210.00f,false);

        ArrayList<OrdenDePagoEmitidaDTO> ordenes = new ArrayList<>();
        ordenes.add(dto);

        data = convertDtoToData(ordenes);

        tableModel = new DefaultTableModel(data, columnNames);
        tableOrdenesEmitidas = new JTable(tableModel);
        tableOrdenesEmitidas.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(tableOrdenesEmitidas);
        scrollPane.setPreferredSize(new Dimension(380,1280));
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);

    }

    public Object[][] convertDtoToData(List<OrdenDePagoEmitidaDTO> list) {
        Object[][] data = new Object[list.size()][7];
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        /*
                    data[i][1] = formatter.format(list.get(i).fechaDeEmision);
            data[i][2] = list.get(i).cuitDelProveedor;
            data[i][3] = list.get(i).razonSocialDelProveedor;
            data[i][4] = list.get(i).numeroDeCCDelProveedor;

         */
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).numeroDeOrden;
            data[i][1] = list.get(i).cantidadDeFacturas;
            data[i][2] = list.get(i).cantidadDenotasDeCredito;
            data[i][3] = list.get(i).cantidadDenotasDeDebito;
            data[i][4] = list.get(i).totalACancelar;
            data[i][5] = list.get(i).totalDeRetenciones;
//            data[i][10] = list.get(i).liquidada ? "Si" : "No";
        }
        return data;
    }

}
