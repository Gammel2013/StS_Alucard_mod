package alucardmod.cards;

import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static alucardmod.util.ActionGenerator.dealDamageAction;

public class Strike extends ActionCard {

    public static final String ID = makeID(Strike.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.ATTACK,
            CardRarity.BASIC,
            CardTarget.ENEMY,
            1
    )
            .setDamage(6, 3)
            .setTags(
                    CardTags.STARTER_STRIKE,
                    CardTags.STRIKE
            );

    public Strike() {
        super(ID, info);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                dealDamageAction(
                        abstractPlayer,
                        abstractMonster,
                        damage
                )
        };
    }
}
