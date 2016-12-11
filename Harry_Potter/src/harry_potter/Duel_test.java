/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harry_potter;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Amritanshu
 */
public class Duel_test extends Application {
    
    @Override
    public void start(Stage theStage) {
       
        
        Group root = new Group();
        Scene theScene = new Scene( root,1366, 768 );
        Canvas canvas = new Canvas( 1366, 768 );
        root.getChildren().add( canvas );
        theStage.setTitle("Hello World!");
        theStage.setScene(theScene);
        
        
        ArrayList<String> input = new ArrayList<String>();
         ArrayList<String> in = new ArrayList<String>();

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
        
        LongValue lastNanoTime = new LongValue( System.nanoTime() );    

        Sprite s1 = new Sprite();                      //s1 is a person
        s1.setPosition(200, 300);
        s1.setImage("/harry_potter/Movement/r1.png");
        
        Sprite s2 = new Sprite();                      //s2 is another person
        s2.setPosition(1100, 300);
        s2.setImage("/harry_potter/Movement/l1.png");
        
        Sprite spell1 = new Sprite();       //Sprite for spells cast by s1
        Sprite spell2 = new Sprite();       //Sprite for spells cast by s2
        
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
                // game logic sample. I'm using space for input for s1 and shift as input for s2. Change it if you want voice.
                if (input.contains("SPACE")){
                    in.add("SPACE");
                    spell1.setPosition(s1.getXPosition()-10, s1.getYPosition()-10);
                    s1.setImage("/harry_potter/Spells/PersonFacingRight.gif");
                    spell1.setImage("/harry_potter/Spells/Lumos.gif");
                    spell1.setVelocity(150, 0);
                } 
                if (input.contains("SHIFT")){
                    in.add("SHIFT");
                    spell2.setPosition(s2.getXPosition()-10, s2.getYPosition()-10);
                    s2.setImage("/harry_potter/Spells/PersonFacingLeft.gif");
                    spell2.setImage("/harry_potter/Spells/Lumos.gif");
                    spell2.setVelocity(-150, 0);
                }  
                s1.update(elapsedTime);
                s2.update(elapsedTime);
                spell1.update(elapsedTime);
                spell2.update(elapsedTime);
                // you may use the code below for collision detection between 2 spells. You may or may not use the arraylist but logic is same.
                Sprite sp = new Sprite();
                if ( spell1.intersects(spell2))
                {
                    sp.setImage("/harry_potter/Spells/Explosion.gif");
                    sp.setPosition(spell1.getXPosition(), 300);
                    sp.update(elapsedTime);   
                }
                if(spell2.intersects(spell1))
                {
                    sp.setImage("/harry_potter/Spells/Explosion.gif");
                    sp.setPosition(spell2.getXPosition(), 300);
                    sp.update(elapsedTime);
                }
               //When the 2 spells collide with each other, they should stop . There is some logical error in code for collision. see if you can rectify it.
                // render
           
                gc.clearRect(0, 0, 1366,768);
                s1.render(gc);
                s2.render(gc);
                
                if(spell2.getXPosition()-spell1.getXPosition()>=0){                    
                    spell1.render(gc);
                    spell2.render(gc);                  
                }
                
                /*if((spell2.getXPosition()-spell1.getXPosition()<0)&&(input.contains("SPACE"))||(input.contains("SHIFT"))){
                    spell1.setPosition(s1.getXPosition()-10, s1.getYPosition()-10);     
                    
                }
                
                if((spell2.getXPosition()-spell1.getXPosition()<0)&&(input.contains("SHIFT"))){                
                }*/
                   
                
                //else
                sp.render(gc);
                
                
               
               
            }
        }.start();
        
        theStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
