package edu.uade.proveedores.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmCompulsaDePrecios extends JFrame implements ActionListener {

    private FrmCompulsaDePrecios self;
    private JPanel panelPrincipal;
    private JButton button1;
    private JTextField textField1;
    private JTextField textField2;

    public FrmCompulsaDePrecios(String title){
        super(title);
        this.setContentPane(panelPrincipal);
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.self = this;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        FrmCompulsaDePrecios frame = new FrmCompulsaDePrecios("Demo IOO");
        frame.setVisible(true);
    }
}
