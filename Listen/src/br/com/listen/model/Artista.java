package br.com.listen.model;

public class Artista {

	private int idArtista;
	private String nomeArtista;
	private int idGenero;
	public int getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	public String getNomeArtista() {
		return nomeArtista;
	}
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	public int getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	@Override
	public String toString() {
		return "Artista [idArtista=" + idArtista + ", nomeArtista=" + nomeArtista + ", idGenero=" + idGenero + "]";
	}

	
}
