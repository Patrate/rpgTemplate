package fr.emmuliette.rpgtemplate.skills;

import java.util.Set;

public interface SkillOwner {

	public abstract Set<AbstractSkill<?>> getSkills();
	
	public default boolean addSkill(AbstractSkill<?> skill) {
		return getSkills().add(skill);
	}
	
	public default boolean removeSkill(AbstractSkill<?> skill) {
		return getSkills().remove(skill);
	}

}
