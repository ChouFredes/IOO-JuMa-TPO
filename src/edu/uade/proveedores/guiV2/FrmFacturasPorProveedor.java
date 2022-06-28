package edu.uade.proveedores.guiV2;
import edu.uade.proveedores.controller.CompraController;
import edu.uade.proveedores.controller.ProveedorController;
import edu.uade.proveedores.dao.ProveedorDao;
import edu.uade.proveedores.dto.DocumentoComercialDTO;
import edu.uade.proveedores.dto.ProveedorDTO;
import edu.uade.proveedores.model.Proveedor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FrmFacturasPorProveedor extends JDialog{

    private ArrayList<Date> fechas = CompraController.getInstance().obtenerListaFechasFacturas();
    private ArrayList<Long> cuits = ProveedorController.getInstance().obtenerCuitProveedores();
    private JPanel PnlPrincipal;
    private JComboBox cbProveedores;
    private JComboBox cbFechas;
    private JTable tableFacturas;
    private DefaultTableModel tableModel;
    private Object[][] data;
    private String[] columnNames = {"id","fechaEmision","tipo doc","comprobante"};
    private Date fechaItem;
    private Long cuitItem;

    public FrmFacturasPorProveedor(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setModal(true);
        this.setSize(320, 320);
        this.setContentPane(PnlPrincipal);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        DefaultComboBoxModel modelProveedores = new DefaultComboBoxModel();
        modelProveedores.addAll(cuits);
        cbProveedores.setModel(modelProveedores);

        DefaultComboBoxModel modelFechas = new DefaultComboBoxModel();
        modelFechas.addAll(fechas);
        cbFechas.setModel(modelFechas);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date fecha = formatter.parse("02-06-2022");

        ProveedorDao daoProveedor = new ProveedorDao();
        Proveedor proveedor = daoProveedor.getById("b85ab4c6-64db-4e30-bc37-6cc1e77a20e2");
        ProveedorDTO proveedorDTO = ProveedorDTO.toDTO(proveedor);

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

        ArrayList<DocumentoComercialDTO> lista = CompraController.getInstance().getFacturaPorProveedor(11121314151L);
        data = convertDtoToData(lista);
        tableModel = new DefaultTableModel(data, columnNames);
        tableFacturas = new JTable(tableModel);
        tableFacturas.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(tableFacturas);
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

}
