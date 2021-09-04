package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Monitor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;

public class Ventana extends JFrame implements IVista{

	private JPanel contentPane;
	private JTextField PrimerOperando;
	private JTextField SegundoOperando;
	private JTextField Operacion;
	
	private JTextPane Resultado;
	private JLabel lblMensajeError;

	/**
	 * Create the frame.
	 */
	public Ventana() {
		
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		PrimerOperando = new JTextField();
		PrimerOperando.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PrimerOperando.setBounds(88, 89, 124, 29);
		panel.add(PrimerOperando);
		PrimerOperando.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCalcular.setBounds(201, 210, 98, 36);
		btnCalcular.addActionListener(Monitor.getinstance());
		panel.add(btnCalcular);
		
		Resultado = new JTextPane();
		Resultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Resultado.setBounds(156, 271, 202, 95);
		panel.add(Resultado);
		
		SegundoOperando = new JTextField();
		SegundoOperando.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SegundoOperando.setColumns(10);
		SegundoOperando.setBounds(296, 89, 124, 29);
		panel.add(SegundoOperando);
		
		Operacion = new JTextField();
		Operacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Operacion.setColumns(10);
		Operacion.setBounds(191, 148, 124, 29);
		panel.add(Operacion);
		
		JLabel lblNewLabel = new JLabel("Primer Operando:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(88, 66, 124, 17);
		panel.add(lblNewLabel);
		
		JLabel lblSegundoOperando = new JLabel("Segundo Operando:");
		lblSegundoOperando.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSegundoOperando.setBounds(296, 66, 135, 17);
		panel.add(lblSegundoOperando);
		
		JLabel lblOperacion = new JLabel("Operacion:");
		lblOperacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOperacion.setBounds(95, 154, 86, 17);
		panel.add(lblOperacion);
		
		JLabel lblNewLabel_1 = new JLabel("Suma - Resta - Division - Multiplicacion");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setLabelFor(this);
		lblNewLabel_1.setBounds(170, 121, 206, 36);
		panel.add(lblNewLabel_1);
		
		lblMensajeError = new JLabel("");
		lblMensajeError.setBounds(109, 398, 322, 36);
		panel.add(lblMensajeError);
	}

	/**
	 * Utiliza un if de validacion para validar que se ingreso algo<br>
	 * @return Devuelve el primer operando ingresado por el usuario
	 * 
	 */
	@Override
	public double getPrimerOperando() {
		if (this.PrimerOperando.getText().isEmpty()){
			MostrarEstado("Ingrese Operando 1");
			return -1;
		} else {
			return Double.parseDouble(this.PrimerOperando.getText());
		}
	}

	
	/**
	 * Utiliza un if de validacion para validar que se ingreso algo<br>
	 * @return Devuelve el segundo operando ingresado por el usuario<br>
	 */
	@Override
	public double getSegundoOperando() {
		if (this.SegundoOperando.getText().isEmpty()){
			MostrarEstado("Ingrese Operando 2");
			return -1;
		} else {
			return Double.parseDouble(this.SegundoOperando.getText());
		}		
	}


	/**
	 *  Muestra el mensaje de error de haber ocurrido
	 */
	@Override
	public void MostrarEstado(String Mensaje) {
		this.lblMensajeError.setText(Mensaje);		
	}

	/**
	 * Muestra el resultado del ultimo calculo sin error
	 */
	@Override
	public void MostrarResultado(double resultado) {
		this.Resultado.setText(String.valueOf((int)resultado));
		
	}

	/**
	 * Devuelve la operacion ingresada por el usuario
	 */
	@Override
	public String getOperacion() {
		if (Operacion.getText().isEmpty()){
			MostrarEstado("Ingrese Operacion");
			return "";
		} else {
			return Operacion.getText();
		}
	}

	
}
