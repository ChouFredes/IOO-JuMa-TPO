package edu.uade.proveedores.gui;

import edu.uade.proveedores.controller.ProveedorController;
import edu.uade.proveedores.dto.ProductoDTO;
import edu.uade.proveedores.enumeration.TipoImpuestoProducto;
import edu.uade.proveedores.enumeration.TipoRubro;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static java.lang.Long.parseLong;

public class ProductoABM extends JDialog {

    private final JPanel contentPanel = new JPanel();

    private JTextField txtId;
    private JFormattedTextField txtFechaDeCreacion;
    private JTextField txtCuitDelProveedor;
    private JTextField txtRazonSocial;
    private JTextField txtDescripcion;
    private JTextField txtDetallePorUnidad;
    private JFormattedTextField txtPrecioPorUnidad;
    private JTextField txtRubro;
    private JTextField txtIVA;
    private ProductoDTO productoDTO;
    private ModalResult modalResult;
    private JComboBox cbProveedor;
    private JComboBox cbRubro;
    private JComboBox cbIVA;
    private ArrayList<Long> cuits;
    private ArrayList<String> tipoRubros;
    private ArrayList<String> tipoImpuestoProductos;
    private Long cuitItem;
    private String tipoImpuestoProductoItem;
    private String tipoRubroItem;
    JLabel lblId;
    JLabel lblFechaDeCreacion;
    JLabel lblCuitDelProveedor;
    JLabel lblRazonSocial;
    JLabel lblDescripcion;
    JLabel lblPrecioPorUnidad;
    JLabel lblDetallePorUnidad;
    JLabel lblRubro;
    JLabel lblIVA;


    private void inicializarControles() throws Exception {
        setBounds(300, 300, 450, 450);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        lblId = new JLabel("Id");
        txtId = new JTextField();
        txtId.setColumns(10);
        txtId.setEnabled(false);

        lblFechaDeCreacion = new JLabel("Fecha de creacion");
        txtFechaDeCreacion = new JFormattedTextField();
        txtFechaDeCreacion.setColumns(10);
        txtFechaDeCreacion.setEnabled(false);

        lblCuitDelProveedor = new JLabel("Cuit");
        txtCuitDelProveedor = new JTextField();
        txtCuitDelProveedor.setColumns(10);

        cbProveedor = new JComboBox();
        inicializarCboProveedores();
        cbProveedor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cuitItem = (Long) cbProveedor.getSelectedItem();
            }
        });

        lblRazonSocial = new JLabel("Razon Social");
        txtRazonSocial = new JTextField();
        txtRazonSocial.setColumns(10);
        lblRazonSocial.setVisible(false);
        txtRazonSocial.setVisible(false);

        lblDescripcion = new JLabel("Descripcion");
        txtDescripcion = new JTextField();
        txtDescripcion.setColumns(10);

        lblPrecioPorUnidad = new JLabel("Precio Por Unidad");
        txtPrecioPorUnidad = new JFormattedTextField();
        txtPrecioPorUnidad.setColumns(10);

        lblDetallePorUnidad = new JLabel("Detalle por unidad");
        txtDetallePorUnidad = new JTextField();
        txtDetallePorUnidad.setColumns(10);

        lblRubro = new JLabel("Rubro");
        txtRubro = new JTextField();
        txtRubro.setColumns(10);

        cbRubro = new JComboBox();
        inicializarCboRubro();
        cbRubro.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                tipoRubroItem = cbRubro.getSelectedItem().toString();
            }
        });

        lblIVA = new JLabel("IVA");
        txtIVA = new JTextField();
        txtIVA.setColumns(10);

        cbIVA = new JComboBox();
        inicializarCboIVA();
        cbIVA.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                tipoImpuestoProductoItem = cbIVA.getSelectedItem().toString();
            }
        });

        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblId)
                                        .addComponent(lblFechaDeCreacion)
                                        .addComponent(lblCuitDelProveedor)
                                        .addComponent(lblRazonSocial)
                                        .addComponent(lblDescripcion)
                                        .addComponent(lblPrecioPorUnidad)
                                        .addComponent(lblDetallePorUnidad)
                                        .addComponent(lblRubro, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblIVA))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFechaDeCreacion, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                        .addComponent(cbProveedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRazonSocial, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrecioPorUnidad, GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDetallePorUnidad, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbRubro, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbIVA, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                )
                                .addContainerGap(108, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblId)
                                        .addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(4)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblFechaDeCreacion)
                                        .addComponent(txtFechaDeCreacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCuitDelProveedor)
                                        .addComponent(cbProveedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblRazonSocial)
                                        .addComponent(txtRazonSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblDescripcion)
                                        .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPrecioPorUnidad)
                                        .addComponent(txtPrecioPorUnidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblDetallePorUnidad)
                                        .addComponent(txtDetallePorUnidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblRubro)
                                        .addComponent(cbRubro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblIVA)
                                        .addComponent(cbIVA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addContainerGap(60, Short.MAX_VALUE))
        );
        contentPanel.setLayout(gl_contentPanel);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            asignarDatosEntidad();
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        modalResult = ModalResult.OK;
                        dispose();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        modalResult = ModalResult.CANCELL;
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }

    }

    private void inicializarCboIVA() throws Exception {
        tipoImpuestoProductos = new ArrayList<>();
        for (TipoImpuestoProducto tipoImpuesto:TipoImpuestoProducto.values()) {
            tipoImpuestoProductos.add(String.valueOf(tipoImpuesto));
        }

        DefaultComboBoxModel modelTipoIVAProducto = new DefaultComboBoxModel();
        modelTipoIVAProducto.addAll(tipoImpuestoProductos);
        cbIVA.setModel(modelTipoIVAProducto);
    }

    private void inicializarCboRubro() throws Exception {
        tipoRubros = new ArrayList<>();
        for (TipoRubro tipoRubro:TipoRubro.values()) {
            tipoRubros.add(String.valueOf(tipoRubro));
        }

        DefaultComboBoxModel modelTipoRubro = new DefaultComboBoxModel();
        modelTipoRubro.addAll(tipoRubros);
        cbRubro.setModel(modelTipoRubro);
    }

    private void inicializarCboProveedores() throws Exception {
        cuits = new ArrayList<>();
        cuits = ProveedorController.getInstance().obtenerCuitProveedores();

        DefaultComboBoxModel modelProveedores = new DefaultComboBoxModel();
        modelProveedores.addAll(cuits);
        cbProveedor.setModel(modelProveedores);
    }

    private void asignarFormato() {
        try {
            try {
                //txtFechaDeCreacion.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
                //txtPrecioPorUnidad.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##########.##")));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProductoABM(JFrame frame) throws Exception {
        super(frame, "Producto", true);
        setLocationRelativeTo(frame);
        inicializarControles();
        asignarFormato();
    }

    private void asignarDatosEntidad() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        if (productoDTO == null) {
            productoDTO = new ProductoDTO(null,Long.parseLong(cbProveedor.getSelectedItem().toString()),null,
                    txtDescripcion.getText(),Float.parseFloat(txtPrecioPorUnidad.getText()),
                    Integer.parseInt(txtDetallePorUnidad.getText()), TipoRubro.valueOf(cbRubro.getSelectedItem().toString()),
                    TipoImpuestoProducto.valueOf(cbIVA.getSelectedItem().toString()),null);
        } else {
            productoDTO = new ProductoDTO(txtId.getText(),Long.parseLong(cbProveedor.getSelectedItem().toString()),
                    txtRazonSocial.getText(),txtDescripcion.getText(),Float.parseFloat(txtPrecioPorUnidad.getText()),
                    Integer.parseInt(txtDetallePorUnidad.getText()), TipoRubro.valueOf(cbRubro.getSelectedItem().toString()),
                    TipoImpuestoProducto.valueOf(cbIVA.getSelectedItem().toString()),formatter.parse(txtFechaDeCreacion.getText()));
        }

    }

    private void asignarDatosForm() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        txtId.setText(productoDTO.id);
        txtId.setEnabled(false);

        txtFechaDeCreacion.setText(formatter.format(productoDTO.fechaDeCreacion));
        txtFechaDeCreacion.setEnabled(false);

        txtCuitDelProveedor.setText(productoDTO.cuitDelProveedor.toString());
        txtCuitDelProveedor.setEnabled(false);

        cbProveedor.setSelectedItem(productoDTO.cuitDelProveedor);
        cbProveedor.setEnabled(false);

        txtRazonSocial.setText(productoDTO.razonSocial);
        txtRazonSocial.setEnabled(false);
        lblRazonSocial.setVisible(true);
        txtRazonSocial.setVisible(true);

        txtDescripcion.setText(productoDTO.descripcion);
        txtPrecioPorUnidad.setText(String.format("%.2f",productoDTO.precioPorUnidad));
        txtDetallePorUnidad.setText(String.valueOf(productoDTO.detallePorUnidad));

        txtRubro.setText(productoDTO.rubro.toString());
        cbRubro.setSelectedItem(productoDTO.rubro.toString());

        txtIVA.setText(productoDTO.IVA.toString());
        cbIVA.setSelectedItem(productoDTO.IVA.toString());

    }

    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }
    public void setProductoDTO(ProductoDTO productoDTO) {
        this.productoDTO = productoDTO;
        if (productoDTO != null)
            asignarDatosForm();
    }

    public ModalResult getModalResult() {
        return modalResult;
    }
}