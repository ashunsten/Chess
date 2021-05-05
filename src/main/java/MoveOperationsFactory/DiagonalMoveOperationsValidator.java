package MoveOperationsFactory;

public class DiagonalMoveOperationsValidator implements MoveOperationsValidator{

    @Override
    public boolean validateCurrentMove(int currentX, int currentY, int finalX, int finalY) {

        if(Math.abs(currentX-finalX) == Math.abs(currentY-finalY))
            return true;
        return false;

    }
}
