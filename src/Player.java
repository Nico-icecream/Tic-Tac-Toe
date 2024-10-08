public abstract class Player {
     ChessBoard chessBoard;


    public Player(ChessBoard chessBoard,char chessman) {
        this.chessBoard = chessBoard;
        this.chessman=chessman;
    }
    int playerWin=0;
    int playerLost=0;
    int playerTie=0;
    char chessman;
    abstract void move();
}