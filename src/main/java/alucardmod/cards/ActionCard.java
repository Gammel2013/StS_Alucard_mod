package alucardmod.cards;

import alucardmod.character.AlucardCharacter;
import alucardmod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Arrays;

public abstract class ActionCard extends BaseCard {

    public static final CardColor COLOR = AlucardCharacter.Meta.CARD_COLOR;

    public ActionCard(String ID, CardStats info) {
        super(ID, info);

        setDamage(getDamage(), getUpgradedDamage());
        setBlock(getBlock(), getUpgradedBlock());
        setMagic(getMagic(), getUpgradedMagic());

        tags.addAll(Arrays.asList(getCardTags()));
    }

    abstract CardTags[] getCardTags();

    abstract int getDamage();
    abstract int getUpgradedDamage();

    abstract int getBlock();
    abstract int getUpgradedBlock();

    abstract int getMagic();
    abstract int getUpgradedMagic();

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        AbstractGameAction[] actions = getGameActions(abstractPlayer, abstractMonster);
        for (AbstractGameAction action : actions) {
            addToBot(action);
        }
    }

    abstract AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster);
}
