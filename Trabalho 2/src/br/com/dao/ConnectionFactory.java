package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
public Connection getConnection() {
		
		String url = "jdbc:mysql://127.0.0.1:3306/dbcontrolegastos";
		String user = "root";
		String password = "12345";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch(Exception erro) {
			throw new RuntimeException("Conexao falhou" + erro);
		}
		
	}
}
