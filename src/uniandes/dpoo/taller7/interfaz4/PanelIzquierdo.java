package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;

public class PanelIzquierdo extends JPanel implements MouseListener {
	
	private Tablero board = new Tablero(5);
	private VentanaPrincipal window;
	private ImageIcon on;
	private ImageIcon off;
	
	public PanelIzquierdo(VentanaPrincipal window) 
	{
		this.window = window;
		on = new ImageIcon("./data/On.png");
		off = new ImageIcon("./data/Off.png");
		addMouseListener(this);
		
		setOpaque(true);
		setBackground(Color.GRAY);
	}
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawRect(0,0,120,320);
		g2d.fillRect(10, 50, 50, 60);
		
		boolean [][] boardGame = board.darTablero();
		int boardSize = boardGame.length;
		
		int panelWidth = getWidth() / boardSize;
        int panelHeight = getHeight() / boardSize;

        // Calcular el tamano y margen de cada cuadrado
        //int tamano = Math.min(panelWidth, panelHeight) / size;
        //int margin =0;

        // Dibujar los cuadrados segun el numero especificado
        for (int i = 0; i < boardSize; i++) 
        {
            for (int j = 0; j < boardSize; j++) 
            {
            	if (boardGame[i][j]) {
                    g2d.setColor(Color.YELLOW);
                    g2d.fillRect(i * panelWidth, j * panelHeight, panelWidth, panelHeight);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(i * panelWidth, j * panelHeight, panelWidth, panelHeight);
                    g2d.drawImage(on.getImage(), i * panelWidth, j * panelHeight, panelWidth, panelHeight, null); // Establecer el color amarillo para true
                } else {
                    g2d.setColor(Color.YELLOW);
                    g2d.fillRect(i * panelWidth, j * panelHeight, panelWidth, panelHeight);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(i * panelWidth, j * panelHeight, panelWidth, panelHeight);
                    g2d.drawImage(off.getImage(), i * panelWidth, j * panelHeight, panelWidth, panelHeight, null);
                }
            }
        }
	}
	
	public void setBoard(Tablero board)
	{
		this.board = board;
		repaint();
	}
	
	@Override
    public void mousePressed(MouseEvent e)
	{
        // Obtener la posición del clic
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		board.jugar(casilla[1], casilla[0]);
		window.updatePlays();
		repaint();
		if (board.tableroIluminado()) {
			int puntaje=board.calcularPuntaje();
			JOptionPane.showMessageDialog(null, "Has ganado! Tu puntaje es de: "+puntaje);
			window.verificarTop10(puntaje);
		}
        
    }
	
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int ladoTablero = board.darTablero().length;
	int altoPanelTablero = getHeight();
	int anchoPanelTablero = getWidth();
	int altoCasilla = altoPanelTablero / ladoTablero;
	int anchoCasilla = anchoPanelTablero / ladoTablero;
	int fila = (int) (y / altoCasilla);
	int columna = (int) (x / anchoCasilla);
	return new int[] { fila, columna };
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void reiniciarTablero() {
		// TODO Auto-generated method stub
		board.reiniciar();
		repaint();
	}
	
	//public void nuevo(int tamanio)
	//{
	//	boardSize = tamanio;
	//	repaint();
	//}
	
}
