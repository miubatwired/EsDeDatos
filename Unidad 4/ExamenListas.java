package unidad4;
import javax.swing.JOptionPane;
/*
    Nombre: Jorge Alberto Babun Muñoz
 */

public class ExamenListas {
    public static void main(String[] args) {
        String carga;
        float peso;
        ListaCircularVagones tren = new ListaCircularVagones();
        String opciones = """
                1. Agregar Carga
                2. Desenchar vagón
                3. Despliega tren
                4. Salir
                """;
        int opcion = 0;
        while(opcion!=4){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(opciones));
            switch (opcion){
                case 1:
                    carga = JOptionPane.showInputDialog("Teclee la carga ");
                    peso = Float.parseFloat(JOptionPane.showInputDialog("Teclee el peso de la carga"));
                    if(!tren.encontrarPorString(carga, peso)){
                        tren.insertaFinal(new NodoVagon(carga, peso));
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, tren.desengancharInicio());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, tren.toString());
                    break;
            }
        }
    }
}
