package unidad4;

import javax.swing.JOptionPane;

public class Practica1 {
    public static void main(String[] args) {
        int opcion = 0;
        String descripcion;
        int cantidad;
        float precio;
        ListaArticulos articulos = new ListaArticulos();
        String opciones = """
                1. Insertar un artículo alfabéticamente
                2. Mostrar lista de artículos
                3. Eliminar el último artículo
                4. Eliminar un artículo por descripción
                5. Terminar
                """;
        while(opcion!=5){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(opciones));
            switch(opcion){
                case 1:
                    descripcion = JOptionPane.showInputDialog("Teclee la descripción del artículo");
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Teclee la cantidad de artículos"));
                    precio = Float.parseFloat(JOptionPane.showInputDialog("Teclee el precio del artículo"));
                    articulos.insertaAlfabetico(new NodoArticulo(descripcion, cantidad, precio));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, articulos.toString());
                    break;
                case 3:
                    articulos.eliminaUltimo();
                    break;
                case 4:
                    String desc = JOptionPane.showInputDialog("Teclee la descripción del objeto a eliminar");
                    JOptionPane.showMessageDialog(null, articulos.eliminarPorDescripcion(desc).toString());
                    break;
            }
        }
    }
}
