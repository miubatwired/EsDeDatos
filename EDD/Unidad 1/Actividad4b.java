import javax.swing.JOptionPane;

public class Actividad4b {
        static int i, n, j, maximo;
        
        public static void main(String[] args){
                n=5;
                medotoA(n);
                metodoB(n);
        }

        public static void medotoA(int n){
                int[][] m = new int[n][n];
                int cont=1;
                j =0;
                for( i=0; i<m.length; i++){
                        for(j =0; j <m[i].length; j++){
                                m[i][j] = cont;
                                cont++;
                        }
                        i++;
                        if(i!=n){
                                for(j =(m[i].length-1); j >=0; j--){
                                        m[i][j] = cont++;
                                }
                        }
                }
                despliega(m, "Método A");
        }


        public static void metodoB (int n){
                int[][] m = new int[n][n];
                int cont = 1;
                int posFilas = 0, posInicial =1, posColumnas = 1;
                maximo =n;
                for(int i=0; i<m.length; i++) {
                        m[i][i] = cont;
                        cont++;
                }
                for(int i=0; i<m.length; i++){
                        posFilas =0;
                                while (posColumnas <n && posFilas < maximo -1){
                                        m[posFilas][posColumnas] = cont;
                                        cont++;
                                        posColumnas++;
                                        posFilas++;
                        }
                                posInicial +=1;
                                posColumnas = posInicial;
                                maximo--;
                }
                despliega( m, "Método B");
        }

        public static void despliega(int[][] m, String titulo){
                String s = titulo + " \n\n";
                for (int i = 0; i < m.length ; i++){
                        for (int j = 0; j < m[i].length; j++) {
                                s+= m[i][j] + ",";
                        }
                        s+= "\n";
                }
                JOptionPane.showMessageDialog(null,s);
        }
}
