package ex1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Ex2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNome;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex2 frame = new Ex2();
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
	public Ex2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(155, 41, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Matricula:");
		lblNewLabel.setBounds(99, 44, 56, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnInsert = new JButton("New button");
		btnInsert.setBounds(152, 141, 89, 23);
		contentPane.add(btnInsert);
		
		txtNome = new JTextField();
		txtNome.setBounds(155, 72, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(155, 103, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(99, 75, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setBounds(99, 106, 46, 14);
		contentPane.add(lblNewLabel_2);
	}
}
