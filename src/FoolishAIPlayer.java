import java.util.ArrayList;

public class FoolishAIPlayer extends Player{

    public FoolishAIPlayer(ChessBoard chessBoard, char chessman) {
        super(chessBoard,chessman);
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

        ArrayList<Integer> freeSpace=chessBoard.getFreeSpace();
        int location =freeSpace.get((int) (Math.random() *freeSpace.size()));
        chessBoard.setBoard(location / 10, location % 10, chessman);
    }
}

