package practice.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerController {

    private final List<Player> playerList;

    public PlayerController() {
        this.playerList = new ArrayList<>();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public Player createPlayer(String name, PlayingPiece playingPiece) {
        UUID uuid = UUID.randomUUID();
        Player player = new Player(uuid.toString(), name, playingPiece);
        playerList.add(player);
        return player;
    }

}
