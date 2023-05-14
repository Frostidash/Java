package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText login = findViewById(R.id.login);
        EditText pass = findViewById(R.id.password);
        Button button = findViewById(R.id.enter);
        Button button2 = findViewById(R.id.create);
        Listener listener = new Listener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = login.getText().toString();
                String b = pass.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);


            }
        });


    }
}

class Listener implements View.OnClickListener {
    Context context;

    public Listener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        String text = ((Button) v).getText().toString();
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}