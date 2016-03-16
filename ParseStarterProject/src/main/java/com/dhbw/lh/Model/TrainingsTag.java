package com.dhbw.lh.Model;

import java.util.ArrayList;

public class TrainingsTag {
    private String title = "";
    ArrayList<TrainingsUebung> uebungen = new ArrayList<>();

    public TrainingsTag(String title){
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TrainingsUebung addUebung(String title){
        TrainingsUebung trainingsUebung = new TrainingsUebung(title);
        uebungen.add(trainingsUebung);
        return trainingsUebung;
    }

    public void removeUebung(TrainingsUebung trainingsUebung){
        uebungen.remove(trainingsUebung);
    }

    public ArrayList<TrainingsUebung> getUebungen() {
        return uebungen;
    }

    public void setArrayUebungen(ArrayList<TrainingsUebung> uebungenArray) {
        uebungen = uebungenArray;
    }

}
