package com.example.android.moodtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int compteur = 0;
    private ImageView mWelcomeSmiley;
    private ImageButton mHistory;
    private TextView mCounter;
    private ImageButton mComment;

    private SwipeGestureDetector gestureDetector;


    private Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureDetector = new SwipeGestureDetector(this);



        mWelcomeSmiley = (ImageView) findViewById(R.id.welcome_smiley);
        mCounter = (TextView) findViewById(R.id.counter);
        mHistory = (ImageButton) findViewById(R.id.history);
        mComment = (ImageButton) findViewById(R.id.comment);






        mWelcomeSmiley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // compteur = ++compteur;
                // mCounter.setText(Integer.toString(compteur));
                // System.out.println(compteur);


            }
        });

        // CLIC SUR HISTORY
        mHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // compteur = --compteur;
                // mCounter.setText(Integer.toString(compteur));
                // mWelcomeSmiley.setImageResource(R.drawable.smiley_sad);
                //System.out.println(compteur);
                Intent historyActivityIntent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(historyActivityIntent);



            }
        });

        // CLIC SUR COMMENT - OPENS ALERT DIALOG - UserImputValue is the Input ( To see how to store it)
        mComment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final AlertDialog.Builder inputAlert = new AlertDialog.Builder(context);
                inputAlert.setTitle("un commentaire à faire?");
                inputAlert.setMessage("entrez votre commentaire et cliquez sur valider");
                final EditText userInput = new EditText(context);
                inputAlert.setView(userInput);
                inputAlert.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String userInputValue = userInput.getText().toString();
                        //System.out.println(userInputValue);
                    }
                });
                inputAlert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = inputAlert.create();
                alertDialog.show();
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    public void onSwipe(SwipeGestureDetector.SwipeDirection TOP_TO_BOTTOM) {
        System.out.println("droite gauche");
    }


}




