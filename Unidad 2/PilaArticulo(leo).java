import javax.swing.*;

public class PilaArticulos {

    private Articulo p[ ];
    private int tope;

    public PilaArticulos ( ) {
        p = new Articulo [5];
        tope = -1;
    }

    public PilaArticulos (int n) {
        p=new Articulo [n];
        tope = -1;
    }

    public Articulo [ ] getP ( ) {
        return p;
    }

    public int getTope ( ) {
        return tope;
    }
    
    public void setP ( Articulo [ ] nuevoP ) {
        p = nuevoP;
    }

    public void setTope ( int nuevoTope ) {
        tope = nuevoTope;
    }

    public void insertar (Articulo nuevo ) {
        if ( !estaLlena() ) {
            tope++;
            p[tope] = nuevo;
        }
    }

    public Articulo eliminar ( ) {
        Articulo borrado = null;
        if ( !estaVacia() ) {
            borrado = p[tope];
            p[tope] = null; 
            tope--;
        }
        return borrado; 
    }

    public boolean estaVacia ( ) {
        if( tope == -1)
            return true;
        else
            return false;
    }

    public boolean estaLlena ( ) {
        if ( tope == p.length - 1)
            return true;
        else
            return false;
    }

    public Articulo datoEnTope ( ) {
        if ( !estaVacia() )
            return p[tope];
        else
            return null;
    }
    public int numElementos ( ) {
        return tope+1;
    }

    public String toString() {
        String s="Elementos en la pila:\n";
        int i;
        for( i = tope; i >= 0; i--){
            s += p[i]+"\n";
        }
        s+="Fin de la pila";
        return s;
    }

    public void calcularTotal(){
        float sum = 0;
        for (int i = 0; i <= tope; i++) {
            sum += p[i].getCantidad() * p[i].getPrecio();
        }
        JOptionPane.showMessageDialog(null,"Total inventario: " + sum);
    }
    public void aumentarPrecio(){
        for (int i = 0; i <= tope; i++) {
            p[i].setPrecio(p[i].getPrecio() * 1.08f);
        }
    }
    public void buscarArticulo(String str) {
        for (int i = 0; i <= tope; i++) {
            if (p[i].getDescripcion().equalsIgnoreCase(str)) {
                JOptionPane.showMessageDialog(null, p[i].toString());
            }
        }
    }
    public void buscarMayor(){
        float mayor = p[0].getPrecio();
        int ind = 0;
        for (int i = 0; i <= tope; i++) {
            if (p[i].getPrecio() > mayor) {
                mayor = p[i].getPrecio();
                ind = i;
            }
        }
        JOptionPane.showMessageDialog(null, p[ind]);
    }
    public void menorA5(){
        String s = "Articulos con cantidad menor a 5: \n";
        for (int i = 0; i <= tope; i++) {
            if (p[i].getCantidad() < 5) {
                s += p[i].getDescripcion() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, s);
    }
    public  void eliminarTodo(){
        String s = "Articulos eliminados: \n";
        for (int i = 0; i <= tope; i++) {
            s+= p[i].getDescripcion() + "\n";
            p[i] = null;
        }
        tope = -1;
        JOptionPane.showMessageDialog(null,s);
    }
}
