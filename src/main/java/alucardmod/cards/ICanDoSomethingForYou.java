package alucardmod.cards;

import alucardmod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ICanDoSomethingForYou extends ActionCard {

    public static final String ID = makeID(ICanDoSomethingForYou.class.getSimpleName());

    private static final CardStats info = new CardStats(
            COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
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
