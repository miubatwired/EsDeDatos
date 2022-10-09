import javax.swing.*;
/*
    Este programa convierte una expresión de infijo a postfijo
    Los comentarios son nomas para puro debug
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
        for (int i = 0; i < operadores.length; i++) {
            if(op == operadores[i].charAt(0) || op == (operadores[i].charAt(1))){
                //A System.out.println(operadores[i].charAt(0));
                return i+1;
            }
        }
        return 0;
    }

    public static String convertirExpresion(String op){
        boolean entro = false;
        String res = "";
        PilaChar pila = new PilaChar(op.length());
        char c;
        for (int i = 0; i < op.length(); i++) {
            c = op.charAt(i);
            /*System.out.println("res: "+ res);
            System.out.println("Caracter que entra al switch: " + c);*/
            //Thread.sleep(2000);
            switch (prioridad(c)){
                case 0:
                    res+= c;
                    //System.out.println(res);
                    break;
                case 1:
                case 2:
                case 3:
                   /* System.out.println("El caracter " + c +" Entro al caso 3");
                    Thread.sleep(2000);*/
                    if(!pila.estaVacia()){
                        //  System.out.println("entro a !pila.estavacia");
                        while(true){
                            //System.out.println("Caracter" + c +" Entro a ciclo");
                            if(prioridad(c) <= prioridad(pila.datoEnTope()) && !entro){
                                // System.out.println("Entro a condicion pricoidad(c) <=");
                                res+= pila.datoEnTope();
                                // System.out.println("Res en if prio = " + res);
                                pila.eliminar();
                            }else{
                                /*Thread.sleep(2000);
                                System.out.println("Entro a else pila.insertar(C)");*/
                                pila.insertar(c);
                                break;
                            }
                        }
                    }else{
                        /*Thread.sleep(2000);
                        System.out.println("Entro a else pila insertar");*/
                        pila.insertar(c);
                    }
                    break;
                case 4:
                    /*System.out.println("Entro a caso 4");
                    Thread.sleep(2000);*/
                    //System.out.println(res);
                    if(!pila.estaVacia()){
                        //System.out.println("Entro a !estaVacia");
                        //Thread.sleep(2000);
                        if(c == '('){
                            /*System.out.println("Entro a if'('");
                            Thread.sleep(2000);*/
                            pila.insertar(c);
                        }else if(c == ')'){
                            /*System.out.println("Entro a elif ')'");
                            Thread.sleep(2000);*/
                            while(true){
                                //System.out.println("Ayuda");
                                if(pila.datoEnTope() != '('){
                                    res+=pila.eliminar();
                                }else{
                                    pila.eliminar();
                                    entro = true;
                                    break;
                                }
                            }
                        }
                    }else{
                        if(c == '('){
                            pila.insertar(c);
                            entro = true;
                        }
                    }
                    break;
            }
        }
        while(!pila.estaVacia()){
            res+= pila.eliminar();
        }
        return res;
    }
}
