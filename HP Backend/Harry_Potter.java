/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harry_potter;

import java.util.ArrayList;
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
public class Harry_Potter{
    
   

    /**
     * @param args the command line arguments
     */
      
        int i;
        long id;
        int health;
        int specialpower;
        ArrayList<String> spells;
        
        void spelladd(String s)
        {
            spells.add(s);
        }
        
        boolean spellstatus(String spell)
        {
            
            while(i<spells.size())
            {
                if(spells.get(i)==spell)
                {
                    return true;
                }
            }
            return false;
        }
        
        int gethealth()
        {
            return health;
        }
        
        
        
        
        
    
    
}
