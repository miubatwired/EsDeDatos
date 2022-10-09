import javax.swing.*;
/*
    Este programa convierte una expresión de infijo a postfijo
 */

public class U2Tarea2 {
    public static void main(String[] args) throws InterruptedException {
        int opc = 0;
        String menu = "1) Convertir de infijo a Postfijo \n2) Terminar";
        while(opc != 2){
            opc = Integer.parseInt(JOptionPane.showInputDialog(null,menu));
            if(opc !=2){
                String op = JOptionPane.showInputDialog(null,"Ingresa la operacion");
                JOptionPane.showMessageDialog(null,convertirExpresion(op));
            }
        }
    }

    public static int prioridad(char op){
        String[] operadores = {"+-","*/","^ ","()"};
        for (int i = 0; i < operadores.length; i++)
            if(op == operadores[i].charAt(0) || op == (operadores[i].charAt(1)))
                return i+1;
        return 0;
    }

    public static String convertirExpresion(String op){
        boolean entro = false;
        String res = "";
        PilaChar pila = new PilaChar(op.length());
        char c;
        for (int i = 0; i < op.length(); i++) {
            c = op.charAt(i);
            switch (prioridad(c)){
                case 0:
                    res+= c;
                    break;
                case 1:
                case 2:
                case 3:
                    if(!pila.estaVacia()){
                        while(true)
                            if(prioridad(c) <= prioridad(pila.datoEnTope()) && !entro){
                                res+= pila.datoEnTope();
                                pila.eliminar();
                            }else{
                                pila.insertar(c);
                                break;
                            }
                    }else
                        pila.insertar(c);
                    break;
                case 4:
                    if(!pila.estaVacia()){
                        if(c == '('){
                            entro = true;
                            pila.insertar(c);
                        }else if(c == ')'){
                            while(true){
                                if(pila.datoEnTope() != '('){
                                    res+=pila.eliminar();
                                }else{
                                    pila.eliminar();
                                    entro = true;
                                    break;
                                }
                            }
                        }
                    }else if (c == '('){
                        pila.insertar(c);
                        entro = true;
                    }
                    break;
            }
        }
        while(!pila.estaVacia())
            res+= pila.eliminar();
        return res;
    }
}
