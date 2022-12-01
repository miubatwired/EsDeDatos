package unidad4;
/*
    Nombre: Jorge Alberto Babun Muñoz
 */

public class ListaCircularVagones {
    private NodoVagon inicio;
    private NodoVagon fin;
    private int numNodos;

    public ListaCircularVagones(){
        inicio = fin = null;
        numNodos = 0;
    }

    public NodoVagon getInicio() {
        return inicio;
    }

    public NodoVagon getFin() {
        return fin;
    }

    public int getNumNodos() {
        return numNodos;
    }

    public void setInicio(NodoVagon inicio) {
        this.inicio = inicio;
    }

    public void setFin(NodoVagon fin) {
        this.fin = fin;
    }

    public void setNumNodos(int numNodos) {
        this.numNodos = numNodos;
    }


    public boolean estaVacia(){
        return inicio==null;
    }

    public boolean encontrarPorString(String carga, float peso){
        NodoVagon r = inicio;
        if(!estaVacia()){
            do{
                if(r.getCarga().equals(carga)){
                    r.setPeso(r.getPeso() + peso);
                    return true;
                }
                r = r.getEnlace();
            }while(r!=inicio);
        }
        return false;
    }

    public void insertaFinal(NodoVagon nuevo){
        if(estaVacia()){
            inicio = fin = nuevo;
            nuevo.setEnlace (nuevo);
        }else{
            fin.setEnlace(nuevo);
            fin = nuevo;
            fin.setEnlace(inicio);
        }
        numNodos++;
    }

    public String desengancharInicio(){
        NodoVagon primer = inicio;
        String eliminado = "El tren no tiene vagones enganchados";
        if(!estaVacia()){
            if(inicio!=fin){
                eliminado = inicio.toString();
                inicio = inicio.getEnlace();
                fin.setEnlace(inicio);
                numNodos--;
            }else{
                eliminado = inicio.toString();
                inicio = null;
                fin = null;
                numNodos--;
            }
        }
        return eliminado;
    }

    public String toString () {
        StringBuilder stringBuilder = new StringBuilder();
        NodoVagon r = inicio;
        if (estaVacia()) {
            stringBuilder.append("El tren no tiene vagones enganchados");
        } else {
            do {
                stringBuilder.append(r.toString()).append("\n");
                r = r.getEnlace();
            } while (r != inicio);
        }
        return stringBuilder.toString();
    }


}
