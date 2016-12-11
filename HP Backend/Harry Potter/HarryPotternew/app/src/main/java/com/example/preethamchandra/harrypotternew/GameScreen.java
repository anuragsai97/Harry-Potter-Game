package com.example.preethamchandra.harrypotternew;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by preethamchandra on 09/12/16.
 */


public class GameScreen extends AppCompatActivity{
    
    final int portNumber = 4444;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private String hostName;
    
    private String spell="nothing";
    TextView display;
    Button btnListen;
    
    public boolean connectionStatus = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        Bundle bundle = getIntent().getExtras();
        
        hostName = bundle.getString("serverIP");
        display = (TextView)findViewById(R.id.display);
        btnListen = (Button)findViewById(R.id.btn1);
        
        
        connect.start();
        Toast.makeText(GameScreen.this, "Establishing connection...", Toast.LENGTH_SHORT).show();
        
        
        
        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMethod();
            }
        });
        
        
        
    }
    
    private void btnMethod() {
        try{
            Toast.makeText(GameScreen.this, "Connection " + connectionStatus, Toast.LENGTH_SHORT).show();
            promptSpeechListner();
        }catch (Exception e){
            
        }
    }
    
    private void promptSpeechListner() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                        getString(R.string.speech_prompt));
        
        //extra stuff
        //intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS,200);
        intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS,200);
        //
        
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                           "Device doesn't support this feature",
                           Toast.LENGTH_SHORT).show();
        }
    }
    
    /**
     * Receiving speech input
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    spell = (result.get(0));
                    display.setText(spell);
                    //display.setText(result.get(0));
                }
                break;
            }
                
        }
    }
    
    
    Thread connect = new Thread(){
    @Override
    public void run() {
    try {
    connectionStatus = true;
    Socket kkSocket = new Socket(hostName, portNumber);
    PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
    String fromServer, fromUser;
    //System.out.println("Executed till here");
    while ((fromServer = in.readLine()) != null) {
        System.out.println("Server: " + fromServer);
        if (fromServer.equals("stop"))
            break;
        fromUser = spell;
        if (!fromUser.equals("stop")) {
            System.out.println("Client: " + fromUser);
            out.println(fromUser);
            
        }
    }
    
    
    
} catch (IOException x) {
connectionStatus =false;
x.printStackTrace();
}
catch (Exception e){
connectionStatus =false;
e.printStackTrace();
}


}
};


}
