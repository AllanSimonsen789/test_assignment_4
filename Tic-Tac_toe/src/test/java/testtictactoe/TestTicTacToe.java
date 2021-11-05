package testtictactoe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestTicTacToe {

    @Test
    public void testStartGame() {
        // Arrange
        StartGameOfTicTacToe start = new StartGameOfTicTacToe();
        // Act
        start.startTheGame();
        // Assert

    }
}
