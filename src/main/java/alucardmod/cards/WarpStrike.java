package alucardmod.cards;

import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static alucardmod.util.ActionGenerator.dealDamageAction;

public class WarpStrike extends ActionCard {

    public static final String ID = makeID(WarpStrike.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            2
    )
            .setDamage(12, 4)
            .setMagic(1, 1);

    public WarpStrike() {
        super(ID, info);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                new ApplyPowerAction(
                        abstractMonster,
                        abstractPlayer,
                        new VulnerablePower(
                                abstractMonster,
                                magicNumber,
                                false
                        )
                ),
                dealDamageAction(
                        abstractPlayer,
                        abstractMonster,
                        damage
                )
        };
    }
}
