package org.corso.albergo;


/**
 * Modella le attivitá di un Albergo: Prenotazione e Cancellazione Prenotazione.
 * Si occupa anche di "costruire" le camere dell'albergo quando viene creata l'istanza
 */
public class Albergo {

    private static final int NR_MAX_CAMERE = 5;
    private static final int NR_MAX_PRENOTAZIONI = 20;
    private final Camera[] camere;
    private final Prenotazione[] prenotazioni;


    public Albergo() {
        this.camere = new Camera[NR_MAX_CAMERE];
        this.prenotazioni = new Prenotazione[NR_MAX_PRENOTAZIONI];
        creaCamereAlbergo();
    }


    /**
     * Genera una prenotazione per il cliente che la richiede.
     * Verifica la disponibilitá della camera ed in caso positivo
     * aggiunge la prenotazone all´elenco delle prenotazioni consolidate.
     *
     * @param cliente
     * @return Prenotazione
     * @throws NessunaCameraDisponibileException
     * @throws PrenotazioneNonValidaException
     */
    public Prenotazione prenota(Cliente cliente) throws NessunaCameraDisponibileException, PrenotazioneNonValidaException {
        Prenotazione prenotazione=null;
        Camera cameraLibera = trovaCameraLibera();
        if (cameraLibera==null) {
            throw new NessunaCameraDisponibileException();
        } 
        prenotazione = new Prenotazione(cameraLibera, cliente);
        if (prenotazione==null)
            throw new PrenotazioneNonValidaException();
    
        aggiungiPrenotazione(prenotazione);
        return prenotazione;
    }


    /**
     * Annulla una prenotazione in base al cliente.
     * Verifica che la prenotazione sia presente.
     *
     * @param cliente
     * @return Prenotazione
     * @throws PrenotazioneNonValidaException
     */
    public Prenotazione disdici(Cliente cliente) throws PrenotazioneNonValidaException {
        Prenotazione prenotazione = trovaPrenotazionePerCliente(cliente);
        if (prenotazione==null)
            throw new PrenotazioneNonValidaException();
        
        rimuoviPrenotazione(prenotazione);
        return prenotazione;
    }


    /**
     * Crea gli oggetti Camere e li mette nell'array Camere
     */
    private void creaCamereAlbergo() {
        int progressivoCamere = 1;
        for(int i=0; i < camere.length; i++) {
            if (camere[i]==null) {
                camere[i] = new Camera(""+progressivoCamere++ +"A");
            }
        }
    }


    /**
     * Cerca la prima camera libera e la ritorna.
     * Una camera libera non é associata a nessuna prenotazione esistente.
     *
     * @return Camera
     */
    private Camera trovaCameraLibera() {
        Camera cameraLibera= null;
        for(int i=0; i < camere.length; i++) {
            cameraLibera = camere[i];
            for(int c=0; c < prenotazioni.length; c++) {
                if ((prenotazioni[c]!=null) && (prenotazioni[c].getCamera().equals(cameraLibera))) {
                    cameraLibera=null;
                }
            }
            if (cameraLibera!=null) {
                return cameraLibera;
            }
        }
        return null;
    }


    /**
     * Aggiunge l'oggetto prenotazione all'array delle prenotazioni.
     *
     * @param prenotazione
     */
    private void aggiungiPrenotazione(Prenotazione prenotazione) {
        for(int p=0; p < prenotazioni.length; p++) {
            if (prenotazioni[p]==null) {
                prenotazioni[p] = prenotazione;
                break;
            }
        }    
    }

    /**
     * Rimuove l'oggetto prenotazione dall'array delle prenotazioni.
     *
     * @param prenotazione
     */
    private void rimuoviPrenotazione(Prenotazione prenotazione) {
        for(int p=0; p < prenotazioni.length; p++) {
            if ((prenotazioni[p]!=null) && (prenotazioni[p].getIdPrenotazione().equals(prenotazione.getIdPrenotazione()))) {
                prenotazioni[p] = null;
                break;
            }
        }    
    }


    /**
     * Trova una prenotazioni di un cliente nell´array delle prenotazioni.
     *
     * @param cliente
     * @return
     */
    private Prenotazione trovaPrenotazionePerCliente(Cliente cliente) {
        for(int p=0; p < prenotazioni.length; p++) {
            if ((prenotazioni[p]!=null) && (prenotazioni[p].getCliente().equals(cliente))) {
                return prenotazioni[p];
            }
        }
        return null;
    }
}