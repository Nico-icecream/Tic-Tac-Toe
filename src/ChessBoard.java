import java.util.ArrayList;

public class ChessBoard {
    private final char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public char[][] getBoard() {
        return board;
    }

    public boolean setBoard(int x, int y, char chequer) {

        if (board[x][y] == ' ') {
            board[x][y] = chequer;
            return true;
        } else {
            return false;
        }
    }

    public void show() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.printf("| %c | %c | %c |\n", board[i][0], board[i][1], board[i][2]);
            System.out.println("-------------");
        }
    }

    public ArrayList<Integer> getFreeSpace(){
        ArrayList<Integer> space=new ArrayList<>();
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]==' '){
                    space.add(i*10+j);
                }
            }
        }
        return space;
    }

    public void init(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j]=' ';
            }
        }
    }

}
