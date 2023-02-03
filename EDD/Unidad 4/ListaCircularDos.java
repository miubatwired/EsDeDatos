package unidad4;
/* CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA CIRCULAR con 3 atributos:
 *  - un apuntador al primer nodo (inicio)
 *  - un apuntador al ultimo nodo (fin)
 *  - un contador de nodos (numNodos) que SIEMPRE va a ser ENTERO */

public class ListaCircularDos {
    // Atributos
    private NodoDos inicio;
    private NodoDos fin;
    private int numNodos;

    //  Constructor (crea una lista vacia)
    public ListaCircularDos() {
        inicio = fin = null;
        numNodos = 0;
    }

    // get...
    public NodoDos getInicio() {
        return inicio;
    }

    public NodoDos getFin() {
        return fin;
    }

    public int getNumNodos() {
        return numNodos;
    }

    // set...
    public void setInicio (NodoDos n) {
        inicio = n;
    }

    public void setFin (NodoDos n) {
        fin = n;
    }

    public void setNumNodos (int nn) {
        numNodos = nn;
    }

    // checa si la lista esta vacia
    public boolean listaVacia () {
        if (inicio == null)
            return true;
        else
            return false;
    }

    //inserta nodo al inicio
    public void insertaInicio (NodoDos nuevo) {
        if (listaVacia () ) {
            inicio = fin = nuevo;
            nuevo.setEnlace (nuevo);
        }
        else {
            nuevo.setEnlace (inicio);
            inicio = nuevo;
            fin.setEnlace (nuevo);
        }
        numNodos++;
    }

    public void insertaFinal(NodoDos nuevo){
        if(listaVacia()){
            inicio = fin = nuevo;
            nuevo.setEnlace (nuevo);
        }else{
            fin.setEnlace(nuevo);
            fin = nuevo;
            fin.setEnlace(inicio);
        }
        numNodos++;
    }

    public NodoDos eliminaX(String borra){
        NodoDos prev = inicio;
        NodoDos eliminado = null;
        if(!listaVacia()){
            if(numNodos == 1 && borra.equals(prev.getDato1())){
                eliminado = inicio;
                inicio = null;
                fin = null;
                numNodos--;
            }else{
                NodoDos actual = inicio.getEnlace();
                if(borra.equals(prev.getDato1())){
                    eliminado = prev;
                    inicio = actual;
                    fin.setEnlace(actual);
                    numNodos--;
                }else{
                    do{
                        if(borra.equals(actual.getDato1())){
                            eliminado = actual;
                            prev.setEnlace(actual.getEnlace());
                            if(actual == fin){
                                fin = prev;
                            }
                            numNodos--;
                        }
                        actual = actual.getEnlace();
                        prev = prev.getEnlace();
                    }while(actual!=inicio);
                }
            }
        }
        return eliminado;
    }

    //toString
    public String toString () {
        String s = "";
        NodoDos r = inicio;
        if (listaVacia ()) {
            s += "Lista vacia";
        } else {
            do {
                s += r.toString() + "\n";
                r = r.getEnlace();
            } while (r != inicio);
        }
        return s;
    }

    // faltan métodos
}
