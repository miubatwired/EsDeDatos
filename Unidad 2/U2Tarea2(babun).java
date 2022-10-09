import javax.swing.JOptionPane;

/*
    Este programa convierte una expresión de infijo a postfijo
 */

public class U2Tarea2 {
    public static void main(String[] args) {
        int opc = 0;
        String infijo;
        String menu = "1) Convertir de infijo a Postfijo \n2) Terminar";
        while(opc!=2){
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
            if(opc==1){
                infijo = JOptionPane.showInputDialog("Escriba la expresión a convertir: ");
                JOptionPane.showMessageDialog(null, "La expresión a convertir: \n" + infijo +
                        "\n\nLa expresión convertida en postfijo es: \n" + convAPostfijo(infijo));
            }
        }
    }

    public static String convAPostfijo(String infijo){
        PilaChar pilaOp = new PilaChar(infijo.length()/2);
        String postfijo = "";
        char op = ' ';
        int pri = 0;
        for(int i=0; i<infijo.length(); i++){
            op = infijo.charAt(i);
            pri = prioridad(op);
            switch (pri){
                case 1:
                    if(op=='('){
                        pilaOp.insertar(op);
                    }else{
                        while(pilaOp.datoEnTope()!='('){
                            postfijo += pilaOp.eliminar();
                        }
                        pilaOp.eliminar();
                    }
                    break;
                case 2:
                case 3:
                case 4:
                    if(pilaOp.estaVacia()){
                        pilaOp.insertar(op);
                    }else {
                        while (pri <= prioridad(pilaOp.datoEnTope())) {
                            postfijo += pilaOp.eliminar();
                        }
                        pilaOp.insertar(op);
                    }
                    break;
                case 5:
                    postfijo += op;
            }
        }
        while(pilaOp.datoEnTope()!=' '){
            postfijo += pilaOp.eliminar();
        }
        return postfijo;
    }
    public static int prioridad(char op){
        String[] operadores = {"  ", "()","+-", "*/","^ "};
        for (int i = 0; i < operadores.length; i++) {
            if(op == operadores[i].charAt(0) || op == (operadores[i].charAt(1))){
                return i;
            }
        }
        return 5;
    }
}
