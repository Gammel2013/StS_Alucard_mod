package alucardmod.util;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.BlurPower;

public class ActionGenerator {

    public static DamageAction dealDamageAction(
            AbstractPlayer abstractPlayer,
            AbstractMonster abstractMonster,
            int amount
    ) {
        return dealDamageAction(
                abstractPlayer,
                abstractMonster,
                amount,
                DamageInfo.DamageType.NORMAL,
                AbstractGameAction.AttackEffect.SLASH_VERTICAL
        );
    }

    public static DamageAction dealDamageAction(
            AbstractPlayer abstractPlayer,
            AbstractMonster abstractMonster,
            int amount,
            DamageInfo.DamageType damageType,
            AbstractGameAction.AttackEffect attackEffect
    ) {
        return new DamageAction(
                abstractMonster,
                new DamageInfo(abstractPlayer, amount, damageType),
                attackEffect
        );
    }

    public static GainBlockAction gainBlockAction(
            AbstractCreature target,
            int amount
    ) {
        return new GainBlockAction(target, amount);
    }

    public static GainBlockAction gainBlockAction(
            AbstractCreature target,
            AbstractCreature source,
            int amount,
            boolean superFast
    ) {
        return new GainBlockAction(
                target,
                source,
                amount,
                superFast
        );
    }

    public static ApplyPowerAction gainBlurAction(
            AbstractCreature target,
            int amount
    ) {
        return gainBlurAction(
                target,
                target,
                amount
        );
    }

    public static ApplyPowerAction gainBlurAction(
            AbstractCreature target,
            AbstractCreature source,
            int amount
    ) {
        return gainPowerAction(
                target,
                source,
                new BlurPower(target, amount)
        );
    }

    public static ApplyPowerAction gainPowerAction(
            AbstractCreature target,
            AbstractPower power,
            int amount
    ) {
        return gainPowerAction(
                target,
                target,
                power,
                amount
        );
    }

    public static ApplyPowerAction gainPowerAction(
            AbstractCreature target,
            AbstractCreature source,
            AbstractPower power,
            int amount
    ) {
        return new ApplyPowerAction(
                target,
                source,
                power,
                amount
        );
    }

    public static ApplyPowerAction gainPowerAction(
            AbstractCreature target,
            AbstractPower power
    ) {
        return gainPowerAction(
                target,
                target,
                power
        );
    }

    public static ApplyPowerAction gainPowerAction(
            AbstractCreature target,
            AbstractCreature source,
            AbstractPower power
    ) {
        return new ApplyPowerAction(
                target,
                source,
                power
        );
    }
}
