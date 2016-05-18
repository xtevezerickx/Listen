package br.com.listen.model;

public class Faixas {
	String dscFaixa;
	int idCd;

	

	public String getDscFaixa() {
		return dscFaixa;
	}

	public void setDscFaixa(String dscFaixa) {
		this.dscFaixa = dscFaixa;
	}

	@Override
	public String toString() {
		return "Faixas [ dscFaixa=" + dscFaixa + ", idCd=" + idCd + "]";
	}

	public int getIdCd() {
		return idCd;
	}

	public void setIdCd(int idCd) {
		this.idCd = idCd;
	}
}
