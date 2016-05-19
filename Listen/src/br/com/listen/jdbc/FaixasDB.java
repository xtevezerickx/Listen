package br.com.listen.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.listen.model.CDs;
import br.com.listen.model.Faixas;

public class FaixasDB extends Conexao {
	public void insert(Faixas faixa) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "INSERT INTO faixa(dscFaixa,idCd) VALUES ( ?, ?)";
			pst = con.prepareStatement(stn);
			pst.setString(1, faixa.getDscFaixa());
			pst.setInt(2, faixa.getIdCd());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}
	
	public List<Faixas> buscaPorIdCd(int idCd) throws Exception{
		List<Faixas> listaDeFaixas = new ArrayList<Faixas>();
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet rs = null;
		try {
			pst = con.prepareStatement("select dscFaixa from faixa where idCd = ? ");
			pst.setInt(1, idCd);
			rs = pst.executeQuery();
			while(rs.next()){
				Faixas f= new Faixas();
				f.setDscFaixa(rs.getString("dscFaixa"));
				listaDeFaixas.add(f);
			}
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Erro Desconhecido" + e.getMessage());
			throw e;
		} 
		return listaDeFaixas;
		
	}
	

}
