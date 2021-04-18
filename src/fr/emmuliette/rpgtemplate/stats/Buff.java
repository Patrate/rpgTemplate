package fr.emmuliette.rpgtemplate.stats;

import java.util.HashSet;
import java.util.Set;

import fr.emmuliette.rpgtemplate.Tickable;
import fr.emmuliette.rpgtemplate.conditions.AbstractCondition;

public class Buff extends Tickable {
	private Set<BuffListener> listeners;
	
	public static void giveBuff(StatOwner target, Buff buff) {
		AbstractStat stat = target.getStat(buff.getStatName());
		stat.addBuff(buff);
		buff.listeners.add(stat);
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
		this.listeners = new HashSet<BuffListener>();
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

	@Override
	public void tick() {
		condition.tick();
		if(!condition.isValid()) {
			for(BuffListener bl:listeners) {
				bl.removeBuff(this);
			}
			listeners.clear();
			unregister();
		}
	}
}
