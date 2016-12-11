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
			//display stats
			displayStats(duel);
			//
			
			//players turn
			spell = duel.player.performSpell();
			if(!duel.bot.canCounter(spell)){
				duel.bot.health-=spell.damage;
			}
			
			//display stats
			displayStats(duel);
			//
			
			//opponents turn
			spell = duel.bot.performSpell();
			System.out.println("Opponenet performed " + spell.name);
			System.out.println("Quick! Counter the Spell");
			counterSpell = duel.player.performCounterSpell();
			if(counterSpell.counters.name.equals(spell.name)){
				System.out.println("You countered it :)");
			}
			else{
				duel.player.takesDamage(spell.damage);
			}
			duel.player.turnComplete();
		}
		
		if(duel.player.getCurrentHealth()!=0){
			System.out.println("You win");
		}
		else
			System.out.println("You loose");
	}
	
	private static void displayStats(Duel duel) {
		System.out.println("Your health: " + duel.player.getCurrentHealth());
		System.out.println("Your magic: " + duel.player.getCurrentMagic());
		System.out.println("Opponent health: " + duel.bot.health + "\n");
	}

	public static boolean gameOn(Duel d){
		if(d.player.getCurrentHealth()!=0 && d.bot.health!=0)
			return true;
		return false;
	}
}
