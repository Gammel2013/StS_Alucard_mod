package alucardmod.cards;

import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FrailPower;

import static alucardmod.util.ActionGenerator.dealDamageAction;
import static alucardmod.util.ActionGenerator.gainBlockAction;

public class SummonSpirit extends ActionCard {

    public static final String ID = makeID(SummonSpirit.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    )
            .setDamage(7, 4)
            .setMagic(2, 1);

    public SummonSpirit() {
        super(ID, info);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                dealDamageAction(abstractPlayer, abstractMonster, damage),
                new ApplyPowerAction(
                        abstractMonster,
                        abstractPlayer,
                        new FrailPower(
                                abstractMonster,
                                magicNumber,
                                false
                        )
                )
        };
    }
}
