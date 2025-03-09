package alucardmod.cards;

import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ICanDoSomethingForYou extends ActionCard {

    public static final String ID = makeID(ICanDoSomethingForYou.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            0
    )
            .setMagic(2, 1);

    public ICanDoSomethingForYou() {
        super(ID, info);
        this.setExhaust(true);
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
