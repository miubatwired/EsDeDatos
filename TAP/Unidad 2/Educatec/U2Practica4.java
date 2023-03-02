package unidad2;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class U2Practica4 {
    public static void main(String[] args) {
        int x,y;
        int[][] matriz = new int[2][2];
        String[] opciones = {"Generar Matriz", "Despliega Matriz", "Suma de elementos", "Terminar"};
        boolean salir=false;
        while(!salir){
            String respuesta = (String) JOptionPane.showInputDialog(null,"Seleccione una opción","Matrices Recursivas", JOptionPane.QUESTION_MESSAGE, null, opciones, 0);
            switch (respuesta){
                case "Generar Matriz":
                    JLabel labelx = new JLabel("Filas");
                    JTextField tfx = new JTextField();
                    JLabel labely = new JLabel("Columnas");
                    JTextField tfy  =new JTextField();
                    Object[] comp2 = {labelx, tfx, labely, tfy};
                    JOptionPane.showMessageDialog(null, comp2, "Generar Matriz", JOptionPane.QUESTION_MESSAGE, null);
                    x=Integer.parseInt(tfx.getText());
                    y=Integer.parseInt(tfy.getText());
                    matriz = new int[x][y];
                    llenaMatriz(matriz,0,0);
                    break;
                case "Despliega Matriz":
                    JOptionPane.showMessageDialog(null, despliegaMatriz(matriz,0,0));
                    break;
                case "Suma de elementos":
                    JOptionPane.showMessageDialog(null, sumaMatriz(matriz,0,0));
                    break;
                case "Terminar":
                    salir = true;
            }
        }
    }
    public static void llenaMatriz(int [][] m,int fila, int columna){
        if(fila==m.length || columna==m[fila].length){
            return;
        }else{
            m[fila][columna] = 1 + (int) (Math.random()*10);
            llenaMatriz(m, fila, columna+1);
            llenaMatriz(m, fila+1, 0);
        }
    }

    public static String despliegaMatriz(int [][] m,int fila, int columna){
        if(fila==m.length){
            return "";
        }
        if(columna==m[fila].length){
            return "\n" + despliegaMatriz(m, fila+1, 0);
        }else{
            return m[fila][columna] + " " + despliegaMatriz(m, fila, columna+1);
        }
    }

    public static int sumaMatriz(int [][] m,int fila, int columna){
        if(fila==m.length){
            return 0;
        }
        if(columna==m[fila].length){
            return sumaMatriz(m, fila+1, 0);
        }else{
            return m[fila][columna] + sumaMatriz(m, fila, columna+1);
        }
    }

}
