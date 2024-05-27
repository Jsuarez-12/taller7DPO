package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class PanelDerecho extends JPanel implements ActionListener{

	private JButton botNuevo;
	private JButton botReiniciar;
	private JButton botT10;
	private JButton botCamJug;
	private VentanaPrincipal ventana;
	
	public PanelDerecho(VentanaPrincipal ventana) {
		
		setBackground(new Color(150, 150, 150));
		this.ventana = ventana;
		setOpaque(true);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Component filler1 = Box.createVerticalGlue();
        add(filler1);
		
        botNuevo = new JButton("NUEVO");
        botReiniciar = new JButton("REINICIAR");
        botT10 = new JButton("TOP-10");
        botCamJug = new JButton("CAMBIAR JUGADOR");
        
        Dimension d = new Dimension(170,30);
        botNuevo.setMaximumSize(d);
        botReiniciar.setMaximumSize(d);
        botT10.setMaximumSize(d);
        botCamJug.setMaximumSize(d);
        botNuevo.setPreferredSize(d);
        botReiniciar.setPreferredSize(d);
        botT10.setPreferredSize(d);
        botCamJug.setPreferredSize(d);

        botNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);
        botReiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botT10.setAlignmentX(Component.CENTER_ALIGNMENT);
        botCamJug.setAlignmentX(Component.CENTER_ALIGNMENT);

        //botNuevo.setBackground(Color.decode("#2a89e0"));
        //botReiniciar.setBackground(Color.decode("#2a89e0"));
        //botT10.setBackground(Color.decode("#2a89e0"));
        //botCamJug.setBackground(Color.decode("#2a89e0"));

        botNuevo.addActionListener(this);
        botReiniciar.addActionListener(this);
        botT10.addActionListener(this);
        botCamJug.addActionListener(this);
        
        add(botNuevo);
        add(Box.createRigidArea(new Dimension(0,25)));
        add(botReiniciar);
        add(Box.createRigidArea(new Dimension(0,25)));
        add(botT10);
        add(Box.createRigidArea(new Dimension(0,25)));
        add(botCamJug);
        
        Component filler2 = Box.createVerticalGlue();
        add(filler2);

        //botNuevo.setForeground(Color.WHITE);
        //botT10.setForeground(Color.WHITE);
        //botReiniciar.setForeground(Color.WHITE);
        //botCamJug.setForeground(Color.WHITE);

        setPreferredSize(new Dimension(200, 100));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String action=e.getActionCommand();
		if (action.equals("NUEVO")) {
			int tamanio=ventana.newSize();
			int dificultad=ventana.newDifficulty();
			ventana.newBoard(tamanio,dificultad);
		}
		else if(action.equals("REINICIAR")) {
			ventana.reiniciarTablero();
		}
		else if(action.equals("TOP-10")) {
			ventana.showTop10();
		}
		else {
		    String player = JOptionPane.showInputDialog(null, "Ingresa el nombre del nuevo jugador:");
		    if (player != null) { // Verificar si se ingres� un nombre
		        ventana.actualizarNuevoJugador(player);
		    }
		}
		
	}
	
}
