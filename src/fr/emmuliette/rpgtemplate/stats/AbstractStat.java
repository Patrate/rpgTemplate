package fr.emmuliette.rpgtemplate.stats;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStat implements BuffListener {
	private final StatOwner owner;
	private int value;
	private final String name;
	private Map<String, Buff> buff;
	
	public AbstractStat(String name, StatOwner owner, Integer value) {
		this.name = name;
		this.owner = owner;
		this.value = value;
		buff = new HashMap<String, Buff>();
		update();
	}
	
	public void addBuff(Buff buff) {
		this.buff.put(buff.getName(), buff);
		update();
	}
	
	@Override
	public void removeBuff(Buff buff) {
		if(this.buff.containsKey(buff.getName())) {
			this.buff.remove(buff.getName());
			update();
		}
	}
	
	public String getName() {
		return name;
	}
	
	protected abstract void update();
	
	public void addValue(int newValue) {
		this.value += newValue;
		update();
	}
	
	public void setValue(int newValue) {
		this.value = newValue;
		update();
	}
	
	public int getBaseValue() {
		return value;
	}
	
	public int getBonusValue() {
		int totalValue = 0;
		for(Buff b:buff.values()) {
			totalValue += b.getValue();
		}
		return totalValue;
	}
	
	public int getValue() {
		return getBaseValue() + getBonusValue();
	}
	
	protected StatOwner getOwner() {
		return owner;
	}
	
	@Override
	public String toString() {
		if(getBonusValue() != 0) {
			return name + ": " + getValue() + "("+ getBaseValue() + "+" + getBonusValue() + ")" ;
		} else {
			return name + ": " + getValue();
		}
	}
}