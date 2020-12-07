package br.com.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.bean.GastosBean;
import br.com.bean.ProdutoBean;
import br.com.dao.ProdutoDAO;

public class ProdutoBO {
	ProdutoDAO produtoDAO = new ProdutoDAO();
	
	public ArrayList<ProdutoBean> listarProdutos() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.listarProdutos();
	}
	
	public ProdutoBean getProduto(int id) throws SQLException {
		return produtoDAO.getProduto(id);
	}
	
	public GastosBean contabilizarGastos() {
		ArrayList<ProdutoBean> produtos = new ArrayList<ProdutoBean>();
		produtos = listarProdutos();
		int cap = 0;
		int con = 0;
		double maior = 0;
		double menor = 0;
		double total = 0;
		produtos.size();
		if(!produtos.isEmpty()) {
			maior = produtos.get(0).getValor();
			menor = produtos.get(0).getValor();
			for (ProdutoBean produtoBean : produtos) {
				if(produtoBean.getCategoria().equals("Bens de consumo")) {
					con++;
				} else {
					cap++;
				}
				if(produtoBean.getValor() > maior) {
					maior = produtoBean.getValor();
				}
				if(produtoBean.getValor() < menor) {
					menor = produtoBean.getValor();
				}
				total = total + produtoBean.getValor();
			}

			GastosBean gastos = new GastosBean(produtos.size(),con,cap,maior,menor,total);
			
			return gastos;
		} else {
			GastosBean gastos = new GastosBean(produtos.size(),con,cap,maior,menor,total);
			return gastos;
		}
			
	}
	
	public boolean inserirProduto(String nome, double valor,String categoria, String descricao) {	
		ProdutoBean produto = new ProdutoBean(nome,valor,categoria,descricao);
		return produtoDAO.inserirProduto(produto);
	}
	
	public boolean atualizarProduto(int id,String nome, double valor,String categoria, String descricao) {
		ProdutoBean produto = new ProdutoBean(nome,valor,categoria,descricao);
		produto.setId(id);
		return produtoDAO.atualizarProduto(produto);
	}
	
	public boolean deletarProduto(int id) {
		return produtoDAO.excluirProduto(id);
	}
}
