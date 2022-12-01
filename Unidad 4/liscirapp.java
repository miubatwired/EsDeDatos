package unidad4;

import javax.swing.*;

public class liscirapp {
    public static void main(String[] args) {
        ListaCircularDos lis = new ListaCircularDos();
        String dato1;
        float dato2;
        String opciones = """
                1. Insertar Inicio
                2. Insertar Final
                3. Mostrar elementos
                4. Eliminar
                5. Terminar
                """;
        int opc=0;
        while(opc!=5){
            opc = Integer.parseInt(JOptionPane.showInputDialog(opciones));
            switch (opc) {
                case 1 -> {
                    dato1 = JOptionPane.showInputDialog("Dato 1 String");
                    dato2 = Float.parseFloat(JOptionPane.showInputDialog("Dato 2 Float"));
                    NodoDos nodoDos = new NodoDos(dato1, dato2);
                    JOptionPane.showMessageDialog(null, nodoDos.toString());
                    lis.insertaInicio(nodoDos);
                }
                case 2 -> {
                    dato1 = JOptionPane.showInputDialog("Dato 1 String");
                    dato2 = Float.parseFloat(JOptionPane.showInputDialog("Dato 2 Float"));
                    lis.insertaFinal(new NodoDos(dato1, dato2));
                }
                case 3 -> JOptionPane.showMessageDialog(null, lis.toString());
                case 4 -> {
                    String borrar = JOptionPane.showInputDialog(null, "Escriba el string a eliminar");
                    JOptionPane.showMessageDialog(null, lis.eliminaX(borrar));
                }
            }
        }
    }
}