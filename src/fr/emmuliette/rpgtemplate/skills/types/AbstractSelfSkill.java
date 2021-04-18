package fr.emmuliette.rpgtemplate.skills.types;

import fr.emmuliette.rpgtemplate.skills.AbstractSkill;
import fr.emmuliette.rpgtemplate.skills.SkillOwner;
import fr.emmuliette.rpgtemplate.skills.targets.SelfTarget;

public abstract class AbstractSelfSkill extends AbstractSkill<SelfTarget> {

	@Override
	public final void cast(SkillOwner caster, SelfTarget target) {
		cast(caster);
	}
	
	public abstract void cast(SkillOwner caster);

}
