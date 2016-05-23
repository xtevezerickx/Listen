package br.com.listen.utils;

public enum GenerosType implements Comparable<GenerosType>{
	ELETRONICA("Eletronica"),
	HIPHOP("Hip-Hop"),
	POP("Pop"),
	ROCK("Rock"),
	SAMBA("Samba"),
	SERTANEJO("Sertanejo");

	String descricao;

	private GenerosType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	

}
