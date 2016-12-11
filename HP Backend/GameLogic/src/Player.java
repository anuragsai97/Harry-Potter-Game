import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Player {
	protected int maxHealth;
	protected int maxMagic;
	protected int currentHealth;
	protected int currentMagic;
	
	
	
	public Player(){
		this.setMaxHealth(100);
		this.setMaxMagic(100);
		this.setCurrentHealth(100);
		this.setCurrentMagic(100);
	}
	
	public void takesDamage(int damage){
		this.setCurrentHealth(this.getCurrentHealth() - damage);
	}
	
	public boolean usesSpell(int magic){
		if(magic <= currentMagic){
			currentMagic -= magic;
			return true;
		}
		return false;
	}
	
	//setters and getters
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getMaxMagic() {
		return maxMagic;
	}

	public void setMaxMagic(int maxMagic) {
		this.maxMagic = maxMagic;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getCurrentMagic() {
		return currentMagic;
	}

	public void setCurrentMagic(int currentMagic) {
		this.currentMagic = currentMagic;
	}
	//
	
	//main method to test
	public static void main(String[] args){
		
	}
	//

	public Spell performSpell() throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String spellText;
		Spell spell;
		System.out.println("Enter spell");
		spellText = bf.readLine();
		spell = Spell.getSpell(spellText);
		if(spell!=null){
			this.currentMagic-=spell.magic;
		}
		return spell;
	}

	public CounterSpell performCounterSpell() throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String spellText;
		CounterSpell counterSpell;
		System.out.println("Enter spell");
		spellText = bf.readLine();
		counterSpell = CounterSpell.getSpell(spellText);
		return counterSpell;
		
	}
}
