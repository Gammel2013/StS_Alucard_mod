package alucardmod.cards;

import alucardmod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static alucardmod.util.ActionGenerator.gainBlurAction;
import static alucardmod.util.ActionGenerator.gainBlockAction;

public class Outspeed extends ActionCard {

    public static final String ID = makeID(Outspeed.class.getSimpleName());

    private static final CardStats info = new CardStats(
            COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.SELF,
            2
    );

    public Outspeed() {
        super(ID, info);
    }

    @Override
    CardTags[] getCardTags() {
        return new CardTags[]{

        };
    }

    @Override
    int getDamage() {
        return 0;
    }

    @Override
    int getUpgradedDamage() {
        return 0;
    }

    @Override
    int getBlock() {
        return 7;
    }

    @Override
    int getUpgradedBlock() {
        return 5;
    }

    @Override
    int getMagic() {
        return 1;
    }

    @Override
    int getUpgradedMagic() {
        return 0;
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                gainBlockAction(abstractPlayer, block),
                gainBlurAction(abstractPlayer, magicNumber)
        };
    }
}
