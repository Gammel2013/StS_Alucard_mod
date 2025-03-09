package alucardmod.relics;

import alucardmod.character.AlucardCharacter;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.BurningBlood;

public class FamiliarFaces extends BaseRelic {

    private static final String NAME = FamiliarFaces.class.getSimpleName();
    public static final String ID = makeID(NAME);

    private static final RelicTier RARITY = RelicTier.STARTER;
    private static final LandingSound SOUND = LandingSound.CLINK;

    private static final int HEAL = 3;
    private static final int DRAW = 1;

    public FamiliarFaces() {
        super(ID, NAME, AlucardCharacter.Meta.CARD_COLOR, RARITY, SOUND);
    }

    @Override
    public void onVictory() {
        show();

        AbstractPlayer player = AbstractDungeon.player;

        if (player.currentHealth > 0) {
            player.heal(HEAL);
        }
    }

    public void atBattleStart() {
        show();

        this.addToBot(
                new DrawCardAction(
                        AbstractDungeon.player,
                        DRAW
                )
        );
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + HEAL + DESCRIPTIONS[1] + DRAW + DESCRIPTIONS[2];
    }
}
