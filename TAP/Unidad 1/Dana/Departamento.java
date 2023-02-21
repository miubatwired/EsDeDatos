package unidad1;

public class Departamento {
    private String nombre;
    private String responsable;
    private Articulo[] articulos;

    public Departamento(String nombre, String responsable, Articulo[] articulos) {
        this.nombre = nombre;
        this.responsable = responsable;
        this.articulos = articulos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public Articulo[] getArticulos() {
        return articulos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setArticulos(Articulo[] articulos) {
        this.articulos = articulos;
    }
}