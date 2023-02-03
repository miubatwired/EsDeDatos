/** CLASE INSTANCIABLE PARA MANEJAR UN nodo con 2 datos:
 - un string (dato1)
 - un flotante (dato2)
 - y OBIVAMENTE el apuntador que guarda la dirección del siguiente nodo (enlace) */


public class NodoArticulos {
    // 3 atributos: los 2 datos y el enlace
    private String descripcion;
    private float precio;
    private int cantidad;
    private NodoArticulos enlace;

    // 1er. Constructor, crea un nodo con datos vacíos (NO recibe parámetros)
    public NodoArticulos( ) {
        descripcion = "";
        precio = 0.0f;
        cantidad = 0;
        enlace = null;
    }
    // 2do. Constructor, recibe como parámetros los 2 datos, el enlace NO se recibe, sino 
    // que se pone en null porque todos los nodos nuevos está DESCONECTADOS de la lista 
    public NodoArticulos(String descripcion, float precio, int cantidad) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        enlace = null;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public NodoArticulos getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoArticulos enlace) {
        this.enlace = enlace;
    }

    // Método toString
    public String toString( ) {
        return "Descripcion: " + descripcion + "\nPrecio: " + precio + "\nCantidad: " + cantidad;
    }

} // fin de la clase Nodo
