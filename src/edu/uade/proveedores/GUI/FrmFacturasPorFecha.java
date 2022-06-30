package edu.uade.proveedores.GUI;
import edu.uade.proveedores.controller.*;
import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.dto.DocumentoComercialDTO;
import edu.uade.proveedores.dto.ProveedorDTO;
import edu.uade.proveedores.model.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FrmFacturasPorFecha extends JDialog {

    private ArrayList<Date> fechas;
    private ArrayList<Long> cuits;
    private JPanel PnlPrincipal;
    private JComboBox cbProveedores;
    private JComboBox cbFechas;
    private JTable tableFacturas;
    private JButton btnBuscar;
    private DefaultTableModel tableModel;
    private Object[][] data;
    private String[] columnNames = {"id","fechaEmision","tipo doc","comprobante"};
    private Date fechaItem;
    private Long cuitItem;

    public FrmFacturasPorFecha(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setModal(true);
        this.setSize(320, 320);
        this.setContentPane(PnlPrincipal);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(data, columnNames);
        tableFacturas = new JTable(tableModel);
        tableFacturas.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(tableFacturas);
        scrollPane.setPreferredSize(new Dimension(380,280));
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);

        inicializarCombos();

        cbProveedores.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cuitItem = (Long) cbProveedores.getSelectedItem();
            }
        });
        cbFechas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fechaItem = (Date) cbFechas.getSelectedItem();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    data = convertDtoToData(CompraController.getInstance().getFacturaPorDiaPorProveedor(fechaItem, cuitItem));

                    tableModel.setDataVector(data, columnNames);
                    tableModel.fireTableDataChanged();

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void inicializarCombos() throws Exception {

        cuits = ProveedorController.getInstance().obtenerCuitProveedores();

        DefaultComboBoxModel modelProveedores = new DefaultComboBoxModel();
        modelProveedores.addAll(cuits);
        cbProveedores.setModel(modelProveedores);

        fechas = CompraController.getInstance().obtenerListaFechasFacturas();

        DefaultComboBoxModel modelFechas = new DefaultComboBoxModel();
        modelFechas.addAll(fechas);
        cbFechas.setModel(modelFechas);

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

}
