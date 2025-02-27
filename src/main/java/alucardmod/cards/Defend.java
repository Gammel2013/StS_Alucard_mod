package alucardmod.cards;

import alucardmod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static alucardmod.util.ActionGenerator.gainBlockAction;

public class Defend extends ActionCard {

    public static final String ID = makeID(Defend.class.getSimpleName());

    private static final CardStats info = new CardStats(
            COLOR,
            // The type. ATTACK/SKILL/POWER/CURSE/STATUS
            CardType.SKILL,
            // BASIC is for starting cards
            // COMMON/UNCOMMON/RARE
            // SPECIAL for event-only cards
            // STATUS for status effects
            // CURSE for curses, except for special curses like Curse of the Bell and Necronomicurse.
            CardRarity.BASIC,
            // The target. Single target is ENEMY, all enemies is ALL_ENEMY. Look at cards similar to what you want to see what to use.
            CardTarget.SELF,
            // The card's base cost. -1 is X cost, -2 is no cost for unplayable cards like curses, or Reflex.
            1
    );

    public Defend() {
        super(ID, info);
    }

    @Override
    CardTags[] getCardTags() {
        return new CardTags[]{
            CardTags.STARTER_DEFEND,
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
        return 5;
    }

    @Override
    int getUpgradedBlock() {
        return 3;
    }

    @Override
    int getMagic() {
        return 0;
    }

    @Override
    int getUpgradedMagic() {
        return 0;
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                gainBlockAction(abstractPlayer, block)
        };
    }
}
