package practica2unidad1;

public class ExcepcionPosicionOcupada extends Exception {
	private static final long serialVersionUID = 3510737393934682272L;

	public ExcepcionPosicionOcupada(String mensajeError) {
		super(mensajeError);
	}
}
