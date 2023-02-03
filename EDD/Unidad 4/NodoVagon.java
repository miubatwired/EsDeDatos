package unidad4;
/*
    Nombre: Jorge Alberto Babun Muñoz
 */

public class NodoVagon {
    String carga;
    float peso;
    NodoVagon enlace;

    public NodoVagon(){
        carga = "";
        peso = 0;
        enlace = null;
    }

    public NodoVagon(String carga, float peso) {
        this.carga = carga;
        this.peso = peso;
        enlace = null;
    }

    public String getCarga() {
        return carga;
    }

    public float getPeso() {
        return peso;
    }

    public NodoVagon getEnlace() {
        return enlace;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setEnlace(NodoVagon enlace) {
        this.enlace = enlace;
    }

    public String toString(){
        return "Carga: " + carga + "\nPeso: " + peso;
    }
}
