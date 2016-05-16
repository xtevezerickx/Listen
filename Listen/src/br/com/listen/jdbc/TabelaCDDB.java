package br.com.listen.jdbc;

import java.sql.*;
import java.util.*;

import br.com.listen.model.CDs;

public class TabelaCDDB extends Conexao {

	public TabelaCDDB() {
		super();

	}

	public ArrayList<CDs> findAll() throws SQLException, Exception {
		ArrayList<CDs> lista = new ArrayList<CDs>();
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
			rs = stm.executeQuery("SELECT * FROM CDs");
			while (rs.next()) {
				CDs cdBean = new CDs();
				cdBean.setCodigoCD(rs.getInt("codigoCD"));
				cdBean.setCodigoArtista(rs.getInt("codigoArtista"));
				cdBean.setCodigoGenero(rs.getInt("codigoGenero"));
				cdBean.setTitulo(rs.getString("titulo"));
				cdBean.setPreco(rs.getDouble("preco"));
				lista.add(cdBean);
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
		return lista;
	}

	public CDs findByPrimaryKey(int valorChave) throws Exception {
		CDs cd = new CDs();
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet rs = null;
		try {
			pst = con.prepareStatement("select * from CDs where codigoCD = ? ");
			// substituir a 1� �?� pelo conte�do do valorChave,
			// isto �, procura na tabela o codigoCd=valorChave
			pst.setInt(1, valorChave);
			rs = pst.executeQuery();
			cd.setCodigoCD(rs.getInt("codigoCD"));
			cd.setCodigoArtista(rs.getInt("codigoArtista"));
			cd.setCodigoGenero(rs.getInt("codigoGenero"));
			cd.setTitulo(rs.getString("titulo"));
			cd.setPreco(rs.getDouble("preco"));
			return cd;
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
	public void insert(CDs aux) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "INSERT INTO Cds(codigoCD, codigoArtista, codigoGenero, titulo, preco) VALUES (?, ?, ?, ?, ?)";
			pst = con.prepareStatement(stn);
			pst.setInt(1, aux.getCodigoCD());
			pst.setInt(2, aux.getCodigoArtista());
			pst.setInt(3, aux.getCodigoGenero());
			pst.setString(4, aux.getTitulo());
			pst.setDouble(5, aux.getPreco());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}

	public void update(CDs aux) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "UPDATE CDs SET codigoArtista=?, codigoGenero=?, titulo=?, preco=? WHERE codigoCD=?";
			pst = con.prepareStatement(stn);
			pst.setInt(1, aux.getCodigoArtista());
			pst.setInt(2, aux.getCodigoGenero());
			pst.setString(3, aux.getTitulo());
			pst.setDouble(4, aux.getPreco());
			pst.setInt(5, aux.getCodigoCD());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}

	public void delete(int valorChave) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet rs = null;
		try {
			pst = con.prepareStatement("delete from CDs where codigoCD = ? ");
			// substituir a 1� �?� pelo conte�do do valorChave,
			// isto �, procura na tabela o codigoCd=valorChave
			pst.setInt(1, valorChave);
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