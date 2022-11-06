import javax.swing.*;

public class app {
    public static void main(String[] args) {
        ListaArticulos lista = new ListaArticulos();
        String menu = """
                      1. Insertar un articulo al inicio
                      2. Insertar un articulo al final
                      3. Mostar lista de articulos
                      4. Inventario total
                      5. Eliminar el PRIMER articulo
                      6. Articulos que cuestan menos de $25
                      7. Aumentar precio de articulos
                      8. Buscar articulo por descripcion
                      9. Terminar
                      """;
        String desc; int cantidad; float precio;
        int opc = 0;
        while(opc != 9){
            opc = Integer.parseInt(JOptionPane.showInputDialog(null,menu));
            if(opc != 9){
                switch (opc) {
                    case 1 -> {
                        desc = JOptionPane.showInputDialog(null, "Descripcion del articulo a insertar");
                        cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de articulos"));
                        precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Precio del articulo"));
                        lista.insertaInicio(new NodoArticulos(desc, precio, cantidad));
                    }
                    case 2 -> {
                        desc = JOptionPane.showInputDialog(null, "Descripcion del articulo a insertar");
                        cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de articulos"));
                        precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Precio del articulo"));
                        lista.insertarFinal(new NodoArticulos(desc, precio, cantidad));
                    }
                    case 3 -> JOptionPane.showMessageDialog(null,lista.toString());
                    case 4 -> JOptionPane.showMessageDialog(null,"El inventario total es de: " + lista.mostrarInventario());
                    case 5 -> JOptionPane.showMessageDialog(null,lista.eliminarPrimero().toString());
                    case 6 -> JOptionPane.showMessageDialog(null,"Articulos con precio menor a 25: \n" + lista.mostrarDescripcion());
                    case 7 -> {
                        float per = Integer.parseInt(JOptionPane.showInputDialog(null,"Porcentaje a aumentar"));
                        System.out.println(per);
                        lista.aumentarPrecios((per/100) + 1);
                    }
                    case 8 -> {
                        desc = JOptionPane.showInputDialog(null,"Descripcion a buscar");
                        if(lista.buscarDescripcion(desc))
                            JOptionPane.showMessageDialog(null,"SI EXISTE EL ARTICULO");
                        else
                            JOptionPane.showMessageDialog(null,"NO EXISTE EL ARTICULO");
                    }
                }
            }
        }
    }
}
