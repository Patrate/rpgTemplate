package fr.emmuliette.rpgtemplate.stat;

import java.util.Map;

public interface StatOwnerInterface {
	
	public abstract Map<String, AbstractStat> getStats();
	
	public default AbstractStat getStat(String statName) {
		return getStats().get(statName);
	}
	
	public default void addStat(AbstractStat stat) {
		getStats().put(stat.getName(), stat);
	}
}
