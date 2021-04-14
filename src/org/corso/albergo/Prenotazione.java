package org.corso.albergo;

public class Prenotazione {
    
    private String idPrenotazione;
    private Camera camera;
    private Cliente cliente;

    public Prenotazione() {   
    }

    public Prenotazione(Camera camera, Cliente cliente) {
        this.camera = camera;
        this.cliente = cliente;
        this.idPrenotazione = "PR-" + getRandomNumber(100, 8000); 
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String getIdPrenotazione() {
        return idPrenotazione;
    }

    public Camera getCamera() {
        return camera;
    }
    public void setCamera(Camera camera) {
        this.camera = camera;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }    
}
