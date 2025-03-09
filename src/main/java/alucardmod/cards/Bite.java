package alucardmod.cards;

import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;

import static alucardmod.util.ActionGenerator.dealDamageAction;
import static alucardmod.util.ActionGenerator.gainPowerAction;

public class Bite extends ActionCard {

    public static final String ID = makeID(Bite.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.ATTACK,
            CardRarity.BASIC,
            CardTarget.ENEMY,
            2
    )
            .setDamage(10, 4)
            .setMagic(2, 1);

    public Bite() {
        super(ID, info);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                dealDamageAction(
                        abstractPlayer,
                        abstractMonster,
                        damage
                ),
                gainPowerAction(
                        abstractPlayer,
                        new DrawCardNextTurnPower(
                                abstractPlayer,
                                magicNumber
                        )
                )
        };
    }
}
