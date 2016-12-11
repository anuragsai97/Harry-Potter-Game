import java.util.ArrayList;

public class ComputerBot{
	int health;
	int level;
	public ComputerBot(int health, int level){
		this.health = health;
		this.level = level;
	}
	
	
	public int randomGenerator(){
		int x = (int)(Math.random()*level*2);
		if(x>2)
			return 2;
		return x;
	}
	
	public int randomGenerator(Spell s){
		int x = (int)(Math.random()*level*(2-s.level));
		if(x>2)
			return 2;
		return x;
	}
	
	public boolean canCounter(Spell s){
		int x = randomGenerator(s);
		if(x<1)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args){
		ComputerBot x = new ComputerBot(100, 2);
		for(int i=0; i<10; i++)
			System.out.println(x.canCounter(Spell.spells.get(0).get(0)));
			//System.out.println(x.randomGenerator());
		
	}

	public Spell performSpell() {
		int x = randomGenerator();
		Spell s = Spell.spells.get(x).get((int)(Math.random())*(Spell.spells.get(x).size()));
		return s;
	}
}
