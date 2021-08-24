package model;

public class Cliente {
	
	private String nome;
	private int nr_adulti;
	private int nr_bambini;
	
	
	public void creaRichiestaAlloggio() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNr_bambini() {
		return nr_bambini;
	}

	public void setNr_bambini(int nr_bambini) {
		this.nr_bambini = nr_bambini;
	}

	public int getNr_adulti() {
		return nr_adulti;
	}

	public void setNr_adulti(int nr_adulti) {
		this.nr_adulti = nr_adulti;
	}

}
