package com.example.dell.footballcounter;

import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    private boolean isStart;
    public MediaPlayer media;
    int goalManU = 0, foulManU = 0, onTargetManU = 0, offTargetManU = 0, cornerManu = 0, offsideManU = 0, yellowCardManU = 0, redCardManU = 0, goalKickManU = 0;
    int goalRealMadrid = 0, foulRealMadrid = 0, onTargetRealMadrid = 0, offTargetRealMadrid = 0, cornerRealMadrid = 0, offsideRealMadrid = 0, yellowCardRealMadrid = 0, redCardRealMadrid = 0, goalKickRealMadrid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronometer);
        start();
//        chronometer.setBase(SystemClock.elapsedRealtime());
//        chronometer.start();
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                chronometer = chronometerChanged;
            }
        });

        Button goalManU_Btn = findViewById(R.id.goalManu_Btn);
        goalManU_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                goal();
                goalManU += 1;
                displayManU(goalManU, foulManU, onTargetManU, offTargetManU, cornerManu, offsideManU, yellowCardManU, redCardManU, goalKickManU);
            }
        });
        Button foulManU_Btn = findViewById(R.id.foulManU_Btn);
        foulManU_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                foulManU += 1;
                displayManU(goalManU, foulManU, onTargetManU, offTargetManU, cornerManu, offsideManU, yellowCardManU, redCardManU, goalKickManU);
            }
        });
        Button onManU_Btn = findViewById(R.id.onManU_Btn);
        onManU_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTargetManU += 1;
                displayManU(goalManU, foulManU, onTargetManU, offTargetManU, cornerManu, offsideManU, yellowCardManU, redCardManU, goalKickManU);
            }
        });
        Button offManU_Btn = findViewById(R.id.offManU_Btn);
        offManU_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offtarget();
                offTargetManU += 1;
                displayManU(goalManU, foulManU, onTargetManU, offTargetManU, cornerManu, offsideManU, yellowCardManU, redCardManU, goalKickManU);
            }
        });
        Button cornerManU_Btn = findViewById(R.id.cornerManU_Btn);
        cornerManU_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                cornerManu += 1;
                displayManU(goalManU, foulManU, onTargetManU, offTargetManU, cornerManu, offsideManU, yellowCardManU, redCardManU, goalKickManU);
            }
        });
        Button offsideManU_Btn = findViewById(R.id.offsideManU_Btn);
        offsideManU_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                offside();
                offsideManU += 1;
                displayManU(goalManU, foulManU, onTargetManU, offTargetManU, cornerManu, offsideManU, yellowCardManU, redCardManU, goalKickManU);
            }
        });
        Button yellowCardManU_Btn = findViewById(R.id.yellowCardManU_Btn);
        yellowCardManU_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                yellow();
                yellowCardManU += 1;
                displayManU(goalManU, foulManU, onTargetManU, offTargetManU, cornerManu, offsideManU, yellowCardManU, redCardManU, goalKickManU);
            }
        });
        Button redCardManU_Btn = findViewById(R.id.redCardManU_Btn);
        redCardManU_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                red();
                redCardManU += 1;
                displayManU(goalManU, foulManU, onTargetManU, offTargetManU, cornerManu, offsideManU, yellowCardManU, redCardManU, goalKickManU);
            }
        });
        Button goalKickManU_Btn = findViewById(R.id.goalKickManU_Btn);
        goalKickManU_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                goalKickManU += 1;
                displayManU(goalManU, foulManU, onTargetManU, offTargetManU, cornerManu, offsideManU, yellowCardManU, redCardManU, goalKickManU);
            }
        });
//        Button reset_Btn = findViewById(R.id.reset_Btn);
//        reset_Btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                whistle();
//                goalManU = 0;
//                foulManU = 0;
//                onTargetManU = 0;
//                offTargetManU = 0;
//                cornerManu = 0;
//                offsideManU = 0;
//                yellowCardManU = 0;
//                redCardManU = 0;
//                goalKickManU = 0;
//                goalRealMadrid = 0;
//                foulRealMadrid = 0;
//                onTargetRealMadrid = 0;
//                offTargetRealMadrid = 0;
//                cornerRealMadrid = 0;
//                offsideRealMadrid = 0;
//                yellowCardRealMadrid = 0;
//                redCardRealMadrid = 0;
//                goalKickRealMadrid = 0;
//
//                displayManU(goalManU, foulManU, onTargetManU, offTargetManU, cornerManu, offsideManU, yellowCardManU, redCardManU, goalKickManU);
//                displayRealMadrid(goalRealMadrid, foulRealMadrid, onTargetRealMadrid, offTargetRealMadrid, cornerRealMadrid, offsideRealMadrid, yellowCardRealMadrid, redCardRealMadrid, goalKickRealMadrid);
//
//            }
//        });
        /**
         * Real Madrid Buttons
         */
        Button goalRealMadrid_Btn = findViewById(R.id.goalRealMadrid_Btn);
        goalRealMadrid_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                goal();
                goalRealMadrid += 1;
                displayRealMadrid(goalRealMadrid, foulRealMadrid, onTargetRealMadrid, offTargetRealMadrid, cornerRealMadrid, offsideRealMadrid, yellowCardRealMadrid, redCardRealMadrid, goalKickRealMadrid);
            }
        });
        Button foulRealMadrid_Btn = findViewById(R.id.foulRealMadrid_Btn);
        foulRealMadrid_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                foulRealMadrid += 1;
                displayRealMadrid(goalRealMadrid, foulRealMadrid, onTargetRealMadrid, offTargetRealMadrid, cornerRealMadrid, offsideRealMadrid, yellowCardRealMadrid, redCardRealMadrid, goalKickRealMadrid);
            }
        });
        Button onRealMadrid_Btn = findViewById(R.id.onRealMadrid_Btn);
        onRealMadrid_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTargetRealMadrid += 1;
                displayRealMadrid(goalRealMadrid, foulRealMadrid, onTargetRealMadrid, offTargetRealMadrid, cornerRealMadrid, offsideRealMadrid, yellowCardRealMadrid, redCardRealMadrid, goalKickRealMadrid);
            }
        });
        Button offRealMadrid_Btn = findViewById(R.id.offRealMadrid_Btn);
        offRealMadrid_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offtarget();
                offTargetRealMadrid += 1;
                displayRealMadrid(goalRealMadrid, foulRealMadrid, onTargetRealMadrid, offTargetRealMadrid, cornerRealMadrid, offsideRealMadrid, yellowCardRealMadrid, redCardRealMadrid, goalKickRealMadrid);
            }
        });
        Button cornerRealMadrid_Btn = findViewById(R.id.cornerRealMadrid_Btn);
        cornerRealMadrid_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                cornerRealMadrid += 1;
                displayRealMadrid(goalRealMadrid, foulRealMadrid, onTargetRealMadrid, offTargetRealMadrid, cornerRealMadrid, offsideRealMadrid, yellowCardRealMadrid, redCardRealMadrid, goalKickRealMadrid);
            }
        });
        Button offsideRealMadrid_Btn = findViewById(R.id.offsideRealMadrid_Btn);
        offsideRealMadrid_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                offside();
                offsideRealMadrid += 1;
                displayRealMadrid(goalRealMadrid, foulRealMadrid, onTargetRealMadrid, offTargetRealMadrid, cornerRealMadrid, offsideRealMadrid, yellowCardRealMadrid, redCardRealMadrid, goalKickRealMadrid);
            }
        });
        Button yellowCardRealMadrid_Btn = findViewById(R.id.yellowCardRealMadrid_Btn);
        yellowCardRealMadrid_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                yellow();
                yellowCardRealMadrid += 1;
                displayRealMadrid(goalRealMadrid, foulRealMadrid, onTargetRealMadrid, offTargetRealMadrid, cornerRealMadrid, offsideRealMadrid, yellowCardRealMadrid, redCardRealMadrid, goalKickRealMadrid);
            }
        });
        Button redCardRealMadrid_Btn = findViewById(R.id.redCardRealMadrid_Btn);
        redCardRealMadrid_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                red();
                redCardRealMadrid += 1;
                displayRealMadrid(goalRealMadrid, foulRealMadrid, onTargetRealMadrid, offTargetRealMadrid, cornerRealMadrid, offsideRealMadrid, yellowCardRealMadrid, redCardRealMadrid, goalKickRealMadrid);
            }
        });
        Button goalKickRealMadrid_Btn = findViewById(R.id.goalKickRealMadrid_Btn);
        goalKickRealMadrid_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle();
                goalKickRealMadrid += 1;
                displayRealMadrid(goalRealMadrid, foulRealMadrid, onTargetRealMadrid, offTargetRealMadrid, cornerRealMadrid, offsideRealMadrid, yellowCardRealMadrid, redCardRealMadrid, goalKickRealMadrid);
            }
        });

    }

    /**
     * This Method handles the sound
     */
    public void start() {
        media = MediaPlayer.create(getApplicationContext(), R.raw.start);
        media.start();

    }

    public void offside() {
        media = MediaPlayer.create(getApplicationContext(), R.raw.offside);
        media.start();

    }
    public void endOfFirstHalf() {
        media = MediaPlayer.create(getApplicationContext(), R.raw.endoffirst);
        media.start();

    }
    public void secondHalfBeging() {
        media = MediaPlayer.create(getApplicationContext(), R.raw.second);
        media.start();

    }
    public void yellow() {
        media = MediaPlayer.create(getApplicationContext(), R.raw.yellow);
        media.start();

    }
    public void red() {
        media = MediaPlayer.create(getApplicationContext(), R.raw.red);
        media.start();

    }

    public void whistle() {
        media = MediaPlayer.create(getApplicationContext(), R.raw.whistle);
        media.start();

    }

    public void offtarget() {
        media = MediaPlayer.create(getApplicationContext(), R.raw.target);
        media.start();

    }

    public void goal() {
        int[] goalSounds = {R.raw.fantastic, R.raw.tempo, R.raw.good, R.raw.magnificent, R.raw.right, R.raw.top, R.raw.twoplayers};
        Random sounds = new Random();
        int l = 0, h = goalSounds.length;
        int rndm = sounds.nextInt(h - l) + l;
        media = MediaPlayer.create(getApplicationContext(), goalSounds[rndm]);
        media.start();

    }

    public void displayManU(int countManU, int foulManU, int ontargetmanu, int offtargetmanu, int cornermanu, int offsidemanu, int yellowcardmanu,
                            int redcardmanu, int goalkickmanu) {
        TextView goalCount = findViewById(R.id.goalManU_txt);
        goalCount.setText("" + countManU);
        TextView foulCount = findViewById(R.id.foulManU);
        foulCount.setText("" + foulManU);
        TextView ontargetmanucount = findViewById(R.id.onManU_txt);
        ontargetmanucount.setText(("" + ontargetmanu));
        TextView offtargetmanucount = findViewById(R.id.offManU_txt);
        offtargetmanucount.setText(("" + offtargetmanu));
        TextView cornermanucount = findViewById(R.id.cornerManU_txt);
        cornermanucount.setText(("" + cornermanu));
        TextView offsidemanucount = findViewById(R.id.offsideManU);
        offsidemanucount.setText(("" + offsidemanu));
        TextView yellowcardmanucount = findViewById(R.id.yellowCardManU);
        yellowcardmanucount.setText(("" + yellowcardmanu));
        TextView redcardmanucount = findViewById(R.id.redCardManU);
        redcardmanucount.setText(("" + redcardmanu));
        TextView goalkickmanucount = findViewById(R.id.goalKickManU);
        goalkickmanucount.setText(("" + goalkickmanu));

    }

    public void displayRealMadrid(int countRealMadrid, int foulRealMadrid, int ontargetrealmadrid, int offtargetrealmadrid, int cornerrealmadrid, int offsiderealmadrid, int yellowcardrealmadrid,
                                  int redcardrealmadrid, int goalkickmanu) {
        TextView goalCountr = findViewById(R.id.goalRealMadrid_txt);
        goalCountr.setText("" + countRealMadrid);
        TextView foulCountr = findViewById(R.id.foulRealMadrid);
        foulCountr.setText("" + foulRealMadrid);
        TextView ontargetrealmadridcount = findViewById(R.id.onReal_txt);
        ontargetrealmadridcount.setText(("" + ontargetrealmadrid));
        TextView offtargetrealmadridcount = findViewById(R.id.offReal_txt);
        offtargetrealmadridcount.setText(("" + offtargetrealmadrid));
        TextView cornerrealmadridcount = findViewById(R.id.cornerRealMadrid_txt);
        cornerrealmadridcount.setText(("" + cornerrealmadrid));
        TextView offsiderealmadridcount = findViewById(R.id.offsideRealMadrid);
        offsiderealmadridcount.setText(("" + offsiderealmadrid));
        TextView yellowcardrealmadridcount = findViewById(R.id.yellowCardRealMadrid);
        yellowcardrealmadridcount.setText(("" + yellowcardrealmadrid));
        TextView redcardrealmadridcount = findViewById(R.id.redCardRealMadrid);
        redcardrealmadridcount.setText(("" + redcardrealmadrid));
        TextView goalkickmanucount = findViewById(R.id.goalKickRealMadrid);
        goalkickmanucount.setText(("" + goalkickmanu));

    }

    public void start(View view) {
        if (isStart) {
            chronometer.stop();

            isStart = false;
            ((Button) view).setText("1st Half End");
            ((Button) view).setEnabled(false);
            Button secondhalf = findViewById(R.id.start_second);
            secondhalf.setEnabled(true);
            TextView half = findViewById(R.id.half);
            half.setText("1st Half End");
            LinearLayout man = findViewById(R.id.man);
            man.setVisibility(View.INVISIBLE);
            LinearLayout real = findViewById(R.id.real);
            real.setVisibility(View.INVISIBLE);
            whistle();
            endOfFirstHalf();
        } else {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            isStart = true;
            LinearLayout man = findViewById(R.id.man);
            man.setVisibility(View.VISIBLE);
            LinearLayout real = findViewById(R.id.real);
            real.setVisibility(View.VISIBLE);
            ((Button) view).setText("Stop 1st Half");
            whistle();

        }

    }

    public void second(View view) {
        if (isStart) {
            chronometer.stop();
            isStart = false;
            ((Button) view).setText("2nd Half End");
            ((Button) view).setEnabled(false);
            TextView half = findViewById(R.id.half);
            half.setText("Match Ended");
            LinearLayout man = findViewById(R.id.man);
            man.setVisibility(View.GONE);
            LinearLayout real = findViewById(R.id.real);
            real.setVisibility(View.GONE);
            whistle();
        } else {
            TextView half = findViewById(R.id.half);
            half.setText("2nd Half");
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            isStart = true;
            LinearLayout man = findViewById(R.id.man);
            man.setVisibility(View.VISIBLE);
            LinearLayout real = findViewById(R.id.real);
            real.setVisibility(View.VISIBLE);
            ((Button) view).setText("Stop 2nd Half");
            whistle();
            secondHalfBeging();

        }
    }
}
