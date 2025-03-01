package alucardmod.cards;

import alucardmod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;

import static alucardmod.util.ActionGenerator.gainPowerAction;

public class ICanDoSomethingForYou extends ActionCard {

    public static final String ID = makeID(ICanDoSomethingForYou.class.getSimpleName());

    private static final CardStats info = new CardStats(
            COLOR,
            // The type. ATTACK/SKILL/POWER/CURSE/STATUS
            CardType.SKILL,
            CardRarity.COMMON,
            // The target. Single target is ENEMY, all enemies is ALL_ENEMY. Look at cards similar to what you want to see what to use.
            CardTarget.SELF,
            // The card's base cost. -1 is X cost, -2 is no cost for unplayable cards like curses, or Reflex.
            0
    );

    public ICanDoSomethingForYou() {
        super(ID, info);
        this.setExhaust(true);
    }

    @Override
    CardTags[] getCardTags() {
        return new CardTags[]{};
    }

    @Override
    protected int getMagic() {
        return 2;
    }

    @Override
    protected int getUpgradedMagic() {
        return 1;
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                new DrawCardAction(
                        abstractPlayer,
                        magicNumber
                )
        };
    }
}
