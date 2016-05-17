package br.com.listen.model;

public class Faixas {
	int numFaixa;
	String dscFaixa;
	int idCd;

	public int getNumFaixa() {
		return numFaixa;
	}

	public void setNumFaixa(int numFaixa) {
		this.numFaixa = numFaixa;
	}

	public String getDscFaixa() {
		return dscFaixa;
	}

	public void setDscFaixa(String dscFaixa) {
		this.dscFaixa = dscFaixa;
	}

	@Override
	public String toString() {
		return "Faixas [numFaixa=" + numFaixa + ", dscFaixa=" + dscFaixa + ", idCd=" + idCd + "]";
	}

	public int getIdCd() {
		return idCd;
	}

	public void setIdCd(int idCd) {
		this.idCd = idCd;
	}
}
