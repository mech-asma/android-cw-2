package com.example.cw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class userInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        final Button button1 = findViewById(R.id.call);
        final Button button2 = findViewById(R.id.openGmail);
        final Button button3 = findViewById(R.id.maps);
        TextView t1 = findViewById(R.id.textView2);
        TextView t2 = findViewById(R.id.textView3);
        TextView t3 = findViewById(R.id.textView4);
        TextView t4 = findViewById(R.id.textView5);

        Bundle b = getIntent().getExtras();
        t1.setText(b.getString("Info1"));
        t2.setText(b.getString("Info2"));
        t3.setText(b.getString("Info3"));
        t4.setText(b.getString("Info4"));

        // Intent to open dialer
        Uri u = Uri.parse("tel:" + "info2");
        final Intent callIntent = new Intent(Intent.ACTION_DIAL, u);

        // Action for 1st button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(callIntent);
            }
        });

        // Intent to open gmail
        final Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "This is my subject text");

        // Action for 2nd button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Intent.createChooser(emailIntent, null));
            }
        });
        // Intent to open Maps
        Uri gmIntent = Uri.parse("google.streetview:cbll=46.414382,10.013988");
        final Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmIntent);
        mapIntent.setPackage("com.google.android.apps.maps");

        // Action for 3rd button
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mapIntent);
            }
        });

    }
}