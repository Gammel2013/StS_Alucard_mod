package alucardmod.cards;

import alucardmod.util.CardStats;
import alucardmod.util.FullCardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.blue.ReinforcedBody;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import static alucardmod.util.ActionGenerator.dealDamageAction;

public class Gun extends ActionCard {

    public static final String ID = makeID(Gun.class.getSimpleName());

    private static final FullCardStats info = new FullCardStats(
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            -1
    )
            .setDamage(8, 4);

    public Gun() {
        super(ID, info);
    }

    @Override
    AbstractGameAction[] getGameActions(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        ArrayList<AbstractGameAction> actions = new ArrayList<>();
        for (int i = 0; i < this.energyOnUse; i++) {
            actions.add(
                    dealDamageAction(
                            abstractPlayer,
                            abstractMonster,
                            damage
                    )
            );
        }
        return actions.toArray(actions.toArray(new AbstractGameAction[0]));
    }
}
