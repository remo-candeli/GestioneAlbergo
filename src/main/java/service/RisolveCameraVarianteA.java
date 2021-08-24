package service;

import org.corsojava.albergo.medium.exceptions.CameraIdealeNonCalcolabileException;
import org.corsojava.albergo.medium.exceptions.CameraSenzaCapacitaException;
import org.corsojava.albergo.medium.model.Camera;
import org.corsojava.albergo.medium.model.Cliente;
import org.corsojava.albergo.medium.service.intf.AssegnazioneCameraStrategy;


/**
 * 
 * 
 * @author remo
 *
 */
public class RisolveCameraVarianteA implements AssegnazioneCameraStrategy {

	@Override
	public Camera getCameraRichiesta(Richiesta richiesta)  throws CameraIdealeNonCalcolabileException, CameraSenzaCapacitaException {
		Camera cameraIdeale = null;
		Cliente cliente = richiesta.getCliente();
		
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
