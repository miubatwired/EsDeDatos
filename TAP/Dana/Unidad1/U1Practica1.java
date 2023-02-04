package unidad1;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Arrays;

public class U1Practica1 {
    public static void main(String[] args) {
        Alumno[] alumnos = new Alumno[10];

        String[] opcionesSeleccion = { "Dar de alta alumno", "Mostrar alumnos", "Mostrar alumnos menores de edad",
                "Mostrar alumnos reprobados", "Aumentar puntos", "Alumnos que nacieron en FEB/2002", "Salir" };

        String opcionSeleccionada = "SELECCIONAR";

        while (opcionSeleccionada != opcionesSeleccion[opcionesSeleccion.length - 1]){
            opcionSeleccionada = JOptionPane.showInputDialog(null, "Qué desea hacer?", "Operaciones alumnos",
                    JOptionPane.QUESTION_MESSAGE, null, opcionesSeleccion, "SELECCIONAR").toString();
            switch (opcionSeleccionada){
                case "Dar de alta alumno":
                    int pos = Integer.parseInt(JOptionPane.showInputDialog("¿En qué posición desea ingresar al alumno?"));
                    if(pos>0 && pos<11){
                        if(alumnos[pos]==null){
                            alumnos[pos] = altaAlumno();
                        }else{
                            JOptionPane.showMessageDialog(null, "Esta posición está ocupada");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Esa posición no es válida");
                    }
                    break;
                case "Mostrar alumnos":
                    for(int i=0; i<10; i++){
                        if(alumnos[i]!=null)
                            JOptionPane.showMessageDialog(null, alumnos[i].toString());
                    }
                    break;
                case "Mostrar alumnos menores de edad":
                    for(int i=0; i<10; i++){
                        if(alumnos[i] != null && alumnos[i].getEdad()<18){
                            JOptionPane.showMessageDialog(null, alumnos[i].toString());
                        }
                    }
                    break;
                case "Mostrar alumnos reprobados":
                    StringBuilder reprobados = new StringBuilder();
                    for(int i=0; i<10; i++){
                        if(alumnos[i]!=null && alumnos[i].calculaPromedio()<70){
                            reprobados.append("Nombre: ").append(alumnos[i].getNombre()).append("\nCalificaciones: ").append(Arrays.toString(alumnos[i].getCalif())).append("\n\n");
                        }
                    }
                    if(!reprobados.isEmpty()){
                        JOptionPane.showMessageDialog(null, reprobados.toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "No hay alumnos reprobados");
                    }
                    break;
                case "Aumentar puntos":
                    float cali = 0;
                    float[] vecal = new float[3];
                    boolean encontrado = false;
                    String nombre = JOptionPane.showInputDialog(null, "Escriba el nombre del alumno");
                    for(int i=0; i<10; i++){
                        if(alumnos[i]!=null){
                            if(alumnos[i].getNombre().equals(nombre)){
                                encontrado = true;
                                for(int j=0; j<3; j++){
                                    cali = alumnos[i].getCalif()[j] + 5;
                                    if(cali>100){
                                        vecal[j] = 100f;
                                    }else{
                                        vecal[j] = cali;
                                    }
                                }
                                alumnos[i].setCalif(vecal);
                            }
                        }
                    }
                    if(!encontrado){
                        JOptionPane.showMessageDialog(null,"No se encontró el alumno");
                    }
                    break;
                case "Alumnos que nacieron en FEB/2002":
                    StringBuilder s = new StringBuilder();
                    for(int i=0; i<10; i++){
                        if(alumnos[i]!=null){
                            if(alumnos[i].getFechaNac().getMes()==2 && alumnos[i].getFechaNac().getAño()==2002){
                                s.append(alumnos[i].toString()).append("\n\n");
                            }
                        }
                    }
                    if(!s.isEmpty()){
                        JOptionPane.showMessageDialog(null, s.toString());
                    }
                    break;
            }
        }
    }


    private static Alumno altaAlumno() {

        Alumno nuevoAlumno = new Alumno();

        JLabel labelNombre = new JLabel("Nombre:");
        JLabel labelNumeroControl = new JLabel("Número de control:");
        JLabel labelCalificaciones = new JLabel("Calificaciones:");
        JTextField tfNombre = new JTextField();
        JTextField tfNumeroControl = new JTextField();
        JTextField tfCalificacion1 = new JTextField();
        JTextField tfCalificacion2 = new JTextField();
        JTextField tfCalificacion3 = new JTextField();

        Object[] componentesFormularioDatosPersonales = { labelNombre, tfNombre, labelNumeroControl, tfNumeroControl,
                labelCalificaciones, tfCalificacion1, tfCalificacion2, tfCalificacion3 };

        JOptionPane.showMessageDialog(null, componentesFormularioDatosPersonales, "Datos personales",
                JOptionPane.QUESTION_MESSAGE, null);

        float[] calificacionesNAlumno = { Float.parseFloat(tfCalificacion1.getText()),
                Float.parseFloat(tfCalificacion2.getText()), Float.parseFloat(tfCalificacion3.getText()) };

        JLabel labelDia = new JLabel("Dia:");
        JLabel labelMes = new JLabel("Mes:");
        JLabel labelAnio = new JLabel("Año:");
        JTextField tfDia = new JTextField();
        JTextField tfMes = new JTextField();
        JTextField tfAnio = new JTextField();

        Object[] componentesFormularioFechaNac = { labelDia, tfDia, labelMes, tfMes, labelAnio, tfAnio };

        JOptionPane.showMessageDialog(null, componentesFormularioFechaNac, "Fecha de nacimiento",
                JOptionPane.QUESTION_MESSAGE, null);

        int alumnoDiaN = Integer.parseInt(tfDia.getText());
        int alumnoMesN = Integer.parseInt(tfMes.getText());
        int alumnoAnioN = Integer.parseInt(tfAnio.getText());
        Fecha fechaNacimientoNuevoAlumno = new Fecha(alumnoDiaN, alumnoMesN, alumnoAnioN);

        nuevoAlumno.setNombre(tfNombre.getText());
        nuevoAlumno.setNumControl(Integer.parseInt(tfNumeroControl.getText()));
        nuevoAlumno.setCalif(calificacionesNAlumno);
        nuevoAlumno.setFechaNac(fechaNacimientoNuevoAlumno);
        nuevoAlumno.calcularEdad();

        tfNombre.setText("");
        tfNumeroControl.setText("");
        tfCalificacion1.setText("");
        tfCalificacion2.setText("");
        tfCalificacion3.setText("");
        tfDia.setText("");
        tfMes.setText("");
        tfAnio.setText("");

        return nuevoAlumno;

    }
}
