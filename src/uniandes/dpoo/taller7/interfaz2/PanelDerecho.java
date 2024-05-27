package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class PanelDerecho extends JPanel{

	private JButton botNuevo;
	private JButton botReiniciar;
	private JButton botT10;
	private JButton botCamJug;
	
	public PanelDerecho() {
		
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

        //botNuevo.addActionListener(this);
        
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
	
}
