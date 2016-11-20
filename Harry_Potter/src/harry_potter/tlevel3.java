/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
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
public class tlevel3{



    String spell;
    /**
     * @param args the command line arguments
     */
   character h;
     int i;
     
     tlevel3(character h)
     {
         this.h=h;
     }
  void play()
  {
      System.out.println("Let us get started");
      spellquiz();

  }
    void spellchecker()
    {
        /// Display the spell names for this level
for(i=0;i<4;i++)
{
        switch(i)
        {
            case 1:
       try{
           if(spell.equals("Expectopatronum") || spell.equals("Expect") || spell.equals("patronum") || spell.equals("tronum"))
            {
                h.spelladd(spell,50);
            }
            }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

            case 2:
        try{
           if(spell.equals("Crucio") || spell.equals("Crucial") || spell.equals("Cruio") || spell.equals("rucio")  )
            {
                h.spelladd(spell,90);
            }
            }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

            case 3:
        try {
            if(spell.equals("Avada kedavra") || spell.equals("Avada")|| spell.equals("kedavra") || spell.equals("davra") || spell.equals("Avad"))
                {
                    h.spelladd(spell,300);
                }
                }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

           case 4:
              try{  if(spell.equals(" Imperio"))
                {
                    h.spelladd(spell,80);
                }
                }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

        }
}
    }

    void spellquiz()
    {

    }
    
    

}
