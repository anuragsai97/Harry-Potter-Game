package harry_potter;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
/**
 *
 * @author ANURAG
 */
public class IntroVideo extends Application {
 
 /**
  * @param args the command line arguments
  */
 public static void main(String[] args) {
     launch(args);
 }
 
 @Override
 public void start(Stage theStage) {
     
    Media media = new Media(new File("C:/Users/PDN SRNIVAS/Documents/NetBeansProjects/Harry_Potter/src/harry_potter/Intro Video.mp4").toURI().toString());

    MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setAutoPlay(true);
    MediaView mediaView = new MediaView(mediaPlayer);
     
    StackPane root = new StackPane();
    root.getChildren().add(mediaView);
    mediaView.setFitWidth(1366);
    mediaView.setFitHeight(768);
    theStage.setTitle("Harry Potter");
    Scene scene = new Scene(root, 800, 600);
    
    scene.setFill(Color.rgb(0, 0, 0));
   
     theStage.setScene(scene);
     theStage.show();
 }
}