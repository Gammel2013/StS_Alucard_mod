package alucardmod.cards;

import alucardmod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.green.Predator;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;

import static alucardmod.util.ActionGenerator.dealDamageAction;
import static alucardmod.util.ActionGenerator.gainPowerAction;

public class Bite extends ActionCard {
    // makeID adds the mod ID, so the final ID will be something like "modID:MyCard"
    public static final String ID = makeID(Bite.class.getSimpleName());

    private static final CardStats info = new CardStats(
            COLOR,
            // The type. ATTACK/SKILL/POWER/CURSE/STATUS
            CardType.ATTACK,
            // BASIC is for starting cards
            // COMMON/UNCOMMON/RARE
            // SPECIAL for event-only cards
            // STATUS for status effects
            // CURSE for curses, except for special curses like Curse of the Bell and Necronomicurse.
            CardRarity.BASIC,
            // The target. Single target is ENEMY, all enemies is ALL_ENEMY. Look at cards similar to what you want to see what to use.
            CardTarget.ENEMY,
            // The card's base cost. -1 is X cost, -2 is no cost for unplayable cards like curses, or Reflex.
            2
    );

    public Bite() {
        super(ID, info);
    }

    @Override
    CardTags[] getCardTags() {
        return new CardTags[] {
                CardTags.STARTER_STRIKE,
                CardTags.STRIKE
        };
    }

    @Override
    int getDamage() {
        return 10;
    }

    @Override
    int getUpgradedDamage() {
        return 4;
    }

    @Override
    int getBlock() {
        return 0;
    }

    @Override
    int getUpgradedBlock() {
        return 0;
    }

    @Override
    int getMagic() {
        return 2;
    }

    @Override
    int getUpgradedMagic() {
        return 1;
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                dealDamageAction(
                        abstractPlayer,
                        abstractMonster,
                        damage
                ),
                gainPowerAction(
                        abstractPlayer,
                        new DrawCardNextTurnPower(
                                abstractPlayer,
                                magicNumber
                        )
                )
        };
    }
}
