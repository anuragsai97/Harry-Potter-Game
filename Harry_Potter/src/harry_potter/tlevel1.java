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

import java.net.Socket;
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
public class tlevel1  {

    String spell;
    character h;
    /**
     * @param args the command line arguments
     */
    tlevel1(character h)
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

       /*  Socket MyClient;
    try {
           MyClient = new Socket("Machine name", PortNumber);
    }
    catch (IOException e) {
        System.out.println(e);
    }
      */
         for(i=0;i<4;i++)
         {
        switch(i)
        {
            case 1:
       try{
        if(spell.equals("Lumos")|| spell.equals("Lumo")|| spell.equals("Lu")|| spell.equals("Lum") || spell.equals("umo"))
        {
            h.spelladd(spell,0);
        }
       }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

            case 2:
                try{
                    if(spell.equals("Wingardium leviosa")|| spell.equals("Wing")||spell.equals("leviosa")|| spell.equals("Wingardium")|| spell.equals("ingardium ")||spell.equals("eviosa") )
                            {
                    h.spelladd(spell,5);
                }
            }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

            case 3:
            try{
                if(spell.equals("Accio") || spell.equals("Ac") || spell.equals("Acio") || spell.equals("Acc") || spell.equals("Aio") || spell.equals("Acciyo"))
                {
                    h.spelladd(spell,0);
                }
            }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

            case 4:

            try {
                if(spell.equals("Alohomora") || spell.equals("Alo") || spell.equals("Aloho") || spell.equals("Alomora") || spell.equals("Aohomora") || spell.equals("homora") || spell.equals("Aomora"))
                {
                    h.spelladd(spell,0);
                }
            }catch(Exception e)
                {
                    System.out.println(" Spell not found");
                }

    }
         }
         upgrade();
    }

    void spellquiz()
    {
        spellchecker();
    }
    
    boolean status()
    {
        if(h.spells.size()==4)
        {
            return true;
        }
        return false;
    }

    character upgrade()
    {
        
        return h;
    }



}
