import java.io.IOException;

public class Duel {
	
	Player player;
	ComputerBot bot;
	public Duel(Player player, ComputerBot bot){
		this.player = player;
		this.bot = bot;
	}
	
	public static void main(String[] args) throws IOException{
		Duel duel = new Duel(new Player(), new ComputerBot(100, 1));
		Spell spell; 
		CounterSpell counterSpell;
		
		while(gameOn(duel)){
			System.out.println("Your health: " + duel.player.getCurrentHealth());
			System.out.println("Your magic: " + duel.player.getCurrentMagic());
			System.out.println("Opponent health: " + duel.bot.health);
			spell = duel.player.performSpell();
			System.out.println(spell.magic + spell.name);
			//counterSpell = duel.bot.performCounterSpell();
			//if(counterSpell.counters.equals(spell)){
				
			//}
			//spell = duel.bot.performSpell();
			//counterSpell = duel.player.performCounterSpell();
		}
		
		if(duel.player.getCurrentHealth()!=0){
			System.out.println("You win");
		}
		else
			System.out.println("You loose");
	}
	
	public static boolean gameOn(Duel d){
		if(d.player.getCurrentHealth()!=0 && d.bot.health!=0)
			return true;
		return false;
	}
}
