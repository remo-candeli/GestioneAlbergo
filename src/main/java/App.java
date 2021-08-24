import org.corsojava.albergo.medium.exceptions.CameraGiaPresenteInAlbergoException;
import org.corsojava.albergo.medium.exceptions.CameraSenzaCapacitaException;
import org.corsojava.albergo.medium.exceptions.CameraSenzaNumeroIdentificativoException;
import org.corsojava.albergo.medium.model.Albergo;
import org.corsojava.albergo.medium.model.Camera;
import org.corsojava.albergo.medium.model.Cliente;
import org.corsojava.albergo.medium.model.MappaAlbergo;
import org.corsojava.albergo.medium.service.Alloggio;
import org.corsojava.albergo.medium.service.Richiesta;

import java.time.LocalDate;


/**
 * 
 * @author remo
 *
 */
public class App 
{
	
	private Albergo albergo;
	private Cliente[] clienti;
	
    public static void main( String[] args ) {
    	App app = new App();
    	app.creaAlbergo();
    	app.creaRichiesteAlloggioClientiGiorno1(LocalDate.now());
    	app.stampaCamereOccupate(LocalDate.now());
    	
    	app.elaboraPartenzeClienti(LocalDate.now());
    	app.stampaCamereOccupate(LocalDate.now());
    	
    	app.elaboraPartenzeClienti(LocalDate.now().plusDays(1));
    	app.stampaCamereOccupate(LocalDate.now().plusDays(1));
    }
    
    private void elaboraPartenzeClienti(LocalDate inData) {
    	albergo.liberaStanze(inData);
	}

	public void creaAlbergo() {
    	albergo = new Albergo();
    	albergo.setMappaAlbergo(generaMappaAlbergo()); 
    }

	
	private MappaAlbergo generaMappaAlbergo() {
		MappaAlbergo ma = new MappaAlbergo();
		try {
			// 4 camere matrimoniali con un letto singolo aggiuntivo
			ma.aggiungiCamera(new Camera("1A", 1, 1, 0));
			ma.aggiungiCamera(new Camera("1B", 1, 1, 0));
			ma.aggiungiCamera(new Camera("2A", 1, 1, 0));
			ma.aggiungiCamera(new Camera("2B", 1, 1, 0));
			
			// 3 camere con due letti singoli.
			ma.aggiungiCamera(new Camera("3A", 1, 0, 0));
			ma.aggiungiCamera(new Camera("3B", 1, 0, 0));
			ma.aggiungiCamera(new Camera("3C", 1, 0, 0));
			
			// 3 con soli letti singoli.
			ma.aggiungiCamera(new Camera("4A", 0, 0, 1));
			ma.aggiungiCamera(new Camera("4B", 0, 0, 1));
			ma.aggiungiCamera(new Camera("4C", 0, 0, 1));
			
		} catch(CameraSenzaCapacitaException | CameraGiaPresenteInAlbergoException | CameraSenzaNumeroIdentificativoException e) {
			System.out.println("...okkio ci sono camere incasinate!");
		}
			
		return ma;
	}	
	
    
    public void creaRichiesteAlloggioClientiGiorno1(LocalDate inData) {
    	Richiesta richiesta;
    	Cliente cliente;
    	clienti = new Cliente[2];
    	
    	// Famiglia 1
    	cliente = new Cliente();
    	cliente.setNome("Leopoldi");
    	cliente.setNr_adulti(2);
    	cliente.setNr_bambini(1);
    	richiesta = new Richiesta();
    	richiesta.setCliente(cliente);
    	richiesta.setDtIniziale(inData);
    	richiesta.setDtFinale(inData.plusDays(3));
    	albergo.aggiungiRichiesta(richiesta);
    	
    	// Famiglia 2    	
    	cliente = new Cliente();
    	cliente.setNome("Minchioni");
    	cliente.setNr_adulti(2);
    	cliente.setNr_bambini(1);
    	richiesta = new Richiesta();
    	richiesta.setCliente(cliente);
    	richiesta.setDtIniziale(inData);
    	richiesta.setDtFinale(inData.plusDays(4));
    	albergo.aggiungiRichiesta(richiesta); 
    	
    	// Coppia 1
    	cliente = new Cliente();
    	cliente.setNome("Sarchiaponi");
    	cliente.setNr_adulti(2);
    	cliente.setNr_bambini(0);
    	richiesta = new Richiesta();
    	richiesta.setCliente(cliente);
    	richiesta.setDtIniziale(inData);
    	richiesta.setDtFinale(inData);
    	albergo.aggiungiRichiesta(richiesta);    	
    	
    	// Coppia 2    	
    	cliente = new Cliente();
    	cliente.setNome("Capuleti");
    	cliente.setNr_adulti(2);
    	cliente.setNr_bambini(0);
    	richiesta = new Richiesta();
    	richiesta.setCliente(cliente);
    	richiesta.setDtIniziale(inData);
    	richiesta.setDtFinale(inData.plusDays(6));
    	albergo.aggiungiRichiesta(richiesta);    
    	
    	// Coppia 3    	
    	cliente = new Cliente();
    	cliente.setNome("Montecchi");
    	cliente.setNr_adulti(2);
    	cliente.setNr_bambini(0);
    	richiesta = new Richiesta();
    	richiesta.setCliente(cliente);
    	richiesta.setDtIniziale(inData);
    	richiesta.setDtFinale(inData.plusDays(5));
    	albergo.aggiungiRichiesta(richiesta);    	
    	
    	// Single
    	cliente = new Cliente();
    	cliente.setNome("Aieie");
    	cliente.setNr_adulti(1);
    	cliente.setNr_bambini(0);
    	richiesta = new Richiesta();
    	richiesta.setCliente(cliente);
    	richiesta.setDtIniziale(inData);
    	richiesta.setDtFinale(inData.plusDays(3));
    	albergo.aggiungiRichiesta(richiesta);    	
    	
    	albergo.eseguiAssegnazioni();
    }
    
    
    public void stampaCamereOccupate(LocalDate inData) {
		System.out.println("======================");
		System.out.println("Elenco Camere Occupate al "+ inData);
		System.out.println("======================");
    	for(Alloggio alloggio: albergo.getAlloggi()) {
    		Camera camera = alloggio.getCamere().get(0);
   			System.out.println("Camera: " + camera.getId_camera() + " tipo: "+ camera.getDatiCamera() + ", occupata da " + alloggio.getCliente().getNome());
   			System.out.println("");
    	}    	
    }
}
