package com.dhbw.lh.Model;

import java.util.ArrayList;

public class TrainingsPlan {
    private String title;
    public ArrayList<TrainingsTag> tage = new ArrayList<>();

    public TrainingsPlan(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TrainingsTag addTag(String title){
        TrainingsTag trainingsTag = new TrainingsTag(title);
        tage.add(trainingsTag);
        return trainingsTag;
    }

    public void removeTag(TrainingsTag trainingsTag){
        tage.remove(trainingsTag);
    }

    public ArrayList<TrainingsTag> getTage() {
        return tage;
    }

    public void setArrayChildren(ArrayList<TrainingsTag> tageArray) {
        tage = tageArray;
    }
}
