package harry_potter;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
/**
*
* @author erix7
*/
public class IntroPage extends Application {
 
 /**
  * @param args the command line arguments
  */
 public static void main(String[] args) {
     launch(args);
 }
 
 @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.setId("pane");
        Scene scene = new Scene(root, 800, 600);
        //scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        //Canvas canvas = new Canvas( 1366, 768 );
        //root.getChildren().add( canvas );
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}