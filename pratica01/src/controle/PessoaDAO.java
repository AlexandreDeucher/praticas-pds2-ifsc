package controle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO {
	
	private Conexao con;
	
	//insert
	public boolean inserir(Pessoa p) {
		
		con = Conexao.getInstancia();
		
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO pessoa (cpf, nome) VALLUES (?, ?);";
			PreparedStatement stm = c.prepareStatement(null);
			
			stm.setInt(1, 123);
			stm.setString(2, "alexandre");
			
			int valida = stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		
		return false;
	}
	//update
	public boolean atualizar(Pessoa p) {
		Connection con = Conexao.getInstancia().conectar();
		try {
			String query = "UPDATE pessoa SET nome = ? WHERE cpf = ?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, p.getNome());
			stm.setInt(2, p.getCpf());
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	//delete
		public boolean deletar(Pessoa p) {
			Connection con = Conexao.conectar();
			try {
				String query = "DELETE FROM pessoa WHERE cpf = ?";
				PreparedStatement stm = con.prepareStatement(query);
				stm.setInt(1, p.getCpf());
				stm.executeUpdate();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			Conexao.fecharConnection();
			
			return false;
	}		
	//listar
		public ArrayList<Pessoa> listarPessoas(Pessoa p){
			ArrayList<Pessoa> pessoas = new ArrayList<>();
			
			con = Conexao.getInstancia();
			
			Connection c = con.conectar();
		try {
				
			Statement stm = c.createStatement();
			String query = "SELECT * FROM pessoa";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				int cpf = rs.getInt("cpf");
				String nome = rs.getString("nome");
				pessoas.add(p);
			}
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
		
			con.fecharConexao();
			
		return null;	
		}
}
