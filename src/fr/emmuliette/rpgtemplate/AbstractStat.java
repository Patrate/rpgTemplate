package fr.emmuliette.rpgtemplate;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStat {
	private final AbstractPlayer owner;
	private int value;
	private final String name;
	private Map<String, AbstractBuff> buff;
	
	public AbstractStat(String name, AbstractPlayer owner, Integer value) {
		this.name = name;
		this.owner = owner;
		this.value = value;
		buff = new HashMap<String, AbstractBuff>();
		update();
	}
	
	public void addBuff(String name, AbstractBuff buff) {
		if(this.buff.containsKey(name)) {
			this.buff.get(name).remove();
		}
		this.buff.put(name, buff);
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
	
	public int getValue() {
		int totalValue = value;
		for(AbstractBuff b:buff.values()) {
			totalValue += b.getValue();
		}
		return totalValue;
	}
	
	protected AbstractPlayer getOwner() {
		return owner;
	}
	
	@Override
	public String toString() {
		return name + ": " + value;
	}
}