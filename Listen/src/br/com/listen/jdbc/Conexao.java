package br.com.listen.jdbc;

import java.sql.*;

public class Conexao {

	public Connection dbConn;

	public Connection getConexao() throws Exception {
		String driver = "oracle.jdbc.OracleDriver";
		String URL = "jdbc:oracle:thin:@10.51.183.39:1521:XE";
		String login = "CCO3";
		String senha = "CCO3";
		dbConn = null;
		try{
			Class.forName(driver);
			dbConn = DriverManager.getConnection(URL, login, senha);
		} catch (Exception e){
			throw e; 
		}
		return dbConn;
	}

	public void close() throws Exception{
		if (dbConn != null) {
			dbConn.close();
		}
	}

}