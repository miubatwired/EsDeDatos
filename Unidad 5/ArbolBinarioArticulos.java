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
