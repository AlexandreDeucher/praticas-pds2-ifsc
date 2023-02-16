package controle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO {
	
	private Conexao con;
	
	//insert
	public boolean inserir(Pessoa p) {
		
		con = Conexao.getInstancia();
		
		Connection c = con.conectar();
		try {
			PreparedStatement stm = c.prepareStatement(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		
		return false;
	}
	//update
	public boolean atualizar(Pessoa p) {
		
		
		
		return false;
	}
	//delete
		public boolean deletar(Pessoa p) {
			
			
			
			return false;
	}		
	//listar
		public ArrayList<Pessoa> listarPessoas(){
			
			
		return null;	
		}
}
