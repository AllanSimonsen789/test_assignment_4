package tictactoegame;

public class StartGameOfTicTacToe {


    private static boolean gameOver = false;
    private char[][] grid;


    public static void main(String[] args) {
        playGroundGrid test = new playGroundGrid();

        System.out.println("2 player Tic Tac Toe game");
        System.out.println("The placement is indicated by number you write in the console");
        System.out.println("FX. top left is 1, top right is 3");
        System.out.println("Bottom left is 7, and bottom right is 9");
        System.out.println("You get the idea");
        System.out.println("x always go first");


        test.setupGame();





    }


}
