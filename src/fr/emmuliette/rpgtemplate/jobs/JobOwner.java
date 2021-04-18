package fr.emmuliette.rpgtemplate.jobs;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public interface JobOwner {

	public boolean addJob(Class<? extends AbstractJob> jobClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	
	public boolean removeJob(AbstractJob job);
	
	public Collection<AbstractJob> getJobs();
	
	public AbstractJob getJob(Class<? extends AbstractJob> job);
	
	public boolean hasJob(Class<? extends AbstractJob> job);
	
}
