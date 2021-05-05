package MoveOperationsFactory;

public class OneMoveOperationsValidator implements MoveOperationsValidator{

    public boolean validateCurrentMove(int currentX, int currentY, int finalX, int finalY) {

        if(Math.abs(currentX-finalX)==1 || Math.abs(currentY-finalY)==1)
            return true;
        return false;
    }
}
