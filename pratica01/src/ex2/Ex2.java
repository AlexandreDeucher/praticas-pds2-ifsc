package ex2;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ex1.Ex1;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		txtMatricula.setBounds(76, 41, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Matricula:");
		lblNewLabel.setBounds(10, 44, 56, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnInsert = new JButton("New button");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ex2 ex2 = new Ex2();
				String matricula=txtMatricula.getText();
				if(matricula == null || matricula.isEmpty()) {
					JOptionPane.showMessageDialog(null,"campo matricula vazio");
				}else {
					ex2.setMatricula(matricula);
				}
				String nome=txtNome.getText();
				if(nome == null || nome.isEmpty()) {
					JOptionPane.showMessageDialog(null,"campo nome vazio");
				}else {
					ex2.setNome(nome);
				}
				String email=txtEmail.getText();
				if(email == null || email.isEmpty()) {
					JOptionPane.showMessageDialog(null,"campo email vazio");
				}else {
					ex2.setEmail(email);
				}
				
			}
		});
		btnInsert.setBounds(30, 138, 89, 23);
		contentPane.add(btnInsert);
		
		txtNome = new JTextField();
		txtNome.setBounds(76, 72, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(76, 103, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 69, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setBounds(10, 106, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 41, 252, 209);
		contentPane.add(scrollPane);
		
		ArrayList<Ex2> lista = new ArrayList<>();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "matricula", "nome", "email"});
		
		if(lista.size() > 0 && lista != null) {
			for (Ex2 ex2 : lista) {
				modelo.addRow(new Object [] {ex2.getMatricula(), ex2.getNome(), ex2.getEmail()});
			}
		}
		table.setModel(modelo);
	}
	private static Connection conexao;
	private static Ex1 instancia;
	private static final String DATABASE = "alexandre";
	private static final String USER = "root";
	private static final String PSW = "aluno";
	private Ex1 con;		
	
	private String matricula;
	private String nome;
	private String email;
	private JTable table;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static Ex1 getInstancia() {
		if(instancia == null) {
			instancia = new Ex1();
		}
		return instancia;
	}
	public Connection conectar() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/"
					+ DATABASE + "?serverTimezone=UTC",USER, PSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexao;
}
	public boolean facharConexao() {
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//inserir
	public boolean inserir(Ex1 a) {
		con =Ex1.getInstancia();
		Connection conecta = con.conectar();
		
		try {
			String query = "INSERT INTO aluno (matricula, nome, email) VALLUES (?,?,?);";
			PreparedStatement stm = conecta.prepareStatement(query);
			stm.setInt(1, a.getMatricula());
			stm.setString(2, a.getNome());
			stm.setString(3, a.getEmail());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return inserir(a);
	}
}
