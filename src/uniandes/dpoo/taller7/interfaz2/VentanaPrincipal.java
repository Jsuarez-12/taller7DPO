package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VentanaPrincipal extends JFrame {
   private PanelDerecho derecha;
   private PanelSuperior arriba;
   private PanelInferior abajo;
	
	public VentanaPrincipal() {
		
		setTitle("Juego de LightsOut");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        
        
        // Configurar el layout del JFrame
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.white);
        
        // Crear los paneles
        JPanel izquierda = new JPanel();
        derecha = new PanelDerecho();
        arriba = new PanelSuperior();
        abajo = new PanelInferior();
        //abajo.setPreferredSize(new Dimension(600, 100)); // Ajustar tama�o preferido
        //abajo.setBackground(Color.cyan);
      

        
        // A�adir los paneles al JFrame
        add(izquierda, BorderLayout.CENTER);
        add(derecha, BorderLayout.EAST);
        add(arriba, BorderLayout.NORTH);
        add(abajo, BorderLayout.SOUTH);

        setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
}



