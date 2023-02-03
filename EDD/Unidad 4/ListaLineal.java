package unidad4;

/** CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA LINEAL Ó SIMPLE 
 * La lista que vamos a estar manejando tiene 2 atributos:
 * - el apuntador al primer nodo (inicio) del mismo tipo de la clase anterior Nodo
 * - un contador de nodos (numNodos) que SIEMPRE va a ser ENTERO */
 
public class ListaLineal {
    // Atributos
    private NodoDos inicio;
    private int numNodos;
    
    // Constructor para crear una lista vacía
    public ListaLineal () { 
        inicio = null; 
        numNodos=0;
    }

    // get...
    public NodoDos getInicio ( ) {
        return inicio;
    }
        
    public int getNumNodos ( ) { 
        return numNodos;
    }

    // Método que devuelve true si la lista está vacía
    public boolean isEmpty() {
        if(inicio == null)
            return true;
        else
            return false;
    }

    // Método que inserta un nodo al inicio de la lista 
    public void insertaInicio (NodoDos nuevo) {
        nuevo.setEnlace(inicio);
        inicio = nuevo;
        numNodos++; 
    }

    public void recorreLista() {
        NodoDos r = inicio;
        System.out.println("Empieza la lista:\n");
        while (r != null) {
            System.out.println ( r.toString() + "\n");
            r = r.getEnlace();
        }
        System.out.println("Fin de la lista"); }

    public String toString(){
        NodoDos r = inicio;
        String s = "";
        for(;r!=null;){
        s += r.toString() + "\n";
        r = r.getEnlace();
        }
    return s;
    }

    public float sumaDatos2(){
        float suma;
        suma=0;
        NodoDos r = inicio;
        for(;;){
            if(r==null){
                break;
            }
            suma = suma + r.getDato2();
            r = r.getEnlace();
        }
        return suma;
    }
    public void insertarFinal(NodoDos x){
        NodoDos r = inicio;
        if(isEmpty()){
            inicio = x;
        }else{
            while(r.getEnlace()!=null){
                r = r.getEnlace();
            }
            r.setEnlace(x); //liga el último nodo al nuevo "x"
        }
        numNodos++;
    }

    public boolean buscarPorDato1(String s){
        NodoDos r=inicio;
        while(r!=null){
            if(r.getDato1().equalsIgnoreCase(s)){
                return true;
            }
        }
        return false;
    }

    public NodoDos eliminaInicio(){
        NodoDos r = inicio;
        if(!isEmpty()){
            inicio = r.getEnlace();
            numNodos--;
        }
        return r;
    }

    // FALTAN MUCHOS MÁS MÉTODOS
}
