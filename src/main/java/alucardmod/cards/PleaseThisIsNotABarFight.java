package alucardmod.cards;

import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

import static alucardmod.util.ActionGenerator.gainPowerAction;

public class PleaseThisIsNotABarFight extends ActionCard {

    public static final String ID = makeID(PleaseThisIsNotABarFight.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            0
    )
            .setMagic(2, 1);

    public PleaseThisIsNotABarFight() {
        super(ID, info);
        this.setExhaust(true);
        this.cardsToPreview = new OrMaybeItIs(false);
    }

    public PleaseThisIsNotABarFight(boolean showPreview) {
        super(ID, info);
        this.setExhaust(true);
        if (showPreview) {
            this.cardsToPreview = new OrMaybeItIs(false);
        }
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            super.upgrade();

            if (this.cardsToPreview != null) {
                this.cardsToPreview.upgrade();
            }
        }
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
