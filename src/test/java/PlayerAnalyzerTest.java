import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import analyzers.PlayerAnalyzer;
import entities.Player;

class PlayerAnalyzerTest {

    final PlayerAnalyzer playerAnalyzer;

    PlayerAnalyzerTest() {
        this.playerAnalyzer = new PlayerAnalyzer();
    }

    @Test
    void testNormalPlayer() {
        // Set up test data
        Player playerToTest = new Player();
        playerToTest.setName("playerOne");
        playerToTest.setAge(25);
        playerToTest.setExperience(5);
        playerToTest.setSkills(List.of(2, 2, 2));
        List<Player> playersToTest = List.of(playerToTest);
        // Invoke tested method
        double result = this.playerAnalyzer.calculateScore(playersToTest);
        // Verify expected results
        assertEquals(250.0, result);
    }

    @Test
    void testJuniorPlayer() {
        // Set up test data
        Player playerToTest = new Player();
        playerToTest.setName("playerOne");
        playerToTest.setAge(15);
        playerToTest.setExperience(3);
        playerToTest.setSkills(List.of(3, 3, 3));
        List<Player> playersToTest = List.of(playerToTest);
        // Invoke tested method
        double result = this.playerAnalyzer.calculateScore(playersToTest);
        // Verify expected results
        assertEquals(67.5, result);
    }

    @Test
    void testSeniorPlayer() {
        // Set up test data
        Player playerToTest = new Player();
        playerToTest.setName("playerOne");
        playerToTest.setAge(35);
        playerToTest.setExperience(15);
        playerToTest.setSkills(List.of(4, 4, 4));
        List<Player> playersToTest = List.of(playerToTest);
        // Invoke tested method
        double result = this.playerAnalyzer.calculateScore(playersToTest);
        // Verify expected results
        assertEquals(2520.0, result);
    }

    @Test
    void testMultiplePlayers() {
        // Set up test data
        Player playerToTestOne = new Player();
        playerToTestOne.setName("playerOne");
        playerToTestOne.setAge(25);
        playerToTestOne.setExperience(5);
        playerToTestOne.setSkills(List.of(2, 2, 2));
        Player playerToTestTwo = new Player();
        playerToTestTwo.setName("playerOne");
        playerToTestTwo.setAge(35);
        playerToTestTwo.setExperience(15);
        playerToTestTwo.setSkills(List.of(4, 4, 4));
        Player playerToTestThree = new Player();
        playerToTestThree.setName("playerOne");
        playerToTestThree.setAge(35);
        playerToTestThree.setExperience(15);
        playerToTestThree.setSkills(List.of(4, 4, 4));
        List<Player> playersToTest = List.of(playerToTestOne, playerToTestTwo, playerToTestThree);
        // Invoke tested method
        double result = this.playerAnalyzer.calculateScore(playersToTest);
        // Verify expected results
        assertEquals(5290.0, result);
    }

    @Test
    void testNullSkills() {
        // Set up test data
        Player playerToTest = new Player();
        playerToTest.setName("playerOne");
        playerToTest.setAge(15);
        playerToTest.setExperience(3);
        playerToTest.setSkills(null);
        List<Player> playersToTest = List.of(playerToTest);
        // Verify expected results
        Assertions.assertThrows(NullPointerException.class, () -> {
            // Invoke tested method
            this.playerAnalyzer.calculateScore(playersToTest);
        });
    }

    @Test
    void testZeroPlayers() {
        // Set up test data
        List<Player> playersToTest = new ArrayList<>();
        // Invoke tested method
        double result = this.playerAnalyzer.calculateScore(playersToTest);
        // Verify expected results
        assertEquals(0, result);
    }
}
