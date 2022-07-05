package edu.uade.proveedores.gui;

import edu.uade.proveedores.dto.ProductoDTO;
import edu.uade.proveedores.tablemodel.ProductoTableModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FrmABMProductos extends JDialog {

    ArrayList<ProductoDTO> productos;
    private JFrame frame;
    //private JTable table;

    private ProductoTableModel tableModel;
    private JPanel PnlPrincipal;
    private JTable tableProductos;

    public FrmABMProductos(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        tableModel = new ProductoTableModel();
        initialize();

    }

    private void agregarProducto() {
        try {
            ProductoABM dialog = new ProductoABM(frame);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            //JOptionPane.showMessageDialog(null, "termineeee");
            if (dialog.getModalResult() == ModalResult.OK)
                tableModel.agregar(dialog.getProductoDTO());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void modificarProducto() {
        try {
            if (tableProductos.getSelectedRow() > -1) {
                ProductoABM dialog = new ProductoABM(frame);
                dialog.setProductoDTO(tableModel.obtenerProducto(tableProductos.getSelectedRow()));
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                if (dialog.getModalResult() == ModalResult.OK)
                    tableModel.agregar(dialog.getProductoDTO());
                    //tableModel.refresh();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarProducto() {
        try {
            if (tableProductos.getSelectedRow() > -1) {
                tableModel.eliminar(tableProductos.getSelectedRow());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300)
                width = 300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }


        frame = new JFrame();
        frame.setBounds(100, 100, 752, 560);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel PnlPrincipal = new JPanel();
        PnlPrincipal.setBorder(new EmptyBorder(10, 0, 0, 0));
        PnlPrincipal.setMinimumSize(new Dimension(10, 50));
        frame.getContentPane().add(PnlPrincipal, BorderLayout.SOUTH);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { eliminarProducto(); }
        });


        JButton btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                modificarProducto();
            }
        });

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { agregarProducto(); }
        });

        JSeparator separator = new JSeparator();
        GroupLayout gl_panel = new GroupLayout(PnlPrincipal);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, gl_panel.createSequentialGroup()
                                .addContainerGap(423, Short.MAX_VALUE)
                                .addComponent(btnAgregar)
                                .addGap(18)
                                .addComponent(btnModificar)
                                .addGap(18)
                                .addComponent(btnEliminar)
                                .addContainerGap())
                        .addComponent(separator, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEliminar)
                                        .addComponent(btnModificar)
                                        .addComponent(btnAgregar))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlPrincipal.setLayout(gl_panel);

        PnlPrincipal = new JPanel();
        PnlPrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));
        PnlPrincipal.setBackground(SystemColor.activeCaption);
        frame.getContentPane().add(PnlPrincipal, BorderLayout.NORTH);
        PnlPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel = new JLabel("ABM de Productos");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        PnlPrincipal.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setAutoscrolls(true);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        tableProductos = new JTable(tableModel);
        tableProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (arg0.getClickCount() == 2)
                    modificarProducto();
            }
        });
        tableProductos.setAutoCreateRowSorter(true);
        tableProductos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane.setViewportView(tableProductos);
        frame.setVisible(true);
        //PnlPrincipal.setVisible(true);
    }
}

