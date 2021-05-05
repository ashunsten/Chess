package MoveOperationsFactory;

public class MultiMoveOperationsValidator implements MoveOperationsValidator{

    public boolean validateCurrentMove(int currentX, int currentY, int finalX, int finalY) {
        if(currentX == finalX || currentY == finalY)
            return true;
        else if(Math.abs(currentX-finalX) == Math.abs(currentY-finalY)) {
            return true;
        }
        return false;
    }
}
