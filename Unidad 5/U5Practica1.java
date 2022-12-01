package unidad5;

import javax.swing.JOptionPane;

public class U5Practica1 {
    public static void main(String[] args) {
        ArbolBinarioArticulos tree = new ArbolBinarioArticulos();
        String opciones = """
                 1. Insertar un artículo 
                2. Recorrido inorden
                3. Recorrido preorden
                4. Inventario total
                5. Aumentar precio
                6. Devuelve string datos
                7. Buscar artículo
                8. Terminar
                """;
        int opcion = 0;
        while (opcion != 8) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(opciones));
            switch (opcion) {
                case 1:
                    String descripcion = JOptionPane.showInputDialog("Escriba la descripción del artículoi");
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Escriba la cantidad del artículo"));
                    float precio = Float.parseFloat(JOptionPane.showInputDialog("Escriba el precio del artículo"));
                    tree.insertarNodo(new NodoArticuloArbolBin(descripcion, cantidad, precio));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, tree.inorden(tree.getRaiz()));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, tree.preorden(tree.getRaiz()));
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, tree.getInventarioTotal(tree.getRaiz()));
                    break;
                case 5:
                    tree.aumentarPrecio(tree.getRaiz());
                    break;
                case 6:
                    if(!tree.estaVacio()){
                        JOptionPane.showMessageDialog(null, tree.articulosHojas(tree.getRaiz()));

                    }else{
                        JOptionPane.showMessageDialog(null, "El árbol está vacío");
                    }
                    break;
                case 7:
                    String articulo = JOptionPane.showInputDialog("Nombre del artíuclo");
                    if(tree.buscaArticulo(tree.getRaiz(), articulo)){
                        JOptionPane.showMessageDialog(null, "sí");
                    }else{
                        JOptionPane.showMessageDialog(null, "No");
                    }
                    break;
            }
        }
    }
}
