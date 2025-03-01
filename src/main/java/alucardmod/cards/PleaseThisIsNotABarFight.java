package alucardmod.cards;

import alucardmod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

import static alucardmod.util.ActionGenerator.dealDamageAction;
import static alucardmod.util.ActionGenerator.gainPowerAction;

public class PleaseThisIsNotABarFight extends ActionCard {
    // makeID adds the mod ID, so the final ID will be something like "modID:MyCard"
    public static final String ID = makeID(PleaseThisIsNotABarFight.class.getSimpleName());

    private static final CardStats info = new CardStats(
            COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            0
    );

    public PleaseThisIsNotABarFight() {
        super(ID, info);
        this.setExhaust(true);
        this.cardsToPreview = new OrMaybeItIs();
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            super.upgrade();
            this.cardsToPreview.upgrade();
        }
    }

    @Override
    CardTags[] getCardTags() {
        return new CardTags[] {};
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
        AbstractCard card = new OrMaybeItIs();
        if (this.upgraded) {
            card.upgrade();
        }
        return new AbstractGameAction[] {
                gainPowerAction(
                        abstractMonster,
                        abstractPlayer,
                        new WeakPower(
                                abstractMonster,
                                magicNumber,
                                false
                        ),
                        magicNumber
                ),
                new MakeTempCardInDiscardAction(
                        card,
                        1
                )
        };
    }
}
