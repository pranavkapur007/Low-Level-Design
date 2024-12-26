package practice.tictactoe;

public class Player {

    private String id;
    private String name;
    private PlayingPiece playingPiece;

    public Player(String id, String name, PlayingPiece playingPiece) {
        this.id = id;
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }
}
