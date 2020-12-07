package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.bean.ProdutoBean;


public class ProdutoDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	public ProdutoDAO() {
		conn = new ConnectionFactory().getConnection();
	}
	
	public ArrayList<ProdutoBean> listarProdutos() {
		String sql = "SELECT id_Produto, nome, valor,categoria, descricao FROM produto";
		ArrayList<ProdutoBean> produtos = new ArrayList<ProdutoBean>();
		try {
			
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {				
				ProdutoBean produto = new ProdutoBean(rs.getString("nome"),rs.getDouble("valor"),rs.getString("categoria"),rs.getString("descricao"));
				produto.setId(rs.getInt("id_Produto"));
				produtos.add(produto);
			}
			return produtos;
		} catch(Exception erro) {
			return produtos;
		}
		
	}
	
	public ProdutoBean getProduto(int id_Produto) throws SQLException {
		String sql = "SELECT id_Produto, nome, valor,categoria, descricao FROM produto WHERE id_Produto = ?;";

		ProdutoBean produto = null;
		ps = conn.prepareStatement(sql);
		ps.setInt(1,id_Produto);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {				
			produto = new ProdutoBean(rs.getString("nome"),rs.getDouble("valor"),rs.getString("categoria"),rs.getString("descricao"));
			produto.setId(rs.getInt("id_Produto"));	
		}
		
		return produto;
		
		
	}
	
	public boolean inserirProduto(ProdutoBean produto) {
		String sql = "INSERT INTO produto (nome,valor,categoria,descricao) values (?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getValor());
			ps.setString(3, produto.getCategoria());
			ps.setString(4, produto.getDescricao());
			ps.execute();
			ps.close();
			return true;
		} catch(Exception erro) {
			return false;
		}
	}
	
	public boolean atualizarProduto(ProdutoBean produto) {
		String sql = "UPDATE produto SET nome = ?, valor = ?,categoria = ?, descricao = ? WHERE id_Produto = ?;";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,produto.getNome());
			ps.setDouble(2,produto.getValor());
			ps.setString(3,produto.getCategoria());
			ps.setString(4,produto.getDescricao());
			ps.setInt(5,produto.getId());
			ps.execute();
			ps.close();
			
			return true;
		} catch(Exception erro) {
			return false;
		}
	}
	
	public boolean excluirProduto(int id_Produto) {
		String sql = "DELETE FROM produto WHERE id_Produto = ?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id_Produto);
			ps.execute();
			ps.close();
			
			return true;
		} catch (Exception erro) {
			return false;
		}
	}
}
