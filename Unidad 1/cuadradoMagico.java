import javax.swing.*;

<<<<<<< HEAD
public class cuadromagico {
=======
public class cuadradoMagico {
>>>>>>> ca83ab7 (tercer commit)
    static int[][] prueba1 = {{4,9,2},{3,5,7},{8,1,6}};

    public static void main(String[] args) {
        if(resuelve(prueba1)){
            despliega(prueba1,"Es magico! :D");
        }else{
            despliega(prueba1, "No es magico! D:");
        }
    }
    public static boolean resuelve(int[][] m){
        int sum=0,sumaux=0,length = m.length -1,auxsum = 0;

        for (int i = 0; i < m.length; i++) {
            sum+= m[i][i];
            sumaux += m[i][length--];
        }
        if(sum != sumaux){
            return false;
        }
        sumaux = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                sumaux+=m[i][j];
                auxsum += m[j][i];
            }
            if(sumaux == sum && auxsum == sum){
                sumaux = 0;
                auxsum = 0;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void despliega(int[][]m, String x){
        String mensaje = (x + "\n\n");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                mensaje+= (m[i][j] + " \t ");
            }
            mensaje += "\n";
        }
        JOptionPane.showMessageDialog(null,mensaje);
    }
}
