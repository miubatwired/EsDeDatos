package unidad5;

/**
 * Nombre: Jorge Alberto Babun Muñoz
 */

public class NodoAlumno {
    private NodoAlumno izquierdo;
    private NodoAlumno derecho;
    private String nombre;
    private float calif;

    public NodoAlumno(String nombre, float calif){
        this.nombre = nombre;
        this.calif = calif;
        izquierdo = derecho = null;
    }

    public NodoAlumno getDerecho() {
        return derecho;
    }

    public NodoAlumno getIzquierdo() {
        return izquierdo;
    }

    public String getNombre(){
        return nombre;
    }

    public float getCalif(){
        return calif;
    }

    public void setIzquierdo(NodoAlumno izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoAlumno derecho) {
        this.derecho = derecho;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCalif(float calif) {
        this.calif = calif;
    }

    public String toString(){
        return "Nombre: " + nombre + "          Calif: " + calif;
    }
}
