import javax.swing.JOptionPane;

<<<<<<< HEAD
public class Actividad4 {
=======
public class Actividad4{
>>>>>>> ca83ab7 (tercer commit)
    static int i,j,n;

    public static void main(String[] args) throws Exception{
        n = 5;
        metodoB(n);
        n=5;
        medotoA(n);
    }

    public static void medotoA(int n){
        int[][] m = new int[n][n];
        int cont=1;
        j=0;
        String titulo = "Método a";
        for( i=0; i<m.length; i++){
            if(i % 2 == 1){
                for (int j = n-1; j >= 0 ; j--) {
                    m[i][j] = cont++;
                }
            }else{
                for (int j = 0; j < m.length ; j++) {
                    m[i][j] = cont++;
                }
            }

        }
        despliega(m,titulo);
    }
    public static void metodoB (int n){ //Metodo de leo
        int[][] m = new int[n][n];
        int cont = 1,z = 0, aux = 0;
        j = 0;
        int length = m.length;
        while(z < (m.length)){
            for (int i = 0; i < length; i++) {
                m[i][j] = cont++;
                j++;
            }
            aux++;
            z++;
            length = m.length-aux;
            j = m.length - length;
        }
        despliega( m, "Método B");
    }

    public static void despliega(int[][] m, String titulo){
        String s = titulo + " \n\n";
        for (int i = 0; i < m.length ; i++) {
            for (int j = 0; j < m[i].length; j++) {
                s+= m[i][j] + " \t ";
            }
            s+= "\n";
        }
        JOptionPane.showMessageDialog(null,s);
    }
}
