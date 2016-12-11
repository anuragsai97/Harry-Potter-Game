/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class tlevel2{

    String spell;
    /**
     * @param args the command line arguments
     */
    character h;
    tlevel2(character h)
    {
        this.h=h;
    }
     
     int i;
  void play()
  {
      System.out.println("Let us get started");
      spellquiz();

  }
    void spellchecker()
    {
        /// Display the spell_test names for this level
        
        
    for(i=0;i<4;i++)
    {
        switch(i)
        {
            case 1:
        try {
            if(spell.equals("Stupefy") || spell.equals("Stupe")|| spell.equals("Stu") || spell.equals("Supefy"))
                {
                    h.spelladd(spell,30);
                }
             }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

            case 2:
        try  {
            if(spell.equals("Reducto") || spell.equals("Reduct") || spell.substring(0, 3).equals("Red") || spell.equals("duct"))
                {
                    h.spelladd(spell,60);
                }
            }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

            case 3:
          try{
              if(spell.equals("Petrificum totalus") || spell.equals("totalus") || spell.equals("Petrificum") || spell.equals("total") || spell.equals("Petri") || spell.equals("Petry"))
                {
                    h.spelladd(spell,80);
                }
            }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

            case 4:
            try {
                if(spell.equals("Expelliarmus") || spell.equals("Expel") || spell.equals("liarmus") || spell.equals("pelliarmus")|| spell.equals("lia"))
                   {
                       h.spelladd(spell,70);
                   }
            }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }
            
            
        }
        
        
    }
    upgrade();
    }

    void spellquiz()      // spell_test quiz must be wriiten
    {
        spellchecker();
    }

    boolean status()
    {
        if(h.spells.size()==8)
        {
            return true;
        }
        return false;
    }
    
     character upgrade()    // returning the obeject after a level
    {
        
        return h;
    }


}

