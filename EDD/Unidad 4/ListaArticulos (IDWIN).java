package Unidad4;

import javax.swing.*;

public class ListaArticulos {

    private NodoArticulo inicio;
    private int numNodos;

    public ListaArticulos () {
        inicio = null;
        numNodos=0;
    }

    public NodoArticulo getInicio() {
        return inicio;
    }

    public int getNumNodos() {
        return numNodos;
    }

    public boolean listaVacia() {
        if (inicio == null)
            return true;
        else
            return false;
    }

    public void insertaInicio (NodoArticulo nuevo) {
        nuevo.setEnlace(inicio);
        inicio = nuevo;
        numNodos++;
    }

    public NodoArticulo eliminarInicio(){
        NodoArticulo r = inicio;
        inicio = inicio.getEnlace();
        numNodos--;
        return r;
    }

    public String listado25(){
        NodoArticulo r = inicio;
        String s="";
        if(!listaVacia()){
            for (;;) {
                if( r == null)
                    break;
                if (r.getPrecio() < 25)
                    s += r.toString();
                r=r.getEnlace();
            }
        }
        return s;
    }

    public void aumento(int x){
        NodoArticulo r = inicio;
        float porciento = 1 + (x*.01f);
        if(!listaVacia()){
            for(;;) {
                if( r == null)
                    break;
                r.setPrecio(r.getPrecio() * porciento);
                r = r.getEnlace();
            }
        }else
            JOptionPane.showMessageDialog(null,"no se pudo hacer el aumento de precio");
    }

    public void buscar(String s){
        NodoArticulo r = inicio;
        if(r==null){
            JOptionPane.showMessageDialog(null,"NO SE ENCUENTRA EL ARTICULO");
        }
        if(!listaVacia()){
            for(;; ){
                if( r == null)
                    break;
                if(r.getDescripcion().equalsIgnoreCase(s)) {
                    JOptionPane.showMessageDialog(null, r.toString());
                }
                r=r.getEnlace();
            }
        }
    }

    public void recorreLista() {
        NodoArticulo r = inicio;
        System.out.println("Empieza la lista:\n");
        while (r != null) {
            System.out.println ( r.toString() + "\n");
            r = r.getEnlace();
        }
        System.out.println("Fin de la lista");
    }

    public void insertarFinal(NodoArticulo x) {
        NodoArticulo r = inicio;
        if (listaVacia())
            inicio = x;
        else{
            while (r.getEnlace() != null) {
                r = r.getEnlace();
            }
            r.setEnlace(x);
        }
        numNodos++;
    }
    public float inventario(){
        NodoArticulo r = inicio;
        float suma=0;
        System.out.println("suma:"+suma);
        if(!listaVacia()){
            System.out.println("entro");
            for (;;){
                if( r == null)
                    break;
                suma += r.getPrecio() * r.getCantidad();
                System.out.println(suma);
                r=r.getEnlace();
            }
        }
        return suma;
    }

    public String toString(){
        NodoArticulo r = inicio;
        String s="Datos de la lista \n";
        for(;;){
            if(r==null){
                break;
            }
            s += r.toString() + "\n ";
            r = r.getEnlace();
        }
        return s;
    }
}