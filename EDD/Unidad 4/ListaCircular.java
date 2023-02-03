package unidad4;

import java.util.Random;
import javax.swing.JOptionPane;
public class ListaCircular {
    private Nodo inicio;
    private Nodo fin;
    private int numNodos;

    public ListaCircular(){
        inicio = fin = null;
        numNodos = 0;
    }

    public Nodo getInicio(){
        return inicio;
    }

    public Nodo getFin(){
        return fin;
    }

    public int getNumNodos(){
        return numNodos;
    }

    public void setInicio(Nodo inicio){
        this.inicio = inicio;
    }

    public void setFin(Nodo fin){
        this.fin = fin;
    }

    public void setNumNodos(int numNodos){
        this.numNodos = numNodos;
    }

    public boolean isEmpty(){
        return inicio==null;
    }

    public void insertaInicio(Nodo nuevo){
        if(isEmpty()){
            inicio = fin = nuevo;
            nuevo.setEnlace (nuevo);
        }else{
            nuevo.setEnlace(inicio);
            inicio = nuevo;
            fin.setEnlace(nuevo);
        }
        numNodos++;
    }

    public void insertaFinal(Nodo nuevo){
        if(isEmpty()){
            inicio = fin = nuevo;
            nuevo.setEnlace (nuevo);
        }else{
            fin.setEnlace(nuevo);
            fin = nuevo;
            fin.setEnlace(inicio);
        }
        numNodos++;
    }

    public void centurion(){
        Nodo r = fin;
        Nodo actual = inicio;
        String todo = "";
        Nodo morido = null;
        int dado = 0;
        Random ran = new Random();
        while(numNodos>1){
            dado = ran.nextInt(1,6);
            todo="El soldado que lanza el dado es " + actual.getNombre() + " y tiró " + dado;
            for(int i = 1; i <= dado; i++) {
                if(i==dado){
                    morido = actual;
                    r.setEnlace(actual.getEnlace());
                    actual = actual.getEnlace();
                    numNodos--;
                    todo+="\nEl soldado eliminado es " + morido.getNombre();
                    JOptionPane.showMessageDialog(null, todo);
                    if(morido == fin){
                        fin = r;
                    }
                    if(morido == inicio){
                        inicio = r;
                    }
                    break;
                }
                r = r.getEnlace();
                actual = actual.getEnlace();
            }
            JOptionPane.showMessageDialog(null, toString());
        }
        JOptionPane.showMessageDialog(null, "El ganador es " + inicio.getNombre());
    }


    public String toString () {
        StringBuilder stringBuilder = new StringBuilder();
        Nodo r = inicio;
        if (isEmpty()) {
            stringBuilder.append("Lista vacia");
        } else {
            do {
                stringBuilder.append(r.toString()).append("\n");
                r = r.getEnlace();
            } while (r != inicio);
        }
        return stringBuilder.toString();
    }


}
