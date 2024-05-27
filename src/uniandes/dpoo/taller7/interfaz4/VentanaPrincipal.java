package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;



public class VentanaPrincipal extends JFrame {
	
	private PanelSuperior arriba;
	private PanelInferior abajo;
	private PanelIzquierdo izquierda;
	private PanelDerecho derecha;
	private Top10 top;
	private String jugadorActual;
	private File registros;

	public VentanaPrincipal() {
		
		setTitle("Juego de LightsOut");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        
        
        // Configurar el layout del JFrame
        setLayout(new BorderLayout());
        
        top = new Top10();
        registros = new File("./data/top10.csv");
        top.cargarRecords(registros);
        jugadorActual = null;
        
        // Crear los paneles
        arriba = new PanelSuperior();
        izquierda = new PanelIzquierdo(this);
        derecha = new PanelDerecho(this);
        abajo = new PanelInferior();
        //abajo.setPreferredSize(new Dimension(600, 100)); // Ajustar tamaño preferido
        //abajo.setBackground(Color.cyan);
        
        // Añadir los paneles al JFrame
        add(izquierda, BorderLayout.CENTER);
        add(arriba, BorderLayout.NORTH);
        add(derecha, BorderLayout.EAST);        
        add(abajo, BorderLayout.SOUTH);
        setVisible(true);
        
		
	}
	
	//public void nuevoJuego(int size)
	//{
	//	izquierda.nuevo(size);
	//}
	
	public int newSize()
	{
		return arriba.get_size();
	}
	
	public int newDifficulty()
	{
		return arriba.getDifficulty();
	}
	
	public void newBoard(int size, int difficutly)
	{
		Tablero board = new Tablero(size);
		board.desordenar(difficutly);
		izquierda.setBoard(board);
		abajo.resetPlays();
	}
	
	public void updatePlays() {
		// TODO Auto-generated method stub
		abajo.updatePlays();
	}
	
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}

	public void reiniciarTablero() {
		// TODO Auto-generated method stub
		izquierda.reiniciarTablero();
		abajo.resetPlays();
	}

	public void showTop10() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel(new BorderLayout());
	    DefaultListModel<String> listModel = new DefaultListModel<>();
	    for (RegistroTop10 registro : top.darRegistros()) {
	        String linea = registro.toString();
	        listModel.addElement(linea);
	    }
	    JList<String> jList = new JList<>(listModel);
	    jList.setCellRenderer(new ListCellRenderer<String>() {
	        @Override
	        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
	            JLabel label = new JLabel(value);
	            label.setOpaque(true);
	            label.setFont(new Font("Arial", Font.PLAIN, 14));
	            if (index == 0) {
	                label.setBackground(new Color(255, 215, 0)); // Oro
	            } else if (index == 1) {
	                label.setBackground(new Color(192, 192, 192)); // Plata
	            } else if (index == 2) {
	                label.setBackground(new Color(205, 127, 50)); // Bronce
	            } else {
	                label.setBackground(new Color(240, 240, 240)); // Fondo por defecto
	            }
	            if (isSelected) {
	                label.setBackground(label.getBackground().darker());
	            }
	            return label;
	        }
	    });
	    JScrollPane scrollPane = new JScrollPane(jList);

	    JLabel title = new JLabel("Top 10");
	    title.setFont(new Font("Arial", Font.BOLD, 16));
	    title.setHorizontalAlignment(SwingConstants.CENTER);
	    panel.add(title, BorderLayout.NORTH);

	    jList.setBackground(new Color(240, 240, 240));
	    jList.setFont(new Font("Arial", Font.PLAIN, 14));

	    panel.add(scrollPane, BorderLayout.CENTER);
	    JOptionPane.showMessageDialog(null, panel, "JList en Ventana Emergente", JOptionPane.PLAIN_MESSAGE);
	
	}

	public void actualizarNuevoJugador(String player) 
	{
		// TODO Auto-generated method stub
		jugadorActual = player;
		abajo.updatePlayer(player);
	}

	public void verificarTop10(int puntaje) {
		// TODO Auto-generated method stub
		boolean enough = top.esTop10(puntaje);
		if (enough)
		{
			top.agregarRegistro(jugadorActual, puntaje);
			
			
		}
	}
}



