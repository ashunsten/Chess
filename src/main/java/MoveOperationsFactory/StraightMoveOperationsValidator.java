package MoveOperationsFactory;

public class StraightMoveOperationsValidator implements MoveOperationsValidator{

    @Override
    public boolean validateCurrentMove(int currentX, int currentY, int finalX, int finalY) {
        if(currentX == finalX || currentY == finalY)
            return true;
        return false;
    }
}
