package com.dhbw.lh.gymmemore;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.dhbw.lh.Controler.ImageHelper;
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
    private RelativeLayout rll;
    private boolean backgroundChange = false;
    ImageHelper imageHelper;
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
        rll = (RelativeLayout) findViewById(R.id.rll_main);

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
        rll.setOnClickListener(this);
        //endregion

        imageHelper = new ImageHelper();
        drawBackground();

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
                /*LineGraph line = new LineGraph();
                Intent lineIntent = new Intent(MainActivity.this, GraphActivity.class);
                startActivity(lineIntent);
                break;*/
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
            case R.id.rll_main:
                if(imageHelper.getCurrentBackgroundID(this)==6){
                    imageHelper.setCurrentBackgroundID(0,this);
                }else{
                    imageHelper.setCurrentBackgroundID(imageHelper.getCurrentBackgroundID(this)+1,this);
                }
                drawBackground();
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


    private void drawBackground(){
        switch(imageHelper.getCurrentBackgroundID(this)) {
            case 0:
                rll.setBackground(getResources().getDrawable(R.drawable.ic_background_weights));
                break;
            case 1:
                rll.setBackground(getResources().getDrawable(R.drawable.ic_background_squat));
                break;
            case 2:
                rll.setBackground(getResources().getDrawable(R.drawable.ic_background_seat));
                break;
            case 3:
                rll.setBackground(getResources().getDrawable(R.drawable.ic_background_standing));
                break;
            case 4:
                rll.setBackground(getResources().getDrawable(R.drawable.ic_background_bed));
                break;
            case 5:
                rll.setBackground(getResources().getDrawable(R.drawable.ic_background_bridge));
                break;
            case 6:
                rll.setBackground(getResources().getDrawable(R.drawable.ic_background_fitness));
                break;
            default:
                break;
        }
    }
}
