package alucardmod.cards;

import alucardmod.util.CardStats;
import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static alucardmod.util.ActionGenerator.gainBlockAction;

public class Defend extends ActionCard {

    public static final String ID = makeID(Defend.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.SELF,
            1
    )
            .setBlock(5, 3)
            .setTags(
                    CardTags.STARTER_DEFEND
            );

    public Defend() {
        super(ID, info);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                gainBlockAction(abstractPlayer, block)
        };
    }
}
