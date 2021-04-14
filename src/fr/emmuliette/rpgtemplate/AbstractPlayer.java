package fr.emmuliette.rpgtemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import fr.emmuliette.rpgtemplate.stat.AbstractStat;
import fr.emmuliette.rpgtemplate.stat.AbstractStatBuilder;
import fr.emmuliette.rpgtemplate.stat.StatOwnerInterface;

public abstract class AbstractPlayer implements StatOwnerInterface {
	private Map<String, AbstractStat> stats;
	private Map<Class<? extends AbstractJob>, AbstractJob> jobs;
	private AbstractRace race;
	
	private int statPoint;
	private int jobPoint;
	
	public AbstractPlayer(AbstractStatBuilder statBuilder,
			AbstractRace race) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		stats = new HashMap<String, AbstractStat>();
		for(AbstractStat stat:statBuilder.buildStats(this)) {
			stats.put(stat.getName(), stat);
		}
		this.jobs = new HashMap<Class<? extends AbstractJob>, AbstractJob>();
		this.race = race;
		this.race.apply(this);
		this.statPoint = 0;
		this.jobPoint = 0;
	}
	
	
	// ===== JOBS =====
	
	public boolean addJob(Class<? extends AbstractJob> jobClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if(jobs.containsKey(jobClass)) {
			return false;
		}
		AbstractJob newJob = jobClass.getConstructor(AbstractPlayer.class).newInstance(this);
		jobs.put(jobClass, newJob);
		newJob.apply();
		return true;
	}
	
	public boolean removeJob(AbstractJob job) {
		if(jobs.containsValue(job)) {
			jobs.remove(job.getClass());
			return true;
		}
		return false;
	}
	
	public Collection<AbstractJob> getJobs() {
		return jobs.values();
	}
	
	public AbstractJob getJob(Class<? extends AbstractJob> job) {
		return jobs.get(job);
	}
	
	public boolean hasJob(Class<? extends AbstractJob> job) {
		return jobs.containsKey(job);
	}
	
	public void addJobPoint(int newJP) {
		jobPoint += newJP;
	}
	
	public int getJobPoint() {
		return jobPoint;
	}
	
	// ===== RACE =====
	public AbstractRace getRace() {
		return race;
	}
	
	// ===== STATS =====
	
	public Map<String, AbstractStat> getStats(){
		return stats;
	}
	
	public void addStatPoint(int newSP) {
		statPoint += newSP;
	}
	
	public int getStatPoint() {
		return statPoint;
	}
	
	// ===== OTHER =====
	
	@Override
	public String toString() {
		return race.toString() + " " + jobs.values() + ":\n" + stats.values();
	}
}
