package com.example.app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView hello;
    EditText name;
    Button button;
    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = findViewById(R.id.helloLabel);
        name = findViewById(R.id.editText);
        button = findViewById(R.id.button);

    }

    public void clicked(View v) {
        hello.setText("Hello" + name.getText());

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                hello.setText("two seconds later");
            }
        }, 2000);
    }

    public void openNewScreen(View v) {
        Intent intent = new Intent(this, NewScreen.class);
        startActivity(intent);
    }

}
