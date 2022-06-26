package edu.uade.proveedores.dto;

public class DeudaDeProveedorDTO extends GenericDTO{

    public final Long cuit;
    public final float deudaTotal;

    public DeudaDeProveedorDTO(Long cuit, float deudaTotal) {
        this.cuit = cuit;
        this.deudaTotal = deudaTotal;
    }

    @Override
    public String toString() {
        return "ProveedorDTO {" +
                ", cuit = '" + this.cuit + '\'' +
                ", deudaTotal = '" + this.deudaTotal + '\'' +
                " }";
    }
}
