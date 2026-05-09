package com.ashenhart.recruits_compat.gameassets;

import com.ashenhart.recruits_compat.Recruits_compat;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;
import yesman.epicfight.world.damagesource.StunType;

import java.util.Set;

public class RecruitAnimations {
    public static AnimationManager.AnimationAccessor<StaticAnimation> HOLD_RECRUIT_SPEAR;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_AUTO_1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_AUTO_3;
    public static AnimationManager.AnimationAccessor<StaticAnimation> HOLD_RECRUIT_SPEAR_ONE_HAND;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_ONE_HAND_AUTO_1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_ONE_HAND_AUTO_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_ONE_HAND_AUTO_3;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_ONE_HAND_POWER_ATTACK;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_TWO_HAND_AUTO_1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_TWO_HAND_AUTO_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_TWO_HAND_AUTO_3;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_TWO_HAND_AUTO_4;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_TWO_HAND_AUTO_6;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BLOCK_RECRUIT_SPEAR;


    @SubscribeEvent
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(Recruits_compat.MODID, RecruitAnimations::build);
    }
    public static void build(AnimationManager.AnimationBuilder builder) {
        HOLD_RECRUIT_SPEAR = builder.nextAccessor("biped/living/hold_recruit_spear", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        RECRUIT_SPEAR_AUTO_1 = builder.nextAccessor("biped/combat/recruit_spear_auto_1", (accessor) ->
                new AttackAnimation(0.15F, 0.2F, 0.3F, 0.5F, 1.5F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.2F));
        RECRUIT_SPEAR_AUTO_3 = builder.nextAccessor("biped/combat/recruit_spear_auto_3", (accessor) ->
                new AttackAnimation(0.15F, 0.5F, 0.55F, 0.6F, 1.6F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.2F));
        HOLD_RECRUIT_SPEAR_ONE_HAND = builder.nextAccessor("biped/living/hold_recruit_spear_one_hand", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        RECRUIT_SPEAR_ONE_HAND_AUTO_1 = builder.nextAccessor("biped/combat/recruit_spear_one_hand_auto_1", (accessor) ->
                new AttackAnimation(0.15F, 0.4F, 0.5F, 0.7F, 1.2F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        RECRUIT_SPEAR_ONE_HAND_AUTO_2 = builder.nextAccessor("biped/combat/recruit_spear_one_hand_auto_2", (accessor) ->
                new AttackAnimation(0.15F, 0.4F, 0.5F, 0.8F, 1.2F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        RECRUIT_SPEAR_ONE_HAND_AUTO_3 = builder.nextAccessor("biped/combat/recruit_spear_one_hand_auto_3", (accessor) ->
                new AttackAnimation(0.15F, 0.4F, 0.5F, 0.7F, 1.3F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        RECRUIT_SPEAR_ONE_HAND_POWER_ATTACK = builder.nextAccessor("biped/combat/recruit_spear_one_hand_power_attack", (accessor) ->
                new AttackAnimation(0.18F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.4F, 0.5F, 0.7F, 0.8F, 1.0F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT)
                                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.FINISHER)),
                        new AttackAnimation.Phase(1.1F, 1.3F, 1.5F, 1.7F, 1.8F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN)
                                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.FINISHER))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.8F)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        RECRUIT_SPEAR_TWO_HAND_AUTO_1 = builder.nextAccessor("biped/combat/recruit_spear_two_hand_auto_1", (accessor) ->
                new AttackAnimation(0.15F, 0.4F, 0.7F, 0.9F, 1.2F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        RECRUIT_SPEAR_TWO_HAND_AUTO_2 = builder.nextAccessor("biped/combat/recruit_spear_two_hand_auto_2", (accessor) ->
                new AttackAnimation(0.15F, 0.4F, 0.7F, 0.9F, 1.2F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        RECRUIT_SPEAR_TWO_HAND_AUTO_3 = builder.nextAccessor("biped/combat/recruit_spear_two_hand_auto_3", (accessor) ->
                new AttackAnimation(0.15F, 0.5F, 0.55F, 0.8F, 1.3F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.2F));
        RECRUIT_SPEAR_TWO_HAND_AUTO_4 = builder.nextAccessor("biped/combat/recruit_spear_two_hand_auto_4", (accessor) ->
                new AttackAnimation(0.15F, 0.6F, 1.0F, 1.5F, 1.65F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.1F));
        RECRUIT_SPEAR_TWO_HAND_AUTO_6 = builder.nextAccessor("biped/combat/recruit_spear_two_hand_auto_6", (accessor) ->
                new AttackAnimation(0.15F, 0.3F, 0.35F, 0.4F, 1.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.2F));
        BLOCK_RECRUIT_SPEAR = builder.nextAccessor("biped/skill/block_recruit_spear", (accessor) -> new StaticAnimation(0.25F,true, accessor, Armatures.BIPED));
    }
}
