package com.example.cw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = findViewById(R.id.nextPage);
        final EditText name = findViewById(R.id.name);
        final EditText number = findViewById(R.id.number);
        final EditText email = findViewById(R.id.email);
        final EditText address = findViewById(R.id.address);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,userInfo.class);
                String i1 = name.getText().toString();
                String i2 = number.getText().toString();
                String i3 = email.getText().toString();
                String i4 = address.getText().toString();

                i.putExtra("Info1",i1);
                i.putExtra("Info2",i2);
                i.putExtra("Info3",i3);
                i.putExtra("Info4",i4);
                startActivity(i);
            }
        });
    }
}