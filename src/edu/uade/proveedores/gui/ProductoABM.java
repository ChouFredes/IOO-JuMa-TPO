package edu.uade.proveedores.gui;

import edu.uade.proveedores.dto.ProductoDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private void inicializarControles() {
        setBounds(100, 100, 450, 245);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JLabel lblId = new JLabel("Id");
        txtId = new JTextField();
        txtId.setColumns(10);

        JLabel lblFechaDeCreacion = new JLabel("Fecha de creacion");
        txtFechaDeCreacion = new JFormattedTextField();

        JLabel lblCuitDelProveedor = new JLabel("Cuit");
        txtCuitDelProveedor = new JTextField();
        txtCuitDelProveedor.setColumns(10);

        JLabel lblRazonSocial = new JLabel("Razon Social");
        txtRazonSocial = new JTextField();
        txtRazonSocial.setColumns(10);

        JLabel lblDescripcion = new JLabel("Descripcion");
        txtDescripcion = new JTextField();
        txtDescripcion.setColumns(10);

        JLabel lblPrecioPorUnidad = new JLabel("Precio Por Unidad");
        txtPrecioPorUnidad = new JFormattedTextField();

        JLabel lblDetallePorUnidad = new JLabel("Detalle por unidad");
        txtDetallePorUnidad = new JTextField();
        txtDetallePorUnidad.setColumns(10);

        JLabel lblRubro = new JLabel("Rubro");
        txtRubro = new JTextField();
        txtRubro.setColumns(10);

        JLabel lblIVA = new JLabel("IVA");
        txtIVA = new JTextField();
        txtIVA.setColumns(10);

        JCheckBox aaaachcSindicalizado = new JCheckBox("Sindicalizado");


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
                                        .addComponent(txtCuitDelProveedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRazonSocial, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrecioPorUnidad, GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDetallePorUnidad, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRubro, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtIVA, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(txtCuitDelProveedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(txtRubro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblIVA)
                                        .addComponent(txtIVA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                        asignarDatosEntidad();
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

    private void asignarFormato() {
        try {
            try {
                txtFechaDeCreacion.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
                txtPrecioPorUnidad.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####.##")));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProductoABM(JFrame frame) {
        super(frame, "Persona", true);
        setLocationRelativeTo(frame);
        inicializarControles();
        asignarFormato();
    }

    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }

    private void asignarDatosEntidad() {
        /*
        productoDTO.setDni(txtDNI.getText());
        productoDTO.setApellido(txtApellido.getText());
        productoDTO.setNombre(txtNombre.getText());
        productoDTO.setFchNacimiento(txtFNacimiento.getText());
        productoDTO.setSueldo(0.0);

         */
    }

    private void asignarDatosForm() {
        /*
        txtDNI.setText(productoDTO.getDni());
        txtApellido.setText(productoDTO.getApellido());
        txtNombre.setText(productoDTO.getNombre());
        txtFNacimiento.setText(productoDTO.getFchNacimiento());
        txtSueldo.setValue(productoDTO.getSueldo());
        */
    }

    public void setProductoDTO(ProductoDTO productoDTO) {
        this.productoDTO = productoDTO;
        asignarDatosForm();
    }

    public ModalResult getModalResult() {
        return modalResult;
    }
}