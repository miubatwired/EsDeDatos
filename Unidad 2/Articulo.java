package unidad2;

public class Articulo {
    private String descripcion;
    private int cantidad;
    private float precio;

    Articulo(String descripcion, int cantidad, float precio){
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }
    public String toString(){
        return "Descripcion: " + descripcion + "\nCantidad: " + cantidad + "\nPrecio: " + precio;
    }
}
