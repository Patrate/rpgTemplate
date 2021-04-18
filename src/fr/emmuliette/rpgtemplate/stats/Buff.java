package fr.emmuliette.rpgtemplate.stats;

import fr.emmuliette.rpgtemplate.conditions.AbstractCondition;

public class Buff {
	
	public static void giveBuff(StatOwner target, Buff buff) {
		target.getStat(buff.getStatName()).addBuff(buff);
	}
	
	private String name;
	private AbstractCondition condition;
	private int value;
	private String statName;
	
	public Buff(String name, String statName, int value, AbstractCondition condition) {
		this.name = name;
		this.condition = condition;
		this.value = value;
		this.statName = statName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStatName() {
		return statName;
	}
	
	public boolean isValid() {
		return condition.isValid();
	}

	public AbstractCondition getCondition() {
		return condition;
	}

	public void setCondition(AbstractCondition condition) {
		this.condition = condition;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
