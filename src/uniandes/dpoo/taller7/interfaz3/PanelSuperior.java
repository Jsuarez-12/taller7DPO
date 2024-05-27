package uniandes.dpoo.taller7.interfaz3;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSuperior extends JPanel implements ActionListener{

	private JLabel sizeTag;
	private JComboBox<String> sizes;
	private JLabel difTag;
	private ButtonGroup BotGroup;
	private VentanaPrincipal ventana;

	public PanelSuperior(VentanaPrincipal ventana) {
		
		this.ventana = ventana;
		sizeTag = new JLabel("Tamaño");
		String[] sizesOptions = {"5x5","7x7","9x9"};
		sizes = new JComboBox<>(sizesOptions);
		difTag = new JLabel("Dificultad");
		BotGroup = new ButtonGroup();

		sizes.setPreferredSize(new Dimension(80,20));
		sizes.addActionListener(this);

		add(sizeTag);
		add(sizes);
		add(Box.createRigidArea(new Dimension(75,0)));
		add(difTag);
		add(Box.createRigidArea(new Dimension(15,0)));
		addBot("Easy");
		addBot("Medium");
		addBot("Hard");

		setPreferredSize(new Dimension(600, 50));

	}

	public void addBot(String texto) {
		JRadioButton boton = new JRadioButton(texto);
		BotGroup.add(boton);
		add(boton);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JComboBox<String> combo = (JComboBox<String>) e.getSource();
        String selectedOption = (String) combo.getSelectedItem();
        handleComboBoxSelection(selectedOption);
	}
	
	private void handleComboBoxSelection(String selectedOption) {
        switch (selectedOption) {
            case "5x5":
            	ventana.nuevoJuego(5);
                // Handle Option 1
                break;
            case "7x7":
            
                ventana.nuevoJuego(7);
                // Handle Option 2
                break;
            case "9x9":
            	ventana.nuevoJuego(9);
                // Handle Option 3
                break;
            default:
                System.out.println("Unknown option selected");
                break;
        }
    }
}
