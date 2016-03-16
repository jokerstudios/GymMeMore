package com.dhbw.lh.Model;

import java.util.ArrayList;
import java.util.LinkedList;

public class TrainingsUebung {
    private String title = "";
    private ArrayList<Muscle> muscles = new ArrayList<>();

    public TrainingsUebung(String title) {
        setTitle(title);
    }

//    public TrainingsUebung(String title, LinkedList<Muscle> muskelGruppenList) {
//        setTitle(title);
//        if(muskelGruppenList != null)
//            this.muscles = muskelGruppenList;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TrainingsUebung addMuscle(String title){
        Muscle muscle = new Muscle(title);
        muscles.add(muscle);
        return this;
    }

    public void removeMuscle(Muscle muscle){
        muscles.remove(muscle);
    }

    public ArrayList<Muscle> getMuscles() {
        return muscles;
    }
}