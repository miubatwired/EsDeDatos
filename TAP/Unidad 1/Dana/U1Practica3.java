package unidad1;

import javax.swing.*;
import java.awt.*;

public class U1Practica3 {
    public static void main(String[] args) {
        Disco[] discos = {new Disco("Ok Computer", new Fecha(21,5,1997), new String[]{"Airbag", "Paranoid Android", "Subterranean Homesick Alien", "Exit Music (For A Film)", "Let Down", "Karma Police",
            "Fitter Happier", "Electioneering", "Climbing up the Walls", "No Surprises", "Lucky", "The Tourist"}), new Disco("Ambient 1: Music for Airports",new Fecha(1,3,1978),new String[]{"1/1", "2/1", "1/2","2/2"})
            , new Disco("F# A# ∞", new Fecha(14,8,1997), new String[]{"The Dead Flag Blues", "East Hastings", "Providence"}),
            new Disco("The Head On The Door", new Fecha(1,1,1985), new String[]{"In Between Days", "Kyoto Song", "The Blood", "Six Different Ways", "Push", "The Baby Screams", "Close To Me", "A Night Like This", "Screw", "Sinking"})};
        String[] opciones = {"Mostrar discos", "Discos lanzados en mm/aaaa", "Buscar una canción", "Terminar"};
        String opcion = "SELECCIONAR";
        //ImageIcon icon = new ImageIcon("/home/manzana/Documentos/TEC/Semestre 4/TAP/Programas/src/unidad1/icons/a.jpg");
        boolean salir = false;
        while(!salir){
            opcion = JOptionPane.showInputDialog(null, "Qué desea hacer?", "Operaciones alumnos",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "SELECCIONAR").toString();
            switch (opcion){
                case "Mostrar discos":
                    for (Disco disco : discos) {
                        JOptionPane.showMessageDialog(null, disco.toString());
                    }
                    break;
                case "Discos lanzados en mm/aaaa":
                    JLabel labelMes = new JLabel("Mes");
                    JLabel labelAño = new JLabel("Año");
                    JTextField tfMes = new JTextField();
                    JTextField tfAño = new JTextField();

                    Object[] comp = {labelMes, tfMes, labelAño, tfAño};
                    JOptionPane.showMessageDialog(null, comp, "Inserte mes y año", JOptionPane.QUESTION_MESSAGE, null);

                    int mes = Integer.parseInt(tfMes.getText());
                    int año = Integer.parseInt(tfAño.getText());
                    for (Disco disco : discos) {
                        if (disco.getFechaLanzamineto().getMes() == mes && disco.getFechaLanzamineto().getAño() == año) {
                            JOptionPane.showMessageDialog(null, disco.toString());
                        }
                    }
                    break;
                case "Buscar una canción":
                    String titulo = JOptionPane.showInputDialog("Escriba el nombre del álbum a buscar");
                    boolean encontro = false;
                    int i=0;
                    while (!encontro && i< discos.length) {
                        for(int j=0; j<discos[i].getCanciones().length; j++){
                            if(discos[i].getCanciones()[j].equalsIgnoreCase(titulo)){
                                JOptionPane.showMessageDialog(null, "Se encontró en el disco " + discos[i].getTitulo() + " que está en la posición " + i);
                                encontro = true;
                            }
                        }
                        i++;
                    }
                    if(!encontro){
                        JOptionPane.showMessageDialog(null, "No se encontró la canción");
                    }
                    break;
                case "Terminar":
                    salir = true;
            }
        }
    }
}
