package fr.emmuliette.rpgtemplate.stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStat {
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
	
	// TODO call this every X ticks ?
	public void tick() {
		boolean changed = false;
		List<String> removedBuff = new ArrayList<String>();
		for(Buff b:buff.values()) {
			if(!b.isValid()) {
				removedBuff.add(b.getName());
				changed = true;
			}
		}
		if(changed) {
			for(String buffName:removedBuff) {
				buff.remove(buffName);
			}
			update();
		}
	}
	
	public void addBuff(Buff buff) {
		this.buff.put(buff.getName(), buff);
		update();
	}
	
	public void removeBuff(String name) {
		this.buff.remove(name);
		update();
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