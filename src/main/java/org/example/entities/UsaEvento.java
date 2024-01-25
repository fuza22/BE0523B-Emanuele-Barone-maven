package org.example.entities;

import org.example.DAO.EventoDAO;
import org.example.DAO.LocationDAO;
import org.example.DAO.PartecipazioneDAO;
import org.example.DAO.Persona2DAO;
import org.example.m1.w3.d4.entities.PartitaDiCalcio;

import java.time.LocalDate;
import java.util.List;

public class UsaEvento {

    public static void main(String[] args) {

        EventoDAO eventoDao = new EventoDAO();
        LocationDAO locationDao = new LocationDAO();
        PartecipazioneDAO partecipazioneDao = new PartecipazioneDAO();
        Persona2DAO persona2Dao = new Persona2DAO();
//
//
//        Persona2 p1 = new Persona2();
//        p1.setNome("Emanuele");
//        p1.setCognome("Barone");
//
//        Persona2 p2 = new Persona2();
//        p2.setNome("Mauro");
//        p2.setCognome("Cassoni");
//
//        persona2Dao.save(p1);
//        persona2Dao.save(p2);
//
//        Location l1 = new Location();
//        l1.setCitta("Palermo");
//
//        locationDao.save(l1);
//
//        Evento e1 = new Evento();
//        e1.setDescrizione("Descrizione");
//        e1.setLocation(l1);
//
//        Evento e2 = new Evento();
//        e1.setDescrizione("Descrizione2");
//        e1.setLocation(l1);
//
//        eventoDao.save(e1);
//        eventoDao.save(e2);
//
//        Partecipazione part1 = new Partecipazione();
//        part1.setPersona2(p1);
//        part1.setEvento(e1);
//
//        Partecipazione part2 = new Partecipazione();
//        part2.setPersona2(p2);
//        part2.setEvento(e2);
//
//        partecipazioneDao.save(part1);
//        partecipazioneDao.save(part2);


        PartitaDiCalcio p1 = new PartitaDiCalcio();
        p1.setDescrizione("Partita");
        p1.setSquadraDiCasa("Milan");
        p1.setSquadraOspite("Cagliari");
        p1.setNumeroGolSquadraDiCasa(3);
        p1.setNumeroGolSquadraOspite(1);
        p1.getSquadraVincente();


    }




}
