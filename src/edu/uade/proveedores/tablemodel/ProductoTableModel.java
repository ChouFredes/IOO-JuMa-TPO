package edu.uade.proveedores.tablemodel;

import edu.uade.proveedores.controller.ProveedorController;
import edu.uade.proveedores.dto.ProductoDTO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

;

public class ProductoTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<ProductoDTO> productos;
	private ProveedorController proveedorController;
	
	protected String[] columnNames = new String[] { "id", "cuit", "razonSocial", "descripcion", "precioPorUnidad",
			"detallePorUnidad", "rubro", "IVA", "fechaDeCreacion"};
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, boolean.class, String.class, float.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public ProductoTableModel() throws Exception {
		proveedorController = ProveedorController.getInstance();
		actualizarProductos();
	}

	private void actualizarProductos() {
		productos = proveedorController.obtenerProductos();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return productos.size();
	}
	
    @Override
    public boolean isCellEditable(int row, int column)
    {
    	return false;
    }
    
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) 
		{ 
			case 0: return productos.get(rowIndex).id;
			case 1: return productos.get(rowIndex).cuitDelProveedor;
			case 2: return productos.get(rowIndex).razonSocial;
			case 3: return productos.get(rowIndex).descripcion;
			case 4: return productos.get(rowIndex).precioPorUnidad;
			case 5: return productos.get(rowIndex).detallePorUnidad;
			case 6: return productos.get(rowIndex).rubro;
			case 7: return productos.get(rowIndex).IVA;
			case 8: return productos.get(rowIndex).fechaDeCreacion;
			default: return null; 
		}
	}
	
	public void agregar(ProductoDTO productoDTO)
	{
		proveedorController.agregarProductoDeProveedor(productoDTO);
		actualizarProductos();
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		proveedorController.eliminarProductoDeProveedor(productos.get(fila));
		actualizarProductos();
		fireTableDataChanged();
	}
	
	public void eliminar(ProductoDTO productoDTO)
	{
		eliminar(productos.indexOf(productoDTO));
	}

	public ProductoDTO obtenerProducto(int indice) {
		return productos.get(indice);
	}

}
