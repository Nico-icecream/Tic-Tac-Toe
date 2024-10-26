import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(ChessBoard chessBoard, char chessman) {
        super(chessBoard, chessman);
    }

    @Override
    void move() {
        System.out.print("It's your turn now.If you don't want to play please enter -1. ");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int x, y;
            try {
                x = scanner.nextInt();
                y = scanner.nextInt();
            } catch (Exception e) {
                System.out.print("Error!Please enter the number between 0 and 2. ");
                continue;
            }
            if (x == -1 || y==-1) {
                System.exit(0);
            }

            if (x < 3 && y < 3 && x > -1 && y > -1 && chessBoard.setBoard(x, y, chessman)) {
                break;
            } else {
                System.out.print("please enter the correct location. ");
            }
        }
    }
}
