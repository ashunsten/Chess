package ChessBoard;

public interface GenericPiece {

    String getPieceSymbol();
    boolean verifyMoveLocation(int currentX, int currentY, int finalX, int finalY);
}
