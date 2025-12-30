package com.ashenhart.recruits_compat.world.capabilities.entitypatch.mob;

import com.ashenhart.recruits_compat.gameassets.RecruitAnimations;
import com.ashenhart.recruits_compat.gameassets.RecruitMobCombatBehaviours;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.MobCombatBehaviors;
import yesman.epicfight.world.capabilities.entitypatch.Factions;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.Set;

public class RecruitPatch<T extends PathfinderMob> extends AbstractRecruitPatch<T> {
    public RecruitPatch() {
        super(Factions.VILLAGER);
    }

    @Override
    protected void setWeaponMotions() {
        super.setWeaponMotions();
        this.weaponLivingMotions.put(CapabilityItem.WeaponCategories.SPEAR, ImmutableMap.of(
                CapabilityItem.Styles.TWO_HAND, Set.of(
                        Pair.of(LivingMotions.IDLE, RecruitAnimations.RECRUIT_SPEAR_LIVING),
                        Pair.of(LivingMotions.WALK, RecruitAnimations.RECRUIT_SPEAR_LIVING),
                        Pair.of(LivingMotions.CHASE, RecruitAnimations.RECRUIT_SPEAR_LIVING)
                )
        ));

        this.weaponAttackMotions.put(CapabilityItem.WeaponCategories.SPEAR, ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, RecruitMobCombatBehaviours.RECRUIT_SPEAR, CapabilityItem.Styles.ONE_HAND, RecruitMobCombatBehaviours.RECRUIT_SPEAR_ONE_HAND));
        this.weaponAttackMotions.put(CapabilityItem.WeaponCategories.LONGSWORD, ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, MobCombatBehaviors.HUMANOID_LONGSWORD, CapabilityItem.Styles.ONE_HAND, MobCombatBehaviors.HUMANOID_ONEHAND_TOOLS));
    }

    @Override
    public void setAIAsInfantry(boolean holdingRanedWeapon) {
        if (!holdingRanedWeapon) {
            super.setAIAsInfantry(holdingRanedWeapon);
        }
    }

    @Override
    public void setAIAsMounted(Entity ridingEntity) {
    }
}