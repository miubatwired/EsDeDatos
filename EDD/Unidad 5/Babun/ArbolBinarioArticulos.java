package unidad5;

import unidad4.NodoArticulo;

public class ArbolBinarioArticulos {
    private NodoArticuloArbolBin raiz;

    public ArbolBinarioArticulos ( ) {
        raiz = null;
    }

    public NodoArticuloArbolBin getRaiz(){
        return raiz;
    }

    public void setRaiz(NodoArticuloArbolBin raiz){
        this.raiz = raiz;
    }

    public boolean estaVacio(){
        return raiz==null;
    }

    public void insertarNodo ( NodoArticuloArbolBin n) {
        if( estaVacio())
            raiz = n;
        else
            insertar(raiz, n); //si ya tiene nodos, busca dónde insertarlo usando un método auxiliar
    }

    public void insertar (NodoArticuloArbolBin raiz, NodoArticuloArbolBin n) {
        if ( n.getDescripcion().compareToIgnoreCase(raiz.getDescripcion() ) < 0) {
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

    public float getInventarioTotal(NodoArticuloArbolBin nodo){
        if(nodo==null)
            return 0f;
        return nodo.getPrecio() * nodo.getCantidad() + getInventarioTotal(nodo.getDerecho()) + getInventarioTotal(nodo.getIzquierdo());
    }

    public void aumentarPrecio(NodoArticuloArbolBin nodo){
        if(nodo==null)
            return;
        nodo.setPrecio(nodo.getPrecio()*1.03f);
        aumentarPrecio(nodo.getIzquierdo());
        aumentarPrecio(nodo.getDerecho());
    }

    public String articulosHojas(NodoArticuloArbolBin nodo){
        if(nodo == null) {
            return "";
        }
        if(nodo.getIzquierdo() == null && nodo.getDerecho() == null){
            return nodo.toString() + "\n";
        }
        return articulosHojas(nodo.getIzquierdo()) + articulosHojas(nodo.getDerecho());
    }

    public boolean buscaArticulo(NodoArticuloArbolBin nodo, String desc){
        if(nodo == null) {
            return false;
        }
        if(nodo.getDescripcion().compareToIgnoreCase(desc)==0){
            return true;
        }
        return buscaArticulo(nodo.getIzquierdo(), desc) || buscaArticulo(nodo.getDerecho(), desc);
    }

    // Método principal para eliminar un nodo de acuerdo a la descripción del artículo
    // el método NO DEVUELVE EL NODO BORRADO, devuelve la raíz del árbol "RECONFIGURADO"
    // es decir, cómo queda después de hacer la eliminación (si es que existe el nodo a borrar)
    public NodoArticuloArbolBin eliminar(NodoArticuloArbolBin nodo, String borrar) {

        if(nodo == null)  // Caso base para parar la llamada recursiva al método
            return nodo;

        if (borrar.compareToIgnoreCase(nodo.getDescripcion()) < 0) {   //busca el nodo a borrar a la izquierda
            nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), borrar));
        } else
        if (borrar.compareToIgnoreCase(nodo.getDescripcion()) > 0) {  // o lo busca a la derecha
            nodo.setDerecho(eliminar(nodo.getDerecho(), borrar));
        } else {
            // Este es el nodo a borrar que coincide con el string recibido
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                // Es una HOJA sin hijos
                System.out.println("borrando: " + borrar);
                return null;
            } else if (nodo.getIzquierdo() == null) {
                // Solo tiene su hijo derecho
                System.out.println("borrando: " + borrar);
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                // Solo tiene su hijo izquierdo
                System.out.println("borrando: "+borrar);
                return nodo.getIzquierdo();
            } else {     // Es un nodo que TIENE SUS 2 HIJOS
                // Busca el nodo MENOR del subárbol DERECHO
                String desc = menorDesc(nodo.getDerecho());    // Utiliza metodos auxiliares para
                int cant = menorCant(nodo.getDerecho());       // traer los datos del nodo más a la izquierda
                float pre = menorPre(nodo.getDerecho());       // es decir el MENOR del subárbol derecho
                nodo.setDescripcion(desc);                     // COPIA los datos de ese nodo SUCESOR que va a
                nodo.setCantidad(cant);                        // sustituir al nodo que sera eliminado
                nodo.setPrecio(pre);
                nodo.setDerecho(eliminar(nodo.getDerecho(), desc));  // se actualiza el enlace al hijo derecho
                System.out.println("borrando " + borrar);
            }
        }
        return nodo;
    }

    // Métodos auxiliares para obtener los datos del nodo que va a
    // sustituir al nodo eliminado
    // es UN MÉTODO por cada dato del nodo, para el nodo de artículos, son 3 métodos para:
    //  - descripcion
    //  - cantidad
    //  - precio
    private String menorDesc (NodoArticuloArbolBin nodo) {

        if(nodo.getIzquierdo() != null) {
            return menorDesc(nodo.getIzquierdo());
        }
        return nodo.getDescripcion();
    }

    private int menorCant (NodoArticuloArbolBin nodo) {

        if(nodo.getIzquierdo() != null) {
            return menorCant(nodo.getIzquierdo());
        }
        return nodo.getCantidad();
    }

    private float menorPre (NodoArticuloArbolBin nodo) {

        if(nodo.getIzquierdo() != null) {
            return menorPre(nodo.getIzquierdo());
        }
        return nodo.getPrecio();
    }


    // devuelve un String con el recorrido PREORDEN del árbol
    public String preorden (NodoArticuloArbolBin nodo) {
        if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
            return "";
        return nodo.toString() +"\n"+ preorden(nodo.getIzquierdo()) +  preorden(nodo.getDerecho());
    }

    // devuelve un String con el recorrido INORDEN del árbol
    public String inorden (NodoArticuloArbolBin nodo) {
        if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
            return "";
        return inorden(nodo.getIzquierdo()) + nodo.toString() +"\n"+ inorden(nodo.getDerecho());
    }

    // devuelve un String con el recorrido POSTORDEN del árbol
    public String postorden (NodoArticuloArbolBin nodo) {
        if (nodo == null)
            return "";
        return postorden(nodo.getIzquierdo()) + postorden(nodo.getDerecho()) + nodo.toString() +"\n";
    }
}
