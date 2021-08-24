package service.intf;

import org.corsojava.albergo.medium.exceptions.CameraIdealeNonCalcolabileException;
import org.corsojava.albergo.medium.exceptions.CameraSenzaCapacitaException;
import org.corsojava.albergo.medium.model.Camera;
import org.corsojava.albergo.medium.service.Richiesta;

public interface AssegnazioneCameraStrategy {
	Camera getCameraRichiesta(Richiesta richiesta) throws CameraIdealeNonCalcolabileException, CameraSenzaCapacitaException;
}
