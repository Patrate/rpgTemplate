package fr.emmuliette.rpgtemplate.races;

public interface RaceOwner {

	public AbstractRace getRace();

	public default void setRace(Class<? extends AbstractRace> race) throws Exception {
		try {
			AbstractRace newRace = RaceRegistry.getRace(race);
			if (getRace() != null) {
				getRace().remove(this);
			}
			internalSetRace(newRace);
			newRace.apply(this);
		} catch (Exception e) {
			// TODO make better exception
			throw e;
		}
	}

	public void internalSetRace(AbstractRace newRace);

}
