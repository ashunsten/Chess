import java.util.Scanner;
import ChessBoard.ChessBoard;

public class Game {

    ChessBoard newGameBoard;
    public Game(){

        this.newGameBoard = new ChessBoard();
    }

    public static void main(String[] args){

        Game newGame = new Game();
        while(true)
        {
            String[][] gameStatus = newGame.newGameBoard.getBoardStatus();
            for(int i=0;i<8;i++){
                System.out.println("--------------------------------");
                for(int j=0;j<8;j++){
                    System.out.print(gameStatus[i][j] + "  " + "|");
                }
                System.out.println();
            }

            Scanner sc= new Scanner(System.in);
            Integer currentX = sc.nextInt();
            Integer currentY = sc.nextInt();
            Integer finalX = sc.nextInt();
            Integer finalY = sc.nextInt();
            System.out.print(currentX);
            System.out.print(currentY);
            System.out.print(finalX);
            System.out.print(finalY);

            if(currentX == -1)
                break;
            newGame.newGameBoard.movePiece(currentX,currentY,finalX,finalY);
        }
    }
}
