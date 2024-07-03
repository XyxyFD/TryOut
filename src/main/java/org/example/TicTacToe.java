package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        this.board = new Board();
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
    }

    public void start() {
        board.clear();
        while (!board.isFull() && !hasWinner()) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
            int[] move = getPlayerMove();
            board.place(move[0], move[1], currentPlayer.getMarker());
            switchCurrentPlayer();
        }
        board.print();
        if (hasWinner()) {
            switchCurrentPlayer();
            System.out.println("Player " + currentPlayer.getMarker() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private int[] getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int row = -1, col = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter row (0-2): ");
            row = scanner.nextInt();
            System.out.print("Enter column (0-2): ");
            col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col)) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a row and column between 0 and 2 that are not already occupied.");
            }
        }

        return new int[]{row, col};
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean hasWinner() {
        return board.hasWinner();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
