package br.com.listen.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.listen.model.Faixas;

public class FaixasDB extends Conexao {
	public void insert(Faixas faixa) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "INSERT INTO faixa(numFaixa,dscFaixa,idCd) VALUES (?, ?, ?)";
			pst = con.prepareStatement(stn);
			pst.setInt(1, faixa.getNumFaixa());
			pst.setString(2, faixa.getDscFaixa());
			pst.setInt(3, faixa.getIdCd());
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}
}
