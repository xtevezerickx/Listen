package br.com.listen.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.listen.model.Usuario;

public class UsuarioDB extends Conexao {
	public UsuarioDB() {
		super();
	}

	public ArrayList<Usuario> findAll() throws SQLException, Exception {
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Usuario");
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setCEP(resultSet.getString("cep"));
				usuario.setCidade(resultSet.getString("cidade"));
				usuario.setCPF(resultSet.getString("cpf"));
				usuario.setCodUsuario(resultSet.getLong("codUsuario"));
				usuario.setDataNascimento(resultSet.getDate("dataNascimento"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setEstado(resultSet.getString("estado"));
				usuario.setRG(resultSet.getString("rg"));
				usuario.setRua(resultSet.getString("rua"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setLogin(resultSet.getString("login"));
				listaUsuario.add(usuario);
			}
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Erro Desconhecido" + e.getMessage());
			throw e;
		} finally {
			resultSet.close();
			this.close();
		}
		return listaUsuario;
	}

	public Usuario findByPrimaryKey(long valorChave) throws Exception {
		Usuario usuario = new Usuario();
		PreparedStatement preparedStatement = null;
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet resultSet = null;
		try {
			preparedStatement = con.prepareStatement("select * from Usuario where codUsuario = ? ");
			preparedStatement.setLong(1, valorChave);
			resultSet = preparedStatement.executeQuery();
			usuario.setCEP(resultSet.getString("cep"));
			usuario.setCidade(resultSet.getString("cidade"));
			usuario.setCPF(resultSet.getString("cpf"));
			usuario.setCodUsuario(resultSet.getLong("codUsuario"));
			usuario.setDataNascimento(resultSet.getDate("dataNascimento"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setEstado(resultSet.getString("estado"));
			usuario.setRG(resultSet.getString("rg"));
			usuario.setRua(resultSet.getString("rua"));
			usuario.setTelefone(resultSet.getString("telefone"));
			usuario.setLogin(resultSet.getString("login"));
			return usuario;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Erro Desconhecido" + e.getMessage());
			throw e;
		} finally {

			resultSet.close();
			this.close();
		}
	}

	public void insert(Usuario usuario) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "INSERT INTO Usuario(rg,cpf,rua,cep,cidade,estado,dataNasicmento,email,telefone,login,senha) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(stn);
			pst.setString(1, usuario.getRG());
			pst.setString(2, usuario.getCPF());
			pst.setString(3, usuario.getRua());
			pst.setString(4, usuario.getCEP());
			pst.setString(5, usuario.getCidade());
			pst.setString(6, usuario.getEstado());
			pst.setDate(7, (Date) usuario.getDataNascimento());
			pst.setString(8, usuario.getEmail());
			pst.setString(9, usuario.getTelefone());
			pst.setString(10, usuario.getLogin());
			pst.setString(11, usuario.getSenha());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}
	
	public void update(Usuario usuario) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "UPDATE CDs SET rg=?, cpf=?, rua=?, cep=?, cidade=?,estado=?,dataNascimento=?,email=?,telefone=?,login=?,senha=? WHERE codUsuario=?";
			pst = con.prepareStatement(stn);
			pst.setString(1, usuario.getRG());
			pst.setString(2, usuario.getCPF());
			pst.setString(3, usuario.getRua());
			pst.setString(4, usuario.getCEP());
			pst.setString(5, usuario.getCidade());
			pst.setString(6, usuario.getEstado());
			pst.setDate(7, (Date) usuario.getDataNascimento());
			pst.setString(8, usuario.getEmail());
			pst.setString(9, usuario.getTelefone());
			pst.setString(10, usuario.getLogin());
			pst.setString(11, usuario.getSenha());
			pst.setLong(12, usuario.getCodUsuario());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
			this.close();
		}
	}

	public void delete(long valorChave) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet rs = null;
		try {
			pst = con.prepareStatement("delete from Usuario where codUsuario = ? ");
			pst.setLong(1, valorChave);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Erro Desconhecido" + e.getMessage());
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			this.close();
		}
	}
	
}
