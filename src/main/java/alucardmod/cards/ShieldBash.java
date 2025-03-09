package alucardmod.cards;

import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static alucardmod.util.ActionGenerator.dealDamageAction;
import static alucardmod.util.ActionGenerator.gainBlockAction;

public class ShieldBash extends ActionCard {

    public static final String ID = makeID(ShieldBash.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    )
            .setBlock(5, 3)
            .setDamage(6, 3);

    public ShieldBash() {
        super(ID, info);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                gainBlockAction(abstractPlayer, block),
                dealDamageAction(abstractPlayer, abstractMonster, damage)
        };
    }
}
