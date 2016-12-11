/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harry_potter;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author ANURAG
 */
public class Duel_final extends Application implements Runnable {
    ArrayList<String> kks_t = new ArrayList<>();
    //ArrayList<String> kks = new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    KnockKnockServer k=new KnockKnockServer();
    
     Duel duel = new Duel(new Player(), new ComputerBot(100, 1));
		Spell spell; 
		CounterSpell counterSpell;
		boolean counters;
		
        
        
    Sprite spell1 = new Sprite();       //Sprite for spells cast by s1
    Sprite spell2 = new Sprite();       //Sprite for spells cast by s2
    
    
    
    /*Player player;
	ComputerBot bot;
	public Duel_final(Player player, ComputerBot bot){
		this.player = player;
		this.bot = bot;
	}
        
        Duel_logic duel = new Duel_logic(new Player(), new ComputerBot(100, 1));
		Spell_logic spell; 
		CounterSpell counterSpell;
    */
    
    public void spell_setter(String spell){
        if(spell.equals("reducto"))
            spell2.setImage("/harry_potter/Spells/reducto.gif");
        if(spell.equals("confringo"))
            spell2.setImage("/harry_potter/Spells/confirgo.gif");
        if(spell.equals("crucio"))
            spell2.setImage("/harry_potter/Spells/crucio.gif");
        if(spell.equals("stupefy"))
            spell2.setImage("/harry_potter/Spells/Stupefy.gif");
        if(spell.equals("expelliarmus"))
            spell2.setImage("/harry_potter/Spells/expelliarmus.gif");
        if(spell.equals("diffindo"))
            spell2.setImage("/harry_potter/Spells/diffindo.gif");
        
    }
    
    public void player_spell_setter(String spell){
        if(spell.equals("reducto"))
            spell1.setImage("/harry_potter/Spells/reducto.gif");
        if(spell.equals("confringo"))
            spell1.setImage("/harry_potter/Spells/confirgo.gif");
        if(spell.equals("crucio"))
            spell1.setImage("/harry_potter/Spells/crucio.gif");
        if(spell.equals("stupefy"))
            spell1.setImage("/harry_potter/Spells/Stupefy.gif");
        if(spell.equals("expelliarmus"))
            spell1.setImage("/harry_potter/Spells/expelliarmus.gif");
        if(spell.equals("diffindo"))
            spell1.setImage("/harry_potter/Spells/diffindo.gif");
        
    }
        
        
    
    
    @Override
    public void start(Stage theStage) {
       
        
        Group root = new Group();
        Scene theScene = new Scene( root,1366, 768 );
        Canvas canvas = new Canvas( 1366, 768 );
        root.getChildren().add( canvas );
        theStage.setTitle("Hello World!");
        theStage.setScene(theScene);
        
        
        ArrayList<String> input = new ArrayList<String>();
         ArrayList<String> in = new ArrayList<String>();
        theScene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                { 
                    String code = e.getCode().toString();
                    if ( !input.contains(code) )
                        input.add( code );
                    }
            });
        theScene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {                  
                    String code = e.getCode().toString();
                    input.remove( code );                 
                }
            });
        
                Thread th=new Thread(k);
                th.start();
                while(kks_t.size()==0){
                    kks_t = k.getstring();
                    //System.out.println(kks_t);
                }
        
        //in.add(kks_t);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        LongValue lastNanoTime = new LongValue( System.nanoTime() );    

        Sprite s1 = new Sprite();                      //s1 is a person
        s1.setPosition(200, 300);
        s1.setImage("/harry_potter/Movement/r1.png");
        
        Sprite s2 = new Sprite();                      //s2 is another person
        s2.setPosition(1100, 300);
        s2.setImage("/harry_potter/Movement/l1.png");
        
        
        
        
   
        final long startNanoTime = System.nanoTime();
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime) 
            {
                // calculate time since last update.
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                // game logic sample. I'm using space for input for s1 and shift as input for s2. Change it if you want voice.
                
                //player.performSpell(kks_t.get(0));
                //if(kks_t.contains(t))

		//while(gameOn(duel)){
			//display stats
			//displayStats(duel);
			//
			                        
			
			//if(spell.equals(""))
                        if((kks_t.contains("reducto"))||(kks_t.contains("crucio"))||(kks_t.contains("diffindo"))||(kks_t.contains("expelliarmus"))||(kks_t.contains("stupefy"))||kks_t.contains("confringo")){
                            //players turn
                            spell = duel.player.performSpell(kks_t.get(0));
                            counters = duel.bot.canCounter(spell);
                            if(!counters){
                            	duel.bot.health-=spell.damage;
                            }
                            if(counters){
                                duel.player.takesDamage(spell.damage);
                            }
                            //get opponent's counter spell
                            counterSpell = duel.bot.getCounterSpell(counters, spell);
                            //counterSpell=duel.bot.performSpell();
                            System.out.println("Opponent used " + counterSpell.name );
                            //
                            
                            spell1.setPosition(s1.getXPosition()-10, s1.getYPosition()-10);
                            player_spell_setter(spell.name);
                            spell1.setVelocity(150, 0);
                            kks_t.clear();
                            spell2.setPosition(s2.getXPosition()-10, s2.getYPosition()-10);
                            //s2.setImage("/harry_potter/Spells/PersonFacingLeft.gif");
                            spell_setter(counterSpell.name);
                            //spell2.setImage("/harry_potter/Spells/sectum sempra.gif");
                            spell2.setVelocity(-150, 0);
                        }
			//display stats
			//displayStats(duel);
			//
			                       
                        
                       /*
			//opponents turn
			spell = duel.bot.performSpell();
			System.out.println("Opponenet performed " + spell.name);
			System.out.println("Quick! Counter the Spell");
			counterSpell = duel.player.performCounterSpell(kks_t.get(0));
			if(counterSpell.counters.name.equals(spell.name)){
				System.out.println("You countered it :)");
			}
			else{
				duel.player.takesDamage(spell.damage);
			}*/
			duel.player.turnComplete();
		//}
		
                
                //if(kks_t.get(0).equals(cb.bot_spell())){
                /*if((kks_t.contains("reducto"))||(kks_t.contains("crucio"))||(kks_t.contains("diffindo"))||(kks_t.contains("expelliarmus")||kks_t.contains("stupefy"))){
                    spell1.setPosition(s1.getXPosition()-10, s1.getYPosition()-10);
                    //in.add(STYLESHEET_MODENA)
                    s1.setImage("/harry_potter/Spells/PersonFacingRight.gif");
                    spell1.setImage("/harry_potter/Spells/"+kks_t.get(0)+".gif");
                    spell1.setVelocity(150, 0);
                    in.add(kks_t.get(0));
                    
                    in.add(kks_t.get(0));
                    kks_t.clear();
                    
                    spell2.setPosition(s2.getXPosition()-10, s2.getYPosition()-10);
                    s2.setImage("/harry_potter/Spells/PersonFacingLeft.gif");
                    //spell_setter();
                    //spell2.setImage("/harry_potter/Spells/sectum sempra.gif");
                    spell2.setVelocity(-150, 0);
                }*/
                
                
		/*if(duel.player.getCurrentHealth()!=0){
			System.out.println("You win");
		}
		else
			System.out.println("You loose");
                
                */
                /*
                spell = duel.player.performSpell(kks_t.get(0));
                if(!duel.bot.canCounter(spell)){
                    duel.bot.health-=spell.damage;
		}
			*/
                
                
                
                
                /*if (input.contains("SPACE")){
                    in.add("SPACE");
                    spell1.setPosition(s1.getXPosition()-10, s1.getYPosition()-10);
                    s1.setImage("/harry_potter/Spells/PersonFacingRight.gif");
                    spell1.setImage("/harry_potter/Spells/Lumos.gif");
                    spell1.setVelocity(150, 0);
                } 
                if (input.contains("SHIFT")){
                    in.add("SHIFT");
                    spell2.setPosition(s2.getXPosition()-10, s2.getYPosition()-10);
                    s2.setImage("/harry_potter/Spells/PersonFacingLeft.gif");
                    spell2.setImage("/harry_potter/Spells/Lumos.gif");
                    spell2.setVelocity(-150, 0);
                } */ 
                s1.update(elapsedTime);
                s2.update(elapsedTime);
                spell1.update(elapsedTime);
                spell2.update(elapsedTime);
                // you may use the code below for collision detection between 2 spells. You may or may not use the arraylist but logic is same.
                Sprite sp = new Sprite();
                
                if ( spell1.intersects(spell2))
                {
                    sp.setImage("/harry_potter/Spells/Explosion.gif");
                    sp.setPosition(spell1.getXPosition(), 300);
                    sp.update(elapsedTime);   
                }
                //render
                gc.clearRect(0, 0, 1366,768);
                s1.render(gc);
                s2.render(gc);
                
                if(spell2.getXPosition()-spell1.getXPosition()>=0){                    
                    spell1.render(gc);
                    spell2.render(gc);
                }

                if(!counters){
                    //if(spell1.getXPosition())
                    spell1.render(gc);
                    if(spell1.intersects(s2)){
                        if(spell1.intersects(spell2)){
                            spell2.setVelocity(0,0);
                        }
                        s2.setImage("/harry_potter/Spells/damage.gif");
                    }
                }
                
                
                
                if(counters){
                    spell2.render(gc); 
                     if(spell1.intersects(s1)){
                         if(spell1.intersects(spell2)){
                            spell1.setVelocity(0,0);
                        }
                         //spell1.setVelocity(0,0);
                        s1.setImage("/harry_potter/Spells/damage_flip.gif");
                    }

                }
                
                

                
                
                //else
                sp.render(gc);
                
                String pointsText = "Player Health: " + (duel.player.getCurrentHealth());
                gc.fillText( pointsText, 30, 36 );
                gc.strokeText( pointsText, 30, 36 );
                
                String bothealth = "Bot Health: " + (duel.bot.health);
                gc.fillText( bothealth, 1100, 36 );
                gc.strokeText( bothealth, 1100, 36 );
               
               
            }
        }.start();
        
        theStage.show();
    }

    /**
     * @param args the command line arguments
     */
    
    private static void displayStats(Duel duel) {
		System.out.println("Your health: " + duel.player.getCurrentHealth());
		System.out.println("Your magic: " + duel.player.getCurrentMagic());
		System.out.println("Opponent health: " + duel.bot.health + "\n");
	}

	public static boolean gameOn(Duel d){
		if(d.player.getCurrentHealth()<=0 && d.bot.health<=0)
			return true;
		return false;
	}
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void run() {
        while(kks_t.size()==0){
                    kks_t = k.getstring();
                   System.out.println(kks_t);
                }
    }
    
}
