package unidad4;

public class NodoArticulo {
    private String descripcion;
    private int cantidad;
    private float precio;
    private NodoArticulo enlace;

    public NodoArticulo(){
        descripcion = "";
        cantidad = 0;
        precio = 0;
        enlace = null;
    }

    public NodoArticulo(String descripcion, int cantidad, float precio){
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        enlace = null;
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

    public NodoArticulo getEnlace() {
        return enlace;
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

    public void setEnlace(NodoArticulo enlace) {
        this.enlace = enlace;
    }

    public String toString(){
        return "Descripción:\t" + descripcion + "\nCantidad:\t" + cantidad + "\nPrecio:\t" + precio;
    }
}
