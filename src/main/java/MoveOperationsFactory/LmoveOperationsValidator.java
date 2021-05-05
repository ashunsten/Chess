package MoveOperationsFactory;

public class LmoveOperationsValidator implements MoveOperationsValidator{

    @Override
    public boolean validateCurrentMove(int currentX, int currentY, int finalX, int finalY) {
        if(Math.abs(currentX-finalX)==2) {
            if(Math.abs(currentY-finalY)==1)
                return true;
        }
        else if(Math.abs(currentY-finalY)==2) {
            if (Math.abs(currentX-finalX)==1) {
                return true;
            }

        }
        return false;
    }
}
