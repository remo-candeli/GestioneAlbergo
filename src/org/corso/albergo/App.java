package org.corso.albergo;


public class App {

    public static void main(String[] args) {
       
        Albergo albergo = new Albergo();

        int c = 0;
        Cliente clienti[] = new Cliente[8];
        clienti[c++] = new Cliente("Remo", "Candeli", "CNDRME...");
        clienti[c++] = new Cliente("Paolo", "Rossi", "PLRSSS...");
        clienti[c++] = new Cliente("Bruno", "Bianchi", "BNCBR...");
        clienti[c++] = new Cliente("Marco", "Verdi", "VRDMRC...");
        clienti[c++] = new Cliente("Franco", "Gialli", "GLLFRN...");

        clienti[c++] = new Cliente("Ernesto", "Rosa", "RSERNS...");
        clienti[c++] = new Cliente("Gianni", "Nero", "NRGNN...");
        clienti[c++] = new Cliente("Sandra", "Celeste", "SNDCL...");
        c = 0;
        
        try {
            stampaPrenotazione(albergo.prenota(clienti[c++]));
            stampaPrenotazione(albergo.prenota(clienti[c++]));
            stampaPrenotazione(albergo.prenota(clienti[c++]));
            stampaPrenotazione(albergo.prenota(clienti[c++]));
            stampaPrenotazione(albergo.prenota(clienti[c++]));

            stampaDisdetta(albergo.disdici(clienti[2]));
            stampaDisdetta(albergo.disdici(clienti[3]));

            stampaPrenotazione(albergo.prenota(clienti[c++]));
            stampaPrenotazione(albergo.prenota(clienti[c++]));
            stampaPrenotazione(albergo.prenota(clienti[c++]));

        } catch(NessunaCameraDisponibileException e) {
            System.out.println("Non vi sono camere disponibili per il cliente " + clienti[c-1].getCognome());
        } catch(PrenotazioneNonValidaException e) {
            System.out.println("Prenotazione non trovata per il cliente " + clienti[c-1].getCognome());
        }

    }

    public static void stampaPrenotazione(Prenotazione prenotazione) {
        if(prenotazione!=null)
            System.out.println("prenotazione "+prenotazione.getIdPrenotazione()
                    + " eseguita per il cliente " + prenotazione.getCliente().getCognome()
                    + " stanza "+ prenotazione.getCamera().getNrCamera());
    }

    public static void stampaDisdetta(Prenotazione prenotazione) {
        if(prenotazione!=null)
            System.out.println("disdetta "+prenotazione.getIdPrenotazione()
                    + " eseguita per il cliente " + prenotazione.getCliente().getCognome()
                    + " stanza "+ prenotazione.getCamera().getNrCamera());
    }
}
