package com.example.preethamchandra.harrypotter1;

import android.content.Intent;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.hardware.Sensor;

import android.speech.RecognizerIntent;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int portNumber = 4444;
    final String hostName = "10.6.3.82";
    //final String hostName = "10.6.4.247";


    private final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView display;
    private Button btn;
    String spell = "happy";
    private Button btnok;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);
        btn = (Button) findViewById(R.id.btn1);
        btnok = (Button) findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptSpeechListner();
            }
        });


        //try{
        btnok.setOnClickListener(new View.OnClickListener() {

            //Socket kkSocket = new Socket(hostName,portNumber);

            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        //your code here
                        try {
                            Socket kkSocket = new Socket(hostName, portNumber);
                            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                            BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));

                            String fromServer, fromUser;

                            /*
                            while ((fromServer = in.readLine()) != null) {
                                System.out.println("Server: " + fromServer);
                                if (fromServer.equals("sleep"))
                                    break;

                                fromUser = display.getText().toString();
                                if (!(fromUser.equals(fromServer))) {
                                    System.out.println("Client: " + fromUser);
                                    out.println(fromUser);
                                }
                            }
                            */

                            /*
                            try {
                                fromServer = in.readLine();
                                System.out.println("Server: " + fromServer);
                                fromUser = display.getText().toString();
                                System.out.println("Client: " + fromUser);
                                out.println(fromUser);
                            }catch (IOException x){
                                x.printStackTrace();
                                Toast.makeText(MainActivity.this, "Error " + x, Toast.LENGTH_SHORT).show();
                            }
                            */


                            while ((fromServer = in.readLine()) != null) {
                                System.out.println("Server: " + fromServer);
                                if (fromServer.equals("Bye."))
                                    break;

                                fromUser = display.getText().toString();
                                if (fromUser != null) {
                                    System.out.println("Client: " + fromUser);
                                    out.println(fromUser);
                                }
                            }



                        } catch (IOException x) {
                            x.printStackTrace();
                            Toast.makeText(MainActivity.this, "Error" + x, Toast.LENGTH_SHORT).show();
                        }


                    }
                }.start();
            }
        });
    }

    private void promptSpeechListner() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
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
                    display.setText(result.get(0));
                    spell = (result.get(0));
                }
                break;
            }

        }
    }
}

                    /*
                    try {
                        Socket kkSocket = new Socket(hostName, portNumber);
                        PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));

                        String fromServer,fromUser;

                        while ((fromServer = in.readLine()) != null) {
                            System.out.println("Server: " + fromServer);
                            if (fromServer.equals("Bye."))
                                break;

                            fromUser = display.getText().toString();
                            if (fromUser != null) {
                                System.out.println("Client: " + fromUser);
                                out.println(fromUser);
                            }
                        }
                    }catch (IOException x){
                        x.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
                */
//});
/*
        }catch (Exception x){
            x.printStackTrace();
            Toast.makeText(MainActivity.this, "Error" + x, Toast.LENGTH_SHORT).show();
        }
*/
        /*
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();

                try {
                    Socket kkSocket = new Socket(hostName, portNumber);
                    PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));

                    String fromServer,fromUser;

                    while ((fromServer = in.readLine()) != null) {
                        System.out.println("Server: " + fromServer);
                        if (fromServer.equals("Bye."))
                            break;

                        fromUser = display.getText().toString();
                        if (fromUser != null) {
                            System.out.println("Client: " + fromUser);
                            out.println(fromUser);
                        }
                    }
                }catch (IOException x){
                    x.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
        */
        /*
        //try{
        //final Socket socket = new Socket("10.6.4.247", 8000);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataOutputStream DOS = null;
                try {
                    Socket socket = new Socket("10.6.4.247", 8000);
                    DOS = new DataOutputStream(socket.getOutputStream());
                    DOS.writeUTF(spell);
                    Toast.makeText(MainActivity.this, "Sent spell to server", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error 1", Toast.LENGTH_SHORT).show();
                }
            }
        });
        *///}

/*
        }catch (IOException x){
            x.printStackTrace();
            Toast.makeText(MainActivity.this, "Error 2", Toast.LENGTH_SHORT).show();
        }
        */
