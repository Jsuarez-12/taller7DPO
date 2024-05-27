package uniandes.dpoo.taller7.interfaz3;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInferior extends JPanel {
	
	
	public PanelInferior() {
		
		JLabel playTag = new JLabel("Jugadas:");
		JTextField plays = new JTextField("0");
		JLabel playerTag = new JLabel("Jugador:");
		JTextField player = new JTextField();
		
		plays.setPreferredSize(new Dimension(80,20));
		player.setPreferredSize(new Dimension(80,20));
		plays.setEditable(false);
		player.setEditable(false);
		
		add(playTag);
		add(Box.createRigidArea(new Dimension(25,0)));
		add(plays);
		add(Box.createRigidArea(new Dimension(75,0)));
		add(playerTag);
		add(Box.createRigidArea(new Dimension(25,0)));
		add(player);
	}
	
}
