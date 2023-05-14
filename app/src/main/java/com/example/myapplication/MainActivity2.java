package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = findViewById(R.id.create_r);
        EditText email = findViewById(R.id.email);
        EditText login = findViewById(R.id.login_r);
        EditText pass = findViewById(R.id.password_r);


        SQLiteDatabase myDB = openOrCreateDatabase("Base Data.db", MODE_PRIVATE, null);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = email.getText().toString();
                String b = login.getText().toString();
                String c = pass.getText().toString();
                try {
                    FileOutputStream fos = new FileOutputStream("Context.txt");
                    byte[] buffer = a.getBytes();
                    byte[] buffer2 = b.getBytes();
                    byte[] buffer3 = c.getBytes();


                    fos.write(buffer, 0, buffer.length);
                    System.out.println("The file has been written");
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                //ContentValues row1 = new ContentValues();
                //row1.put("email", a);
                //row1.put("login", b);
                //row1.put("password", c);
                // myDB.insert("Users",null,row1);

                Toast.makeText(getApplicationContext(), a, Toast.LENGTH_LONG).show();

                if (!(a.equals("")) && !(b.equals("")) && !(c.equals(""))) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                }


            }
        });
        myDB.close();


    }
}