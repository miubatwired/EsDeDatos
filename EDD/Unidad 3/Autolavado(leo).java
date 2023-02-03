import javax.swing.*;

public class Autolavado {
    static int tipoServicio, cont = 0, caja = 500;
    static ColaCircularAutos lavado = new ColaCircularAutos();
    static ColaCircularAutos aspirado = new ColaCircularAutos();
    static ColaCircularAutos encerado = new ColaCircularAutos();
    static String placa;
    public static void main(String[] args) {
        String menu = """
                1. Registro de un auto\s
                2. Sacar auto del area de lavado\s
                3. Sacar auto del area de aspirado\s
                4. Sacar auto del area de encerado
                5. Mostrar autos en area de lavado\s
                6. Mostrar autos en area de aspirado\s
                7. Mostrar autos en area de encerado\s
                8. Reporte financiero \s
                9. Terminar""";
        int opc = 0;
        while(opc != 9){
            opc = Integer.parseInt(JOptionPane.showInputDialog(null,menu));
            if(opc != 9)
                switch (opc){
                    case 1:
                        registrarAuto();
                        break;
                    case 2:
                        sacarAuto(lavado);
                        break;
                    case 3:
                        if(!aspirado.estaVacia())
                            if(aspirado.getCc()[aspirado.getFrente()].getTipoServicio() == 2){
                                JOptionPane.showMessageDialog(null,aspirado.eliminar().getPlaca() + " ha salido del autolavado");
                            }else if(aspirado.getCc()[aspirado.getFrente()].getTipoServicio() == 4){
                                Automovil e = aspirado.eliminar();
                                JOptionPane.showMessageDialog(null,e.getPlaca() + " ha entrado al area de encerado");
                                encerado.insertar(e);
                            }
                        else
                            JOptionPane.showMessageDialog(null,"NO HAY AUTOS PARA ASIPRAR");
                        break;
                    case 4:
                        if(!encerado.estaVacia())
                            JOptionPane.showMessageDialog(null,encerado.eliminar().getPlaca() + " ha salido del autolavado");
                        break;
                    case 5:
                        mostrarAutos(lavado,"LAVADO");
                        break;
                    case 6:
                        mostrarAutos(aspirado,"ASPIRADO");
                        break;
                    case 7:
                        mostrarAutos(encerado, "ENCERADO");
                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null,"Automoviles que se han lavado hoy: \n" + cont + "\nDinero en la caja: "+ caja);
                        break;
                }
        }
    }
    public static void registrarAuto(){
        if(!lavado.estaLlena()){
            placa = JOptionPane.showInputDialog(null,"Placa del vehiculo a registrar");
            tipoServicio = Integer.parseInt(JOptionPane.showInputDialog(null,"Tipo de servicio"));
            lavado.insertar(new Automovil(placa,tipoServicio));
            caja += getServicio(tipoServicio);
        }else
            JOptionPane.showMessageDialog(null,"El area de lavado esta lleno!");
    }
    public static int getServicio(int servicio){
        return switch (servicio) {
            case 1 -> 85;
            case 2 -> 100;
            case 3 -> 125;
            case 4 -> 150;
            default -> -9999;
        };
    }
    public static void sacarAuto(ColaCircularAutos cola){
        if(!cola.estaVacia()) {
            cont++;
            Automovil e = cola.eliminar();
            switch (e.getTipoServicio()) {
                case 1 ->
                    JOptionPane.showMessageDialog(null, e.getPlaca() + " ha salido del autolavado");
                case 2, 4 -> {
                    JOptionPane.showMessageDialog(null, e.getPlaca() + " ha sido transferido a la area de aspirado");
                    aspirado.insertar(e);
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null, e.getPlaca() + " ha sido transferido a la area de encerado");
                    encerado.insertar(e);
                }
            }
        }
    }
    public static void mostrarAutos(ColaCircularAutos cola, String s){
        if(!cola.estaVacia())
            JOptionPane.showMessageDialog(null,"Autos en el area " + s + ": \n" + cola.toString());
        else
            JOptionPane.showMessageDialog(null,"NO HAY AUTOMOVILES EN EL AREA DE " + s);
    }
}
