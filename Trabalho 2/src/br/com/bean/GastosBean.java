package br.com.bean;

public class GastosBean {
	private int qtdItens;
	private int qtdCon;
	private int qtdCap;
	private double maiorValor;
	private double MenorValor;
	private double valorTotal;
	
	public GastosBean(int qtdItens, int qtdCon, int qtdCap, double maiorValor, double menorValor, double valorTotal) {
		super();
		this.qtdItens = qtdItens;
		this.qtdCon = qtdCon;
		this.qtdCap = qtdCap;
		this.maiorValor = maiorValor;
		MenorValor = menorValor;
		this.valorTotal = valorTotal;
	}
	
	public int getQtdItens() {
		return qtdItens;
	}
	public void setQtdItens(int qtdItens) {
		this.qtdItens = qtdItens;
	}
	public int getQtdCon() {
		return qtdCon;
	}
	public void setQtdCon(int qtdCon) {
		this.qtdCon = qtdCon;
	}
	public int getQtdCap() {
		return qtdCap;
	}
	public void setQtdCap(int qtdCap) {
		this.qtdCap = qtdCap;
	}
	public double getMaiorValor() {
		return maiorValor;
	}
	public void setMaiorValor(double maiorValor) {
		this.maiorValor = maiorValor;
	}
	public double getMenorValor() {
		return MenorValor;
	}
	public void setMenorValor(double menorValor) {
		MenorValor = menorValor;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
