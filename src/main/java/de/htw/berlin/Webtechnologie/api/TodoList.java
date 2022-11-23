package de.htw.berlin.Webtechnologie.api;

import java.time.LocalDate;


public class TodoList {

    private long id;
 private String Aufgabe;
 private String Archiv;
 private LocalDate Abgabedatum;
 private String nochZuErledigenTasks;
 private boolean erledigt;
 private boolean rückgängig;
 private boolean speichern;
 private boolean löschen;

    public TodoList(Long id,String aufgabe, String archiv, LocalDate abgabedatumUndZeit, String nochZuErledigenTasks, boolean erledigt, boolean rückgängig, boolean speichern, boolean löschen) {
        this.id= id;
        this.Aufgabe = aufgabe;
        this.Archiv = archiv;
        this.Abgabedatum = abgabedatumUndZeit;
        this.nochZuErledigenTasks = nochZuErledigenTasks;
        this.erledigt = erledigt;
        this.rückgängig = rückgängig;
        this.speichern = speichern;
        this.löschen = löschen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAbgabedatum(LocalDate abgabedatum) {
        Abgabedatum = abgabedatum;
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

    public LocalDate getAbgabedatum() {
        return Abgabedatum;
    }

    public void setAbgabedatumUndZeit(LocalDate abgabedatum) {
        Abgabedatum = abgabedatum;
    }

    public String getNochZuErledigenTasks() {
        return nochZuErledigenTasks;
    }

    public void setNochZuErledigenTasks(String nochZuErledigenTasks) {
        this.nochZuErledigenTasks = nochZuErledigenTasks;
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

