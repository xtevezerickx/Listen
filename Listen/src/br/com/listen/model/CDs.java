package br.com.listen.model;

import java.sql.Date;

import br.com.listen.utils.GenerosType;

public class CDs {

	private int idCD;
	private String nomeCD;
	private double preco;
	private int dataLancamento;
	private Date dataCriacao;
	private String gravadora;
	private String nomeArtista;
	private GenerosType dscGenero;
	
	
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
	public int getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(int dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getNomeCD() {
		return nomeCD;
	}
	public void setNomeCD(String nomeCD) {
		this.nomeCD = nomeCD;
	}
	public String getNomeArtista() {
		return nomeArtista;
	}
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	public GenerosType getDscGenero() {
		return dscGenero;
	}
	public void setDscGenero(GenerosType dscGenero) {
		this.dscGenero = dscGenero;
	}
	@Override
	public String toString() {
		return "CDs [idCD=" + idCD + ", nomeCD=" + nomeCD + ", preco=" + preco + ", dataLancamento=" + dataLancamento
				+ ", dataCriacao=" + dataCriacao + ", gravadora=" + gravadora + ", nomeArtista=" + nomeArtista
				+ ", dscGenero=" + dscGenero + "]";
	}
	

	
	
	
	


}
