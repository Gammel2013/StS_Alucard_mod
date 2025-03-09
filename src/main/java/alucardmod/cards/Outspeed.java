package alucardmod.cards;

import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static alucardmod.util.ActionGenerator.gainBlockAction;
import static alucardmod.util.ActionGenerator.gainBlurAction;

public class Outspeed extends ActionCard {

    public static final String ID = makeID(Outspeed.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.SELF,
            2
    )
            .setBlock(8, 5)
            .setMagic(1, 0);

    public Outspeed() {
        super(ID, info);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                gainBlockAction(abstractPlayer, block),
                gainBlurAction(abstractPlayer, magicNumber)
        };
    }
}
