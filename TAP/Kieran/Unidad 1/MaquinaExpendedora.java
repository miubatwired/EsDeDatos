package practica6u1;

import java.util.Arrays;

public class MaquinaExpendedora {

	private float caja;
	private Snack[][] snacks;

	public MaquinaExpendedora(float caja, Snack[][] snacks) {
		super();
		this.caja = caja;
		this.snacks = snacks;
	}

	public float getCaja() {
		return caja;
	}

	public void setCaja(float caja) {
		this.caja = caja;
	}

	public void aumentarCaja(float ingreso) {
		setCaja(getCaja() + ingreso);
	}

	public void disminuirCaja(float egreso) {
		setCaja(getCaja() - egreso);
	}

	public Snack[][] getSnacks() {
		return snacks;
	}

	public void setSnacks(Snack[][] snacks) {
		this.snacks = snacks;
	}

	@Override
	public String toString() {
		return "MaquinaExpendedora [caja=" + caja + ", snacks=" + Arrays.toString(snacks) + "]";
	}

}
