package org.example.entities;

import org.example.DAO.EventoDAO;
import org.example.DAO.LocationDAO;
import org.example.DAO.PartecipazioneDAO;
import org.example.DAO.Persona2DAO;

import java.time.LocalDate;
import java.util.List;

public class UsaEvento {

    public static void main(String[] args) {

        EventoDAO eventoDao = new EventoDAO();
        LocationDAO locationDao = new LocationDAO();
        PartecipazioneDAO partecipazioneDao = new PartecipazioneDAO();
        Persona2DAO persona2Dao = new Persona2DAO();

        Location location = new Location("Teatro Massimo", "Palermo");
        Persona2 persona2 = new Persona2("Emanuele", "Barone","emanuele@email.it",LocalDate.of(1996,05,22), Sesso.M);
        Evento evento = new Evento("Festazza", LocalDate.of(2024,01, 25), "Bellissima festa", TipoEvento.PRIVATO, 500,  location);
        Partecipazione partecipazione = new Partecipazione(persona2, evento, Stato.DA_CONFERMARE);

        locationDao.save(location);
        persona2Dao.save(persona2);
        eventoDao.save(evento);
        partecipazioneDao.save(partecipazione);
        evento.setPartecipazione(partecipazione);
        eventoDao.update(evento);

        System.out.println(evento);

    }

}
