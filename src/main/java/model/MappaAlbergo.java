package model;

import org.corsojava.albergo.medium.exceptions.CameraGiaPresenteInAlbergoException;
import org.corsojava.albergo.medium.exceptions.CameraSenzaNumeroIdentificativoException;

import java.util.ArrayList;
import java.util.List;


public class MappaAlbergo {
	
	private List<Camera> camere;
	
	public MappaAlbergo() {
		camere = new ArrayList<>();
	}
	
	public List<Camera> getListaCamere() {
		return camere;
	}
	
	public void aggiungiCamera(Camera camera) throws CameraGiaPresenteInAlbergoException, CameraSenzaNumeroIdentificativoException {
		if ((camera.getId_camera()==null) || camera.getId_camera().isEmpty())
			throw new CameraSenzaNumeroIdentificativoException();
		if (!camere.contains(camera)) {
			camere.add(camera);
		} else {
			throw new CameraGiaPresenteInAlbergoException();
		}
	}
}
