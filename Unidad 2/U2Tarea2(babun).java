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
        int pri;
        for(int i=0; i<infijo.length(); i++){
            switch (prioridad(infijo.charAt(i))){
                case 1:
                    if(infijo.charAt(i)=='('){
                        pilaOp.insertar(infijo.charAt(i));
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
                        pilaOp.insertar(infijo.charAt(i));
                    }else {
                        while (prioridad(infijo.charAt(i)) <= prioridad(pilaOp.datoEnTope())) {
                            postfijo += pilaOp.eliminar();
                        }
                        pilaOp.insertar(infijo.charAt(i));
                    }
                    break;
                case 5:
                    postfijo += infijo.charAt(i);
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
