package edu.uade.proveedores.ui;

import edu.uade.proveedores.controller.*;
import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.dto.*;
import edu.uade.proveedores.model.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FrmPlantilla_TotalFacturasPordia extends JFrame implements ActionListener {

    private Object[][] data;
    private String[] columnNames = {"id","fechaEmision","tipo doc","comprobante"};
    private DefaultTableModel tableModel;
    private JTable table;
    private CompraController controller;

    public FrmPlantilla_TotalFacturasPordia(String title) throws Exception {
        super(title);
        setBounds(10,10,400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //TEST
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date fecha = formatter.parse("01-06-2022");

        ProveedorDao daoProveedor = new ProveedorDao();
        Proveedor proveedor = daoProveedor.getById("b85ab4c6-64db-4e30-bc37-6cc1e77a20e2");
        ProveedorDTO proveedorDTO = ProveedorDTO.toDTO(proveedor);
        //TEST

        controller = CompraController.getInstance();
        ArrayList<DocumentoComercialDTO> lista = controller.getFacturaPorDiaPorProveedor(fecha, proveedorDTO);

        data = convertDtoToData(lista);

        tableModel = new DefaultTableModel(data, columnNames);

        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(380,280));
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);


    }


    public Object[][] convertDtoToData(List<DocumentoComercialDTO> list) {
        Object[][] data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).id;
            data[i][1] = list.get(i).fechaDeEmision.toString();
            data[i][2] = list.get(i).tipoDeDocumento;
            data[i][3] = list.get(i).numeroDeComprobante;
        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        if (choice.equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        FrmPlantilla_TotalFacturasPordia myApp = new FrmPlantilla_TotalFacturasPordia("Documentos Comerciales");
        myApp.setVisible(true);
    }
}
