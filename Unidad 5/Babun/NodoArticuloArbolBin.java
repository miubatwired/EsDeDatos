package unidad5;

public class NodoArticuloArbolBin {
    private NodoArticuloArbolBin izquierdo;
    private String descripcion;
    private int cantidad;
    private float precio;
    private NodoArticuloArbolBin derecho;

    // Constructor: Crea nodos hoja
    public NodoArticuloArbolBin(String descripcion, int cantidad, float precio ) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        izquierdo = derecho = null;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public NodoArticuloArbolBin getIzquierdo ( ) {
        return izquierdo;
    }

    public NodoArticuloArbolBin getDerecho ( ) {
        return derecho;
    }

    public void setIzquierdo(NodoArticuloArbolBin izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoArticuloArbolBin derecho) {
        this.derecho = derecho;
    }

    // toString
    public String toString() {
        return "Descripcion " + descripcion + "\nCantidad: " + cantidad + "\nPrecio: " + precio;
    }
}
