package br.com.listen.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.listen.model.Genero;

public class GeneroDB extends Conexao {
	public void insert(Genero genero) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "INSERT INTO genero(dscGenero) VALUES (?)";
			pst = con.prepareStatement(stn);
			pst.setString(1, genero.getDscGenero());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}

	public int descobreId(Genero genero) throws SQLException, Exception {
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
			rs = stm.executeQuery("SELECT * FROM genero");
			while (rs.next()) {
				if(genero.getDscGenero().equals(rs.getString("dscGenero"))){
					return rs.getInt("idGenero");
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
			rs=stm.executeQuery("SELECT MAX(idGenero)FROM genero");
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
