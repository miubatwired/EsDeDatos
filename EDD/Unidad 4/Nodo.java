package unidad4;

public class Nodo {
    private String nombre;
    private Nodo enlace;

    public Nodo(){
        nombre = "";
        enlace = null;
    }

    public Nodo(String nombre){
        this.nombre = nombre;
        enlace = null;
    }

    public String getNombre(){
        return nombre;
    }

    public Nodo getEnlace(){
        return enlace;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }

    public String toString(){
        return "Nombre: " + nombre;
    }

}
