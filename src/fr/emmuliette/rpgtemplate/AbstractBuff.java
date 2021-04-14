package fr.emmuliette.rpgtemplate;

import fr.emmuliette.rpgtemplate.conditions.AbstractCondition;
import fr.emmuliette.rpgtemplate.conditions.ConditionOwner;
import fr.emmuliette.rpgtemplate.stat.AbstractStat;

public abstract class AbstractBuff implements ConditionOwner {
	private String name;
	private AbstractCondition condition;
	private int value;
	private AbstractStat owner;
	
	public AbstractBuff(String name, AbstractCondition condition, int value) {
		this.name = name;
		this.condition = condition;
		this.value = value;
	}
	
	public final void remove() {
		this.owner = null;
		this.condition.remove();
	}
	
	public final void deactivate() {
		owner.removeBuff(name);
		this.owner = null;
	}
	
	public void setOwner(AbstractStat owner) {
		this.owner = owner;
	}
	
	public String getName() {
		return name;
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
