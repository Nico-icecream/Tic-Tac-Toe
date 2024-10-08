public class AIPlayer extends Player{




    public AIPlayer(ChessBoard chessBoard,char chessman) {
        super(chessBoard,chessman);
        this.chessBoard = chessBoard;
    }

    @Override
    void move() {
        System.out.println("It's my turn!Let me think two second.");
        System.out.println("Two thousands years later.......");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int location = chessBoard.getFreeSpace().get((int) (Math.random() * chessBoard.getFreeSpace().size()));
        chessBoard.setBoard(location / 10, location % 10, chessman);
    }
}

