package Articulos;

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
                            insetar(ferreteria);
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
                            calcularTotal(ferreteria);
                        }else{
                            JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                        }
                        break;
                    case 5:
                        if(!ferreteria.estaVacia()){
                            aumentarPrecio(ferreteria);
                        }else{
                            JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                        }
                        break;
                    case 6:
                        if(!ferreteria.estaVacia()){
                            descripcion = JOptionPane.showInputDialog(null,"Descripcion a buscar");
                            buscarArticulo(ferreteria, descripcion,"desc");
                        }else{
                            JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                        };
                        break;
                    case 7:
                        if(!ferreteria.estaVacia()){
                            buscarArticulo(ferreteria,null,"mayor");
                        }else{
                            JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                        }
                        break;
                    case 8:
                        if(!ferreteria.estaVacia()){
                            buscarArticulo(ferreteria,"","min5");
                        }else{
                            JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                        }
                        break;
                    case 9:if(!ferreteria.estaVacia()){
                        eliminarTodo(ferreteria);
                    }else{
                        JOptionPane.showMessageDialog(null,"La ferretaria esta vacia!");
                    }
                }
            }
        }

    }

    public static void insetar(PilaArticulos pila){
        descripcion = JOptionPane.showInputDialog(null,"Descripcion del articulo");
        cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Cantidad del articulo"));
        precio = Float.parseFloat(JOptionPane.showInputDialog(null,"Precio del articulo"));
        pila.insertar(new Articulo(descripcion,cantidad,precio));
    }
    public static void calcularTotal(PilaArticulos pila){
        float sum = 0;
        for (int i = 0; i <= pila.getTope(); i++) {
            sum += pila.getP()[i].getCantidad() * pila.getP()[i].getPrecio();
        }
        JOptionPane.showMessageDialog(null,"Total inventario: " + sum);
    }
    public static void aumentarPrecio(PilaArticulos pila){
        for (int i = 0; i <= pila.getTope(); i++) {
            pila.getP()[i].setPrecio(pila.getP()[i].getPrecio() * 1.08f);
        }
    }
    public static void buscarArticulo(PilaArticulos pila, String str, String cond){
        switch (cond) {
            case "desc":
                for (int i = 0; i <= pila.getTope(); i++) {
                    System.out.println(i);
                    if (pila.getP()[i].getDescripcion().equalsIgnoreCase(str)) {
                        JOptionPane.showMessageDialog(null, pila.getP()[i].toString());
                        break;
                    }
                }
                break;
            case "mayor":
                float mayor = pila.getP()[0].getPrecio();
                int ind = 0;
                for (int i = 0; i <= pila.getTope(); i++) {
                    if (pila.getP()[i].getPrecio() > mayor) {
                        mayor = pila.getP()[i].getPrecio();
                        ind = i;
                    }
                }
                JOptionPane.showMessageDialog(null, pila.getP()[ind]);
                break;
            case "min5":
                String s = "Articulos con cantidad menor a 5: \n";
                for (int i = 0; i <= pila.getTope(); i++) {
                    if (pila.getP()[i].getCantidad() < 5) {
                        s += pila.getP()[i].getDescripcion() + "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, s);
                break;
        }
    }
    public static void eliminarTodo(PilaArticulos pila){
        String s = "Articulos eliminados: \n";
        for (int i = 0; i <= pila.getTope(); i++) {
            s+= pila.getP()[i].getDescripcion() + "\n";
            pila.getP()[i] = null;
        }
        pila.setTope(-1);
        JOptionPane.showMessageDialog(null,s);
    }
}
