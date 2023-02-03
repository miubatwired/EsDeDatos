import javax.swing.*;

public class U2Tarea1 {
    static String descripcion = "";
    static int cantidad = 0;
    static float precio = 0;
    public static void main(String[] args) {
        PilaArticulos ferreteria = new PilaArticulos(14);
        String menu = "1. Instertar un articulo \n2. Mostrar pila de articulos \n3. Elimintar un articulo \n" +
                "4. Mostrar el total del inventario \n5. Aumentar el precio de todos los articulos \n6. Buscar un articulo" +
                "\n7. Articulo mas caro \n8. Articulos con cantidad <5 \n9. Vaciar pila \n10. Terminar";
        int opc = 0;
        while(opc != 10){
            opc = Integer.parseInt(JOptionPane.showInputDialog(null,menu));
            if(opc != 10){
                switch(opc){
                    case 1:
                        if(!ferreteria.estaLlena()){
                            descripcion = JOptionPane.showInputDialog(null,"Descripcion del articulo");
                            cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Cantidad del articulo"));
                            precio = Float.parseFloat(JOptionPane.showInputDialog(null,"Precio del articulo"));
                            ferreteria.insertar(new Articulo(descripcion,cantidad,precio));
                        }else{
                            JOptionPane.showMessageDialog(null,"La pila esta llena!");
                        }
                        break;
                    case 2:
                        if(!ferreteria.estaVacia()){
                            JOptionPane.showMessageDialog(null,ferreteria);
                        }else{
                            JOptionPane.showMessageDialog(null,"La pila esta vacia!");
                        }
                        break;
                    case 3:
                        if(!ferreteria.estaVacia()){
                            JOptionPane.showMessageDialog(null,ferreteria.eliminar());
                        }else{
                            JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                        }
                        break;
                    case 4:
                        if(!ferreteria.estaVacia()){
                            ferreteria.calcularTotal();
                        }else{
                            JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                        }
                        break;
                    case 5:
                        if(!ferreteria.estaVacia()){
                            ferreteria.aumentarPrecio();
                        }else{
                            JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                        }
                        break;
                    case 6:
                        if(!ferreteria.estaVacia()){
                            descripcion = JOptionPane.showInputDialog(null,"Descripcion a buscar");
                            ferreteria.buscarArticulo(descripcion);
                        }else{
                            JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                        };
                        break;
                    case 7:
                        if(!ferreteria.estaVacia()){
                            ferreteria.buscarMayor();
                        }else{
                            JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                        }
                        break;
                    case 8:
                        if(!ferreteria.estaVacia()){
                            ferreteria.menorA5();
                        }else{
                            JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                        }
                        break;
                    case 9:
                        if(!ferreteria.estaVacia()){
                        ferreteria.eliminarTodo();
                    }else{
                        JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                    }
                }
            }
        }
    }
}
