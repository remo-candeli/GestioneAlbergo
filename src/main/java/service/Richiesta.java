package service;

import org.corsojava.albergo.medium.model.Cliente;

import java.time.LocalDate;

public class Richiesta {
	
	private Cliente cliente;
	private LocalDate dtIniziale;
	private LocalDate dtFinale;
	private boolean isEvasa;

	public LocalDate getDtIniziale() {
		return dtIniziale;
	}

	public void setDtIniziale(LocalDate dtIniziale) {
		this.dtIniziale = dtIniziale;
	}

	public LocalDate getDtFinale() {
		return dtFinale;
	}

	public void setDtFinale(LocalDate dtFinale) {
		this.dtFinale = dtFinale;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isEvasa() {
		return isEvasa;
	}

	public void setEvasa(boolean isEvasa) {
		this.isEvasa = isEvasa;
	}

}
