package com.example.kdm.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    Button b1, b2, b3;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);

        pref = getSharedPreferences("KDM", Context.MODE_PRIVATE);
        editor = pref.edit();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = e1.getText().toString();
                String phone = e2.getText().toString();

                editor.putString("name_key", name);
                editor.putString("phone_key", phone);

                editor.commit();

                b1.setTextColor(Color.WHITE);
                b2.setTextColor(Color.BLACK);
                b3.setTextColor(Color.BLACK);

                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name = pref.getString("name_key", null);
               String phone = pref.getString("phone_key", null);

               b1.setTextColor(Color.BLACK);
               b2.setTextColor(Color.WHITE);
               b3.setTextColor(Color.BLACK);

               Toast.makeText(MainActivity.this, "Name:- "+ name + "\nPhone:- " + phone, Toast.LENGTH_SHORT).show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("name_key");
                editor.remove("phone_key");
                editor.commit();

                b1.setTextColor(Color.BLACK);
                b2.setTextColor(Color.BLACK);
                b3.setTextColor(Color.WHITE);

                Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
