package alucardmod.util;

import alucardmod.character.AlucardCharacter;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class FullCardStats extends CardStats {

    protected int baseDamage = 0;
    protected int upgradeDamage = 0;

    protected int baseBlock = 0;
    protected int upgradeBlock = 0;

    protected int baseMagic = 0;
    protected int upgradeMagic = 0;

    protected AbstractCard.CardTags[] cardTags = new AbstractCard.CardTags[0];

    protected int upgradeCost;

    public FullCardStats(
            AbstractCard.CardType cardType,
            AbstractCard.CardRarity cardRarity,
            AbstractCard.CardTarget cardTarget,
            int baseCost
    ) {
        super(AlucardCharacter.Meta.CARD_COLOR, cardType, cardRarity, cardTarget, baseCost);
        this.upgradeCost = baseCost;
    }

    public FullCardStats(
            AbstractCard.CardColor cardColor,
            AbstractCard.CardType cardType,
            AbstractCard.CardRarity cardRarity,
            AbstractCard.CardTarget cardTarget,
            int baseCost
    ) {
        super(cardColor, cardType, cardRarity, cardTarget, baseCost);
        this.upgradeCost = baseCost;
    }

    public FullCardStats(
            AbstractCard.CardType cardType,
            AbstractCard.CardRarity cardRarity,
            AbstractCard.CardTarget cardTarget,
            int baseCost,
            int upgradeCost
    ) {
        super(AlucardCharacter.Meta.CARD_COLOR, cardType, cardRarity, cardTarget, baseCost);
        this.upgradeCost = upgradeCost;
    }

    public FullCardStats(
            AbstractCard.CardColor cardColor,
            AbstractCard.CardType cardType,
            AbstractCard.CardRarity cardRarity,
            AbstractCard.CardTarget cardTarget,
            int baseCost,
            int upgradeCost
    ) {
        super(cardColor, cardType, cardRarity, cardTarget, baseCost);
        this.upgradeCost = upgradeCost;
    }

    public FullCardStats setDamage(int base, int upgrade) {
        this.baseDamage = base;
        this.upgradeDamage = upgrade;

        return this;
    }

    public FullCardStats setBlock(int base, int upgrade) {
        this.baseBlock = base;
        this.upgradeBlock = upgrade;

        return this;
    }

    public FullCardStats setMagic(int base, int upgrade) {
        this.baseMagic = base;
        this.upgradeMagic = upgrade;

        return this;
    }

    public FullCardStats setTags(AbstractCard.CardTags... tags) {
        this.cardTags = tags;

        return this;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getUpgradeDamage() {
        return upgradeDamage;
    }

    public int getBaseBlock() {
        return baseBlock;
    }

    public int getUpgradeBlock() {
        return upgradeBlock;
    }

    public int getBaseMagic() {
        return baseMagic;
    }

    public int getUpgradeMagic() {
        return upgradeMagic;
    }

    public AbstractCard.CardTags[] getCardTags() {
        return cardTags;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }
}
