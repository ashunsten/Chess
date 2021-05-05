package MoveOperationsFactory;

public class PawnMoveOperationsValidator implements MoveOperationsValidator{

    @Override
    public boolean validateCurrentMove(int currentX, int currentY, int finalX, int finalY) {
        if (Math.abs(currentY-finalY)==1 && currentX==finalX)
            return true;
        return false;
    }
}
