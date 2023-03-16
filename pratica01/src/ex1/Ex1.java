package ex1;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ex1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private static Connection conexao;
	private static Ex1 instancia;
	private static final String DATABASE = "alexandre";
	private static final String USER = "root";
	private static final String PSW = "aluno";
	private Ex1 con;		
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex1 frame = new Ex1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private int matricula;
	private String nome;
	private String email;
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
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
	
	/**
	 * Create the frame.
	 */
	public Ex1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}
	
}