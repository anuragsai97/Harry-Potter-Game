import java.util.ArrayList;

public class CounterSpell {
	public String name;
	public Spell counters;
	public int magic;
	
	//static ArrayList<CounterSpell> counterSpells = new ArrayList<>();
	static ArrayList<CounterSpell> counterSpells = new ArrayList<>();
	
	static{
		//counterSpells.add(new CounterSpell("Protego", Spell.spells.get(0), 5));
		//counterSpells.add(new CounterSpell("Levicorpus", Spell.spells.get(1), 10));
		
		//level 0
		counterSpells.add(new CounterSpell("cs1", Spell.spells.get(0).get(0), 10));
		counterSpells.add(new CounterSpell("cs2", Spell.spells.get(0).get(1), 10));
		
		//level 1
		counterSpells.add(new CounterSpell("cs3", Spell.spells.get(1).get(0), 10));
		counterSpells.add(new CounterSpell("cs4", Spell.spells.get(1).get(1), 10));
		
		//level 2
		counterSpells.add(new CounterSpell("cs5", Spell.spells.get(2).get(0), 10));
		counterSpells.add(new CounterSpell("cs6", Spell.spells.get(2).get(1), 10));
		
		/*
		//level 1 spells
		counterSpells.add(new CounterSpell("cs1", Spell.spells.get(0), 10));
		counterSpells.add(new CounterSpell("cs2", Spell.spells.get(1), 10));
		counterSpells.add(new CounterSpell("cs3", Spell.spells.get(2), 10));
		counterSpells.add(new CounterSpell("cs4", Spell.spells.get(3), 10));
		
		//level 2 spells
		counterSpells.add(new CounterSpell("cs1", Spell.spells.get(0), 10));
		counterSpells.add(new CounterSpell("cs2", Spell.spells.get(1), 10));
		counterSpells.add(new CounterSpell("cs3", Spell.spells.get(2), 10));
		counterSpells.add(new CounterSpell("cs4", Spell.spells.get(3), 10));
		*/
		
		//counterSpells.add(new CounterSpell("Crucio", 10, 20));
		//counterSpells.add(new CounterSpell("Levicorpus", 10, 20));
	}
	
	public CounterSpell(String name, Spell counters, int magic){
		this.name = name;
		this.counters = counters;
		this.magic = magic;
	}

	public static CounterSpell getSpell(String spellText) {
		for(CounterSpell i: counterSpells){
			if(i.name.equalsIgnoreCase(spellText)){
				return i;
			}
		}
		return null;
	}
}
