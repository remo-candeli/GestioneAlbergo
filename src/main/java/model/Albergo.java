package model;

import org.corsojava.albergo.medium.service.Alloggio;
import org.corsojava.albergo.medium.service.Assegnazione;
import org.corsojava.albergo.medium.service.Richiesta;
import org.corsojava.albergo.medium.service.RisolveCameraVarianteA;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Albergo {
	
	private List<Richiesta> richieste;
	private MappaAlbergo mappaAlbergo;
	private Assegnazione assegnazioni;
	private List<Alloggio> alloggi;
	
	public List<Alloggio> getAlloggi() {
		return alloggi;
	}

	public Albergo() {
		richieste = new ArrayList<>();
		alloggi = new ArrayList<>();
		assegnazioni = new Assegnazione();
	}
	
	public void setMappaAlbergo(MappaAlbergo mappaAlbergo) {
		this.mappaAlbergo = mappaAlbergo;
	}
	
	public void aggiungiRichiesta(Richiesta richiesta) {
		richieste.add(richiesta);
	}

	public void eseguiAssegnazioni() {
		// imposta la strategia di assegnazione delle camere dell'albergo
		assegnazioni.setCalcolaCapacitaCamera(new RisolveCameraVarianteA());
		
		for(Richiesta richiesta: richieste) {
			System.out.println("Elaborazione richiesta cliente: " + richiesta.getCliente().getNome() + "...");
			Camera cameraProposta = contrattaAssegnazione(richiesta);
			if (cameraProposta!=null) {
				Alloggio alloggio = assegnazioni.assegnaAlloggio(cameraProposta, alloggi, richiesta);
				if (alloggio!=null) {
					richiesta.setEvasa(true);
					System.out.println("..camera "+ alloggio.getCamere().get(0).getId_camera() + " assegnata!");
				} 
			}
			richiesta.setEvasa(true);
		}
		
		// elimina le richieste evase
		for (Iterator<Richiesta> iter = richieste.listIterator(); iter.hasNext(); ) {
			Richiesta richiesta = iter.next();
			if (richiesta.isEvasa())
				iter.remove();
		}
	}
	
	
	public void liberaStanze(LocalDate oggi) {
		for (Iterator<Alloggio> iter = alloggi.listIterator(); iter.hasNext(); ) {
			Alloggio alloggio = iter.next();
			if (alloggio.getDtFinale().isEqual(oggi) || alloggio.getDtFinale().isBefore(oggi)) {
				iter.remove();
			}
		}
	}
	
	private Camera contrattaAssegnazione(Richiesta richiesta) {
		Scanner input = new Scanner(System.in);
		Camera cameraProposta = assegnazioni.verifica(richiesta, alloggi, mappaAlbergo.getListaCamere());
		if (cameraProposta==null) {
			System.out.println("...nessuna camera risulta disponibile.");
			return null;
		}			
		System.out.println(richiesta.getCliente().getNome() + ": " + cameraProposta.getDatiCamera());
		System.out.println(richiesta.getCliente().getNome() + ": Accetti(K), Rifiuti(R)?");
		String conferma = input.nextLine();
		if (conferma.equals("R"))
			cameraProposta = null;
		
		return cameraProposta;
	}

}
