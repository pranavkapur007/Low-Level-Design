package practice.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Game {

    private Deque<Player> players;
    private Board board;

    public void initialize(int size, String firstPlayerName, String secondPlayerName) {
        PlayerController playerController = new PlayerController();
        playerController.createPlayer(firstPlayerName, new PlayingPiece_O());
        playerController.createPlayer(secondPlayerName, new PlayingPiece_X());
        players = new LinkedList<>(playerController.getPlayerList());

        board = new Board(size);
    }

    public void startGame() {
        while (true) {
            if (!hasEmptyCells()) {
                System.out.println("Game Draw!!!");
                break;
            }
            Player player = players.removeFirst();
            int randNumber = getRandomNumber(board.size * board.size);
            int row = randNumber / board.size;
            int col = randNumber % board.size;
            while (!isEmptyCell(row, col)) {
                randNumber = getRandomNumber(board.size * board.size);
                row = randNumber / board.size;
                col = randNumber % board.size;
            }
            System.out.println("Player: " + player.getName());
            System.out.println("Player Symbol Position: [" + row + "][" + col + "]");
            board.addPiece(row, col, player.getPlayingPiece());
            if (isWinner(row, col, player.getPlayingPiece())) {
                System.out.println("Player: " + player.getName() + " wins");
                break;
            }
            players.addLast(player);
            System.out.println();
        }
    }

    private int getRandomNumber(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    private boolean isEmptyCell(int row, int col) {
        int size = board.size;
        return board.getMatrix()[row][col] == null;
    }

    private boolean isWinner(int row, int col, PlayingPiece playingPiece) {

        int size = board.size;
        PlayingPiece[][] matrix = board.getMatrix();
        boolean isWinner = true;
        // row check
        for (int j = 0; j < size; j++) {
            if (matrix[row][j] != playingPiece) {
                isWinner = false;
                break;
            }
        }

        // col check
        if (!isWinner) {
            isWinner = true;
            for (int j = 0; j < size; j++) {
                if (matrix[j][col] != playingPiece) {
                    isWinner = false;
                    break;
                }
            }
        }

        // left diagonal check
        if (!isWinner) {
            isWinner = true;
            for (int i = 0; i < size; i++) {
                if (matrix[i][i] != playingPiece) {
                    isWinner = false;
                    break;
                }
            }
        }

        // right diagonal check
        if (!isWinner) {
            isWinner = true;
            for (int i = 0; i < size; i++) {
                if (matrix[i][size - i - 1] != playingPiece) {
                    isWinner = false;
                    break;
                }
            }
        }
        return isWinner;
    }

    private boolean hasEmptyCells() {
        int size = board.size;
        PlayingPiece[][] matrix = board.getMatrix();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
