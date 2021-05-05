import MoveOperationsFactory.*;
import org.junit.Assert;
import org.junit.Test;
import Enum.PieceType;

public class MoveOperationsValidatorTest {

    @Test
    public void ValidateCurrentMoveTestForPawnMove(){
        MoveOperationsValidator validator = MoveOperationsFactory.getMoveOperationsValidator(PieceType.Pawn);
        int currentX = 4;
        int currentY = 4;
        for(int i=-2; i<=2;i+=4)
        {
            for (int j=-1;j<=2;j+=2)
            {
                Assert.assertEquals("Invalid Pawn Move", false, validator.validateCurrentMove(currentX,currentY,currentX+i,currentY+j));
            }
        }

        Assert.assertEquals("Invalid Pawn Move !!", true, validator.validateCurrentMove(currentX,currentY,currentX,currentY+1));

    }

    @Test
    public void ValidateCurrentMoveTestForLMove(){
        MoveOperationsFactory factory = new MoveOperationsFactory();
        MoveOperationsValidator validator = factory.getMoveOperationsValidator(PieceType.Knight);
        int currentX = 4;
        int currentY = 4;
        for(int i=-2; i<=2;i+=4)
        {
            for (int j=-1;j<=2;j+=2)
            {
                Assert.assertEquals("Invalid Knight Move !!", true, validator.validateCurrentMove(currentX,currentY,currentX+i,currentY+j));
            }
        }

        for(int i=-2; i<=2;i+=4)
        {
            for (int j=-2;j<=2;j+=4)
            {
                Assert.assertEquals("Invalid Knight Move !!", false, validator.validateCurrentMove(currentX,currentY,currentX+i,currentY+j));
            }
        }

    }

    @Test
    public void ValidateCurrentMoveTestForMultiMove(){
        MoveOperationsFactory factory = new MoveOperationsFactory();
        MoveOperationsValidator validator = factory.getMoveOperationsValidator(PieceType.Queen);
        int currentX = 4;
        int currentY = 4;

        Assert.assertEquals("Invalid Multi Move !!", true, validator.validateCurrentMove(currentX,currentY,currentX+1,currentY+1));
        Assert.assertEquals("Invalid Multi Move !!", true, validator.validateCurrentMove(currentX,currentY,currentX,currentY+1));
        Assert.assertEquals("Invalid Multi Move !!", true, validator.validateCurrentMove(currentX,currentY,currentX-1,currentY));
        Assert.assertEquals("Invalid Multi Move", false, validator.validateCurrentMove(currentX,currentY,currentX+1,currentY+2));

    }


}
