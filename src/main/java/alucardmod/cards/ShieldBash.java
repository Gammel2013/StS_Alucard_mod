package alucardmod.cards;

import alucardmod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static alucardmod.util.ActionGenerator.dealDamageAction;
import static alucardmod.util.ActionGenerator.gainBlockAction;

public class ShieldBash extends ActionCard {

    public static final String ID = makeID(ShieldBash.class.getSimpleName());

    private static final CardStats info = new CardStats(
            COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    public ShieldBash() {
        super(ID, info);
    }

    @Override
    CardTags[] getCardTags() {
        return new CardTags[]{

        };
    }

    @Override
    protected int getBlock() {
        return 5;
    }

    @Override
    protected int getUpgradedBlock() {
        return 3;
    }

    @Override
    protected int getDamage() {
        return 6;
    }

    @Override
    protected int getUpgradedDamage() {
        return 3;
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                gainBlockAction(abstractPlayer, block),
                dealDamageAction(abstractPlayer, abstractMonster, damage)
        };
    }
}
