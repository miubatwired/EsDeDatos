package unidad2;

import javax.swing.*;

public class U2Tarea1 {
    public static void main(String[] args) {
        String descripcion;
        int cantidad;
        float precio;
        PilaArticulos ferreteria = new PilaArticulos(14);
        String opciones = "1. Insertar un artículo" + "\n2. Mostrar pila de artículos" + "\n3. Eliminar un artículo" + "\n4. Mostrar el total del inventario" +
                "\n5. Aumentar precio de todos los artículos" + "\n6. Buscar un artículo" + "\n7. Artículo más caro" +
                "\n8. Artículos con cantidad < 5" + "\n9. Vaciar la pila" + "\n10. Terminar";
        int opc =0;
        while(opc!=10){
            opc=Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch(opc){
                case 1:
                        descripcion = JOptionPane.showInputDialog(null, "Descripción del artículo: ");
                        cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad: "));
                        precio = Integer.parseInt(JOptionPane.showInputDialog("Precio: "));
                        ferreteria.insertar(descripcion, cantidad, precio);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, ferreteria.toString());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Artículo borrado" + "\n" + ferreteria.eliminar());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,"Inventario: " + ferreteria.inventario());
                    break;
                case 5:
                    ferreteria.aumentoPrecio();
                    JOptionPane.showMessageDialog(null,"El precio se ha aumentado");
                    break;
                case 6:
                    descripcion = JOptionPane.showInputDialog("Escriba la descripción del artículo a buscar");
                    if(ferreteria.existeArticulo(descripcion))
                        JOptionPane.showMessageDialog(null, "El artículo se encuentra en la pila");
                    else
                        JOptionPane.showMessageDialog(null,"El artículo NO se encuentra en la pila");
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, ferreteria.articuloMasCaro());
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, ferreteria.cantidadMenorA5());
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, ferreteria.vaciarPila());
                    break;
            }
        }

    }
}
