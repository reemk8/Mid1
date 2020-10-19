package com.example.mid1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ImageView hourse;
    Button btn_activity2,btn_activity3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hourse = (ImageView) findViewById(R.id.animal);
        hourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(MainActivity.this,R.raw.horse);
                mp.start();
            }
        });

        btn_activity2 = (Button)findViewById(R.id.btn_activity2);
        btn_activity3 = (Button)findViewById(R.id.btn_activity3);


        btn_activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Activity2.class);
                startActivity(intent);
            }
        });
        btn_activity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,activity_3.class);
                startActivity(intent);
            }
        });
    }
}
