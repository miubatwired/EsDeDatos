package unidad3;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class U3Tarea2 {
    public static void main(String[] args) {
        String[] opciones = {"Ascendente", "Descendente", "Alfabéticamente", "Terminar"};
        boolean salir = false;
        int[] vector;
        while(!salir){
            String respuesta = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Binary Insertion Sort", JOptionPane.QUESTION_MESSAGE, null, opciones, 0);
            switch (respuesta){
                case "Ascendente":
                    vector = crearVector();
                    JOptionPane.showMessageDialog(null, "Vector desordenado: " + Arrays.toString(vector));
                    insercionBinariaAsc(vector);
                    JOptionPane.showMessageDialog(null, "Vector ordenado: " + Arrays.toString(vector));
                    break;
                case "Descendente":
                    vector = crearVector();
                    JOptionPane.showMessageDialog(null, "Vector desordenado: " + Arrays.toString(vector));
                    insercionBinariaDesc(vector);
                    JOptionPane.showMessageDialog(null, "Vector ordenado: " + Arrays.toString(vector));
                    break;
                case "Alfabéticamente":
                    String[] palabras = new String[10];
                    for(int i = 0; i<palabras.length; i++){
                        palabras[i] = JOptionPane.showInputDialog("Escriba la palabra" + i);
                    }
                    JOptionPane.showMessageDialog(null, "Vector desordenado: " + Arrays.toString(palabras));
                    insercionBinariaAscString(palabras);
                    JOptionPane.showMessageDialog(null, "Vector ordenado: " + Arrays.toString(palabras));
                    break;
                case "Terminar":
                    salir = true;
                    break;
            }
        }
    }

    public static int[] crearVector(){
        int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Escriba el tamaño del vector: "));
        int[] vector = new int[tamaño];
        Random random = new Random();
        for(int i=0; i<vector.length; i++){
            vector[i] = random.nextInt(1,100);
        }
        return vector;
    }
    public static void insercionBinariaAsc(int[] x){
        int i, j, izq, der, mitad, temp;
        int comparaciones = 0;
        int recorrimientos = 0;
        for(i= 1; i < x.length; i++){
            temp = x[i];
            izq = 0;
            der = i - 1;
            while(izq<=der){
                mitad = ((izq + der)/2);
                if(temp <= x[mitad]){
                    der = mitad - 1;
                }else{
                    izq = mitad + 1;
                }
                comparaciones++;
            }
            j =i - 1;
            while(j>=izq){
                x[j+1]=x[j];
                j = j-1;
                recorrimientos++;
            }
            x[izq] = temp;
        }
        JOptionPane.showMessageDialog(null, "Comparaciones: " + comparaciones + "\nRecorrimientos: " + recorrimientos);
    }

    public static void insercionBinariaDesc(int[] x){
        int i, j, izq, der, mitad, temp;
        int comparaciones = 0;
        int recorrimientos = 0;
        for(i= 1; i < x.length; i++){
            temp = x[i];
            izq = 0;
            der = i - 1;
            while(izq<=der){
                mitad = ((izq + der)/2);
                if(temp >= x[mitad]){
                    der = mitad - 1;
                }else{
                    izq = mitad + 1;
                }
                comparaciones++;
            }
            j =i - 1;
            while(j>=izq){
                x[j+1]=x[j];
                j = j-1;
                recorrimientos++;
            }
            x[izq] = temp;
        }
        JOptionPane.showMessageDialog(null, "Comparaciones: " + comparaciones + "\nRecorrimientos: " + recorrimientos);
    }

    public static void insercionBinariaAscString(String[] x){
        int i, j, izq, der, mitad;
        int comparaciones = 0;
        int recorrimientos = 0;
        String temp;
        for(i= 1; i < x.length; i++){
            temp = x[i];
            izq = 0;
            der = i - 1;
            while(izq<=der){
                mitad = ((izq + der)/2);
                if(temp.compareToIgnoreCase(x[mitad])<=0){
                    der = mitad - 1;
                }else{
                    izq = mitad + 1;
                }
                comparaciones++;
            }
            j =i - 1;
            while(j>=izq){
                x[j+1]=x[j];
                j = j-1;
                recorrimientos++;
            }
            x[izq] = temp;
        }
        JOptionPane.showMessageDialog(null, "Comparaciones: " + comparaciones + "\nRecorrimientos: " + recorrimientos);
    }
}
