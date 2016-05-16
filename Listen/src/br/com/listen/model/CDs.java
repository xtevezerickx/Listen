package br.com.listen.model;

public class CDs {

	private int codigoCD;
	private int codigoArtista;
	private int codigoGenero;
	private String titulo;
	private double preco;

	public CDs() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoArtista;
		result = prime * result + codigoCD;
		result = prime * result + codigoGenero;
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CDs other = (CDs) obj;
		if (codigoArtista != other.codigoArtista)
			return false;
		if (codigoCD != other.codigoCD)
			return false;
		if (codigoGenero != other.codigoGenero)
			return false;
		if (Double.doubleToLongBits(preco) != Double
				.doubleToLongBits(other.preco))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Código do CD: " + codigoCD + " | Código do Artista: "
				+ codigoArtista + " | Código do gênero: " + codigoGenero
				+ " | Título: " + titulo + " | Preço:" + preco + "\n";
	}

	public int getCodigoCD() {
		return codigoCD;
	}

	public void setCodigoCD(int codigoCD) {
		this.codigoCD = codigoCD;
	}

	public int getCodigoArtista() {
		return codigoArtista;
	}

	public void setCodigoArtista(int codigoArtista) {
		this.codigoArtista = codigoArtista;
	}

	public int getCodigoGenero() {
		return codigoGenero;
	}

	public void setCodigoGenero(int codigoGenero) {
		this.codigoGenero = codigoGenero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
