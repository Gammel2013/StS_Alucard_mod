package alucardmod.cards;

import alucardmod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static alucardmod.util.ActionGenerator.dealDamageAction;
import static alucardmod.util.ActionGenerator.gainPowerAction;

public class OrMaybeItIs extends ActionCard {
    // makeID adds the mod ID, so the final ID will be something like "modID:MyCard"
    public static final String ID = makeID(OrMaybeItIs.class.getSimpleName());

    private static final CardStats info = new CardStats(
            CardColor.COLORLESS,
            CardType.ATTACK,
            CardRarity.SPECIAL,
            CardTarget.ENEMY,
            1
    );

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
            this.cardsToPreview.upgrade();
        }
    }

    @Override
    CardTags[] getCardTags() {
        return new CardTags[] {};
    }

    @Override
    protected int getDamage() {
        return 4;
    }

    @Override
    protected int getUpgradedDamage() {
        return 2;
    }

    @Override
    protected int getMagic() {
        return 1;
    }

    @Override
    protected int getUpgradedMagic() {
        return 1;
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
