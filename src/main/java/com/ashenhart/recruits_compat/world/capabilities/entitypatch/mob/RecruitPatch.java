package com.ashenhart.recruits_compat.world.capabilities.entitypatch.mob;

import com.ashenhart.recruits_compat.gameassets.RecruitAnimations;
import com.ashenhart.recruits_compat.gameassets.RecruitMobCombatBehaviours;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import com.talhanation.recruits.entities.ai.RecruitMeleeAttackGoal;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import yesman.epicfight.api.animation.Animator;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.MobCombatBehaviors;
import yesman.epicfight.world.capabilities.entitypatch.Factions;
import yesman.epicfight.world.capabilities.entitypatch.HumanoidMobPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.entity.ai.goal.AnimatedAttackGoal;
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
                        Pair.of(LivingMotions.IDLE, RecruitAnimations.HOLD_RECRUIT_SPEAR),
                        Pair.of(LivingMotions.WALK, RecruitAnimations.HOLD_RECRUIT_SPEAR),
                        Pair.of(LivingMotions.CHASE, RecruitAnimations.HOLD_RECRUIT_SPEAR)
                ),
                CapabilityItem.Styles.ONE_HAND, Set.of(
                        Pair.of(LivingMotions.IDLE, RecruitAnimations.HOLD_RECRUIT_SPEAR_ONE_HAND),
                        Pair.of(LivingMotions.WALK, RecruitAnimations.HOLD_RECRUIT_SPEAR_ONE_HAND),
                        Pair.of(LivingMotions.CHASE, RecruitAnimations.HOLD_RECRUIT_SPEAR_ONE_HAND)
                )
        ));

        this.weaponAttackMotions.put(CapabilityItem.WeaponCategories.SPEAR, ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, RecruitMobCombatBehaviours.RECRUIT_SPEAR, CapabilityItem.Styles.ONE_HAND, RecruitMobCombatBehaviours.RECRUIT_SPEAR_ONE_HAND));
        this.weaponAttackMotions.put(CapabilityItem.WeaponCategories.LONGSWORD, ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, MobCombatBehaviors.HUMANOID_LONGSWORD, CapabilityItem.Styles.ONE_HAND, MobCombatBehaviors.HUMANOID_ONEHAND_TOOLS));
    }

    @Override
    public void setAIAsInfantry(boolean holdingRanedWeapon) {
        this.original.goalSelector.getAvailableGoals().removeIf(goal ->
                goal.getGoal() instanceof RecruitMeleeAttackGoal
        );
        this.original.goalSelector.getAvailableGoals().removeIf(goal ->
                goal.getGoal() instanceof AnimatedAttackGoal
        );
        this.original.goalSelector.getAvailableGoals().removeIf(goal ->
                goal.getGoal() instanceof TargetChasingGoal
        );
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

    @Override
    public void updateHeldItem(CapabilityItem fromCap, CapabilityItem toCap,
                               ItemStack from, ItemStack to, InteractionHand hand) {
        if (this.getEntityState().attacking()) {
            this.modifyLivingMotionByCurrentItem(false);
            return;
        }

        super.updateHeldItem(fromCap, toCap, from, to, hand);
    }

}