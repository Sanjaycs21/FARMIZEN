package com.example.farmizen;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    MediaPlayer mPlayer;
    private ImageView arrow;
    private ImageView apple;
    private ImageView pineapple;
    private ImageView orange;
    private ImageView tomato;
    private ImageView carrot;
    private ImageView onion;
    private ImageView ricestar;
    private ImageView atari;
    private ImageView spearhead;
    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        arrow = findViewById(R.id.arrow);
        apple=findViewById(R.id.apple);
        pineapple=findViewById(R.id.pineapple);
        orange=findViewById(R.id.orange);
        tomato=findViewById(R.id.tomato);
        carrot=findViewById(R.id.carrot);
        onion=findViewById(R.id.onion);
        ricestar=findViewById(R.id.ricestar);
        atari=findViewById(R.id.atari);
        spearhead=findViewById(R.id.spearhead);
        play = findViewById(R.id.ps);
        mPlayer = MediaPlayer.create(this, R.raw.voice);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        play.setOnClickListener(view -> {
            if(mPlayer.isPlaying()){
                Toast.makeText(this, "Already Playing", Toast.LENGTH_SHORT).show();
                return;
            }
            mPlayer.start();
        });

        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle("Small Information")
                .setMessage("4ஜி,5ஜின்னு எத்தனை ஜி வந்தாலும் நமக்கு கஞ்சி ஊத்தப்போறது விவசாயி தான்.")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create();
        alert.show();
        arrow.setOnClickListener(view -> {
            finish();
        });
        View.OnClickListener listener = view -> {
            startActivity(new Intent(MainActivity5.this, MainActivity6.class));
            finish();
        };
        apple.setOnClickListener(listener);
        pineapple.setOnClickListener(listener);
        orange.setOnClickListener(listener);
        tomato.setOnClickListener(listener);
        carrot.setOnClickListener(listener);
        onion.setOnClickListener(listener);
        ricestar.setOnClickListener(listener);
        atari.setOnClickListener(listener);
        spearhead.setOnClickListener(listener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayer.pause();
    }
}