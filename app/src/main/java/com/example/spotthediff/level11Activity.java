package com.example.spotthediff;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Timer;

public class level11Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvFindTheDiff;
    private TextView tvTimer;
    private RadioGroup rbGroup;
    private RadioButton rbB1;
    private RadioButton rbB2;
    private RadioButton rbB3;
    private RadioButton rbB4;
    private Button btNext;
    private Timer timer;
    private Switch music;
    private SoundPool sp;
    private final int size = 19;
    private Handler gameHandler = new Handler();
    private static int seconds = 0;
    private boolean running = false;
    private final int duration = 30;
    private GameModel myGame;
    private static int newScore = 0;
    private GameModel[] arrGameModel = new GameModel[size];
    private TextRB[] arrTextRB = new TextRB[size];
    private static int counter = 0;
    private ImageView ivPicture;
    private TextView tvScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level11);
        initViews();
        initObjects();
        running = true;
        runTimerForGame(30);
    }


    private void initViews() {
        ivPicture = findViewById(R.id.ivp1);
       // tvScore = findViewById(R.id.tvScore);
        rbB1 = findViewById(R.id.rbB1);

        rbB2 = findViewById(R.id.rbB2);

        rbB3 = findViewById(R.id.rbB3);

        rbB4 = findViewById(R.id.rbB4);

        btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(this);
    }

    private void initObjects() {
      //  myGame = new GameModel(R.drawable.turtle1, R.drawable.turtle1, 1, 30, 1);
        arrTextRB[0] = new TextRB("eyes and tongue", "hand and leg", "stomach and leg", "neck and turtle shell");
        arrTextRB[1] = new TextRB("eyes and grass", "foot and skin", "ear and foot", "tail and skin");
        arrTextRB[2] = new TextRB("eyes and strip", "eyebrows and mustache", "leg and tail", "ears and strip");
        arrTextRB[3] = new TextRB("thumb and sunglasses", "tail", "stomach and leg", "eyebrows and tooth");
        arrTextRB[4] = new TextRB("tongue and eyebrow", "stomach and fin", "tail and eyes", "tongue and belly");
        arrTextRB[5] = new TextRB("eyes and skin", "tongue and fin", "cheek", "nostrils and eyes");
        arrTextRB[6] = new TextRB("eyes and tail", "cheeks and water splash", "eyebrows and cheeks", "mouth and water splash");
        arrTextRB[7] = new TextRB("eye and dots", "claws and mouth", "legs and eyes", "dots and mouth");
        arrTextRB[8] = new TextRB("wing and belly", "beak and eye", "eye and eyebrows", "tongue and eyebrows");
        arrTextRB[9] = new TextRB("beak and eyes", "tongue and tail", "tail and eyebrows", "leg and tongue");
        arrTextRB[10] = new TextRB("wing and legs", "eyes and nostril", "eyes and tail", "nostril and wing");
        arrTextRB[11] = new TextRB("horns and belly", "eyes and tail", "tooth and belly", "tooth and feelers");
        arrTextRB[12] = new TextRB("eyes and nails", "ears and eyes", "eyebrows and proboscis", "nails and ears");
        arrTextRB[13] = new TextRB("nostrils", "eye and knees", "knees and tongue", "nails and ears");
        arrTextRB[14] = new TextRB("tail and strip", "tongue and strip", "eyes and tongue", "ears");
        arrTextRB[15] = new TextRB("thumb and eyebrows", "tail and nose", "stomach and ears", "nose and nails");

        arrGameModel[0] = new GameModel(R.drawable.turtle, R.drawable.turtle, 1, 30, 1, arrTextRB[0]);

        arrGameModel[1] = new GameModel(R.drawable.cow, R.drawable.cow, 1, 30, 2,arrTextRB[1]);

        arrGameModel[2] = new GameModel(R.drawable.cat, R.drawable.cat, 1, 30, 1,arrTextRB[2]);

        arrGameModel[3] = new GameModel(R.drawable.alligator, R.drawable.alligator, 1, 30, 4,arrTextRB[3]);

        arrGameModel[4] = new GameModel(R.drawable.dolphine, R.drawable.dolphine, 2, 30, 1,arrTextRB[4]);

        arrGameModel[5] = new GameModel(R.drawable.fish, R.drawable.fish, 2, 30, 4,arrTextRB[5]);

        arrGameModel[6] = new GameModel(R.drawable.whale, R.drawable.whale, 2, 30, 2,arrTextRB[5]);

        arrGameModel[7] = new GameModel(R.drawable.crab, R.drawable.crab, 2, 30, 1,arrTextRB[5]);

        arrGameModel[8] = new GameModel(R.drawable.bird, R.drawable.bird, 2, 30, 3,arrTextRB[5]);

        arrGameModel[9] = new GameModel(R.drawable.eagle, R.drawable.eagle, 2, 30, 2,arrTextRB[5]);

        arrGameModel[10] = new GameModel(R.drawable.yona, R.drawable.yona, 2, 30, 4,arrTextRB[5]);

        arrGameModel[11] = new GameModel(R.drawable.dragon, R.drawable.dragon, 2, 30, 3,arrTextRB[5]);

        arrGameModel[12] = new GameModel(R.drawable.elephant, R.drawable.elephant, 2, 30, 1,arrTextRB[5]);

        arrGameModel[13] = new GameModel(R.drawable.hippo, R.drawable.hippo, 2, 30, 2,arrTextRB[5]);

        arrGameModel[14] = new GameModel(R.drawable.zebra, R.drawable.zebra, 2, 30, 2,arrTextRB[5]);

        arrGameModel[15] = new GameModel(R.drawable.lion, R.drawable.lion, 2, 30, 4,arrTextRB[5]);

    }

    public void onRBClicked(View view) {
        // is the button clicked
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbB1:
                if (checked) {
                    if (myGame.pictureCompare(1)) {
                        newScore+= myGame.addScore();
                        // tvScore.setText(newScore.toString());

                    }
                }
                break;
            case R.id.rbB2:
                if (checked) {
                    if (myGame.pictureCompare(2))
                        newScore += myGame.addScore();
                }
                break;
            case R.id.rbB3:
                if (checked) {
                    if (myGame.pictureCompare(3))
                        newScore += myGame.addScore();
                }
                break;
            case R.id.rbB4:
                if (checked) {
                    if (myGame.pictureCompare(4))
                        newScore += myGame.addScore();
                }
                break;
        }

        }



    private void setTimer(Timer timer) {
    }

    @Override
    public void onClick(View view) {


        if (counter < size - 1) {
            counter++;

            ivPicture.setImageResource(arrGameModel[counter].getPicture1());
            //ivPicture.setImageResource(R.drawable.turtle11);
            rbB1.setChecked(false);
            rbB1.setText(arrTextRB[counter].getText1());
            rbB2.setChecked(false);
            rbB2.setText(arrTextRB[counter].getText2());
            rbB3.setChecked(false);
            rbB3.setText(arrTextRB[counter].getText3());
            rbB4.setChecked(false);
            rbB4.setText(arrTextRB[counter].getText4());
            running = false;
        }
        else {
            counter = 0; // add intent to profile activity

            Intent intent = new Intent(level11Activity.this, YourProfileActivity.class);
            startActivity(intent);
        }

    }



    private <elapsedTime> void runTimerForGame(final int duration) {
        final TextView timeView = (TextView) findViewById(R.id.tvTimer);
        final LocalDateTime startTime = LocalDateTime.now();

        gameHandler = new Handler();
        // we are demanding to start the Timer ASAP by using Method post !!! of Handler
        gameHandler.post
                (new Runnable() {
                    @Override
                    public void run() {
                        int minutes = (seconds % 3600) / 60;
                        int secs = seconds % 60;
                        String time = String.format(Locale.getDefault(),"%02d:%02d",minutes, secs);
                        timeView.setText(time);
                        // here is the activity state , we will get running in the following  cases : when onStart, onResume and Start button
                        //  ifFinished();
                        if (running && seconds < duration) {
                            final LocalDateTime currentTime = LocalDateTime.now();
//                            final elapsedTime = LocalDateTime.now() - startTime;
                        } else if (seconds == duration)
                            stopRunning();
                        gameHandler.postDelayed(this, 1000);  // we are demanding to resume the Timer in 1000 millisecs
                    }

                    private void stopRunning() {
                        running = false;
                    }
                });
    }

    // Alert Dialog created in code
    private void showAlertDialog() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Are you ready to play?");
        alertDialog.setMessage("Please click one of the buttons");
        alertDialog.setIcon(R.drawable.apppp);
        alertDialog.setCancelable(true);

        // Buttons Building
        // in case clicked YES
        // remove from list
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(level11Activity.this, "Lets start!", Toast.LENGTH_SHORT).show();
                running = true;
                seconds = 0;
                runTimerForGame(30);
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(level11Activity.this, "You Clicked No", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        AlertDialog dialog = alertDialog.create();
        dialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
     public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.yourprofile) {
            Intent intent = new Intent(this, YourProfileActivity.class);
            startActivity(intent);
        }
        if (id == R.id.instructions) {
            Intent intent = new Intent(this, instructions.class);
            startActivity(intent);
        }
        if (id == R.id.share){
            Intent intent = new Intent(this, ShareActivity.class);
            startActivity(intent);
        }

        if (id == R.id.exit){

        }
        return true;
    }




}

