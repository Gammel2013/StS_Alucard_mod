package alucardmod.cards;

import alucardmod.util.CardStats;
import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;

import static alucardmod.util.ActionGenerator.gainPowerAction;

public class HeadfirstForHalos extends ActionCard {

    public static final String ID = makeID(HeadfirstForHalos.class.getSimpleName());

    private static final int SELF_DAMAGE = 10;
    private static final String SELF_DAMAGE_KEY = "self_damage";

    private static final FullCardStats info = new FullCardStats(
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    )
            .setMagic(1, 1);

    public HeadfirstForHalos() {
        super(ID, info);
        setCustomVar(SELF_DAMAGE_KEY, SELF_DAMAGE);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                new LoseHPAction(
                        abstractPlayer,
                        abstractPlayer,
                        customVar(SELF_DAMAGE_KEY)
                ),
                gainPowerAction(
                        abstractPlayer,
                        new IntangiblePlayerPower(abstractPlayer, magicNumber)
                )
        };
    }
}
