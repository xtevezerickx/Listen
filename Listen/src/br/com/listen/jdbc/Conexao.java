package br.com.listen.jdbc;

import java.sql.*;

public class Conexao {

	public Connection dbConn;

	public Connection getConexao() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost/listen";
		String login = "root";
		String senha = "1234";
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