package fr.emmuliette.rpgtemplate.skills.targets;

import fr.emmuliette.rpgtemplate.BaseEntity;
import fr.emmuliette.rpgtemplate.skills.AbstractTarget;
import fr.emmuliette.rpgtemplate.skills.SkillOwner;

public class EntityTarget extends AbstractTarget {

	@Override
	public boolean validTarget(SkillOwner caster, Object target) {
		return target instanceof BaseEntity;
	}

}
