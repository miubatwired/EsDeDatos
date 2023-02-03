package unidad1;
import javax.swing.*;
import java.util.Arrays;

public class U1Practica1 {
    public static void main(String[] args) {
        hola();
        Alumno[] alumnos = new Alumno[10];
        String menu = """
                                OPCIONES
                1. Alta de un alumno
                2. Mostrar alumnos
                3. Alumnos menores de edad
                4. Alumnos con promedio reprobado
                5. Aumentar puntos
                6. Alumnos que nacieron en FEB/2002
                7. Salir
                """;
        String nombre;
        int edad, numControl, pos, dia, mes, año;
        boolean control = true;
        float[] calificaciones;
        float calif;
        int opcion = 0;
        while(control){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opcion){
                case 1:
                    pos = Integer.parseInt(JOptionPane.showInputDialog("¿En qué posición desea insertar al alumno?"));
                    if(pos>0 && pos<11){
                        if(alumnos[pos-1]==null){
                            calificaciones = new float[3];
                            nombre = JOptionPane.showInputDialog("Escriba el nombre del alumno");
                            edad = Integer.parseInt(JOptionPane.showInputDialog("Escriba la edad del alumno"));
                            numControl = Integer.parseInt(JOptionPane.showInputDialog("Escriba el número de control del alumno"));
                            for(int i=0; i<3; i++){
                                calificaciones[i] = Float.parseFloat(JOptionPane.showInputDialog("Escriba la " + i + " califación"));
                            }
                            dia = Integer.parseInt(JOptionPane.showInputDialog("Escriba el día de la fecha de nacimiento"));
                            mes = Integer.parseInt(JOptionPane.showInputDialog("Escriba el mes de la fecha de nacimiento"));
                            año = Integer.parseInt(JOptionPane.showInputDialog("Escriba el año de la fecha de nacimiento"));
                            alumnos[pos-1] = new Alumno(nombre, edad, numControl, calificaciones, new Fecha(dia, mes, año));
                        }else{
                            JOptionPane.showMessageDialog(null, "Esa posición está ocupada");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Esta posición no es válida");
                    }
                    break;
                case 2:
                    for(int i=0; i<10; i++){
                        if(alumnos[i]!=null)
                            JOptionPane.showMessageDialog(null, alumnos[i].toString());
                    }
                    break;
                case 3:
                    for(int i=0; i<10; i++){
                        if(alumnos[i] != null && alumnos[i].getEdad()<18){
                            JOptionPane.showMessageDialog(null, alumnos[i].toString());
                        }
                    }
                    break;
                case 4:
                    StringBuilder reprobados = new StringBuilder();
                    for(int i=0; i<10; i++){
                        if(alumnos[i]!=null && alumnos[i].calculaPromedio()<70){
                            reprobados.append("Nombre: ").append(alumnos[i].getNombre()).append("\nCalificaciones: ").append(Arrays.toString(alumnos[i].getCalif())).append("\n\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, reprobados.toString());
                    break;
                case 5:
                    float cali = 0;
                    float[] vecal = new float[3];
                    nombre = JOptionPane.showInputDialog(null, "Escriba el nombre del alumno");
                    for(int i=0; i<10; i++){
                        if(alumnos[i]!=null){
                            if(alumnos[i].getNombre().equals(nombre)){
                                for(int j=0; j<3; j++){
                                    cali = alumnos[i].getCalif()[j] + 5;
                                    if(cali>100){
                                        vecal[j] = 100f;
                                    }else{
                                        vecal[j] = cali;
                                    }
                                }

                            }
                            alumnos[i].setCalif(vecal);
                        }
                    }
                    break;
                case 6:
                    String s = "";
                    for(int i=0; i<10; i++){
                        if(alumnos[i]!=null){
                            if(alumnos[i].getFechaNac().getMes()==2 && alumnos[i].getFechaNac().getAño()==2002){
                                s += alumnos[i].toString() + "\n\n";
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, s);
                    break;
                case 7:
                    control = false;
            }
        }
    }

    public static void hola(){
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }
    }
}
