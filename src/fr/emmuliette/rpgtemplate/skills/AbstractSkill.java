package fr.emmuliette.rpgtemplate.skills;

public abstract class AbstractSkill<T extends AbstractTarget> {
	
	public abstract void cast(SkillOwner caster, T target);
}
