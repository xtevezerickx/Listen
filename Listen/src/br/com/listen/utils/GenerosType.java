package br.com.listen.utils;

public enum GenerosType {
	ROCK("Rock"),
	POP("Pop"),
	SAMBA("Samba"),
	SERTANEJO("Sertanejo"),
	ELETRONICA("Eletronica");
	
	String descricao;
	
	private GenerosType(String descricao){
		this.descricao=descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	
	
}
