package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VentanaPrincipal extends JFrame {

	
	private PanelIzquierdo izquierda;

	public VentanaPrincipal() {
		
		setTitle("Juego de LightsOut");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        
        
        // Configurar el layout del JFrame
        setLayout(new BorderLayout());
        
        // Crear los paneles
        izquierda = new PanelIzquierdo(5);
        PanelDerecho derecha = new PanelDerecho();
        PanelSuperior arriba = new PanelSuperior(this);
        PanelInferior abajo = new PanelInferior();
        //abajo.setPreferredSize(new Dimension(600, 100)); // Ajustar tamaño preferido
        //abajo.setBackground(Color.cyan);
      

        
        // Añadir los paneles al JFrame
        add(izquierda, BorderLayout.CENTER);
        add(derecha, BorderLayout.EAST);
        add(arriba, BorderLayout.NORTH);
        add(abajo, BorderLayout.SOUTH);
        setVisible(true);
		
	}
	
	public void nuevoJuego(int size)
	{
		izquierda.nuevo(size);
	}
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
}



