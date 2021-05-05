package ChessBoard;
import Enum.PieceType;
import Enum.PieceSide;
import MoveOperationsFactory.MoveOperationsFactory;

public class ChessPiece implements GenericPiece{

    private final PieceType pieceType;
    private boolean isAlive;
    private PieceSide pieceSide;
    private final String pieceSymbol;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getPieceSymbol() {
        return pieceSymbol;
    }

    public ChessPiece(PieceType pieceType, PieceSide pieceSide, String pieceSymbol) {
        this.pieceType = pieceType;
        this.isAlive = true;
        this.pieceSide = pieceSide;
        this.pieceSymbol = pieceSymbol;
    }

    @Override
    public boolean verifyMoveLocation(int currentX, int currentY, int finalX, int finalY) {
        return MoveOperationsFactory.getMoveOperationsValidator(this.pieceType)
                .validateCurrentMove(currentX,currentY,finalX,finalY);
    }
}
