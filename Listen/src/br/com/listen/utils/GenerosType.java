package br.com.listen.utils;

public enum GenerosType implements Comparable<GenerosType>{
	ROCK("Rock"),
	POP("Pop"),
	SAMBA("Samba"),
	SERTANEJO("Sertanejo"), 
	ELETRONICA("Eletronica"),
	HIPHOP("Hip-Hop");

	String descricao;

	private GenerosType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	

}
