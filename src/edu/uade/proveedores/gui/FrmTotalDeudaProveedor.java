package edu.uade.proveedores.gui;

import edu.uade.proveedores.controller.ProveedorController;
import edu.uade.proveedores.dto.DeudaDeProveedorDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class FrmTotalDeudaProveedor extends  JDialog{
    private JPanel PnlPrincipal;
    private ArrayList<Long> cuits;
    private Long cuitItem;
    private JComboBox cbProveedores;
    private Object[][] data;
    private String[] columnNames = {"Proovedor","Deuda total"};
    private JTable tableProveedorDeuda;
    private JButton btnBuscar;
    private JButton btnLimpiar;
    private DefaultTableModel tableModel;

    public FrmTotalDeudaProveedor(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setModal(true);
        this.setSize(320, 320);
        this.setContentPane(PnlPrincipal);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(data, columnNames);
        tableProveedorDeuda = new JTable(tableModel);
        tableProveedorDeuda.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(tableProveedorDeuda);
        scrollPane.setPreferredSize(new Dimension(380,280));
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);

        inicializarCombo();
        cbProveedores.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cuitItem = (Long) cbProveedores.getSelectedItem();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    data = convertDtoToData(ProveedorController.getInstance().obtenerDeudaPorProveedor(cuitItem));
                    tableModel.setDataVector(data, columnNames);
                    tableModel.fireTableDataChanged();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    inicializarCombo();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void inicializarCombo() throws Exception {

        cuits = ProveedorController.getInstance().obtenerCuitProveedores();
        DefaultComboBoxModel modelProveedores = new DefaultComboBoxModel();
        modelProveedores.addAll(cuits);
        cbProveedores.setModel(modelProveedores);

    }

    public Object[][] convertDtoToData(List<DeudaDeProveedorDTO> list) {
        Object[][] data = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).cuit.toString();
            data[i][1] = "$" + list.get(i).deudaTotal;
        }
        return data;
    }
}
