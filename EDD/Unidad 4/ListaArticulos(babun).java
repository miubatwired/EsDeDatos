package unidad4;

public class ListaArticulos {
    private NodoArticulo inicio;
    private int numNodos;

    public ListaArticulos(){
        inicio = null;
        numNodos = 0;
    }

    public NodoArticulo getInicio ( ) {
        return inicio;
    }

    public int getNumNodos ( ) {
        return numNodos;
    }

    public boolean isEmpty(){
        return inicio==null;
    }

    public void setInicio(NodoArticulo inicio){
        this.inicio = inicio;
    }

    public void setNumNodos(int numNodos){
        this.numNodos = numNodos;
    }

    public void insertaInicio (NodoArticulo nuevo) {
        nuevo.setEnlace(inicio);
        inicio = nuevo;
        numNodos++;
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

    public void insertarFinal(NodoArticulo x){
        NodoArticulo r = inicio;
        if(isEmpty()){
            inicio = x;
        }else{
            while(r.getEnlace()!=null){
                r = r.getEnlace();
            }
            r.setEnlace(x);
        }
        numNodos++;
    }

    public NodoArticulo eliminaInicio(){
        NodoArticulo r = inicio;
        if(!isEmpty()){
            inicio = r.getEnlace();
            numNodos--;
        }
        return r;
    }

    public String precioMenor(){
        NodoArticulo r = inicio;
        boolean found = false;
        StringBuilder sbuilder = new StringBuilder();
        while (r!=null) {
            if(r.getPrecio()<25){
                sbuilder.append(r.toString()).append("\n");
                found = true;
            }
            r = r.getEnlace();
        }
        if(found){
            return sbuilder.toString();
        }else{
            return "No hay artículos cuyo precio sea menor a 25";
        }
    }

    public float inventarioTotal(){
        NodoArticulo r = inicio;
        float inventario = 0;
        while(r!=null){
            inventario += r.getCantidad() * r.getPrecio();
            r = r.getEnlace();
        }
        return inventario;
    }

    public void aumentarPorcentaje(float porcentaje){
        NodoArticulo r = inicio;
        porcentaje = porcentaje/100 + 1;
        while (r != null) {
            r.setPrecio(r.getPrecio() * porcentaje);
            r = r.getEnlace();
        }
    }

    public String buscarArticulo(String descripcion){
        NodoArticulo r = inicio;
        String datos = "El artículo no existe";
        while(r!=null){
            if(r.getDescripcion().equalsIgnoreCase(descripcion)){
                datos = r.toString();
            }
            r = r.getEnlace();
        }
        return datos;
    }

    public String toString(){
        NodoArticulo r = inicio;
        StringBuilder sbuilder = new StringBuilder();
        if(!isEmpty()){
            while (r!=null) {
                sbuilder.append(r.toString()).append("\n\n");
                r = r.getEnlace();
            }
            return sbuilder.toString();
        }else{
            return "No hay artículos en la lista";
        }
    }
}
