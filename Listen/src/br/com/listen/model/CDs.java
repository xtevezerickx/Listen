package br.com.listen.model;

public class CDs {

	private int idCD;
	private String nomeCD;
	private double preco;
	private int dataLancamento;
	private String dataCriacao;
	private String gravadora;
	private String nomeArtista;
	private String dscGenero;
	
	
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
	
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
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
	
	public String getDscGenero() {
		return dscGenero;
	}
	public void setDscGenero(String dscGenero) {
		this.dscGenero = dscGenero;
	}
	@Override
	public String toString() {
		return "CDs [idCD=" + idCD + ", nomeCD=" + nomeCD + ", preco=" + preco + ", dataLancamento=" + dataLancamento
				+ ", dataCriacao=" + dataCriacao + ", gravadora=" + gravadora + ", nomeArtista=" + nomeArtista
				+ ", dscGenero=" + dscGenero + "]";
	}
	

	
	
	
	


}
