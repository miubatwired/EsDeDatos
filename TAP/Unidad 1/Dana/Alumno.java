package unidad1;
import java.text.DecimalFormat;

public class Alumno {
    private String nombre;
    private int edad;
    private int numControl;
    private float[] calif;
    private Fecha fechaNac;

    public Alumno() {

    }

    public Alumno(String nombre, int edad, int numControl, float[] calif, Fecha fecha) {
        this.nombre = nombre;
        this.edad = edad;
        this.numControl = numControl;
        this.calif = calif;
        this.fechaNac = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getNumControl() {
        return numControl;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public float[] getCalif() {
        return calif;
    }

    public void setCalif(float[] calif) {
        this.calif = calif;
    }

    public float calculaPromedio(){
        float promedio = 0;
        for(int i=0; i<3; i++){
            promedio += calif[i];
        }
        return promedio/3;
    }

    public void calcularEdad(){
        Fecha fecha2 =new Fecha(2,2,2023);
        if( fechaNac.getMes()<=fecha2.getMes()) {
            if (fechaNac.getDia()<fecha2.getDia() ){
                edad = (fechaNac.getAño() - fecha2.getAño()) * -1;
            }else
                edad = (((fechaNac.getAño() - fecha2.getAño()) * -1) - 1);
        } else {
            this.edad = (((fechaNac.getAño() - fecha2.getAño()) * -1) - 1);
        }
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("###.##");
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nnum Control: " + numControl + "\nCalifiaciones: "
                + calif[0] + ", " + calif[1] + ", " + calif[2] + "\nPromedio: " + df.format(calculaPromedio()) + "\nFecha de nacimiento: "
                + fechaNac.toString();
    }
}
