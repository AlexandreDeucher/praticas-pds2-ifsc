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

	// insert
	public boolean inserir(Pessoa p) {

		con = Conexao.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "INSERT INTO pessoa (cpf, nome) VALLUES (?, ?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setInt(1, p.getCpf());
			stm.setString(2, p.getNome());

			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.fecharConexao();

		return false;
	}

	// update
	public boolean atualizar(Pessoa p) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();
		try {
			String query = "UPDATE pessoa SET nome = ? WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, p.getNome());
			stm.setInt(2, p.getCpf());
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();

		return false;
	}

	// delete
	public boolean deletar(Pessoa p) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();
		try {
			String query = "DELETE FROM pessoa WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setInt(1, p.getCpf());
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();

		return false;
	}

	// listar
	public ArrayList<Pessoa> listarPessoas() {
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

				Pessoa p = new Pessoa();
				p.setCpf(cpf);
				p.setNome(nome);

				pessoas.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		con.fecharConexao();

		return pessoas;
	}
}
