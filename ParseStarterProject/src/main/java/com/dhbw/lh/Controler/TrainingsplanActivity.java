package com.dhbw.lh.Controler;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.dhbw.lh.Model.MyCustomAdapter;
import com.dhbw.lh.Model.Parent;
import com.dhbw.lh.Model.TrainingsTag;
import com.dhbw.lh.Model.TrainingsUebung;
import com.dhbw.lh.gymmemore.R;

import java.util.ArrayList;

public class TrainingsplanActivity extends Activity {
    private ExpandableListView mExpandableList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_plans);


        mExpandableList = (ExpandableListView)findViewById(R.id.manage_plan);

        ArrayList<TrainingsTag> arrayParents = new ArrayList<TrainingsTag>(); //plan.getTrainingstage();
        ArrayList<TrainingsUebung> arrayChildren = new ArrayList<TrainingsUebung>(); // tag.getUebungen()

        //here we set the parents and the children


        //sets the adapter that provides data to the list.
        //mExpandableList.setAdapter(new MyCustomAdapter(TrainingsplanActivity.this, arrayParents));

    }
    
}
