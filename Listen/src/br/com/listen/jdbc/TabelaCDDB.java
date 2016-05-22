package br.com.listen.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

import br.com.listen.model.CDs;
import br.com.listen.utils.GenerosType;

public class TabelaCDDB extends Conexao {

	public TabelaCDDB() {
		super();

	}

	public TreeSet<String> listaTodosArtistas() throws SQLException, Exception {
		TreeSet<String> lista = new TreeSet<String>();
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
			rs = stm.executeQuery("SELECT nomeArtista FROM CD");
			while (rs.next()) {
				lista.add(rs.getString("nomeArtista"));
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
			rs = stm.executeQuery("SELECT * FROM CD");
			while (rs.next()) {
				CDs cd = new CDs();
				cd.setIdCD(rs.getInt("idCd"));
				cd.setNomeCD(rs.getString("nomeCd"));
				cd.setPreco(rs.getDouble("preco"));
				cd.setGravadora(rs.getString("gravadora"));
				cd.setDataLancamento(rs.getInt("dataLancamento"));
				cd.setDataCriacao(rs.getDate("dataCadastro"));
				cd.setDscGenero(GenerosType.valueOf(rs.getString("dscGenero")));
				cd.setNomeArtista(rs.getString("nomeArtista"));
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

	public CDs buscaPeloId(int idCd) throws Exception {
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
			pst = con.prepareStatement("select * from cd where idCd = ? ");
			pst.setInt(1, idCd);
			rs = pst.executeQuery();
			if(rs.next()){
			cd.setIdCD(rs.getInt("idCd"));
			cd.setNomeCD(rs.getString("nomeCd"));
			cd.setPreco(rs.getDouble("preco"));
			cd.setGravadora(rs.getString("gravadora"));
			cd.setDataLancamento(rs.getInt("dataLancamento"));
			cd.setDataCriacao(rs.getDate("dataCadastro"));
			cd.setNomeArtista(rs.getString("nomeArtista"));
			cd.setDscGenero(GenerosType.valueOf(rs.getString("dscGenero")));
			}
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
			String stn = "INSERT INTO cd(nomeCd,preco,gravadora,dataLancamento,dataCadastro,nomeArtista,dscGenero) VALUES (?, ?, ?, ?, ?,?,?)";
			pst = con.prepareStatement(stn);
			pst.setString(1, cd.getNomeCD());
			pst.setDouble(2, cd.getPreco());
			pst.setString(3, cd.getGravadora());
			pst.setInt(4, cd.getDataLancamento());
			pst.setDate(5, d2);
			pst.setString(6, cd.getNomeArtista());
			pst.setString(7, cd.getDscGenero().name());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}

	public void update(CDs cd) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "UPDATE cd SET nomeCd=?, preco=?, gravadora=?, dataLancamento=?,nomeArtista=?,dscGenero=? WHERE idCd=?";
			pst = con.prepareStatement(stn);
			pst.setString(1, cd.getNomeCD());
			pst.setDouble(2, cd.getPreco());
			pst.setString(3, cd.getGravadora());
			pst.setInt(4, cd.getDataLancamento());
			pst.setString(5, cd.getNomeArtista());
			pst.setString(6, cd.getDscGenero().name());
			pst.setInt(7, cd.getIdCD());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}

	public void delete(int idCD) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		try {
			pst = con.prepareStatement("DELETE FROM faixa WHERE idCD = ?");
			pst.setInt(1, idCD);
			pst.execute();
			pst=null;
			pst = con.prepareStatement("DELETE FROM cd WHERE idCD = ? ");
			pst.setInt(1, idCD);
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