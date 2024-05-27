package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	
	public VentanaPrincipal() {
		
		setTitle("Juego de LightsOut");
		setSize(580,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public static void main(String[] args) {
		new VentanaPrincipal();

	}

}
