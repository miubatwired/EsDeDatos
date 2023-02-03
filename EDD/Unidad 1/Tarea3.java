import java.io.*;

<<<<<<< HEAD
public class tarea3 {
=======
public class Tarea3 {
>>>>>>> ca83ab7 (tercer commit)
    public static  void main(String[] args) throws FileNotFoundException, IOException {
        char[][] matrizLetras = new char[][]{{'A', 'H', 'B', 'R'}, {'C', 'O', 'U', 'I'}, {'S', 'T', 'L', 'Q'}, {' ', 'E', 'N', 'Y'}};
        String[][] matrizDirecciones = new String[][]{{"10", "01", "31", "13"}, {"03", "22", "12", "30"}, {"32", "02", "21", "11"}, {"20", "23", "00", "33"}};

        File archivoEntrada = new File("mensaje.txt");
        FileReader lectorArchivo = new FileReader(archivoEntrada);
        BufferedReader buferlectura = new BufferedReader(lectorArchivo);

        String linea ="";
        String descifrado="";
        String num;
        int fila, columna;
        while(linea!=null){
            linea = buferlectura.readLine();
            for(int i = 0;i<linea.length();i=i+2){
                num = matrizDirecciones[linea.charAt(i)][linea.charAt(i+1)];

               descifrado+= matrizLetras[Character.getNumericValue(num.charAt(0))]
                       [Character.getNumericValue(num.charAt(1))];
                //descifrado= matrizLetras[][];
            }
        }
    }
}
