package MoveOperationsFactory;
import Enum.PieceType;

public class MoveOperationsFactory {

    private static MoveOperationsValidator diagonalMoveOperationsValidator;
    private static MoveOperationsValidator oneMoveOperationsValidator;
    private static MoveOperationsValidator pawnMoveOperationsValidator;
    private static MoveOperationsValidator lMoveOperationsValidator;
    private static MoveOperationsValidator straightMoveOperationsValidator;
    private static MoveOperationsValidator multiMoveOperationsValidator;

    private static MoveOperationsValidator getDiagonalMoveOperationsValidator() {
        if(diagonalMoveOperationsValidator ==null) {
            diagonalMoveOperationsValidator = new DiagonalMoveOperationsValidator();
        }

        return diagonalMoveOperationsValidator;
    }

    private static MoveOperationsValidator getOneMoveOperationsValidator() {
        if(oneMoveOperationsValidator ==null){
            oneMoveOperationsValidator = new OneMoveOperationsValidator();
        }
        return oneMoveOperationsValidator;
    }

    private static MoveOperationsValidator getPawnMoveOperationsValidator() {
        if(pawnMoveOperationsValidator == null){
            pawnMoveOperationsValidator = new PawnMoveOperationsValidator();
        }
        return pawnMoveOperationsValidator;
    }

    private static MoveOperationsValidator getlMoveOperationsValidator() {
        if (lMoveOperationsValidator == null){
            lMoveOperationsValidator = new LmoveOperationsValidator();
        }
        return lMoveOperationsValidator;
    }

    private static MoveOperationsValidator getStraightMoveOperationsValidator() {
        if (straightMoveOperationsValidator == null){
            straightMoveOperationsValidator = new StraightMoveOperationsValidator();
        }
        return straightMoveOperationsValidator;
    }

    private static MoveOperationsValidator getMultiMoveOperationsValidator() {
        if (multiMoveOperationsValidator == null){
            multiMoveOperationsValidator = new MultiMoveOperationsValidator();
        }
        return multiMoveOperationsValidator;
    }

    public static MoveOperationsValidator getMoveOperationsValidator(PieceType pieceType)
    {
        switch (pieceType)
        {
            case Bishop:
                return getDiagonalMoveOperationsValidator();
            case King:
                return getOneMoveOperationsValidator();
            case Rook:
                return getStraightMoveOperationsValidator();
            case Pawn:
                return getPawnMoveOperationsValidator();
            case Queen:
                return getMultiMoveOperationsValidator();
            case Knight:
                return getlMoveOperationsValidator();
            default:
                return null;
        }
    }

}
