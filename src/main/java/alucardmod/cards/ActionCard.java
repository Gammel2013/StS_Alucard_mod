package alucardmod.cards;

import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Arrays;

public abstract class ActionCard extends BaseCard {

    public ActionCard(String ID, FullCardStats info) {
        super(ID, info);

        setDamage(info.getBaseDamage(), info.getUpgradeDamage());
        setBlock(info.getBaseBlock(), info.getUpgradeBlock());
        setMagic(info.getBaseMagic(), info.getUpgradeMagic());

        setCostUpgrade(info.getUpgradeCost());

        tags.addAll(Arrays.asList(info.getCardTags()));
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        AbstractGameAction[] actions = getGameActions(abstractPlayer, abstractMonster);
        for (AbstractGameAction action : actions) {
            addToBot(action);
        }
    }

    abstract AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster);
}
