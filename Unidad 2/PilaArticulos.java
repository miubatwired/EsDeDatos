package unidad2;

public class PilaArticulos {
    private Articulo[] p;
    private int tope;

    PilaArticulos(){
        p = new Articulo[5];
        tope=-1;
    }

    PilaArticulos(int n){
        p = new Articulo[n];
        tope = -1;
    }

    public Articulo[] getP() {
        return p;
    }

    public int getTope() {
        return tope;
    }

    public void setP(Articulo[] p) {
        this.p = p;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public float inventario(){
        float suma = 0;
        for(int i=0; i<=tope; i++)
            suma += p[i].getPrecio() * p[i].getCantidad();
        return suma;
    }

    public void aumentoPrecio(){
        for(int i=0; i<=tope; i++){
            p[i].setPrecio(p[i].getPrecio() * 1.08f);
        }
    }
    public boolean existeArticulo(String descripcion){
        for(int i=0; i<=tope; i++)
            if(descripcion.equalsIgnoreCase(p[i].getDescripcion()))
                return true;
        return false;
    }

    public boolean estaVacia() {
        if(tope==-1)
            return true;
        else
            return false;
    }

    public boolean estaLlena() {
        if(tope==p.length-1)
            return true;
        else
            return false;
    }

    public void insertar(String descripcion, int cantidad, float precio){
        if(!estaLlena()){
            tope++;
            p[tope] = new Articulo(descripcion, cantidad, precio);
        }
    }

    public Articulo eliminar(){
        Articulo borrado=null;
        if(!estaVacia()){
            borrado=p[tope];
            p[tope]=null;
            tope--;
        }
        return borrado;
    }

    public Articulo datoEnTope ( ) {
        if ( !estaVacia() )
            return p[tope];
        else
            return null;
    }

    public int numElementos(){
        return tope+1;
    }

    public String vaciarPila(){
        String s = "Elementos eliminados " + "\n";
        if(!estaVacia()){
            for(int i=tope; i>-1; i--){
                s += p[i].toString() + "\n" + "-----------------" + "\n";
                p[i]=null;
            }
        }
        tope = -1;
        return s;
    }

    public String articuloMasCaro(){
        float mayor = 0;
        String s = "Elemento más caro: ";
        for(int i=tope; i>-1; i--)
            if(p[i].getPrecio() >mayor)
                mayor = p[i].getPrecio();
        for(int i=tope; i>-1; i--)
            if(p[i].getPrecio()==mayor)
                s += p[i].toString() + "\n" + "-----------------" + "\n";
        return s;
    }

    public String cantidadMenorA5(){
        String s = "Artículos con cantidad < 5 " + "\n";
        for(int i=tope; i>-1; i--)
            if(p[i].getCantidad() < 5)
                s+= p[i].getDescripcion() + "\n";
        return s;
    }



    public String toString(){
        String s ="Elementos de la pila: " + "\n";
        if(!estaVacia()){
            for(int i=tope; i>-1; i--){
                s += p[i].toString() + "\n" + "-----------------" + "\n";
            }
        }
        return s;
    }




}
