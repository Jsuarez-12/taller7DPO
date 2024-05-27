package uniandes.dpoo.taller7.interfaz4;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInferior extends JPanel {
	
	private JTextField player;
	private JTextField plays;

	public PanelInferior() {
		
		JLabel playTag = new JLabel("Jugadas:");
		plays = new JTextField("0");
		JLabel playerTag = new JLabel("Jugador:");
		player = new JTextField();
		//JcheckBox caja = new JcheckBox();
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

	public void resetPlays() 
	{
		// TODO Auto-generated method stub
		plays.setText("0");
	}

	public void updatePlays() 
	{
		Integer actualPlay = Integer.parseInt(plays.getText());
		plays.setText(Integer.toString(actualPlay+1));
	}

	public void updatePlayer(String player) {
		// TODO Auto-generated method stub
		this.player.setText(player);
	}
	
}
