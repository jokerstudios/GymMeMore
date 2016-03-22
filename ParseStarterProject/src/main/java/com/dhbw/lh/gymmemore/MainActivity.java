package com.dhbw.lh.gymmemore;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.dhbw.lh.Controler.TrainingsplanActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //region VARIABLES
    private Button      statisticsBtn;
    private Button      planBtn;
    private Button      createBtn;
    private ImageView   trainBtn;
    private ImageButton cameraBtn;

    private Spinner dynamicSpinner;
    Typeface font;

    int height;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region FRONTEND
        /*Connect with surface*/
        statisticsBtn= (Button)findViewById(R.id.statistics);
        planBtn=(Button)findViewById(R.id.manage);
        createBtn=(Button)findViewById(R.id.create);
        cameraBtn=(ImageButton)findViewById(R.id.camera);
        trainBtn = (ImageView) findViewById(R.id.train);
        dynamicSpinner  = (Spinner) findViewById(R.id.dynamic_spinner);

        /*Font for the buttons and spinner*/
        font = Typeface.createFromAsset(this.getAssets(), "fonts/minimal.otf");
        statisticsBtn.setTypeface(font);
        planBtn.setTypeface(font);
        createBtn.setTypeface(font);

        /*Clicklistener*/
        statisticsBtn.setOnClickListener(this);
        planBtn.setOnClickListener(this);
        createBtn.setOnClickListener(this);
        cameraBtn.setOnClickListener(this);
        trainBtn.setOnClickListener(this);
        //endregion

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        height = size.y;

        createDropdownMenu();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.manage:
                intent = new Intent(MainActivity.this, TrainingsplanActivity.class);
                startActivity(intent);
                break;
            case R.id.create:
                //intent = new Intent(MainActivity.this, Uebung.class);
                //startActivity(intent);
                break;
            case R.id.camera:
                intent = new Intent(MainActivity.this, Camera.class);
                startActivity(intent);
                break;
            case R.id.train:
                intent= new Intent(MainActivity.this, Train.class);
                startActivity(intent);
                break;
            case R.id.statistics:

                break;
            default:
                break;
        }
    }

    private void createDropdownMenu() {

        String[] items = new String[] { "Plan 1", "Push Pull", "3er Split" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, items)
        {
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                TextView v = (TextView) super.getView(position, convertView, parent);
                v.setTypeface(font);
                return v;
            }
        };

        adapter.setDropDownViewResource(R.layout.spinner_item_layout);

        dynamicSpinner.setDropDownVerticalOffset(calculateSpinnerOffset());
        dynamicSpinner.setAdapter(adapter);

        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private int calculateSpinnerOffset(){
        //Lower version offset from spinner, later versions from top
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return 8*(height/100);
        }else{
            return 0;
        }
    }
}
