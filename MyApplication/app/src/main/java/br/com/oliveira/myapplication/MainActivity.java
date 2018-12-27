package br.com.oliveira.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btMario;
    private Button btLuigi;
    private Button btToad;
    private Button btBowser;
    private Button btWario;
    private Button btYoshi;
    private Button btPeach;
    private Button btDK;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btMario = findViewById(R.id.bt_Mario);

        btMario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.mario);
                Toast.makeText(
                        getBaseContext(),
                        "Mario",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btLuigi = findViewById(R.id.bt_Luigi);

        btLuigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.luigi);
                Toast.makeText(
                        getBaseContext(),
                        "Luigi",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btToad = findViewById(R.id.bt_Toad);

        btToad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.toad);
                Toast.makeText(
                        getBaseContext(),
                        "Toad",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btWario = findViewById(R.id.bt_Wario);

        btWario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.wario);
                Toast.makeText(
                        getBaseContext(),
                        "Wario",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btYoshi = findViewById(R.id.bT_Yoshi);

        btYoshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.yoshi);
                Toast.makeText(
                        getBaseContext(),
                        "Yoshi",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btPeach = findViewById(R.id.bt_Peach);

        btPeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.peach);
                Toast.makeText(
                        getBaseContext(),
                        "Peach",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btDK = findViewById(R.id.bt_DK);

        btDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.dk);
                Toast.makeText(
                        getBaseContext(),
                        "DONKEY KONG",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btBowser = findViewById(R.id.bt_Bowser);

        btBowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.bowse);
                Toast.makeText(
                        getBaseContext(),
                        "Bowser",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }//fecha oncreate


    public void play(int som){
        try{
            mp = MediaPlayer.create(this,som);
            mp.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}//classe
