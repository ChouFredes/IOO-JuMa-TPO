package edu.uade.proveedores.dto;

import edu.uade.proveedores.enumeration.TipoIVA;
import edu.uade.proveedores.enumeration.TipoImpuestoProducto;
import edu.uade.proveedores.enumeration.TipoRubro;
import edu.uade.proveedores.model.Producto;
import edu.uade.proveedores.model.Proveedor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductoDTO extends GenericDTO{

    public final String id;
    public final Date fechaDeCreacion;
    public final Long cuitDelProveedor;
    public final String razonSocial;

    public final String descripcion;
    public final Float precioPorUnidad;
    public final int detallePorUnidad;
    public final TipoRubro rubro;
    public final TipoImpuestoProducto IVA;


    public ProductoDTO(String id, Long cuitDelProveedor, String razonSocial, String descripcion,
                       Float precioPorUnidad, int detallePorUnidad, TipoRubro rubro, TipoImpuestoProducto iva, Date fechaDeCreacion) {
        this.id = id;
        this.cuitDelProveedor = cuitDelProveedor;
        this.razonSocial = razonSocial;
        this.descripcion = descripcion;
        this.precioPorUnidad = precioPorUnidad;
        this.detallePorUnidad = detallePorUnidad;
        this.rubro = rubro;
        this.IVA = iva;
        this.fechaDeCreacion = fechaDeCreacion;
    }


    public static ProductoDTO toDTO(Proveedor proveedor, Producto producto) {
        return new ProductoDTO(producto.getId(), proveedor.getCuit(), proveedor.getRazonSocial(), producto.getDescripcion(),
                producto.getPrecioPorUnidad(), producto.getDetallePorUnidad(), producto.getRubro(), producto.getIVA(),
                producto.getFechaDeCreacion());
    }

    public Producto toModel() {
        Producto model;

        if (this.id != null) {
            model = new Producto(this.id, this.descripcion, this.precioPorUnidad, this.detallePorUnidad,
                    this.rubro, this.IVA, this.fechaDeCreacion);
        } else {
            model = new Producto(this.descripcion, this.precioPorUnidad, this.detallePorUnidad,
                    this.rubro, this.IVA);
        }

        return model;

    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return "ProductoDTO {" +
                " id = '" + this.id + '\'' +
                ", cuitDelProveedor = '" + this.cuitDelProveedor + '\'' +
                ", razonSocial = '" + this.razonSocial + '\'' +
                ", descripcion = '" + this.descripcion + '\'' +
                ", precionPorUnidad = '" + this.precioPorUnidad.toString() + '\'' +
                ", detallePorUnidad = '" + this.detallePorUnidad + '\'' +
                ", rubro = '" + this.rubro + '\'' +
                ", IVA = '" + this.IVA + '\'' +
                ", fechaDeCreacion = '" + formatter.format(this.fechaDeCreacion.toString()) + '\'' +
                " }";
    }

}
