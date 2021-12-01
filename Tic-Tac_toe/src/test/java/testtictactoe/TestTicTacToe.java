package testtictactoe;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.stubbing.OngoingStubbing;
import tictactoegame.StartGameOfTicTacToe;
import tictactoegame.playGroundGrid;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestTicTacToe {


    @Mock
    playGroundGrid playGroundGrid;

    @Spy
    char[][] spyGrid;



    char[][] Grid;

    private char[][] grid;

    //tests if the girds is called
    @Test
    public void testCreateGrid() {
        // Arrange
        playGroundGrid test = mock(playGroundGrid.class);
        // Act
        doNothing().when(test).setupGame();
        // Assert
        verify(test);
    }

    @Test
    public void testItRunsTheConsolOutputVerify() {
        // Arrange
        playGroundGrid test = mock(playGroundGrid.class);
        // Act
        doNothing().when(test).printBoard(spyGrid);
        // Assert
        verify(test);
    }

    @BeforeEach
    public void testos() {
        spyGrid = new char[][]{{' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '}};

    }


    @Test
    public void testPlaceXInTopLeft() {
        // Arrange
        playGroundGrid test = mock(playGroundGrid.class);
        //playGroundGrid test =  new playGroundGrid();
        // Act
        grid = new char[][]{{' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '}};
        spyGrid = new char[][]{{' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '}};

        //when(test.whereToPlaceMarker()).thenReturn(1);
        when(test.placeXMarker(1));
        String resive = String.valueOf(grid[0][0]);
        //char[][] result = test.placeXMarker(1, spyGrid);


        System.out.println(Grid);

        // Assert
        assertEquals(resive, 'x');
    }

    @Test
    @Disabled
    public void testWinningScenario() {
        // Arrange
        playGroundGrid test = mock(playGroundGrid.class);
//        playGroundGrid test = new playGroundGrid();
        // Act

        test.setupGame();
        when(test.whereToPlaceMarker()).thenReturn(1);
        when(test.whereToPlaceMarker()).thenReturn(2);
        when(test.whereToPlaceMarker()).thenReturn(3);
        char[][] grid;
        grid = new char[][]{{' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '}};
//        test.placeXMarker(1);
//        test.placeXMarker(2);
//        test.placeXMarker(3);
        boolean result = test.winningScenario();
        System.out.println(result);

        // Assert
        assertEquals(grid[0][4] = 'x', 'x');
        assertEquals(grid[0][0] = 'x', 'x');
        assertEquals(grid[0][2] = 'x', 'x');
//        assertEquals(true, result);
    }


    //        for (int i = 0 ; i < Grid; i++)
//            for(int j = 0 ; j < Grid ; j++)
//            {
//                if ( grid[i][j] == 88)
//                {
//                    Grid this 2 indexes`
//                    break;
//                }
//            }



}
