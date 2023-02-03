import javax.swing.JOptionPane;

public class Practica3 {
	//variables de clase
	public static int m[][],i ,j; /* i y j no son matrices, sólo se declara la matriz */
	
	
	public static void main(String[] args) {
		m = new int[3][10]; /* Crea una matriz rectangular*/
		/* Asignar valores mediante código */
		for(i=0; i<m.length; i++)
			for(j=0; j<m[i].length; j++)
				m[i][j]=10 + i + j;
		//JOptionPane.showMessageDialog(null, Arrays.deepToString(m));
		
		despliega();
		//JOptionPane.showMessageDialog(null, m + "\n\n" + Arrays.toString(m) + "\n\n" + s);
		m = new int[2][2]; // crear matriz cuadrada
		captura();
		despliega();
	}
	
	public static void despliega() {
		String s = "Despliegue matricial" + "\n\n";
		for(i=0; i<m.length; i++) {
			for(j=0; j<m[i].length; j++)
				s+=m[i][j] + "   ";	
			s += "\n";
		}
		JOptionPane.showMessageDialog(null, s);
	}
	
	public static void captura() {
		for(i=0; i<m.length; i++)
			for(j=0; j<m[i].length; j++)
				m[i][j]= Integer.parseInt(JOptionPane.showInputDialog("Valor ["+ i +"]{"+j+"] :"));
	}
}

