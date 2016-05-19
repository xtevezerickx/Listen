package br.com.listen.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import br.com.listen.model.CDs;

public class TabelaCDDB extends Conexao {

	public TabelaCDDB() {
		super();

	}

	public ArrayList<CDs> findAll() throws SQLException, Exception {
		//TODO fazer essa logica fncionar huehue
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
			rs = stm.executeQuery("SELECT * FROM CD");
			while (rs.next()) {
				CDs cd = new CDs();
				cd.setIdCD(rs.getInt("idCd"));
				cd.setNomeCD(rs.getString("nomeCd"));
				cd.setPreco(rs.getDouble("preco"));
				cd.setGravadora(rs.getString("gravadora"));
				cd.setDataLancamento(rs.getInt("dataLancamento"));
				cd.setDataCriacao(rs.getDate("dataCadastro"));
				cd.setIdArtista(rs.getInt("idArtista"));
				lista.add(cd);
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
	
	public int descobreUltimoId() throws SQLException,Exception{
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
			rs=stm.executeQuery("SELECT MAX(idCd)FROM cd");
			if(rs.next()){
				return rs.getInt(1);
			}else{
				return 0;
			}
		}catch(Exception e){
			throw e;
		}
		

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
	public void insert(CDs cd) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			Date d1 = new Date();
			java.sql.Date d2 = new java.sql.Date(d1.getTime());
			String stn = "INSERT INTO cd(nomeCd,preco,gravadora,dataLancamento,dataCadastro,idArtista) VALUES (?, ?, ?, ?, ?,?)";
			pst = con.prepareStatement(stn);
			pst.setString(1, cd.getNomeCD());
			pst.setDouble(2, cd.getPreco());
			pst.setString(3, cd.getGravadora());
			pst.setInt(4, cd.getDataLancamento());
			pst.setDate(5, d2);
			pst.setInt(6, cd.getIdArtista());
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
		try {
			pst = con.prepareStatement("DELETE FROM cd WHERE idCD = ? ");
			pst.setInt(1, valorChave);
			pst.execute();
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Erro Desconhecido" + e.getMessage());
			throw e;
		} 
		con.close();
	}

}