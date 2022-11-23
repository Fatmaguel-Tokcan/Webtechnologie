package de.htw.berlin.Webtechnologie.persistence;

import javax.persistence.*;
import java.time.LocalDate;



@Entity(name = "TodoLists")
public class TodoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Aufgabe")
    private String Aufgabe;

    @Column(name = "Archiv")
    private String Archiv;

    @Column(name = "AbgabeDatum")
    private LocalDate AbgabeDatum;

    @Column(name = "nochZuErledigenTask")
    private String nochZuErledigenTask;

    @Column(name = "erledigt")
    private boolean erledigt;

    @Column(name = "rückgängig")
    private boolean rückgängig;

    @Column(name = "speichern")
    private boolean speichern;

    @Column(name = "löschen")
    private boolean löschen;

    public TodoListEntity(String aufgabe, String archiv, LocalDate abgabeDatum, String nochZuErledigenTask, boolean erledigt, boolean rückgängig, boolean speichern, boolean löschen) {
        Aufgabe = aufgabe;
        Archiv = archiv;
        AbgabeDatum = abgabeDatum;
        this.nochZuErledigenTask = nochZuErledigenTask;
        this.erledigt = erledigt;
        this.rückgängig = rückgängig;
        this.speichern = speichern;
        this.löschen = löschen;
    }

    protected TodoListEntity() {}

    public Long getId() {
        return id;
    }


    public String getAufgabe() {
        return Aufgabe;
    }

    public void setAufgabe(String aufgabe) {
        Aufgabe = aufgabe;
    }

    public String getArchiv() {
        return Archiv;
    }

    public void setArchiv(String archiv) {
        Archiv = archiv;
    }

    public LocalDate getAbgabeDatum() {
        return AbgabeDatum;
    }

    public void setAbgabeDatum(LocalDate abgabeDatum) {
        AbgabeDatum = abgabeDatum;
    }

    public String getNochZuErledegenTask() {
        return nochZuErledigenTask;
    }

    public void setNochZuErledigenTask(String nochZuErledigenTask) {
        this.nochZuErledigenTask = nochZuErledigenTask;
    }


    public boolean isErledigt() {
        return erledigt;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }

    public boolean isRückgängig() {
        return rückgängig;
    }

    public void setRückgängig(boolean rückgängig) {
        this.rückgängig = rückgängig;
    }

    public boolean isSpeichern() {
        return speichern;
    }

    public void setSpeichern(boolean speichern) {
        this.speichern = speichern;
    }

    public boolean isLöschen() {
        return löschen;
    }

    public void setLöschen(boolean löschen) {
        this.löschen = löschen;
    }
}