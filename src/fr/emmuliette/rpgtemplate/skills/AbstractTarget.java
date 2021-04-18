package fr.emmuliette.rpgtemplate.skills;

public abstract class AbstractTarget {

	public abstract boolean validTarget(SkillOwner caster, Object target);
}
