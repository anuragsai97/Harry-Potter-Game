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
public class tlevel2{

    String spell;
    /**
     * @param args the command line arguments
     */
     Harry_Potter h= new Harry_Potter();
     int i;
  void play()
  {
      System.out.println("Let us get started");
      spellquiz();

  }
    void spellchecker()
    {
        /// Display the spell names for this level

        switch(i)
        {
            case 1:
        try {
            if(spell.equals("Stupefy") || spell.equals("Stupe")|| spell.equals("Stu") || spell.equals("Supefy"))
                {
                    h.spelladd(spell);
                }
             }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

            case 2:
        try  {
            if(spell.equals("Reducto") || spell.equals("Reduct") || spell.equals("Red") || spell.equals("duct"))
                {
                    h.spelladd(spell);
                }
            }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

            case 3:
          try{
              if(spell.equals("Petrificum totalus") || spell.equals("totalus") || spell.equals("Petrificum") || spell.equals("total") || spell.equals("Petri") || spell.equals("Petry"))
                {
                    h.spelladd(spell);
                }
            }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

            case 4:
            try {
                if(spell.equals("Expelliarmus") || spell.equals("Expel") || spell.equals("liarmus") || spell.equals("pelliarmus"|| spell.equals("lia")))
                   {
                       h.spelladd(spell);
                   }
            }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

        }
    }

    void spellquiz()
    {

    }



}
