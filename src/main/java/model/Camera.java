package model;

import org.corsojava.albergo.medium.exceptions.CameraSenzaCapacitaException;

public class Camera {
	
	private String id_camera;
	private int nr_letti_matrimoniali;
	private int nr_letti_singoli_aggintivi;
	private int nr_letti_singoli;
	
	private float capacita;
	
	
	public Camera() {
		
	}

	public Camera(int nr_letti_matrimoniali, int nr_letti_singoli_aggintivi, int nr_letti_singoli) throws CameraSenzaCapacitaException {
		this.nr_letti_matrimoniali = nr_letti_matrimoniali;
		this.nr_letti_singoli_aggintivi = nr_letti_singoli_aggintivi;
		this.nr_letti_singoli = nr_letti_singoli;
		calcolaCapacita(nr_letti_matrimoniali, nr_letti_singoli_aggintivi, nr_letti_singoli);
	}
	
	public Camera(String id_camera, int nr_letti_matrimoniali, int nr_letti_singoli_aggintivi, int nr_letti_singoli) throws CameraSenzaCapacitaException {
		this.setId_camera(id_camera);
		this.nr_letti_matrimoniali = nr_letti_matrimoniali;
		this.nr_letti_singoli_aggintivi = nr_letti_singoli_aggintivi;
		this.nr_letti_singoli = nr_letti_singoli;
		calcolaCapacita(nr_letti_matrimoniali, nr_letti_singoli_aggintivi, nr_letti_singoli);
	}
	
	public float getCapacita() {
		return capacita;
	}

	private void calcolaCapacita(int nr_letti_matrimoniali, int nr_letti_singoli_aggintivi, int nr_letti_singoli) throws CameraSenzaCapacitaException {
		float c_capacita = 0;
		c_capacita += nr_letti_matrimoniali * 0.8f;
		c_capacita += nr_letti_singoli_aggintivi * 0.2f;
		c_capacita += nr_letti_singoli * 0.4f;
		capacita = c_capacita;
		if (capacita==0) {
			throw new CameraSenzaCapacitaException();
		}
	}
	
	public int getNr_letti_matrimoniali() {
		return nr_letti_matrimoniali;
	}
	public void setNr_letti_matrimoniali(int nr_letti_matrimoniali) {
		this.nr_letti_matrimoniali = nr_letti_matrimoniali;
	}
	public int getNr_letti_singoli_aggintivi() {
		return nr_letti_singoli_aggintivi;
	}
	public void setNr_letti_singoli_aggintivi(int nr_letti_singoli_aggintivi) {
		this.nr_letti_singoli_aggintivi = nr_letti_singoli_aggintivi;
	}
	public int getNr_letti_singoli() {
		return nr_letti_singoli;
	}
	public void setNr_letti_singoli(int nr_letti_singoli) {
		this.nr_letti_singoli = nr_letti_singoli;
	}

	public String getId_camera() {
		return id_camera;
	}

	public void setId_camera(String id_camera) {
		this.id_camera = id_camera;
	}
	
	public String getDatiCamera() {
		String result = "";
		if(nr_letti_matrimoniali>0)
			result += nr_letti_matrimoniali + " letto/i Matrimoniale/i ";
		if(nr_letti_singoli_aggintivi>0)
			result += ", " + nr_letti_singoli_aggintivi + " letto/i aggiuntivo/i ";
		if(nr_letti_singoli>0) 
			result += nr_letti_singoli + " letto/i singolo/i "; 
		
		return result;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_camera == null) ? 0 : id_camera.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Camera)) {
			return false;
		}
		Camera other = (Camera) obj;
		if (id_camera == null) {
			if (other.id_camera != null) {
				return false;
			}
		} else if (!id_camera.equals(other.id_camera)) {
			return false;
		}
		return true;
	}
}
