package se.elie.homegame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class GameTest {
    @Test
    public void testFight() {
        Game game = new Game();

        game.visitKitchen();
        game.visitHall();


        assertTrue(!game.getBurglar().isConscious(),"tjuven är medvetenlös du van");
    }


}