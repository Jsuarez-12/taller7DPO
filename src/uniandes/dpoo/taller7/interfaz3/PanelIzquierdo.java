package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelIzquierdo extends JPanel {
	
	private int size;
	
	public PanelIzquierdo(int size) {
		this.size = size;
		setOpaque(true);
		setBackground(Color.GRAY);
	}
	
	@Override
	public void paint(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D)g;
		
		int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Calcular el tamano y margen de cada cuadrado
        int tamano = Math.min(panelWidth, panelHeight) / size;
        int margin =0;

        // Dibujar los cuadrados segun el numero especificado
        for (int i = 0; i < size; i++) 
        {
            for (int j = 0; j < size; j++) 
            {
                int x = margin + j * (tamano + margin);
                int y = margin + i * (tamano + margin);
                g2d.setColor(Color.YELLOW); 
                g2d.fillRect(x, y, tamano, tamano); // Usar fillRect para llenar el cuadrado con color
                g2d.setColor(Color.BLACK); // Establecer el color negro para el borde
                g2d.drawRect(x, y, tamano, tamano); // Dibujar el borde del cuadrado
                
            }
        }
	}
	
	public void nuevo(int tamanio)
	{
		size = tamanio;
		repaint();
	}
	
}
