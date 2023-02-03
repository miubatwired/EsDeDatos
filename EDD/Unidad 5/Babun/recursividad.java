package unidad5;

import javax.swing.*;

public class recursividad {
    public static void main(String[] args) {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog("Valor de n: "));
        System.out.println("La suma desde " + n + "hasta 1 es " + sumaRecursivo(n));
        imprimeParesRecursivo(n);
    }

    public static int sumaRecursivo(int n) {
        if (n == 0) //caso base o terminal (NO RECURSIVO)
            return 0;
        return n + sumaRecursivo(n-1); //llamadarecursiva (repetitva)
    }

    public static void imprimeParesRecursivo(int n){
        if(n==0) //caso base
            return; //devuelve el control del método y termina
        System.out.println(n);
        imprimeParesRecursivo(n-2); //parte recursiva
    }
}
