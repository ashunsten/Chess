package ChessBoard;

import javafx.util.Pair;

import java.util.HashMap;
import Enum.PieceSide;
import Enum.PieceType;

public class ChessBoard implements Board{

    private String[][] boardDistribution;
    private HashMap<Pair<Integer,Integer>, GenericPiece> chessBoardPieces;


    public ChessBoard()
    {
        this.boardDistribution = new String[8][8];
        initializeBoardDistribution();
        this.chessBoardPieces = new HashMap<Pair<Integer,Integer>, GenericPiece>();
        initializeBishop();
        initializeKings();
        initializePawns();
        initializeKnights();
        initializeQueens();
        initializeRooks();
    }
    private void initializeBoardDistribution(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                this.boardDistribution[i][j] = ".";
            }
        }
    }
    @Override
    public void initializeKnights() {

        GenericPiece blackKnight1 = new ChessPiece(PieceType.Knight, PieceSide.Black,"N");
        GenericPiece blackKnight2 = new ChessPiece(PieceType.Knight, PieceSide.Black,"N");

        GenericPiece whiteKnight1 = new ChessPiece(PieceType.Knight, PieceSide.White,"N");
        GenericPiece whiteKnight2 = new ChessPiece(PieceType.Knight, PieceSide.White,"N");

        this.chessBoardPieces.put(new Pair<Integer,Integer>(0,1),blackKnight1);
        this.chessBoardPieces.put(new Pair<Integer,Integer>(0,6),blackKnight2);

        this.chessBoardPieces.put(new Pair<Integer,Integer>(7,1),whiteKnight1);
        this.chessBoardPieces.put(new Pair<Integer,Integer>(7,6),whiteKnight2);

        this.boardDistribution[0][1] = "N";
        this.boardDistribution[0][6] = "N";

        this.boardDistribution[7][1] = "N";
        this.boardDistribution[7][6] = "N";
    }

    @Override
    public void initializeRooks() {

        GenericPiece blackRook1 = new ChessPiece(PieceType.Rook, PieceSide.Black,"R");
        GenericPiece blackRook2 = new ChessPiece(PieceType.Rook, PieceSide.Black,"R");

        GenericPiece whiteRook1 = new ChessPiece(PieceType.Rook, PieceSide.White,"R");
        GenericPiece whiteRook2 = new ChessPiece(PieceType.Rook, PieceSide.White,"R");

        chessBoardPieces.put(new Pair<Integer,Integer>(0,0),blackRook1);
        chessBoardPieces.put(new Pair<Integer,Integer>(0,7),blackRook2);

        chessBoardPieces.put(new Pair<Integer,Integer>(7,0),whiteRook1);
        chessBoardPieces.put(new Pair<Integer,Integer>(7,7),whiteRook2);

        boardDistribution[0][0] = "R";
        boardDistribution[0][7] = "R";

        boardDistribution[7][0] = "R";
        boardDistribution[7][7] = "R";

    }

    @Override
    public void initializeBishop() {

        GenericPiece blackBishop1 = new ChessPiece(PieceType.Bishop, PieceSide.Black,"B");
        GenericPiece blackBishop2 = new ChessPiece(PieceType.Bishop, PieceSide.Black,"B");

        GenericPiece whiteBishop1 = new ChessPiece(PieceType.Bishop, PieceSide.White,"B");
        GenericPiece whiteBishop2 = new ChessPiece(PieceType.Bishop, PieceSide.White,"B");

        chessBoardPieces.put(new Pair<Integer,Integer>(0,2),blackBishop1);
        chessBoardPieces.put(new Pair<Integer,Integer>(0,5),blackBishop2);

        chessBoardPieces.put(new Pair<Integer,Integer>(7,2),whiteBishop1);
        chessBoardPieces.put(new Pair<Integer,Integer>(7,5),whiteBishop2);

        boardDistribution[0][2] = "B";
        boardDistribution[0][5] = "B";

        boardDistribution[7][2] = "B";
        boardDistribution[7][5] = "B";

    }

    @Override
    public void initializeKings() {

        GenericPiece blackKing = new ChessPiece(PieceType.King, PieceSide.Black,"K");

        GenericPiece whiteKing = new ChessPiece(PieceType.King, PieceSide.White,"K");

        this.chessBoardPieces.put(new Pair<Integer,Integer>(0,3),blackKing);

        this.chessBoardPieces.put(new Pair<Integer,Integer>(7,4),whiteKing);

        this.boardDistribution[0][3] = "K";
        this.boardDistribution[7][4] = "K";

    }

    @Override
    public void initializeQueens() {

        GenericPiece blackQueen = new ChessPiece(PieceType.Queen, PieceSide.Black,"Q");

        GenericPiece whiteQueen = new ChessPiece(PieceType.Queen, PieceSide.White,"Q");

        this.chessBoardPieces.put(new Pair<Integer,Integer>(0,4),blackQueen);

        this.chessBoardPieces.put(new Pair<Integer,Integer>(7,3),whiteQueen);

        this.boardDistribution[0][4] = "Q";
        this.boardDistribution[7][3] = "Q";

    }

    @Override
    public void initializePawns() {

        for(int i=0;i<8;i++) {
            GenericPiece blackPawn = new ChessPiece(PieceType.Pawn, PieceSide.Black,"P");
            this.chessBoardPieces.put(new Pair<Integer,Integer>(1,i),blackPawn);
            this.boardDistribution[1][i] = "P";
        }

        for(int i=0;i<8;i++) {
            GenericPiece whitePawn = new ChessPiece(PieceType.Pawn, PieceSide.White,"P");
            this.chessBoardPieces.put(new Pair<Integer,Integer>(6,i),whitePawn);
            this.boardDistribution[6][i] = "P";
        }

    }

    @Override
    public void movePiece(int currentX, int currentY, int finalX, int finalY) {
        try {
            GenericPiece piece = this.getPieceFromBoardStatus(currentX, currentY);
            if (piece.verifyMoveLocation(currentX, currentY, finalX, finalY)) {
                Pair<Integer, Integer> newPieceLocation = new Pair<Integer, Integer>(finalY, finalX);
                Pair<Integer, Integer> oldPieceLocation = new Pair<Integer, Integer>(currentY, currentX);
                this.chessBoardPieces.put(newPieceLocation, piece);
                this.chessBoardPieces.put(oldPieceLocation, null);
                boardDistribution[currentY][currentX] = ".";
                boardDistribution[finalY][finalX] = piece.getPieceSymbol();
            }
        }
        catch (Exception e)
        {
            System.out.println("Invalid Move, Please try again: Piece not Present Here !!");
        }

    }

    @Override
    public String[][] getBoardStatus() {
        return this.boardDistribution;
    }

    @Override
    public GenericPiece getPieceFromBoardStatus(int x, int y) {
        Pair<Integer,Integer> pieceLocation = new Pair<Integer,Integer>(y,x);
        GenericPiece piece = this.chessBoardPieces.get(pieceLocation);
        return  piece;
    }
}
