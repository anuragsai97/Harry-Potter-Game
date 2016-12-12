package harry_potter;

import java.util.ArrayList;

public class ComputerBot{
	int health;
	int level;
	public ComputerBot(int health, int level){
		this.health = health;
		this.level = level;
	}
	
	
	public int randomGenerator(){
		// int x=(int)(Math.random()*5);
                int x = (int)(Math.random()*level*2);
		if(x>2)
			return 2;
		return x;
	}
	
	public int randomGenerator(Spell s){
		//int x = (int)(Math.random()*(level*(2-s.level)));
                //int x=(int)(Math.random()*5);
                //int x=5;
                    int x=(int)(Math.random()*3);
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


	public CounterSpell getCounterSpell(boolean counters, Spell spell) {
		CounterSpell cs = CounterSpell.getSpell(spell);
		if(counters){
			return cs;
		}
		else{
			CounterSpell cs2;
			while(true){
				cs2 = CounterSpell.counterSpells.get((int)(Math.random()*CounterSpell.counterSpells.size()));
                                //cs2 = CounterSpell.counterSpells.get((int)(Math.random()*6));
				if(cs2.name.equals(cs.name)){
					continue;
				}
				else
					return cs2;
			}
			
		}
	}
}
