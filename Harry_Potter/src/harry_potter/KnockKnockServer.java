package harry_potter;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KnockKnockServer implements Runnable {
    
    
    static String s;
    ArrayList<String> kks = new ArrayList<String>(); 
    //Thread kks;
   // public KnockKnockServer(){
     //   Thread kks = new Thread(this);
     //   kks.start();
   // }
    public  void go() throws IOException {
        
        
        
        
        
    	String inputCompare ="";
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.out.println("error:"+e);
           // System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            //System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                clientSocket.getInputStream()));
        String inputLine, outputLine;
        KnockKnockProtocol kkp = new KnockKnockProtocol();
        
        outputLine = kkp.processInput(null);
        out.println(outputLine);
        
        outputLine = "recieving";
        while ((inputLine = in.readLine()) != null) {
             outputLine = kkp.processInput(inputLine);
        	
             out.println(outputLine);
             if(!inputCompare.equals(inputLine)){
                  s=inputLine;
            	 System.out.println("Recieved " + s);
                 listen();
                inputCompare = inputLine;
             }
             //kks.clear();
             
             /*
             if (outputLine.equals("stop"))
                break;
            */
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    public ArrayList<String> getstring()
    {
        return kks;
    }
    
    

    @Override
    public void run() {
        System.out.println("f");
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //KnockKnockServer kk=new KnockKnockServer();
            //kks=new Thread(kk);
            go();
            
        } catch (IOException ex) {
            Logger.getLogger(KnockKnockServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void listen()
    {
        if(!(kks.contains(s))){
        kks.clear();
        kks.add(s);
               // System.out.println("hey"); 
           }
    }
    
    }
    
    



