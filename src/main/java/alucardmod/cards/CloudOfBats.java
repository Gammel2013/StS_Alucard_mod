package alucardmod.cards;

import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;

import static alucardmod.util.ActionGenerator.gainPowerAction;

public class CloudOfBats extends ActionCard {

    public static final String ID = makeID(CloudOfBats.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            2
    )
            .setMagic(1, 0);

    public CloudOfBats() {
        super(ID, info);
        setExhaust(true, false);
        setSelfRetain(true);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                gainPowerAction(
                        abstractPlayer,
                        new IntangiblePlayerPower(abstractPlayer, magicNumber)
                )
        };
    }
}
