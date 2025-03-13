package alucardmod;

import alucardmod.cards.ActionCard;
import org.json.JSONObject;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AlucardModTest {

    static String[] getCardNames() {

        ArrayList<String> names = new ArrayList<String>();

        Reflections reflections = new Reflections("alucardmod.cards", new SubTypesScanner(false));
        for (Class<? extends ActionCard> c : reflections.getSubTypesOf(ActionCard.class)) {
            String name = c.getSimpleName();

            names.add(name);
        }

        return names.toArray(new String[0]);
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("getCardNames")
    void cardStrings(String name) throws IOException {
        // Grab all keys in CardStrings.json
        InputStream cardstrings = AlucardMod.class.getResourceAsStream("/alucardmod/localization/eng/CardStrings.json");
        assert cardstrings != null;

        byte[] bytes = new byte[cardstrings.available()];
        cardstrings.read(bytes, 0, cardstrings.available());

        String text = new String(bytes, StandardCharsets.UTF_8);
        JSONObject obj = new JSONObject(text);

        Set<String> keys = obj.keySet();

        // Check if there's a key for a given card
        String card_key = "alucardmod:" + name;
        assertTrue(
                keys.contains(card_key),
                "Card " + name + " does not have a cardstring."
        );

    }

    @ParameterizedTest
    @MethodSource("getCardNames")
    void cardImages(String name) {

        String images_path = "/alucardmod/images/cards/";

        String[] folders = new String[]{
                "attack",
                "power",
                "skill"
        };

        boolean has_art = false;

        for (String folder : folders) {
            String full_path = images_path + folder + "/" + name + ".png";
            String full_path_p = images_path + folder + "/" + name + "_p.png";

            boolean f = AlucardMod.class.getResource(full_path) != null;
            boolean f_p = AlucardMod.class.getResource(full_path_p) != null;

            if (f && f_p) {
                has_art = true;
                break;
            }
        }

        assertTrue(has_art, "Card " + name + " does not have art");

    }

    @org.junit.jupiter.api.Test
    void makeID() {
    }

    @org.junit.jupiter.api.Test
    void initialize() {
    }

    @org.junit.jupiter.api.Test
    void receivePostInitialize() {
    }

    @org.junit.jupiter.api.Test
    void receiveEditStrings() {
    }

    @org.junit.jupiter.api.Test
    void receiveEditKeywords() {
    }

    @org.junit.jupiter.api.Test
    void localizationPath() {
    }

    @org.junit.jupiter.api.Test
    void imagePath() {
    }

    @org.junit.jupiter.api.Test
    void characterPath() {
    }

    @org.junit.jupiter.api.Test
    void powerPath() {
    }

    @org.junit.jupiter.api.Test
    void relicPath() {
    }

    @org.junit.jupiter.api.Test
    void receiveEditCharacters() {
    }

    @org.junit.jupiter.api.Test
    void receiveEditCards() {
    }

    @org.junit.jupiter.api.Test
    void receiveEditRelics() {
    }
}