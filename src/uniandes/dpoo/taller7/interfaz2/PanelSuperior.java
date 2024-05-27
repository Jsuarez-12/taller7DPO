package uniandes.dpoo.taller7.interfaz2;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSuperior extends JPanel{


	private JLabel sizeTag;
	private JComboBox<String> sizes;
	private JLabel difTag;
	private ButtonGroup BotGroup;

	public PanelSuperior() {
		
		
		sizeTag = new JLabel("Tamaño");
		String[] sizesOptions = {"5x5","7x7","9x9"};
		sizes = new JComboBox<>(sizesOptions);
		difTag = new JLabel("Dificultad");
		BotGroup = new ButtonGroup();
		
		sizes.setPreferredSize(new Dimension(80,20));
		
		add(sizeTag);
		add(sizes);
		add(Box.createRigidArea(new Dimension(75,0)));
		add(difTag);
		add(Box.createRigidArea(new Dimension(15,0)));
		addBot("Easy");
		addBot("Medium");
		addBot("Hard");
		
		setPreferredSize(new Dimension(600, 100));

	}

	public void addBot(String texto) {
		JRadioButton boton = new JRadioButton(texto);
		BotGroup.add(boton);
		add(boton);
	}

}
