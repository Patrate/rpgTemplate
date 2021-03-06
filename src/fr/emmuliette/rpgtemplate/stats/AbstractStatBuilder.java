package fr.emmuliette.rpgtemplate.stats;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStatBuilder {

	private List<Class<? extends AbstractStat>> stats;
	private int baseValue;

	@SafeVarargs
	public AbstractStatBuilder(int baseValue, Class<? extends AbstractStat>... stats) {
		this.baseValue = baseValue;
		this.stats = new ArrayList<Class<? extends AbstractStat>>();
		for (Class<? extends AbstractStat> stat : stats) {
			this.stats.add(stat);
		}
	}

	public List<AbstractStat> buildStats(StatOwner owner) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ArrayList<AbstractStat> statList = new ArrayList<AbstractStat>();
		for (Class<? extends AbstractStat> statClass : stats) {
			statList.add(statClass.getConstructor(StatOwner.class, Integer.class).newInstance(owner, baseValue));
		}
		return statList;
	}
}
