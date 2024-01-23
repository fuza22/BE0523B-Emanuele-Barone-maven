package org.example;

import org.example.entities.Mestiere;
import org.example.entities.Persona;
import org.example.DAO.PersonaDAO;

import java.time.LocalDate;

public class UsaPersonaDAO {

    public static void main(String[] args) {

        PersonaDAO dao = new PersonaDAO();

        Persona p = new Persona();

        p.setNome("Emanuele");
        p.setCognome("Barone");
        p.setMestiere(Mestiere.IMPIEGATO);
        p.setDataNascita(LocalDate.of(2000,05, 22));

        // dao.inserisciPersona(p); chiamo il metodo dao per inserire la persona dentro al database

        // System.out.println(p);


        // Persona p2 = dao.getById(2);

        // System.out.println(p2);

        dao.cancellaPersona(3);

    }

}
