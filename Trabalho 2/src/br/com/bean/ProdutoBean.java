package br.com.bean;

public class ProdutoBean {
	
	private int id;
	private String nome;
	private double valor;
	private String categoria;
	private String descricao;
	private String imagem;
	
	public ProdutoBean(String nome, double valor, String categoria, String descricao) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.categoria = categoria;
		this.descricao = descricao;
		//this.imagem = imagem;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	

}
