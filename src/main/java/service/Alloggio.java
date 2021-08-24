package service;

import org.corsojava.albergo.medium.model.Camera;
import org.corsojava.albergo.medium.model.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alloggio {
	
	private Cliente cliente;
	private LocalDate dtIniziale;
	private LocalDate dtFinale;
	
	private List<Camera> camere;

	public Cliente getCliente() {
		return cliente;
	}

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

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Camera> getCamere() {
		return camere;
	}

	public void setCamere(List<Camera> camere) {
		this.camere = camere;
	}
	
	public void aggiungiCamera(Camera camera)  {
		if (camere==null)
			camere = new ArrayList<>();
		camere.add(camera);
	}
	
	public boolean findCamera(Camera camera) {
		return camere.contains(camera);
	}

}
