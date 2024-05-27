package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSuperior extends JPanel implements ActionListener {

    private JLabel sizeTag;
    private JComboBox<String> sizes;
    private JLabel difTag;
    private ButtonGroup botGroup;
    private int size;
    private int difficulty;

    public PanelSuperior() {
    	
    	setBackground(new Color(150, 150, 150));
        sizeTag = new JLabel("Tamaño");
        String[] sizesOptions = {"5x5", "7x7", "9x9"};
        sizes = new JComboBox<>(sizesOptions);
        difTag = new JLabel("Dificultad");
        botGroup = new ButtonGroup();
        size = 5;

        sizes.setPreferredSize(new Dimension(80, 20));
        sizes.addActionListener(this);

        add(sizeTag);
        add(sizes);
        add(Box.createRigidArea(new Dimension(75, 0)));
        add(difTag);
        add(Box.createRigidArea(new Dimension(15, 0)));
        JRadioButton easyButton = addBot("Fácil");
        JRadioButton mediumButton = addBot("Medio");
        JRadioButton hardButton = addBot("Difícil");
        
        easyButton.setSelected(true);
        easyButton.doClick();

        setPreferredSize(new Dimension(600, 50));
    }

    public JRadioButton addBot(String texto) {
        JRadioButton boton = new JRadioButton(texto);
        boton.addActionListener(this); // Add action listener to the radio button
        botGroup.add(boton);
        add(boton);
        return boton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            JComboBox<String> combo = (JComboBox<String>) e.getSource();
            String selectedOption = (String) combo.getSelectedItem();
            handleComboBoxSelection(selectedOption);
        } else if (e.getSource() instanceof JRadioButton) {
            JRadioButton radioButton = (JRadioButton) e.getSource();
            handleRadioButtonSelection(radioButton.getText());
        }
    }

    private void handleComboBoxSelection(String selectedOption) {
        switch (selectedOption) {
            case "5x5":
                size = 5;
                // Handle 5x5 option
                break;
            case "7x7":
                size = 7;
                // Handle 7x7 option
                break;
            case "9x9":
                size = 9;
                // Handle 9x9 option
                break;
            default:
                System.out.println("Unknown option selected");
                break;
        }
    }

    private void handleRadioButtonSelection(String selectedOption) 
    {
        switch (selectedOption) {
            case "Fácil":
                difficulty = 5;
                // Handle Easy option
                break;
            case "Medio":
                difficulty = 10;
                // Handle Medium option
                break;
            case "Difícil":
                difficulty = 5;
                // Handle Hard option
                break;
            default:
                System.out.println("Unknown difficulty selected");
                break;
        }
    }
    
    public int get_size()
    {
    	return size;
    }
    
    public int getDifficulty()
    {
    	return difficulty;
    }
}
