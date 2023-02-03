package unidad4;

public class ListaArticulos {
    private NodoArticulo inicio;
    private int numNodos;

    public ListaArticulos() {
        inicio = null;
        numNodos = 0;
    }

    public NodoArticulo getInicio() {
        return inicio;
    }

    public int getNumNodos() {
        return numNodos;
    }

    public boolean listaVacia() {
        return inicio == null;
    }

    public void setInicio(NodoArticulo inicio) {
        this.inicio = inicio;
    }

    public void setNumNodos(int numNodos) {
        this.numNodos = numNodos;
    }

    public void insertaInicio(NodoArticulo nuevo) {
        nuevo.setEnlace(inicio);
        inicio = nuevo;
        numNodos++;
    }

    public void recorreLista() {
        NodoArticulo r = inicio;
        System.out.println("Empieza la lista:\n");
        while (r != null) {
            System.out.println(r.toString() + "\n");
            r = r.getEnlace();
        }
        System.out.println("Fin de la lista");
    }

    public void insertarFinal(NodoArticulo x) {
        NodoArticulo r = inicio;
        if (listaVacia()) {
            inicio = x;
        } else {
            while (r.getEnlace() != null) {
                r = r.getEnlace();
            }
            r.setEnlace(x);
        }
        numNodos++;
    }

    public NodoArticulo eliminaInicio() {
        NodoArticulo r = inicio;
        if (!listaVacia()) {
            inicio = r.getEnlace();
            numNodos--;
        }
        return r;
    }

    public String precioMenor() {
        NodoArticulo r = inicio;
        boolean found = false;
        StringBuilder sbuilder = new StringBuilder();
        while (r != null) {
            if (r.getPrecio() < 25) {
                sbuilder.append(r.toString()).append("\n");
                found = true;
            }
            r = r.getEnlace();
        }
        if (found) {
            return sbuilder.toString();
        } else {
            return "No hay artículos cuyo precio sea menor a 25";
        }
    }

    public float inventarioTotal() {
        NodoArticulo r = inicio;
        float inventario = 0;
        while (r != null) {
            inventario += r.getCantidad() * r.getPrecio();
            r = r.getEnlace();
        }
        return inventario;
    }

    public void aumentarPorcentaje(float porcentaje) {
        NodoArticulo r = inicio;
        porcentaje = porcentaje / 100 + 1;
        while (r != null) {
            r.setPrecio(r.getPrecio() * porcentaje);
            r = r.getEnlace();
        }
    }

    public String buscarArticulo(String descripcion) {
        NodoArticulo r = inicio;
        String datos = "El artículo no existe";
        while (r != null) {
            if (r.getDescripcion().equalsIgnoreCase(descripcion)) {
                datos = r.toString();
            }
            r = r.getEnlace();
        }
        return datos;
    }

    public String articuloMasCaro() {
        if (!listaVacia()) {
            NodoArticulo r = inicio;
            NodoArticulo mayor = inicio;
            while (r != null) {
                if (r.getPrecio() > mayor.getPrecio()) {
                    mayor = r;
                }
                r = r.getEnlace();
            }
            return "El artículo más caro es " + mayor.getDescripcion();
        }
        return "La lista está vacía";
    }

    public NodoArticulo eliminaUltimo() {
        NodoArticulo r = inicio;
        int i = 1;
        NodoArticulo eliminado = null;
        if (!listaVacia()) {
            if(numNodos==1){
                eliminado = inicio;
                eliminaInicio();
            }else{
                while (r != null) {
                    eliminado = r;
                    r = r.getEnlace();
                }
                r = inicio;
                while (i <= numNodos) {
                    if (i == numNodos -1) {
                        r.setEnlace(null);
                        numNodos--;
                    }
                    r = r.getEnlace();
                    i++;
                }
            }
        }
        return eliminado;
    }
    public void insertaAlfabetico(NodoArticulo nuevo){
        NodoArticulo r = inicio;
        boolean inserto = false;
        if(!listaVacia()) {
            if (nuevo.getDescripcion().compareToIgnoreCase(r.getDescripcion()) < 0) {
                insertaInicio(nuevo);
            }else{
                NodoArticulo x = inicio;
                NodoArticulo y = x.getEnlace();
                while(y!=null){
                    if(nuevo.getDescripcion().compareToIgnoreCase(x.getDescripcion()) > 0 && nuevo.getDescripcion().compareToIgnoreCase(y.getDescripcion()) < 0){
                        nuevo.setEnlace(y);
                        x.setEnlace(nuevo);
                        numNodos++;
                        inserto = true;
                    }
                    x = x.getEnlace();
                    y = y.getEnlace();
                }
                if(!inserto){
                    insertarFinal(nuevo);
                }
            }
        }else{
            insertaInicio(nuevo);
        }
    }

    public NodoArticulo eliminarPorDescripcion(String s){
        NodoArticulo r=inicio;
        NodoArticulo momento=null;
        int i=1;
        if(!listaVacia()){
            while (r!=null){
                if(i==1){
                    if(r.getDescripcion().equalsIgnoreCase(s)){
                        System.out.println("entro en el uno");
                        inicio=r.getEnlace();
                        momento = r;
                        numNodos--;
                        return momento;
                    }
                }
                if(i<numNodos){
                    if(r.getDescripcion().equalsIgnoreCase(s)){
                        System.out.println("entro en el dos");
                        momento.setEnlace(r.getEnlace());
                        numNodos--;
                        return r;
                    }
                }
                if(i==numNodos){
                    if(r.getDescripcion().equalsIgnoreCase(s)){
                        System.out.println("entro en el tres");
                        momento.setEnlace(null);
                        numNodos--;
                        return r;
                    }
                }
                momento = r;
                r=r.getEnlace();
                i++;
            }
        }
        return null;
    }

    public String toString() {
        NodoArticulo r = inicio;
        StringBuilder sbuilder = new StringBuilder();
        if (!listaVacia()) {
            while(r!=null){
                sbuilder.append(r.toString()).append("\n\n");
                r = r.getEnlace();
            }
            return sbuilder.toString();
        } else {
            return "No hay artículos en la lista";
        }
    }
}


