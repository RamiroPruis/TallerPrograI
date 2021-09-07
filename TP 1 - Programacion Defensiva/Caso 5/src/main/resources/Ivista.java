import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ivista extends JFrame {

	private JPanel contentPane;
	private JPanel panelSur;
	private JLabel lblVolverJugar;
	private JButton btnNewButton;
	private JPanel panelCentral;
	private JLabel lblEligeNumero;
	private JTextField textFieldElijeNumero;
	private JButton btnProbar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ivista frame = new Ivista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ivista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.panelSur = new JPanel();
		this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
		
		this.lblVolverJugar = new JLabel("Volver a jugar");
		this.panelSur.add(this.lblVolverJugar);
		
		this.btnNewButton = new JButton("Reset");
		this.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.panelSur.add(this.btnNewButton);
		
		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.lblEligeNumero = new JLabel("Elige un numero");
		this.panelCentral.add(this.lblEligeNumero);
		
		this.textFieldElijeNumero = new JTextField();
		this.panelCentral.add(this.textFieldElijeNumero);
		this.textFieldElijeNumero.setColumns(10);
		
		this.btnProbar = new JButton("Probar");
		this.btnProbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.panelCentral.add(this.btnProbar);
	}

}
