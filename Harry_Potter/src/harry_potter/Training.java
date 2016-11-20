/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harry_potter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
import java.util.Scanner;
public class Training  {
    
   
    /**
     * @param args the command line arguments
     */
    String s;
    Scanner sc=new Scanner(System.in);
    character h= new character();
    int count;
    
         
    
    
    
    Training()
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
    
    while(s!="N")
    System.out.println("Enter any of the spells:");
     s=sc.next();
    
    if(s.equals("Lumos"))
    {
        // 
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
