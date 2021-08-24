package service.intf;

import org.corsojava.albergo.medium.model.Camera;
import org.corsojava.albergo.medium.service.Alloggio;
import org.corsojava.albergo.medium.service.Richiesta;

import java.util.List;

public interface IAssegnazione {
	
	public void setCalcolaCapacitaCamera(AssegnazioneCameraStrategy assegnaCamera);

	public Camera verifica(Richiesta richiesta, List<Alloggio> alloggi, List<Camera> camereAlbergo);
	
	public Alloggio assegnaAlloggio(Camera camera, List<Alloggio> alloggi, Richiesta richiesta);
}
