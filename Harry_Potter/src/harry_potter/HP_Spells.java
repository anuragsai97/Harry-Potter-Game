/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harry_potter;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ANURAG
 */
public class HP_Spells extends Application {
    
    @Override
    public void start(Stage theStage) 
    {
        theStage.setTitle( "AnimatedImage Example" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 512, 512 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        
        Image spell = new Image( "/harry_potter/Movement/spell.png" );
        Sprite harry_potter = new Sprite();
        Sprite spell2 =new Sprite();
        harry_potter.setPosition(200, 200);
        
        AnimatedImage ufo = new AnimatedImage();
        Image[] imageArray = new Image[13];
        for (int i = 0; i < 13; i++)
            imageArray[i] = new Image( "/harry_potter/Spells/sp" + (i+1) + ".png" );
        ufo.frames = imageArray;
        ufo.duration = 0.100;

        final long startNanoTime = System.nanoTime();
     
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                
                double x = 210 -210 * (t-0.7);//128 * Math.cos(t);
                double y = 210;// + 128 * Math.sin(t);
                //gc.drawImage( spell, x, y );
                spell2.setImage(spell);
                spell2.setPosition(x, y);
                spell2.addVelocity(10, 10);
                spell2.setVelocity(x, y);
                harry_potter.setImage(ufo.getFrame(t));
                gc.clearRect(0, 0, 512, 512);
                harry_potter.render(gc);
                spell2.render(gc);
            }
            
        }.start();
        
        theStage.show();
    
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
