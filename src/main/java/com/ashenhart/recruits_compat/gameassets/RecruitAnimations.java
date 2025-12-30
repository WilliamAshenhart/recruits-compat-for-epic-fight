package com.ashenhart.recruits_compat.gameassets;

import com.ashenhart.recruits_compat.Recruits_compat;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Armatures;

public class RecruitAnimations {
    public static AnimationManager.AnimationAccessor<StaticAnimation> RECRUIT_SPEAR_LIVING;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_AUTO_1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_AUTO_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_AUTO_3;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_ONEHAND_AUTO_1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_ONEHAND_AUTO_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_ONEHAND_AUTO_3;

    @SubscribeEvent
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(Recruits_compat.MODID, RecruitAnimations::build);
    }
    public static void build(AnimationManager.AnimationBuilder builder) {
        RECRUIT_SPEAR_LIVING = builder.nextAccessor("biped/living/recruit_spear_living", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        RECRUIT_SPEAR_AUTO_1 = builder.nextAccessor("biped/combat/recruit_spear_auto_1", (accessor) ->
                new AttackAnimation(0.15F, 0.2F, 0.3F, 0.5F, 1.5F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.2F));
        RECRUIT_SPEAR_AUTO_2 = builder.nextAccessor("biped/combat/recruit_spear_auto_2", (accessor) ->
                new AttackAnimation(0.15F, 0.3F, 0.35F, 0.4F, 1.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.2F));
        RECRUIT_SPEAR_AUTO_3 = builder.nextAccessor("biped/combat/recruit_spear_auto_3", (accessor) ->
                new AttackAnimation(0.15F, 0.5F, 0.55F, 0.6F, 1.6F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.2F));
        RECRUIT_SPEAR_ONEHAND_AUTO_1 = builder.nextAccessor("biped/combat/recruit_spear_onehand_auto_1", (accessor) ->
                new AttackAnimation(0.15F, 0.4F, 0.5F, 0.6F, 0.8F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        RECRUIT_SPEAR_ONEHAND_AUTO_2 = builder.nextAccessor("biped/combat/recruit_spear_onehand_auto_2", (accessor) ->
                new AttackAnimation(0.15F, 0.2F, 0.3F, 0.5F, 1.0F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        RECRUIT_SPEAR_ONEHAND_AUTO_3 = builder.nextAccessor("biped/combat/recruit_spear_onehand_auto_3", (accessor) ->
                new AttackAnimation(0.15F, 0.4F, 0.5F, 0.7F, 1.3F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
    }
}
