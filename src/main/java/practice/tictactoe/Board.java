package practice.tictactoe;

public class Board {

    int size;
    PlayingPiece[][] matrix;

    public Board(int size) {
        this.size = size;
        matrix = new PlayingPiece[size][size];
    }

    public int getSize() {
        return size;
    }

    public PlayingPiece[][] getMatrix() {
        return matrix;
    }

    public void printBoard(){
        for (int i =0;i<size;i++) {
            for (int j = 0;j<size;j++) {
                System.out.print(matrix[i][j]==null?"B":matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public void addPiece(int row, int col, PlayingPiece playingPiece) {
        matrix[row][col] = playingPiece;
    }

}
