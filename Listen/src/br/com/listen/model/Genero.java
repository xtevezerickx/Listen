package br.com.listen.model;

public class Genero {
	private int idGenero;
	private String dscGenero;
	public int getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	public String getDscGenero() {
		return dscGenero;
	}
	public void setDscGenero(String dscGenero) {
		this.dscGenero = dscGenero;
	}
	@Override
	public String toString() {
		return "Genero [idGenero=" + idGenero + ", dscGenero=" + dscGenero + "]";
	}

	

}
