/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harry_potter;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.util.Scanner;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author ANURAG
 */
public class Test extends Application implements Runnable{
    
    user pl;
    
    /*Test(Player p)
    {
        this.p=p;
        
        p.getName();
    }*/
    
    int count=0;
    ArrayList<String> d;
    //tlevel1 t=new tlevel1();
    ArrayList<String> kks_t = new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    KnockKnockServer k=new KnockKnockServer();
   // Test t=new Test();
   // Thread test = new Thread(t);
    //Training tr=new Training();
    int i=0;
    String s;
     public static void main(String[] args) 
    {
        //IntroVideo.launch(args);
        launch(args);
    }

    @Override
    public void start(Stage theStage) 
    {
       

        theStage.setTitle( "Harry Potter" );

        Group root = new Group();
        Scene theScene = new Scene( root,800, 600 );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 1366, 768 );
        root.getChildren().add( canvas );

        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> in=new ArrayList<>();

        theScene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    
                    String code = e.getCode().toString();
                    
                    if ( !input.contains(code) )
                        input.add( code );
                    }
                
            });
        
        
                Thread th=new Thread(k);
                th.start();
                while(kks_t.size()==0){
                    kks_t = k.getstring();
                   // System.out.println(kks_t);
                }
               // test.start();
                //while(kks_t.size()==0){
                //for(int i=0;i<2;i++){
               /* if(k.getstring().size()!=0){
                    
                    System.out.println(k.getstring());
                    kks_t = k.getstring();
                  // System.out.println(kks_t);
                }
              //  */
                
               //kks_t.add("reducto");
               //kks_t.add("Wingardium Leviosa");
                
        

        theScene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    
                    String code = e.getCode().toString();
                    input.remove( code );
                    
                }
            });
               
        GraphicsContext gc = canvas.getGraphicsContext2D();

        
        Sprite harry_potter = new Sprite();
        Sprite spell = new Sprite();
        Sprite text=new Sprite();
        Sprite po=new Sprite();
        
       // po.setPosition(1000, 0);
        Sprite dumbledore=new Sprite();
        Sprite hagrid=new Sprite();
        Sprite balloon=new Sprite();
        Sprite final_balloon=new Sprite();
        
       Media media = new Media(new File("C:\\Users\\PDN SRNIVAS\\Documents\\NetBeansProjects\\Harry_Potter\\src\\harry_potter\\Spell sounds\\leviosa.mp3").toURI().toString());
       MediaPlayer mediaPlayer = new MediaPlayer(media);
       Media media2 = new Media(new File("C:\\Users\\PDN SRNIVAS\\Documents\\NetBeansProjects\\Harry_Potter\\src\\harry_potter\\Harry Potter Theme Song.mp3").toURI().toString());
       MediaPlayer med=new MediaPlayer(media2);
       med.setAutoPlay(true);
       Media media3 = new Media(new File("C:\\Users\\PDN SRNIVAS\\Documents\\NetBeansProjects\\Harry_Potter\\src\\harry_potter\\Spell sounds\\Well done Harry.mp3").toURI().toString());
       MediaPlayer med2=new MediaPlayer(media3);
       
       
        hagrid.setPosition(0,300);
        balloon.setImage("/harry_potter/Introimages/textbaloonL1.png");
        final_balloon.setImage("/harry_potter/Introimages/finalbaloon.png");
        text.setPosition(1100,0);
        dumbledore.setPosition(1000, 150);
        balloon.setPosition(20, 120);
        final_balloon.setPosition(20,120);
         hagrid.setImage("/harry_potter/Introimages/Hagridsprite1.png");
        dumbledore.setImage("/harry_potter/Introimages/Dumbledore.jpg");
         text.setImage("/harry_potter/Introimages/Text_Balloon.png");
        
        harry_potter.setPosition(200, 0);
        harry_potter.setImage("/harry_potter/Movement/d1.png");
       
        
        ArrayList<Sprite> spellsList = new ArrayList<>();   
        
        
        
        for (int i = 0; i < 20; i++)
        {
            Sprite spells = new Sprite();
            spells.setImage("/harry_potter/Movement/spell.png");
            double px = 1000 * Math.random() + 50;
            double py = 1000 * Math.random() + 50;  
            //if((px<=1366)&&(py<=768)){
            spells.setPosition(px,py);
            spellsList.add( spells );
            //}
        }
        
        LongValue lastNanoTime = new LongValue( System.nanoTime() );

        IntValue score = new IntValue(0);
        
        AnimatedImage right = new AnimatedImage();
        Image[] imageArrayr = new Image[2];
        for (int i = 0; i < 2; i++)
            imageArrayr[i] = new Image( "/harry_potter/Movement/r" + (i+1) + ".png" );
        right.frames = imageArrayr;
        right.duration = 0.100;
        
        AnimatedImage left = new AnimatedImage();
        Image[] imageArrayl = new Image[2];
        for (int i = 0; i < 2; i++)
            imageArrayl[i] = new Image( "/harry_potter/Movement/l" + (i+1) + ".png" );
        left.frames = imageArrayl;
        left.duration = 0.100;
        
        AnimatedImage down = new AnimatedImage();
        Image[] imageArrayd = new Image[2];
        for (int i = 0; i < 2; i++)
            imageArrayd[i] = new Image( "/harry_potter/Movement/d" + (i+1) + ".png" );
        down.frames = imageArrayd;
        down.duration = 0.100;
        
        AnimatedImage up = new AnimatedImage();
        Image[] imageArrayu = new Image[2];
        for (int i = 0; i < 2; i++)
            imageArrayu[i] = new Image( "/harry_potter/Movement/u" + (i+1) + ".png" );
        up.frames = imageArrayu;
        up.duration = 0.100;
        
         AnimatedImage spellcast = new AnimatedImage();
        Image[] imageArray = new Image[13];
        for (int i = 0; i < 13; i++)
            imageArray[i] = new Image( "/harry_potter/Spells/sp" + (i+1) + ".png" );
        spellcast.frames = imageArray;
        spellcast.duration = 0.100;
        
        final long startNanoTime = System.nanoTime();
        
        
        
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime) 
            {
                // calculate time since last update.
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                // game logic
                               
                harry_potter.setVelocity(0,0);      
               // input.contains("SPACE");
                //|
               // 
                
                if((kks_t.contains("Wingardium Leviosa")|kks_t.contains("stupefy")||kks_t.contains("reducto"))||kks_t.contains("confringo")||kks_t.contains("stupefied"))
                { 
                    
                    if(in.get(in.size()-1)=="DOWN"){
                        harry_potter.setImage("/harry_potter/Movement/d1.png");
                    }
                    if(in.get(in.size()-1)=="UP"){
                        harry_potter.setImage("/harry_potter/Movement/u1.png");
                    }
                    if(in.get(in.size()-1)=="LEFT"){                      
                        //harry_potter.setImage("/harry_potter/Spells/Spell.gif");
                        
                        if(kks_t.contains("Wingardium Leviosa")||kks_t.contains("Win Guardian Leviosa")){
                            harry_potter.setImage("/harry_potter/Spells/Spell.gif");
                           // med.pause();
                            mediaPlayer.play();
                            
                            kks_t.clear();
                }     
                       // med.play();
                        
                         if(kks_t.contains("stupefy")|kks_t.contains("confringo")|kks_t.contains("reducto")||kks_t.contains("stupefied")){
                         spell.setPosition(harry_potter.getXPosition()-10, harry_potter.getYPosition()-10);
                        harry_potter.setImage("/harry_potter/Spells/Spell.gif");
                         spell.setImage("/harry_potter/Spells/Stupefy.gif");
                         spell.setVelocity(-150, 0);
                      // s=kks_t.get(0);
                       kks_t.clear();
                        i=i+1;
                         //System.out.println("hi");
                if(i==3)
               {
                //System.out.println("heyya");
                   //text balloon popup
              }
                         }
                       //count(s);
                    } 
                    if(in.get(in.size()-1)=="RIGHT"){
                        harry_potter.setImage("/harry_potter/Spells/Spell_flip.gif");
                        
                        if(kks_t.contains("Wingardium Leviosa")||kks_t.contains("Win Guardian Leviosa")){
                             harry_potter.setImage("/harry_potter/Spells/Spell_flip.gif");
                    mediaPlayer.play();
                    kks_t.clear();
                }     
                        
                        if(kks_t.contains("stupefy")|kks_t.contains("confringo")|kks_t.contains("reducto")||kks_t.contains("stupefied")){
                    spell.setPosition(harry_potter.getXPosition()-10, harry_potter.getYPosition()-10);
                    harry_potter.setImage("/harry_potter/Spells/Spell_flip.gif");
                   spell.setImage("/harry_potter/Spells/Stupefy.gif");
                    spell.setVelocity(150, 0);
                    //for(double d=harry_potter.getXPosition(); d>=0; d--)
                   // {
                   //     Thread sp = new Thread();
                   // spell.setPosition(d, harry_potter.getYPosition()-10);
                    //spell.setVelocity(d, 0);
                    //}
                    kks_t.clear();
                }
                }
                       // s=kks_t.get(0);
                        kks_t.clear();
                        //count(s);
                         i=i+1;
                         System.out.println("hi");
                
                        
                   
                
                    }
                    
                
                
                
                
               
                
                if (input.contains("LEFT")){
                    in.add("LEFT");
                    //System.out.println(harry_potter.getXPosition());
                    if(((harry_potter.getXPosition()>=10))){
                        harry_potter.setImage(left.getFrame(t));
                        harry_potter.addVelocity(-150,0);
                    }
                    
                }   
                if (input.contains("RIGHT")){
                    in.add("RIGHT");
                    if(((harry_potter.getXPosition()<=(int)950))){
                        harry_potter.setImage(right.getFrame(t));
                        harry_potter.addVelocity(150,0);
                    }
                }
                if (input.contains("UP")){
                    in.add("UP");
                    if(((harry_potter.getYPosition()>=10))){
                        harry_potter.setImage(up.getFrame(t));
                        harry_potter.addVelocity(0,-150);
                    }
                }
                if (input.contains("DOWN")){
                    in.add("DOWN");
                    if(((harry_potter.getYPosition()<=690))){
                        harry_potter.setImage(down.getFrame(t));
                        harry_potter.addVelocity(0,150);
                    }
                }
                    
                harry_potter.update(elapsedTime);
                spell.update(elapsedTime);
                // collision detection
                
                
                // render
                
                
                gc.clearRect(0, 0, 1366,768);
                harry_potter.render( gc );
                dumbledore.render(gc);
                hagrid.render(gc);
                 //text.render(gc);
                spell.render( gc );
                 
                if(i==3)
                {
                    med2.play();
                    final_balloon.render(gc);
                        //System.out.println("heyya");
                }
                
                
                if(harry_potter.intersects(dumbledore))
                        text.render(gc);
                
                if(harry_potter.getXPosition()==210)
                {
                    System.out.println("hey");
                }
                
                if(harry_potter.intersects(hagrid))
                {
                    balloon.render(gc);
                }
            }
        }.start();

        theStage.show();
       // while(harry_potter.getXPosition()!=1130)
         //       {
                    
                        // text.setImage("/harry_potter/Introimages/Text_Balloon.png");
                        //System.out.println("hi");
                   
           //     }
           
    }
                
    
    public void setdetails(user p)
    {
        //count=count+1;
        pl=p;
        //System.out.println("hi");
        System.out.println(p.name);
    }
    
    public user getdetails()
    {
       // return pl;
        return pl;
    }

    @Override
    public void run() {
        while(kks_t.size()==0){
                    kks_t = k.getstring();
                   System.out.println(kks_t);
                }
    }
}