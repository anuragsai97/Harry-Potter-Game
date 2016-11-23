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
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author ANURAG
 */
public class HP_Movement extends Application {
    
     public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage) 
    {
        theStage.setTitle( "Harry Potter" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 512, 512 );
        root.getChildren().add( canvas );

        ArrayList<String> input = new ArrayList<>();

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

        
        Sprite harry_potter = new Sprite();
        
        harry_potter.setPosition(200, 0);
        harry_potter.setImage("/harry_potter/Movement/d1.png");
        
        ArrayList<Sprite> spellsList = new ArrayList<>();
        
        for (int i = 0; i < 15; i++)
        {
            Sprite spells = new Sprite();
            spells.setImage("/harry_potter/Movement/spell.png");
            double px = 350 * Math.random() + 50;
            double py = 350 * Math.random() + 50;          
            spells.setPosition(px,py);
            spellsList.add( spells );
        }
        
        LongValue lastNanoTime = new LongValue( System.nanoTime() );

        IntValue score = new IntValue(0);

        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                // calculate time since last update.
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                
                // game logic
                
                harry_potter.setVelocity(0,0);
                if (input.contains("LEFT")){
                    harry_potter.setImage("/harry_potter/Movement/l1.png");
                    harry_potter.addVelocity(-50,0);
                }   
                if (input.contains("RIGHT")){
                   harry_potter.setImage("/harry_potter/Movement/r1.png");
                    harry_potter.addVelocity(50,0);
                }
                if (input.contains("UP")){
                    harry_potter.setImage("/harry_potter/Movement/u1.png");
                     harry_potter.addVelocity(0,-50);
                }
                if (input.contains("DOWN")){
                    harry_potter.setImage("/harry_potter/Movement/d1.png");
                   harry_potter.addVelocity(0,50);
                }
                    
                harry_potter.update(elapsedTime);
                
                // collision detection
                
                Iterator<Sprite> spellsIter = spellsList.iterator();
                while ( spellsIter.hasNext() )
                {
                    Sprite spells = spellsIter.next();
                    if ( harry_potter.intersects(spells))
                    {
                        spellsIter.remove();
                        score.value++;
                    }
                }
                
                // render
                
                gc.clearRect(0, 0, 512,512);
                harry_potter.render( gc );
                
                for (Sprite spells : spellsList )
                    spells.render( gc );

               
            }
        }.start();

        theStage.show();
    }    
}