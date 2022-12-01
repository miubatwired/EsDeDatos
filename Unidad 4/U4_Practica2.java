package unidad4;

import javax.swing.*;
import java.util.Random;

public class U4_Practica2 {
    public static void main(String[] args) {
        int n = 4;
        ListaCircular lis = new ListaCircular();
        String nombre;
        for(int i=0; i<=n; i++){
            nombre = JOptionPane.showInputDialog(null, "Escriba el nombre");
            lis.insertaFinal(new Nodo(nombre));
        }
        lis.centurion();
    }
}
