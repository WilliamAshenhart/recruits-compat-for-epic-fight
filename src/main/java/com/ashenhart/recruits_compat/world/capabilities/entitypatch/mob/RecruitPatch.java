package com.ashenhart.recruits_compat.world.capabilities.entitypatch.mob;

import com.ashenhart.recruits_compat.gameassets.RecruitAnimations;
import com.ashenhart.recruits_compat.gameassets.RecruitMobCombatBehaviours;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.item.ShieldItem;
import yesman.epicfight.api.animation.Animator;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.MobCombatBehaviors;
import yesman.epicfight.world.capabilities.entitypatch.Factions;
import yesman.epicfight.world.capabilities.entitypatch.HumanoidMobPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.entity.ai.goal.AnimatedAttackGoal;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors;
import yesman.epicfight.world.entity.ai.goal.TargetChasingGoal;

import java.util.Set;

public class RecruitPatch<T extends PathfinderMob> extends HumanoidMobPatch<T> {
    public RecruitPatch() {
        super(Factions.VILLAGER);
    }

    @Override
    public void initAnimator(Animator animator) {
        super.initAnimator(animator);

        animator.addLivingAnimation(LivingMotions.IDLE, Animations.BIPED_IDLE);
        animator.addLivingAnimation(LivingMotions.WALK, Animations.BIPED_WALK);
        animator.addLivingAnimation(LivingMotions.CHASE, Animations.BIPED_WALK);
        animator.addLivingAnimation(LivingMotions.DEATH, Animations.BIPED_DEATH);
        animator.addLivingAnimation(LivingMotions.DRINK, Animations.BIPED_DRINK);
        animator.addLivingAnimation(LivingMotions.MOUNT, Animations.BIPED_MOUNT);
        animator.addLivingAnimation(LivingMotions.EAT, Animations.BIPED_EAT);
        animator.addLivingAnimation(LivingMotions.JUMP, Animations.BIPED_JUMP);
        animator.addLivingAnimation(LivingMotions.SLEEP, Animations.BIPED_SLEEPING);
        animator.addLivingAnimation(LivingMotions.BLOCK_SHIELD, Animations.BIPED_BLOCK);
    }

    @Override
    protected void setWeaponMotions() {
        super.setWeaponMotions();
        this.weaponLivingMotions.put(CapabilityItem.WeaponCategories.SPEAR, ImmutableMap.of(
                CapabilityItem.Styles.TWO_HAND, Set.of(
                        Pair.of(LivingMotions.IDLE, RecruitAnimations.RECRUIT_SPEAR_LIVING),
                        Pair.of(LivingMotions.WALK, RecruitAnimations.RECRUIT_SPEAR_LIVING),
                        Pair.of(LivingMotions.CHASE, RecruitAnimations.RECRUIT_SPEAR_LIVING)
                ),
                CapabilityItem.Styles.ONE_HAND, Set.of(
                        Pair.of(LivingMotions.IDLE, Animations.BIPED_HOLD_SPEAR),
                        Pair.of(LivingMotions.WALK, Animations.BIPED_WALK_SPEAR),
                        Pair.of(LivingMotions.CHASE, Animations.BIPED_WALK_SPEAR)
                )
        ));
        this.weaponLivingMotions.put(CapabilityItem.WeaponCategories.LONGSWORD, ImmutableMap.of(
                CapabilityItem.Styles.TWO_HAND, Set.of(
                        Pair.of(LivingMotions.IDLE, RecruitAnimations.RECRUIT_LONGSWORD_LIVING),
                        Pair.of(LivingMotions.WALK, RecruitAnimations.RECRUIT_LONGSWORD_LIVING),
                        Pair.of(LivingMotions.CHASE, RecruitAnimations.RECRUIT_LONGSWORD_LIVING)
                )
        ));

        this.weaponAttackMotions.put(CapabilityItem.WeaponCategories.SPEAR, ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, RecruitMobCombatBehaviours.RECRUIT_SPEAR, CapabilityItem.Styles.ONE_HAND, RecruitMobCombatBehaviours.RECRUIT_SPEAR_ONE_HAND));
        this.weaponAttackMotions.put(CapabilityItem.WeaponCategories.LONGSWORD, ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, RecruitMobCombatBehaviours.RECRUIT_LONGSWORD, CapabilityItem.Styles.ONE_HAND, MobCombatBehaviors.HUMANOID_ONEHAND_TOOLS));
    }

    @Override
    public void setAIAsInfantry(boolean holdingRanedWeapon) {
        if (!holdingRanedWeapon) {
            super.setAIAsInfantry(holdingRanedWeapon);
        }
    }

    @Override
    public void updateMotion(boolean considerInaction) {
        super.commonAggressiveRangedMobUpdateMotion(considerInaction);
        if (this.original.isUsingItem() && this.original.getUseItem().getItem() instanceof ShieldItem) {
            this.currentCompositeMotion = LivingMotions.BLOCK_SHIELD;
        }
    }

    @Override
    public void setAIAsMounted(Entity ridingEntity) {
    }
}