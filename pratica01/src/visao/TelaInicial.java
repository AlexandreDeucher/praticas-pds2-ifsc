package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 319);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(109, 149, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(148, 56, 183, 37);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(148, 129, 183, 37);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(60, 197, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(195, 197, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(329, 197, 89, 23);
		contentPane.add(btnDeletar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(90, 140, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNome.setBounds(90, 67, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCpf.setBounds(90, 140, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblCadastrar = new JLabel("Cadastrar");
		lblCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblCadastrar.setBounds(187, 11, 104, 34);
		contentPane.add(lblCadastrar);
	}
}
