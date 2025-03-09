package alucardmod.cards;

import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class DarkInferno extends ActionCard {
    // makeID adds the mod ID, so the final ID will be something like "modID:MyCard"
    public static final String ID = makeID(DarkInferno.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.ATTACK,
            CardRarity.RARE,
            CardTarget.ALL_ENEMY,
            3,
            2
    )
            .setDamage(30, 5)
            .setMagic(2, 0);

    public DarkInferno() {
        super(ID, info);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                new DamageAllEnemiesAction(
                        abstractPlayer,
                        damage,
                        DamageInfo.DamageType.NORMAL,
                        AbstractGameAction.AttackEffect.FIRE
                ),
                new MakeTempCardInDiscardAction(
                        new Burn(),
                        magicNumber
                )
        };
    }
}
