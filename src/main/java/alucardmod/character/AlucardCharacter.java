package alucardmod.character;

import alucardmod.cards.Bite;
import alucardmod.cards.Defend;
import alucardmod.cards.Outspeed;
import alucardmod.cards.Strike;
import alucardmod.relics.FamiliarFaces;
import basemod.BaseMod;
import basemod.abstracts.CustomEnergyOrb;
import basemod.abstracts.CustomPlayer;
import basemod.animations.SpriterAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.screens.CharSelectInfo;

import java.util.ArrayList;

import static alucardmod.AlucardMod.characterPath;
import static alucardmod.AlucardMod.makeID;

public class AlucardCharacter extends CustomPlayer {
    // Stats
    public static final int ENERGY_PER_TURN = 3;
    public static final int MAX_HP = 70;
    public static final int STARTING_GOLD = 99;
    public static final int CARD_DRAW = 5;
    public static final int ORB_SLOTS = 0;

    // Strings
    // This should match whatever you have in the CharacterStrings.json file
    private static final String ID = makeID("Alucard");
    private static String[] getNames() { return CardCrawlGame.languagePack.getCharacterString(ID).NAMES; }
    private static String[] getText() { return CardCrawlGame.languagePack.getCharacterString(ID).TEXT; }

    // This static class is necessary to avoid certain quirks of Java classloading when registering the character.
    public static class Meta {

        // These are used to identify your character, as well as your character's card color.
        @SpireEnum
        public static PlayerClass AlucardClass;

        // These two MUST match. Change it to something unique for your character.
        @SpireEnum(name = "ALUCARD_GRAY_COLOR")
        public static AbstractCard.CardColor CARD_COLOR;
        @SpireEnum(name = "ALUCARD_GRAY_COLOR") @SuppressWarnings("unused")
        public static CardLibrary.LibraryType LIBRARY_COLOR;

        // Character select images
        private static final String CHAR_SELECT_BUTTON = characterPath("select/button.png");
        private static final String CHAR_SELECT_PORTRAIT = characterPath("select/portrait.png");

        // Character card images
        private static final String BG_ATTACK = characterPath("cardback/bg_attack.png");
        private static final String BG_ATTACK_P = characterPath("cardback/bg_attack_p.png");
        private static final String BG_SKILL = characterPath("cardback/bg_skill.png");
        private static final String BG_SKILL_P = characterPath("cardback/bg_skill_p.png");
        private static final String BG_POWER = characterPath("cardback/bg_power.png");
        private static final String BG_POWER_P = characterPath("cardback/bg_power_p.png");
        private static final String ENERGY_ORB = characterPath("cardback/energy_orb.png");
        private static final String ENERGY_ORB_P = characterPath("cardback/energy_orb_p.png");
        private static final String SMALL_ORB = characterPath("cardback/small_orb.png");

        // This is used to color *some* images, but NOT the actual cards.
        // For that, edit the images in the cardback folder!
        private static final Color cardColor = new Color(128f/255f, 128f/255f, 128f/255f, 1f);

        // Methods that will be used in the main mod file
        public static void registerColor() {
            BaseMod.addColor(
                    CARD_COLOR,
                    cardColor,
                    BG_ATTACK,
                    BG_SKILL,
                    BG_POWER,
                    ENERGY_ORB,
                    BG_ATTACK_P,
                    BG_SKILL_P,
                    BG_POWER_P,
                    ENERGY_ORB_P,
                    SMALL_ORB
            );
        }

        public static void registerCharacter() {
            BaseMod.addCharacter(
                    new AlucardCharacter(),
                    CHAR_SELECT_BUTTON,
                    CHAR_SELECT_PORTRAIT
            );
        }
    }


    // In-game images

    // Shoulder 1 and 2 are used at rest sites.
    private static final String SHOULDER_1 = characterPath("shoulder.png");
    private static final String SHOULDER_2 = characterPath("shoulder2.png");
    // Corpse is when you die.
    private static final String CORPSE = characterPath("corpse.png");

    // Textures used for the energy orb
    private static final String[] orbTextures = {
            characterPath("energyorb/layer1.png"), //When you have energy
            characterPath("energyorb/layer2.png"),
            characterPath("energyorb/layer3.png"),
            characterPath("energyorb/layer4.png"),
            characterPath("energyorb/layer5.png"),
            characterPath("energyorb/cover.png"), //"container"
            characterPath("energyorb/layer1d.png"), //When you don't have energy
            characterPath("energyorb/layer2d.png"),
            characterPath("energyorb/layer3d.png"),
            characterPath("energyorb/layer4d.png"),
            characterPath("energyorb/layer5d.png")
    };

    // Speeds at which each layer of the energy orb texture rotates. Negative is backwards.
    private static final float[] layerSpeeds = new float[] {
            -20.0F,
            20.0F,
            -40.0F,
            40.0F,
            360.0F
    };

    // Actual character class code below this point
    public AlucardCharacter() {
        super(
                getNames()[0],
                Meta.AlucardClass,
                new CustomEnergyOrb(
                        orbTextures,
                        characterPath("energyorb/vfx.png"),
                        layerSpeeds
                ),
                new SpriterAnimation(
                        characterPath("animation/default.scml")
                )
        );

        float[] hitbox = {20f, -20f, 200f, 250f};

        initializeClass(
                null,
                SHOULDER_2,
                SHOULDER_1,
                CORPSE,
                getLoadout(),
                hitbox[0],
                hitbox[1],
                hitbox[2],
                hitbox[3],
                new EnergyManager(ENERGY_PER_TURN)
        );

        // Location for text bubbles. You can adjust it as necessary later. For most characters, these values are fine.
        dialogX = (drawX + 0.0F * Settings.scale);
        dialogY = (drawY + 220.0F * Settings.scale);
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        // List of IDs of cards for your starting deck.
        // If you want multiple of the same card, you have to add it multiple times.
        ArrayList<String> retVal = new ArrayList<>();

        retVal.add(Strike.ID);
        retVal.add(Strike.ID);
        retVal.add(Strike.ID);
        retVal.add(Strike.ID);
        retVal.add(Strike.ID);

        retVal.add(Defend.ID);
        retVal.add(Defend.ID);
        retVal.add(Defend.ID);
        retVal.add(Defend.ID);
        retVal.add(Defend.ID);

        retVal.add(Outspeed.ID);

        retVal.add(Bite.ID);

        return retVal;
    }

    @Override
    public ArrayList<String> getStartingRelics() {
        // IDs of starting relics. You can have multiple, but one is recommended.
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(FamiliarFaces.ID);

        return retVal;
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        // This card is used for the Gremlin card matching game.
        // It should be a non-strike non-defend starter card, but it doesn't have to be.
        return new Strike();
    }

    /*- Below this is methods that you should *probably* adjust, but don't have to. -*/

    @Override
    public int getAscensionMaxHPLoss() {
        // Max hp reduction at ascension 14+
        return 4;
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        // These attack effects will be used when you attack the heart.
        return new AbstractGameAction.AttackEffect[] {
                AbstractGameAction.AttackEffect.SLASH_VERTICAL,
                AbstractGameAction.AttackEffect.SLASH_HEAVY,
                AbstractGameAction.AttackEffect.BLUNT_HEAVY
        };
    }

    // Used for some vfx on moving cards (sometimes) (maybe)
    private final Color cardRenderColor = Color.LIGHT_GRAY.cpy();
    // Used for card trail vfx during gameplay.
    private final Color cardTrailColor = Color.LIGHT_GRAY.cpy();
    // Used for a screen tint effect when you attack the heart.
    private final Color slashAttackColor = Color.LIGHT_GRAY.cpy();

    @Override
    public Color getCardRenderColor() {
        return cardRenderColor;
    }

    @Override
    public Color getCardTrailColor() {
        return cardTrailColor;
    }

    @Override
    public Color getSlashAttackColor() {
        return slashAttackColor;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        // Font used to display your current energy.
        // energyNumFontRed, Blue, Green, and Purple are used by the basegame characters.
        // It is possible to make your own, but not convenient.
        return FontHelper.energyNumFontRed;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {
        // This occurs when you click the character's button in the character select screen.
        // See SoundMaster for a full list of existing sound effects, or look at BaseMod's wiki for adding custom audio.
        CardCrawlGame.sound.playA("ATTACK_DAGGER_2", MathUtils.random(-0.2F, 0.2F));
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.MED, ScreenShake.ShakeDur.SHORT, false);
    }
    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        // Similar to doCharSelectScreenSelectEffect, but used for the Custom mode screen. No shaking.
        return "ATTACK_DAGGER_2";
    }

    // Don't adjust these four directly, adjust the contents of the CharacterStrings.json file.
    @Override
    public String getLocalizedCharacterName() {
        return getNames()[0];
    }
    @Override
    public String getTitle(PlayerClass playerClass) {
        return getNames()[1];
    }
    @Override
    public String getSpireHeartText() {
        return getText()[1];
    }
    @Override
    public String getVampireText() {
        // Generally, the only difference in this text is how the vampires refer to the player.
        return getText()[2];
    }

    /*- You shouldn't need to edit any of the following methods. -*/

    //This is used to display the character's information on the character selection screen.
    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo(getNames()[0], getText()[0],
                MAX_HP, MAX_HP, ORB_SLOTS, STARTING_GOLD, CARD_DRAW, this,
                getStartingRelics(), getStartingDeck(), false);
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return Meta.CARD_COLOR;
    }

    @Override
    public AbstractPlayer newInstance() {
        //Makes a new instance of your character class.
        return new AlucardCharacter();
    }
}