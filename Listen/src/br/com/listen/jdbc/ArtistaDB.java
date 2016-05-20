package br.com.listen.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.listen.model.Artista;
import br.com.listen.model.CDs;

public class ArtistaDB extends Conexao{
	public void insert(Artista artista) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "INSERT INTO artista(nomeArtista,idGenero) VALUES (?,?)";
			pst = con.prepareStatement(stn);
			pst.setString(1, artista.getNomeArtista());
			pst.setInt(2, artista.getIdGenero());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}
	public ArrayList<Artista> listaTodosArtistas() throws SQLException, Exception {
		ArrayList<Artista> listaArtista = new ArrayList<Artista>();
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet rs = null;
		Statement stm = null;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery("SELECT * FROM artista");
			while (rs.next()) {
				Artista artista = new Artista();
				artista.setIdArtista(rs.getInt("idArtista"));
				artista.setIdGenero(rs.getInt("idGenero"));
				artista.setNomeArtista(rs.getString("nomeArtista"));
				
				listaArtista.add(artista);
			}
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
		return listaArtista;
	}
	
	public int descobreId(Artista artista) throws SQLException, Exception {
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet rs = null;
		Statement stm = null;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery("SELECT * FROM artista");
			while (rs.next()) {
				if(artista.getNomeArtista().equals(rs.getString("nomeArtista"))){
					return rs.getInt("idArtista");
				}
			}
			return 0;
		} catch (Exception e) {
			throw e;
		}

	}

	public int descobreUltimoId() throws Exception {
		Connection con= null;
		try{
			con=this.getConexao();
		}catch(Exception e){
			throw e;
		}
		ResultSet rs = null;
		Statement stm=null;
		try{
			stm=con.createStatement();
			rs=stm.executeQuery("SELECT MAX(idArtista)FROM artista");
			if(rs.next()){
				return rs.getInt(1);
			}else{
				return 0;
			}
		}catch(Exception e){
			throw e;
		}
	}
}
