package com.dhbw.lh.gymmemore;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Train extends Activity implements View.OnClickListener {
    //region VALUES
    private TextView planTitleTxt;
    private TextView exerciseTitleTxt;

    private TextView setNumberTxt;

    private EditText kgEditTxt;
    private EditText repEditTxt;

    private EditText oldKgEditTxt;
    private EditText oldRepEditTxt;

    private Button addSetBtn;
    private Button doneExerciseBtn;
    private Button skipExerciseBtn;


    private int setNumber=1;
    private int oldSetCount=0;
    private String[][] setData;
    //endregion

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train);

        //Connect wih Surface Objects
        planTitleTxt = (TextView)findViewById(R.id.planTitleTxt);
        exerciseTitleTxt = (TextView)findViewById(R.id.exerciseTitleTxt);

        setNumberTxt = (TextView)findViewById(R.id.setNumberTxt);

        kgEditTxt = (EditText)findViewById(R.id.editTextKg);
        repEditTxt = (EditText)findViewById(R.id.editTextReps);
        oldKgEditTxt = (EditText)findViewById(R.id.editTextKgOld);
        oldRepEditTxt = (EditText)findViewById(R.id.editTextRepsOld);

        addSetBtn = (Button)findViewById(R.id.buttonAddSet);
        doneExerciseBtn = (Button)findViewById(R.id.doneExerciseBtn);
        skipExerciseBtn = (Button)findViewById(R.id.skipExerciseBtn);

        //Set OnClickListener
        planTitleTxt.setOnClickListener(this);
        addSetBtn.setOnClickListener(this);
        doneExerciseBtn.setOnClickListener(this);
        skipExerciseBtn.setOnClickListener(this);

        getExerciseSetData();
        setUpTrainScreen();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.planTitleTxt:
                showRemainingExercises();
                break;
            case R.id.buttonAddSet:
                addSet();
                break;
            case R.id.doneExerciseBtn:
                doneExercise();
                break;
            case R.id.skipExerciseBtn:
                skipExercise();
                break;
        }

    }

    private void setUpTrainScreen(){
        planTitleTxt.setText("Push / Pull");
        setNumberTxt.setText(setNumber+".Set");
        if(setNumber<=oldSetCount) {
            oldKgEditTxt.setText("" + setData[setNumber-1][0]);
            oldRepEditTxt.setText("" + "" + setData[setNumber-1][1]);
        }else{
            oldKgEditTxt.setText("X");
            oldRepEditTxt.setText("X");
        }
    }

    private void getExerciseSetData(){
        //Get Set Data from Server
        //oldSetCount = servercount of sets
        //new String[count of sets][2]
        oldSetCount = 3;
        setData = new String[oldSetCount][2];
        /*for(int i=0;i<oldSetCount;i++) {
            setData[i][0] = "90";//ServerKG
            setData[i][1] = "8";//ServerReps
        }*/
        setData[0][0] = "90";
        setData[0][1] = "8";
        setData[1][0] = "90";
        setData[1][1] = "4";
        setData[2][0] = "80";
        setData[2][1] = "6";


    }

    private void showRemainingExercises(){}

    private void addSet(){
        //Check if Set fields are filled with data
        if(kgEditTxt.getText().length()>0&&repEditTxt.getText().length()>0) {
            setNumber++;
            setNumberTxt.setText(setNumber+ ".Set");
            //saveSetData(kgEditTxt.getText().toString(),repEditTxt.getText().toString());
            kgEditTxt.setText("");
            repEditTxt.setText("");
            kgEditTxt.requestFocus();

            if(setNumber<=oldSetCount) {
                oldKgEditTxt.setText("" + setData[setNumber-1][0]);
                oldRepEditTxt.setText("" + "" + setData[setNumber-1][1]);
            }else{
                oldKgEditTxt.setText("X");
                oldRepEditTxt.setText("X");
            }
        }

    }

    private void doneExercise(){}

    private void skipExercise(){}
}
