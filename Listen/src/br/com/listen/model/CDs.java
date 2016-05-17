package br.com.listen.model;

import java.sql.Date;

public class CDs {

	private int idCD;
	private String tituloCD;
	private double preco;
	private int dataLancamento;
	private Date dataCriacao;
	private String gravadora;
	private int idArtista;
	
	public int getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	public String getGravadora() {
		return gravadora;
	}
	public void setGravadora(String gravadora) {
		this.gravadora = gravadora;
	}
	public int getIdCD() {
		return idCD;
	}
	public void setIdCD(int idCD) {
		this.idCD = idCD;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getTituloCD() {
		return tituloCD;
	}
	public void setTituloCD(String tituloCD) {
		this.tituloCD = tituloCD;
	}
	public int getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(int dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	@Override
	public String toString() {
		return "CDs [idCD=" + idCD + ", tituloCD=" + tituloCD + ", preco=" + preco + ", dataLancamento="
				+ dataLancamento + ", dataCriacao=" + dataCriacao + ", gravadora=" + gravadora + ", idArtista="
				+ idArtista + "]";
	}
	
	
	
	


}
