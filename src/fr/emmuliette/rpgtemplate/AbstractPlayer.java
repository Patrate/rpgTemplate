package fr.emmuliette.rpgtemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPlayer {
	private Map<String, AbstractStat> stats;
	private AbstractJob job;
	private AbstractRace race;
	
	public AbstractPlayer(AbstractStatBuilder statBuilder,
			AbstractRace race,
			Class<? extends AbstractJob> job
			) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		stats = new HashMap<String, AbstractStat>();
		for(AbstractStat stat:statBuilder.buildStats(this)) {
			stats.put(stat.getName(), stat);
		}
		this.job = job.getConstructor(AbstractPlayer.class).newInstance(this);
		this.job.apply();
		this.race = race;
		this.race.apply(this);
	}
	
	public void setJob(AbstractJob job) {
		if (this.job != null) {
			this.job.remove();
		}
		this.job = job;
		this.job.apply();
	}
	
	public AbstractJob getJob() {
		return job;
	}
	
	public AbstractRace getRace() {
		return race;
	}
	
	public AbstractStat getStat(String statName) {
		return stats.get(statName);
	}
	
	public Map<String, AbstractStat> getStats(){
		return stats;
	}
	
	protected void addStat(AbstractStat stat) {
		stats.put(stat.getName(), stat);
	}
	
	@Override
	public String toString() {
		return race.toString() + " " + job.toString() + ":\n" + stats.values();
	}
}
