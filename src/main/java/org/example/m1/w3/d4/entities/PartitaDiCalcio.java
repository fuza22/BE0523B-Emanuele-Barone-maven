package org.example.m1.w3.d4.entities;

import jakarta.persistence.*;
import org.example.entities.Evento;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "partita_di_calcio")
public class PartitaDiCalcio extends Evento {
    @Column(name = "squadra_di_casa")
    private String squadraDiCasa;

    @Column(name = "squadra_ospite")
    private String squadraOspite;

    @Column(name = "squadra_vincente")
    private String squadraVincente;

    @Column(name = "numero_gol_squadra_di_casa")
    private int numeroGolSquadraDiCasa;

    @Column(name = "numero_gol_squadra_ospite")
    private int numeroGolSquadraOspite;

    public PartitaDiCalcio(String squadraDiCasa, String squadraOspite, String squadraVincente, int numeroGolSquadraDiCasa, int numeroGolSquadraOspite) {
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        if(this.numeroGolSquadraDiCasa > this.numeroGolSquadraOspite) this.squadraVincente = this.squadraDiCasa;
            else if(this.numeroGolSquadraDiCasa < this.numeroGolSquadraOspite) this.squadraVincente = this.squadraOspite;
    }

    public PartitaDiCalcio(){}

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolSquadraDiCasa() {
        return numeroGolSquadraDiCasa;
    }

    public void setNumeroGolSquadraDiCasa(int numeroGolSquadraDiCasa) {
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    @Override
    public String toString() {
        return super.toString() +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", numeroGolSquadraDiCasa=" + numeroGolSquadraDiCasa +
                ", numeroGolSquadraOspite=" + numeroGolSquadraOspite;
    }
}
