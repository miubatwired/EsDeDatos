public class PilaChar {
    private char p[];
    private int tope;

    public PilaChar() {
        p=new char[5];
        tope = -1;
    }

    public PilaChar(int n) {
        p=new char[n];
        tope=-1;
    }

    public char[] getP() {
        return p;
    }

    public int getTope() {
        return tope;
    }

    public void setP(char[] nuevoP) {
        p = nuevoP;
    }

    public void setTope(int nuevoTope) {
        tope = nuevoTope;
    }

    public void insertar(char nuevo) {
        if(!estaLlena()) {
            tope++;
            p[tope] = nuevo;
        }
    }

    public char eliminar() {
        char borrado=' ';
        if(!estaVacia()) {
            borrado=p[tope];
            p[tope]=' ';
            tope--;
        }
        return borrado;
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

    public char datoEnTope() {
        if(!estaVacia())
            return p[tope];
        else
            return ' ';
    }

    public String vaciar(){
        String s = "";
        for(int i =tope; i>0;i--){
            s+=p[i];
        }
        return s;
    }

    public int numElementos() {
        return tope+1;
    }

    public String toString() {
        String s="Elementos de la pila:\n";
        int i;
        for(i=tope; i>=0; i--) {
            s+=p[i]+"\n";
        }
        s+="Fin de la pila";
        return s;
    }
}
