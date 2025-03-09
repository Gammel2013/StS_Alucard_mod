package alucardmod.cards;

import alucardmod.util.CardStats;
import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static alucardmod.util.ActionGenerator.dealDamageAction;
import static alucardmod.util.ActionGenerator.gainPowerAction;

public class OrMaybeItIs extends ActionCard {

    public static final String ID = makeID(OrMaybeItIs.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardColor.COLORLESS,
            CardType.ATTACK,
            CardRarity.SPECIAL,
            CardTarget.ENEMY,
            1
    )
            .setDamage(4, 2)
            .setMagic(1, 1);

    public OrMaybeItIs() {
        super(ID, info);
        this.setExhaust(true);
        this.cardsToPreview = new PleaseThisIsNotABarFight(false);
    }

    public OrMaybeItIs(boolean showPreview) {
        super(ID, info);
        this.setExhaust(true);
        if (showPreview) {
            this.cardsToPreview = new PleaseThisIsNotABarFight(false);
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
        AbstractCard card = new PleaseThisIsNotABarFight();
        if (this.upgraded) {
            card.upgrade();
        }
        return new AbstractGameAction[] {
                dealDamageAction(
                        abstractPlayer,
                        abstractMonster,
                        damage
                ),
                gainPowerAction(
                        abstractMonster,
                        abstractPlayer,
                        new VulnerablePower(
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
