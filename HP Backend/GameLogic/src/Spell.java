import java.util.ArrayList;

public class Spell {
	int damage;
	int magic;
	String name;
	
	static ArrayList<ArrayList<Spell>> spells = new ArrayList<>();
	
	
	
	static{
		/*
		spells.add(new Spell("Crucio", 10, 20));
		spells.add(new Spell("Levicorpus", 10, 20));
		spells.add(new Spell("Crucio", 10, 10));
		spells.add(new Spell("Diffendo", 10, 10));
		spells.add(new Spell("Sectum Sempra", 10, 10));
		spells.add(new Spell("Reducto", 10, 10));
		*/
		final ArrayList<Spell> spellsLevel0 = new ArrayList<>();
		final ArrayList<Spell> spellsLevel1 = new ArrayList<>();
		final ArrayList<Spell> spellsLevel2 = new ArrayList<>();
		
		//level 0 spells
		spellsLevel0.add(new Spell("spell1", 10, 10));
		spellsLevel0.add(new Spell("spell2", 15, 15));
		//level 1 spells
		spellsLevel1.add(new Spell("spell3", 20, 20));
		spellsLevel1.add(new Spell("spell4", 25, 25));
		//level 2 spells
		spellsLevel2.add(new Spell("spell5", 20, 20));
		spellsLevel2.add(new Spell("spell6", 25, 25));
		
		//add to list
		spells.add(spellsLevel0);
		spells.add(spellsLevel1);
		spells.add(spellsLevel2);
	}
	
	public Spell(String name, int damage, int magic){
		this.damage = damage;
		this.magic = magic;
		this.name = name;
	}
	
	public static Spell getSpell(String s){
		for(ArrayList<Spell> j: spells){
			for(Spell i: j){
				if(i.name.equalsIgnoreCase(s)){
					return i;
				}
			}
		}
		return null;
	}
	/*
	public static void main(String[] args) throws IOException{
		System.out.println(spells.size());
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("Enter name of spell");
			String x = bf.readLine();
			Spell spell = getSpell(x);
			System.out.println(spell.name + spell.damage);
		}
	}
	*/
}
