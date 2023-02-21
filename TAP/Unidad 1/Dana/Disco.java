package unidad1;

import java.util.Arrays;

public class Disco {
    private String titulo;
    private Fecha fechaLanzamineto;
   private String[] canciones;

    public Disco(String titulo, Fecha fechaLanzamineto, String[] canciones) {
        this.titulo = titulo;
        this.fechaLanzamineto = fechaLanzamineto;
        this.canciones = canciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public Fecha getFechaLanzamineto() {
        return fechaLanzamineto;
    }

    public String[] getCanciones() {
        return canciones;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechaLanzamineto(Fecha fechaLanzamineto) {
        this.fechaLanzamineto = fechaLanzamineto;
    }

    public void setCanciones(String[] canciones) {
        this.canciones = canciones;
    }

    public String toString(){
        StringBuilder listaCanc = new StringBuilder();
        for(int i=0; i<canciones.length; i++){
            listaCanc.append(i+1).append(". ").append(canciones[i]).append("\n");
        }
        return "Título: " + titulo + "\nFecha de Lanzamiento: " + fechaLanzamineto + "\nCanciones: \n" + listaCanc;
    }
}
