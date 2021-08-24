package service;

import org.corsojava.albergo.medium.exceptions.CameraIdealeNonCalcolabileException;
import org.corsojava.albergo.medium.exceptions.CameraSenzaCapacitaException;
import org.corsojava.albergo.medium.model.Camera;
import org.corsojava.albergo.medium.service.intf.AssegnazioneCameraStrategy;
import org.corsojava.albergo.medium.service.intf.IAssegnazione;

import java.util.List;

public class Assegnazione implements IAssegnazione {
	
	AssegnazioneCameraStrategy assegnaCamera;
	
	
	public void setCalcolaCapacitaCamera(AssegnazioneCameraStrategy assegnaCamera) {
		this.assegnaCamera = assegnaCamera;
	}

	public Camera verifica(Richiesta richiesta, List<Alloggio> alloggi, List<Camera> camereAlbergo) {
		Camera cameraAssegnabile = null;
		
		try {
			
			cameraAssegnabile = assegnaCamera.getCameraRichiesta(richiesta);
			
			for(Camera cameraAlbergo: camereAlbergo) {
				boolean cameraLibera = true;
				for(Alloggio alloggio: alloggi) {
					if (alloggio.findCamera(cameraAlbergo)) {
						cameraLibera = false;
					    break;
					}
				}
				
				if (cameraLibera) {
					if (cameraAlbergo.getCapacita()==cameraAssegnabile.getCapacita()) {
						cameraAssegnabile = cameraAlbergo;
						break;
					}
				}
			}
			
		} catch (CameraIdealeNonCalcolabileException | CameraSenzaCapacitaException e) {
			e.printStackTrace();
		}
		
		return cameraAssegnabile;
	}
	
	public Alloggio assegnaAlloggio(Camera camera, List<Alloggio> alloggi, Richiesta richiesta) {
		Alloggio alloggio = new Alloggio();
		alloggio.setCliente(richiesta.getCliente());
		alloggio.setDtIniziale(richiesta.getDtIniziale());
		alloggio.setDtFinale(richiesta.getDtFinale());
		alloggio.aggiungiCamera(camera);
		alloggi.add(alloggio);
		return alloggio;
	}
}
