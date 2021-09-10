package vista;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import excepciones.CombustibleInsuficienteException;
import excepciones.ImposibleCargarException;
import modelo.Surtidor;
import negocio.Negocio;

public class Vista extends JFrame implements Observer {

	private static Vista instance=null;
	private JFrame frame;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel_1;
	private JTextField textField;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JPanel panel_2;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JTextArea textArea;



	public static Vista getInstance(){
		if (instance == null)
			instance = new Vista();
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 600, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		this.frame.getContentPane().add(this.panel, BorderLayout.WEST);
		
		this.btnNewButton_1 = new JButton("Activar MG1");
		this.panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.panel.add(this.btnNewButton_1);
		
		this.btnNewButton = new JButton("Desactivar MG1");
		this.panel.add(this.btnNewButton);
		
		this.panel_1 = new JPanel();
		this.frame.getContentPane().add(this.panel_1, BorderLayout.NORTH);
		
		this.btnNewButton_2 = new JButton("Cargar");
		this.panel_1.add(this.btnNewButton_2);
		
		this.textField = new JTextField();
		this.panel_1.add(this.textField);
		this.textField.setColumns(10);
		
		this.btnNewButton_3 = new JButton("Inicializar");
		this.panel_1.add(this.btnNewButton_3);
		
		this.panel_2 = new JPanel();
		this.frame.getContentPane().add(this.panel_2, BorderLayout.EAST);
		
		this.btnNewButton_4 = new JButton("Activar MG2");
		this.panel_2.add(this.btnNewButton_4);
		
		this.btnNewButton_5 = new JButton("Desactivar MG2");
		this.panel_2.add(this.btnNewButton_5);
		
		this.textArea = new JTextArea();
		this.frame.getContentPane().add(this.textArea, BorderLayout.SOUTH);

		this.addActionListener(Negocio.getInstance());
		Negocio.getInstance().setVista(this);

	}
	
	public void addActionListener(ActionListener actionListener) {
		this.btnNewButton.addActionListener(actionListener);
		this.btnNewButton_1.addActionListener(actionListener);
		this.btnNewButton_2.addActionListener(actionListener);
		this.btnNewButton_3.addActionListener(actionListener);
		this.btnNewButton_4.addActionListener(actionListener);
		this.btnNewButton_5.addActionListener(actionListener);
	}

	/**
	 * Deriva la responsabilidad de Inicializar el surtidor a la capa de negocio
	 */
	public void inicializaSurtidor(){
		try {
			Negocio.getInstance().inicializaSurtidor(Double.parseDouble(this.textField.getText()));
		} catch (ImposibleCargarException e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}

	/**
	 * Deriva la responsabilidad de cargar el surtidor a la Capa de negocio, informa en caso de no poder
	 */
	public void cargaSurtidor(){
		try {
			Negocio.getInstance().cargaSurtidor(Double.parseDouble(this.textField.getText()));
		} catch (ImposibleCargarException e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}


	public void activaManguera1(){
		try {
			Negocio.getInstance().activaManguera1();
		} catch (CombustibleInsuficienteException e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}

	public void desactivaManguera1(){
		Negocio.getInstance().desactivaManguera1();
	}

	public void desactivaManguera2(){
		Negocio.getInstance().desactivaManguera2();
	}

	@Override
	public void update(Observable o, Object arg) {
		this.textArea.append(String.valueOf((double) arg));
	}
}
