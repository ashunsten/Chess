package ChessBoard;

public interface Board {

    void initializeKnights();
    void initializeRooks();
    void initializeBishop();
    void initializeKings();
    void initializeQueens();
    void initializePawns();
    void movePiece(int currentX, int currentY,int finalX,int finalY);
    String[][] getBoardStatus();
    GenericPiece getPieceFromBoardStatus(int x, int y);
}
