package tictactoegame;

import java.util.Scanner;

public class playGroundGrid {

    private char[][] grid;
    private Scanner scanner = new Scanner(System.in);
    boolean turnBool = true;

    public void setupGame() {
        grid = new char[][]{{' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '}};

        printBoard(grid);

    }

    public void printBoard(char[][] grid) {
        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println("");
        }
        System.out.println("------------------------");

        whereToPlaceMarker();

    }

    public int whereToPlaceMarker() {

        if (turnBool == true) {
            turnBool = false;
            System.out.println("X's  turn");
            String placment = scanner.nextLine();
            int placmentInt = Integer.parseInt(placment);

            placeXMarker(placmentInt);

            return placmentInt;
        } else {
            turnBool = true;
            System.out.println("O's  turn");
            String placment = scanner.nextLine();
            int placmentInt = Integer.parseInt(placment);

            placeOMarker(placmentInt, grid);

            return placmentInt;
        }

    }


    public char[][] placeXMarker(int possision) {

        char symbol = 'x';

        switch (possision) {

            case 1:
                grid[0][0] = symbol;
                break;
            case 2:
                grid[0][2] = symbol;
                break;
            case 3:
                grid[0][4] = symbol;
                break;
            case 4:
                grid[2][0] = symbol;
                break;
            case 5:
                grid[2][2] = symbol;
                break;
            case 6:
                grid[2][4] = symbol;
                break;
            case 7:
                grid[4][0] = symbol;
                break;
            case 8:
                grid[4][2] = symbol;
                break;
            case 9:
                grid[4][4] = symbol;
                break;
        }
        if (winningScenario() == true) {
            for (char[] row : grid) {
                for (char c : row) {
                    System.out.print(c);
                }
                System.out.println("");
            }
            System.out.println("------------------------");
            System.out.println("X You Won");
            System.exit(1);
        }


        printBoard(grid);
        return grid;

    }

    public Boolean winningScenario() {
        if (grid[0][0] == 'x' && grid[0][2] == 'x' && grid[0][4] == 'x' ||
                grid[2][0] == 'x' && grid[2][2] == 'x' && grid[2][4] == 'x' ||
                grid[4][0] == 'x' && grid[4][2] == 'x' && grid[4][4] == 'x' ||

                grid[0][0] == 'x' && grid[2][0] == 'x' && grid[4][0] == 'x' ||
                grid[0][2] == 'x' && grid[2][2] == 'x' && grid[4][2] == 'x' ||
                grid[0][4] == 'x' && grid[2][4] == 'x' && grid[4][4] == 'x' ||

                grid[0][0] == 'x' && grid[2][2] == 'x' && grid[4][4] == 'x' ||
                grid[0][4] == 'x' && grid[2][2] == 'x' && grid[4][0] == 'x') {
            return true;
        }
        if (grid[0][0] == 'o' && grid[0][2] == 'o' && grid[0][4] == 'o' ||
                grid[2][0] == 'o' && grid[2][2] == 'o' && grid[2][4] == 'o' ||
                grid[4][0] == 'o' && grid[4][2] == 'o' && grid[4][4] == 'o' ||

                grid[0][0] == 'o' && grid[2][0] == 'o' && grid[4][0] == 'o' ||
                grid[0][2] == 'o' && grid[2][2] == 'o' && grid[4][2] == 'o' ||
                grid[0][4] == 'o' && grid[2][4] == 'o' && grid[4][4] == 'o' ||

                grid[0][0] == 'o' && grid[2][2] == 'o' && grid[4][4] == 'o' ||
                grid[0][4] == 'o' && grid[2][2] == 'o' && grid[4][0] == 'o') {
            return true;
        }

        printBoard(grid);
        return false;
    }

    public char[][] placeOMarker(int possision, char[][] grid) {

        char symbol = 'o';

        switch (possision) {

            case 1:
                grid[0][0] = symbol;
                break;
            case 2:
                grid[0][2] = symbol;
                break;
            case 3:
                grid[0][4] = symbol;
                break;
            case 4:
                grid[2][0] = symbol;
                break;
            case 5:
                grid[2][2] = symbol;
                break;
            case 6:
                grid[2][4] = symbol;
                break;
            case 7:
                grid[4][0] = symbol;
                break;
            case 8:
                grid[4][2] = symbol;
                break;
            case 9:
                grid[4][4] = symbol;
                break;
        }
        if (winningScenario() == true) {
            for (char[] row : grid) {
                for (char c : row) {
                    System.out.print(c);
                }
                System.out.println("");
            }
            System.out.println("------------------------");
            System.out.println("O You Won");
            System.exit(1);
        }

        printBoard(grid);
        return grid;

    }
}
