package org.example.entities;

import org.example.DAO.EventoDAO;

import java.time.LocalDate;

public class UsaEvento {

    public static void main(String[] args) {

        EventoDAO dao = new EventoDAO();

        Evento e = new Evento("Festazza", LocalDate.of(2024,05, 22),"Super festazza paurosa", TipoEvento.PUBBLICO, 50);

        dao.save(e);
        System.out.println(dao.getById(1));

        dao.delete(1);


    }

}
