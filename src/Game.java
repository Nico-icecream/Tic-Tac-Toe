import java.util.Scanner;

public class Game {
    private final ChessBoard chessBoard = new ChessBoard();
    private final Player player1 = new HumanPlayer(chessBoard,'X');
    private Player player2;
    private enum Status {NotEnd,Player1IsWinner, Player2IsWinner,Tie}
    private Status status=Status.NotEnd;

    void start() {
        while (true) {
            System.out.println("Let's play a game!1P or 2P?");
            Scanner scanner=new Scanner(System.in);
            String num=scanner.next().toUpperCase();
            if (num.equals("1P")) {
                player2=new AIPlayer(chessBoard,'O');
            } else if (num.equals("2P")) {
                player2=new HumanPlayer(chessBoard,'O');
            }else{
                continue;
            }
            status=Status.NotEnd;
            chessBoard.init();
            chessBoard.show();
            while (true) {
                player1.move();
                chessBoard.show();
                judge();
                if (status != Status.NotEnd) {
                    break;
                }
                player2.move();
                chessBoard.show();
                judge();
                if (status != Status.NotEnd) {
                    break;
                }
            }
            System.out.printf("player1 wins %d turn(s),loses %d turn(s) and ties %d turn(s)\n",player1.playerWin,player1.playerLost,player1.playerTie);
            System.out.printf("player2 wins %d turn(s),loses %d turn(s) and ties %d turn(s)\n",player2.playerWin,player2.playerLost,player2.playerTie);
        }
    }

    private void judge() {
        char[][] board = chessBoard.getBoard();
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                getWinner(board[i][0]);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
               getWinner(board[0][i]);
            }
        }
        if(board[0][0]==board[1][1]&&board[2][2]==board[1][1]){
            getWinner(board[0][0]);
        }
        if(board[0][2]==board[1][1]&&board[2][0]==board[1][1]){
            getWinner(board[0][2]);
        }
        if(chessBoard.getFreeSpace().isEmpty()&& status==Status.NotEnd){
            System.out.println("Tie!");
            status=Status.Tie;
            player1.playerTie++;
            player2.playerTie++;
        }
    }

    private void getWinner(char chessman){
        if (chessman == 'X') {
            System.out.println("You win!");
            status=Status.Player1IsWinner;
            player1.playerWin++;
            player2.playerLost++;
        } else if (chessman == 'O') {
            System.out.println("Oh no!You lose.");
            status=Status.Player2IsWinner;
            player1.playerLost++;
            player2.playerWin++;
        }
    }

}
