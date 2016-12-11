import java.util.Random;

public class ComputerBot{
	int health;
	int level;
	public ComputerBot(int health, int level){
		this.health = health;
		this.level = level;
	}
	
	public int randomGenerator(){
		return (int)(Math.random()*level);
	}

	public CounterSpell performCounterSpell() {
		// TODO Auto-generated method stub
		return null;
	}
}
