package practice.tictactoe;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.initialize(3, "Player 1", "Player 2");
        game.startGame();
    }
}
