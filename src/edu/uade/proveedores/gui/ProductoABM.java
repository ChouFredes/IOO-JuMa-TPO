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
    private JTextField txtDNI;
    private JTextField txtApellido;
    private JTextField txtNombre;
    private JFormattedTextField txtFNacimiento;
    private JFormattedTextField txtSueldo;
    private ProductoDTO productoDTO;
    private ModalResult modalResult;

    /**
     * Launch the application.
     */

    /**
     * Create the dialog.
     */

    private void inicializarControles() {
        setBounds(100, 100, 450, 245);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("DNI");

        txtDNI = new JTextField();
        txtDNI.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Apellido");

        txtApellido = new JTextField();
        txtApellido.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre");

        txtNombre = new JTextField();
        txtNombre.setColumns(10);

        JCheckBox chcSindicalizado = new JCheckBox("Sindicalizado");

        JLabel lblNewLabel_2 = new JLabel("Nacimiento");

        txtFNacimiento = new JFormattedTextField();

        JLabel lblNewLabel_3 = new JLabel("Sueldo");

        txtSueldo = new JFormattedTextField();
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
                gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(lblNewLabel)
                                        .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(lblNewLabel_3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(chcSindicalizado)
                                        .addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtSueldo, GroupLayout.Alignment.LEADING)
                                                .addComponent(txtFNacimiento, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                                .addContainerGap(108, Short.MAX_VALUE))
        );
        gl_contentPanel.setVerticalGroup(
                gl_contentPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(4)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(txtFNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(txtSueldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chcSindicalizado)
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
                txtFNacimiento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
                txtSueldo.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####.##")));
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