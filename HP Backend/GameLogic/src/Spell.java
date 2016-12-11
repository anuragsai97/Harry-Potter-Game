import java.util.ArrayList;

public class Spell {
	int damage;
	int magic;
	String name;
	int level;
	
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
		spellsLevel0.add(new Spell("spell1", 20, 25, 0));
		spellsLevel0.add(new Spell("spell2", 25, 25, 0));
		//level 1 spells
		spellsLevel1.add(new Spell("spell3", 30, 30, 1));
		spellsLevel1.add(new Spell("spell4", 35, 35, 1));
		//level 2 spells
		spellsLevel2.add(new Spell("spell5", 40, 40, 2));
		spellsLevel2.add(new Spell("spell6", 45, 45, 2));
		
		//add to list
		spells.add(spellsLevel0);
		spells.add(spellsLevel1);
		spells.add(spellsLevel2);
	}
	
	public Spell(String name, int damage, int magic, int level){
		this.damage = damage;
		this.magic = magic;
		this.name = name;
		this.level = level;
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
