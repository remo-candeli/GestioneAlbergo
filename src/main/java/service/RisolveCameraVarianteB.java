package service;

import org.corsojava.albergo.medium.exceptions.CameraIdealeNonCalcolabileException;
import org.corsojava.albergo.medium.exceptions.CameraSenzaCapacitaException;
import org.corsojava.albergo.medium.model.Camera;
import org.corsojava.albergo.medium.model.Cliente;
import org.corsojava.albergo.medium.service.intf.AssegnazioneCameraStrategy;

import java.time.LocalDate;
import java.time.Year;

/**
 * il primo dell'anno non si accettano Clienti.
 * 
 * @author remo
 *
 */
public class RisolveCameraVarianteB implements AssegnazioneCameraStrategy {
	
	private final static LocalDate PRIMO_DELLANNO = LocalDate.of(Year.now().getValue(), 1, 1);

	@Override
	public Camera getCameraRichiesta(Richiesta richiesta)  throws CameraIdealeNonCalcolabileException, CameraSenzaCapacitaException {
		Camera cameraIdeale = null;
		Cliente cliente = richiesta.getCliente();
		
		
		if ((richiesta.getDtIniziale().getDayOfMonth()==PRIMO_DELLANNO.getDayOfMonth()) 
			  && (richiesta.getDtIniziale().getMonth()==PRIMO_DELLANNO.getMonth())) {
			return null;
		}
		
		if (cliente.getNr_adulti()==2) {
			if (cliente.getNr_bambini()==1) {
				cameraIdeale = new Camera(1, 1, 0);
			}
			if (cliente.getNr_bambini()==0) {
				cameraIdeale = new Camera(1, 0, 0);
			}
		}
		
		if (cliente.getNr_adulti()==1) {
			cameraIdeale = new Camera(0, 0, 1);
		}
		
		if (cameraIdeale==null) {
			throw new CameraIdealeNonCalcolabileException();
		}
		return cameraIdeale;
	}

}
