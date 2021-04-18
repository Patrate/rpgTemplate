package fr.emmuliette.rpgtemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import fr.emmuliette.rpgtemplate.jobs.AbstractJob;
import fr.emmuliette.rpgtemplate.jobs.JobOwner;
import fr.emmuliette.rpgtemplate.races.AbstractRace;
import fr.emmuliette.rpgtemplate.races.RaceOwner;
import fr.emmuliette.rpgtemplate.skills.AbstractSkill;
import fr.emmuliette.rpgtemplate.skills.SkillOwner;
import fr.emmuliette.rpgtemplate.stats.AbstractStat;
import fr.emmuliette.rpgtemplate.stats.AbstractStatBuilder;
import fr.emmuliette.rpgtemplate.stats.StatOwner;

public class BaseEntity implements StatOwner, SkillOwner, RaceOwner, JobOwner {
	private Map<String, AbstractStat> stats;
	private Map<Class<? extends AbstractJob>, AbstractJob> jobs;
	private Set<AbstractSkill<?>> skills;
	private AbstractRace race;

	private int statPoint;
	private int jobPoint;

	public BaseEntity(AbstractStatBuilder statBuilder, Class<? extends AbstractRace> race) throws Exception {
		stats = new HashMap<String, AbstractStat>();
		for (AbstractStat stat : statBuilder.buildStats(this)) {
			stats.put(stat.getName(), stat);
		}
		this.jobs = new HashMap<Class<? extends AbstractJob>, AbstractJob>();
		setRace(race);
		this.statPoint = 0;
		this.jobPoint = 0;
	}

	// ===== SKILLS =====

	public Set<AbstractSkill<?>> getSkills() {
		return skills;
	}

	// ===== JOBS =====

	public boolean addJob(Class<? extends AbstractJob> jobClass) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if (jobs.containsKey(jobClass)) {
			return false;
		}
		AbstractJob newJob = jobClass.getConstructor(JobOwner.class).newInstance(this);
		jobs.put(jobClass, newJob);
		newJob.apply();
		return true;
	}

	public boolean removeJob(AbstractJob job) {
		if (jobs.containsValue(job)) {
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

	public void internalSetRace(AbstractRace newRace) {
		this.race = newRace;
	}

	// ===== STATS =====

	public Map<String, AbstractStat> getStats() {
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
