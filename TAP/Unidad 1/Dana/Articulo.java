package unidad1;

public class Articulo {
    private String descripcion;
    private int cantidad;
    private float precio;
    private Fecha fechaCaducidad;

    public Articulo(String descripcion, int cantidad, float precio, Fecha fechaCaducidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecios() {
        return precio;
    }

    public Fecha getFechaCaducidad() {
        return fechaCaducidad;
    }

}
