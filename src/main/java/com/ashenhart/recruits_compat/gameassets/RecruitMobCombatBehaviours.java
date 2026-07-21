package com.ashenhart.recruits_compat.gameassets;

import yesman.epicfight.world.capabilities.entitypatch.HumanoidMobPatch;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors;

public class RecruitMobCombatBehaviours {
    public static final CombatBehaviors.Builder<HumanoidMobPatch<?>> RECRUIT_SPEAR = CombatBehaviors.<HumanoidMobPatch<?>>builder()
            .newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(false).looping(true)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_TWO_HAND_AUTO_1).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_TWO_HAND_AUTO_2).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
            ).newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(false).looping(true)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_TWO_HAND_AUTO_3).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_TWO_HAND_AUTO_4).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_TWO_HAND_AUTO_5).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
            ).newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(50.0F).canBeInterrupted(false).looping(true).cooldown(100)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_TWO_HAND_AUTO_6).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
            );

    public static final CombatBehaviors.Builder<HumanoidMobPatch<?>> RECRUIT_SPEAR_ONE_HAND = CombatBehaviors.<HumanoidMobPatch<?>>builder()
            .newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(false).looping(true)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_ONE_HAND_AUTO_1).withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_ONE_HAND_AUTO_2).withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_ONE_HAND_AUTO_3).withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
            ).newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(50.0F).canBeInterrupted(false).looping(true).cooldown(100)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_TWO_HAND_AUTO_1).withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_TWO_HAND_AUTO_2).withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
            ).newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(10.0F).canBeInterrupted(false).looping(true).cooldown(100)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_SPEAR_ONE_HAND_POWER_ATTACK).withinDistance(0.3D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
            );

    public static final CombatBehaviors.Builder<HumanoidMobPatch<?>> RECRUIT_LONGSWORD = CombatBehaviors.<HumanoidMobPatch<?>>builder()
            .newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(false).looping(true)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_LONGSWORD_AUTO_1).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_LONGSWORD_AUTO_2).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_LONGSWORD_AUTO_3).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
            ).newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(false).looping(true)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_LONGSWORD_AUTO_1_2ND).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_LONGSWORD_AUTO_2_2ND).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(RecruitAnimations.RECRUIT_LONGSWORD_AUTO_3_2ND).withinEyeHeight().withinDistance(0.0D, 3.0D).withinAngleHorizontal(0.0D, 60.0D))
            );
}