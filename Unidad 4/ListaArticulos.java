/** CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA LINEAL Ó SIMPLE
 * La lista que vamos a estar manejando tiene 2 atributos:
 * - el apuntador al primer nodo (inicio) del mismo tipo de la clase anterior Nodo
 * - un contador de nodos (numNodos) que SIEMPRE va a ser ENTERO */

public class ListaArticulos {
    // Atributos
    private NodoArticulos inicio;
    private int numNodos;

    // Constructor para crear una lista vacía
    public ListaArticulos() {
        inicio = null;
        numNodos=0;
    }


    // get...
    public NodoArticulos getInicio ( ) {
        return inicio;
    }

    public int getNumNodos ( ) {
        return numNodos;
    }


    // Método que devuelve true si la lista está vacía
    public boolean listaVacia() {
        if (inicio == null)
            return true;
        else
            return false;
    }


    // Método que inserta un nodo al inicio de la lista
    public void insertaInicio (NodoArticulos nuevo) {
        nuevo.setEnlace(inicio);
        inicio = nuevo;
        numNodos++;
    }


    public void recorreLista() {
        NodoArticulos r = inicio;
        System.out.println("Empieza la lista:\n");
        while (r != null) {
            System.out.println ( r.toString() + "\n");
            r = r.getEnlace();
        }
        System.out.println("Fin de la lista"); }


    public String toString(){
        NodoArticulos r = inicio;
        String s = "";
        for(;r!=null;){
            s += r.toString() + "\n";
            r = r.getEnlace();
        }
        return s;
    }


    public void insertarFinal(NodoArticulos x){
        NodoArticulos r = inicio;
        if(listaVacia()){
            inicio = x;
        }else{
            while(r.getEnlace()!=null){
                r = r.getEnlace();
            }
            r.setEnlace(x); //liga el último nodo al nuevo "x"
        }
        numNodos++;
    }

    public NodoArticulos eliminarPrimero(){
        NodoArticulos r = inicio;
        if(!listaVacia())
            inicio = inicio.getEnlace();
        r.setEnlace(null);
        return r;
    }

    public float mostrarInventario(){
        NodoArticulos r = inicio;
        float mult = 0;
        if(!listaVacia())
            for(; r != null;){
                mult+= r.getCantidad() * r.getPrecio();
                r = r.getEnlace();
            }
        return mult;
    }

    public String mostrarDescripcion(){
        NodoArticulos r = inicio;
        String s = "";
        if(!listaVacia())
            for(;r != null;){
                if(r.getPrecio() < 25)
                    s+= r.getDescripcion() + "\n";
                r = r.getEnlace();
            }
        return s;
    }

    public void aumentarPrecios(float per){
        NodoArticulos r = inicio;
        if(!listaVacia())
            for(;r != null;){
                System.out.println(per);
                System.out.println(r.getPrecio() * per);
                r.setPrecio(r.getPrecio()*per);
                r = r.getEnlace();
            }
    }

    public boolean buscarDescripcion(String desc){
        NodoArticulos r = inicio;
        if(!listaVacia())
            for(;r!= null;){
                if(r.getDescripcion().equalsIgnoreCase(desc))
                    return true;
                r = r.getEnlace();
            }
        return false;
    }
    // FALTAN MUCHOS MÁS MÉTODOS
}