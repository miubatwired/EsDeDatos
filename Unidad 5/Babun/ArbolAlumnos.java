package unidad5;

/**
 * Nombre: Jorge Alberto Babun Muñoz
 */

public class ArbolAlumnos {
    private NodoAlumno raiz;

    public ArbolAlumnos(){
        raiz = null;
    }

    public NodoAlumno getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAlumno raiz) {
        this.raiz = raiz;
    }

    public boolean estaVacio(){
        return raiz==null;
    }

    public void insertarNodo ( NodoAlumno n) {
        if( estaVacio())
            raiz = n;
        else
            insertar(raiz, n); //si ya tiene nodos, busca dónde insertarlo usando un método auxiliar
    }

    public void insertar (NodoAlumno raiz, NodoAlumno n) {
        if ( n.getNombre().compareToIgnoreCase(raiz.getNombre() ) < 0) {
            if ( raiz.getIzquierdo() == null)
                raiz.setIzquierdo (n);
            else
                insertar (raiz.getIzquierdo(), n);
        }
        else {
            if (raiz.getDerecho() == null)
                raiz.setDerecho (n);
            else
                insertar (raiz.getDerecho(), n);
        }
    }

    public void aumentarPuntos(NodoAlumno nodo){
        if(nodo==null){
            return;
        }
        if(nodo.getCalif()!=100){
            nodo.setCalif(nodo.getCalif()+ 5);
        }
        aumentarPuntos(nodo.getIzquierdo());
        aumentarPuntos(nodo.getDerecho());
    }

    public String reprobados(NodoAlumno nodo, String s){
        if(nodo==null){
            return "";
        }
        if(nodo.getCalif()<70){
            return nodo.getNombre() + "\n" + reprobados(nodo.getIzquierdo(),s) + reprobados(nodo.getDerecho(),s);
        }else{
            return reprobados(nodo.getIzquierdo(),s) + reprobados(nodo.getDerecho(),s);
        }
    }

    public NodoAlumno eliminar(NodoAlumno nodo, String borrar) {
        if(nodo == null)
            return nodo;
        if (borrar.compareToIgnoreCase(nodo.getNombre()) < 0) {
            nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), borrar));
        } else
        if (borrar.compareToIgnoreCase(nodo.getNombre()) > 0) {
            nodo.setDerecho(eliminar(nodo.getDerecho(), borrar));
        } else {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                System.out.println("borrando: " + borrar);
                return null;
            } else if (nodo.getIzquierdo() == null) {
                System.out.println("borrando: " + borrar);
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                System.out.println("borrando: "+borrar);
                return nodo.getIzquierdo();
            } else {
                String nombre = menorNombre(nodo.getDerecho());
                float calif = menorCalif(nodo.getDerecho());
                nodo.setNombre(nombre);
                nodo.setCalif(calif);
                nodo.setDerecho(eliminar(nodo.getDerecho(), nombre));
                System.out.println("borrando " + borrar);
            }
        }
        return nodo;
    }

    private String menorNombre (NodoAlumno nodo) {
        if(nodo.getIzquierdo() != null) {
            return menorNombre(nodo.getIzquierdo());
        }
        return nodo.getNombre();
    }

    private Float menorCalif (NodoAlumno nodo) {
        if(nodo.getIzquierdo() != null) {
            return menorCalif(nodo.getIzquierdo());
        }
        return nodo.getCalif();
    }

    public String postorden (NodoAlumno nodo) {
        if (nodo == null)
            return "";
        return postorden(nodo.getIzquierdo()) + postorden(nodo.getDerecho()) + nodo.toString() +"\n";
    }
}
