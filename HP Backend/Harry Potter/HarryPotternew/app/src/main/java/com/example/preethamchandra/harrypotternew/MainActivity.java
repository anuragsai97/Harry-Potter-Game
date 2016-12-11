package com.example.preethamchandra.harrypotternew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLaunch;
    EditText textIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLaunch = (Button)findViewById(R.id.btnLaunch);
        textIP = (EditText)findViewById(R.id.editText);

        btnLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent game = new Intent(MainActivity.this, GameScreen.class);
                game.putExtra("serverIP", textIP.getText().toString());
                startActivity(game);

            }
        });
    }
}
