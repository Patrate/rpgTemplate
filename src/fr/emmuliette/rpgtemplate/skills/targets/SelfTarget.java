package fr.emmuliette.rpgtemplate.skills.targets;

import fr.emmuliette.rpgtemplate.skills.AbstractTarget;
import fr.emmuliette.rpgtemplate.skills.SkillOwner;

public class SelfTarget extends AbstractTarget {

	@Override
	public boolean validTarget(SkillOwner caster, Object target) {
		return caster.equals(target);
	}
}
