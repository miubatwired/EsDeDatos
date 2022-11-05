package unidad4;

import javax.swing.JOptionPane;

public class U4Tarea1 {
    public static void main(String[] args) {
        int opcion = 0;
        String descripcion;
        int cantidad;
        float precio;
        ListaArticulos abarrotes = new ListaArticulos();
        String opciones = """
                              OPCIONES
                1. Insertar un artículo al inicio
                2. Insertar un artículo al final
                3. Mostrar lista de artículos
                4. Inventario total
                5. Eliminar el PRIMER artículo
                6. Artículos que cuestan menos de $ 25.00
                7. Aumentar precio de artículos
                8. Buscar artículo por descripción
                9. Salir
                """;
        while(opcion!=9){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(opciones));
            switch(opcion){
                case 1:
                    descripcion = JOptionPane.showInputDialog("Teclee la descripción del artículo");
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Teclee la cantidad de artículos"));
                    precio = Float.parseFloat(JOptionPane.showInputDialog("Teclee el precio del artículo"));
                    abarrotes.insertaInicio(new NodoArticulo(descripcion, cantidad, precio));
                    break;
                case 2:
                    descripcion = JOptionPane.showInputDialog("Teclee la descripción del artículo");
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Teclee la cantidad de artículos"));
                    precio = Float.parseFloat(JOptionPane.showInputDialog("Teclee el precio del artículo"));
                    abarrotes.insertarFinal(new NodoArticulo(descripcion, cantidad, precio));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, abarrotes.toString());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Inventario total: " + abarrotes.inventarioTotal());
                    break;
                case 5:
                    NodoArticulo eliminado = abarrotes.eliminaInicio();
                    if(eliminado!=null){
                        JOptionPane.showMessageDialog(null, "Datos del objeto eliminado \n" + eliminado.toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "No hay objetos en la lista");
                    }
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, abarrotes.precioMenor());
                    break;
                case 7:
                    float porcentaje = Float.parseFloat(JOptionPane.showInputDialog("¿En qué porcentaje desea aumentar el precio?"));
                    abarrotes.aumentarPorcentaje(porcentaje);
                    break;
                case 8:
                    descripcion = JOptionPane.showInputDialog("Escriba la descripción del artículo a buscar");
                    JOptionPane.showMessageDialog(null, abarrotes.buscarArticulo(descripcion));
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
}
