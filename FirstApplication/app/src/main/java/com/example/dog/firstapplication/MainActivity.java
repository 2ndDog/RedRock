package com.example.dog.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;


public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    private Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) this.findViewById(R.id.button2);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == button) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SecondActivity.class);
            MainActivity.this.startActivity(intent);
        }
    }
}