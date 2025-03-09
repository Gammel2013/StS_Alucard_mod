package alucardmod.cards;

import alucardmod.util.CardStats;
import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;

import static alucardmod.util.ActionGenerator.gainPowerAction;

public class AlucardsShield extends ActionCard {

    public static final String ID = makeID(AlucardsShield.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.POWER,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            1
    )
            .setMagic(2, 1);

    public AlucardsShield() {
        super(ID, info);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        return new AbstractGameAction[] {
                gainPowerAction(
                        abstractPlayer,
                        new DexterityPower(abstractPlayer, magicNumber)
                )
        };
    }
}
