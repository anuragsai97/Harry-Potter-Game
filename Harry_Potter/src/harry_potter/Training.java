/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harry_potter;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Scanner;
import static javafx.application.Application.launch;
public class Training  {
    
   
    /**
     * @param args the command line arguments
     */
    
    
   // Test t=new Test();
    
    
 
 /**
  * @param args the command line arguments
  */
     String s;
    Scanner sc=new Scanner(System.in);
    character h= new character();
    int count=0;
    int k=0;
 public static void main(String[] args) {
     launch(args);
 }
 
// @Override
    public void start(Stage primaryStage) {
        /*StackPane root = new StackPane();
        root.setId("pane");
        Scene scene = new Scene(root, 800, 600);
        
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
        */
    }

    
    /*public static void main(String[] args) 
    {
        launch(args);
        
    }
    @Override
    public void start(Stage theStage)  {
        
        theStage.setTitle( "Harry Potter" );

        Group root = new Group();
        Scene theScene = new Scene( root,800, 600 );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 1366, 768 );
        root.getChildren().add( canvas ); 
        theStage.show();
    }*/
    
    
    
    void Training1()
    {
         tlevel1 t=new tlevel1(h);
        if(count==0)
        {
          t.play();
        practice(t.upgrade());
        count=1;
        }
        
        
        if(t.status())
        {
     tlevel2 t2=new tlevel2(t.upgrade());
     t2.play();
     practice(t.upgrade());
        
        if(t2.status())
        {
    tlevel3 t3=new tlevel3(t2.upgrade());
        }
        }
    }
    
    
    
    
    void practice(character h)
{
    System.out.println("Pick any of the spells:"+h.spells);
    //HP_Spells p= new HP_Spells();
    while(s!="N")
    System.out.println("Enter any of the spells:");
     s=sc.next();
     
     
    
    if(s.equals("Lumos"))
    {
       
    }
    
    if(s.equals("Expelliarmus"))
    {
        
    }
    if(s.equals("Wingardium Leviosa"))
    {
        
    }
     if(s.equals("Accio"))
    {
        
    }
     if(s.equals("Reducto"))
    {
        
    }
     if(s.equals("crucio"))
    {
        
    }
     if(s.equals("Imperio"))
    {
        
    }
     
     if(s.equals("Avada Kedavara"))
    {
        
    }
     
     if(s.equals("Stupefy"))
    {
        
    }
     if(s.equals("Petrificum totalus"))
    {
        
    }
     
     if(s.equals("Expecto Patronum"))
     {
         
     }
     
}

    
    
    
}
