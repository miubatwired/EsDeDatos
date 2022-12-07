package unidad5;

/**
 * Nombre: Jorge Alberto Babun Muñoz
 */

import javax.swing.JOptionPane;

public class ExamenArboles {
    public static void main(String[] args){
        String[] opciones = {"Insertar un alumno", "Recorrido POSTORDEN", "Aumentar 5 puntos", "Alumnos reprobados", "Eliminar un alumno", "Salir"};
        String opcion;
        ArbolAlumnos alumnos = new ArbolAlumnos();
        float calif;
        String nombre;
        boolean control = true;
        while(control){
            opcion = (String)JOptionPane.showInputDialog(null, "Escoja una opción", "Menú", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch(opcion){
                case "Insertar un alumno":
                    nombre = JOptionPane.showInputDialog("Escriba el nombre del alumno");
                    calif = Float.parseFloat(JOptionPane.showInputDialog("Escriba su calificación"));
                    alumnos.insertarNodo(new NodoAlumno(nombre, calif));
                    break;
                case "Recorrido POSTORDEN":
                    JOptionPane.showMessageDialog(null, alumnos.postorden(alumnos.getRaiz()));
                    break;
                case "Aumentar 5 puntos":
                    alumnos.aumentarPuntos(alumnos.getRaiz());
                    break;
                case "Alumnos reprobados":
                    String s = "";
                    JOptionPane.showMessageDialog(null, alumnos.reprobados(alumnos.getRaiz(),s));
                    break;
                case "Eliminar un alumno":
                    nombre = JOptionPane.showInputDialog("Escriba el nombre del alumno a eliminar");
                    alumnos.setRaiz(alumnos.eliminar(alumnos.getRaiz(), nombre));
                    break;
                case "Salir":
                    control = false;
            }
        }
    }
}
