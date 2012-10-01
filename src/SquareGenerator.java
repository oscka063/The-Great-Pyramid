import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-09-28
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class SquareGenerator {
    public enum squareType {Straight, Turn, Junction};
    private int numberOfTypes = squareType.values().length;
    public int getNumberOfTypes() {
        return numberOfTypes;
    }
    public Square getRandomSquare() {
        Random generator = new Random();
        Square tempSquare;
        int randomType = generator.nextInt(2);
        switch (randomType) {
            case 0 : tempSquare = setSquare1();
                break;
            case 1 : tempSquare = setSquare2();
                break;
            default : tempSquare = setSquare1();
        }
        int randomRot = generator.nextInt(4);
        for (int i = 0; i < randomRot; i++) {
             tempSquare.rotateSquare();
        }
        return tempSquare;
    }


    public Square getFixedSquare(squareType type, int rotation) {
        Square tempSquare;
        switch (type) {
            case Turn : tempSquare = setSquare2();
                break;
            case Junction : tempSquare = setSquare3();
                break;
            default : tempSquare = setSquare3();
        }
        for (int i = 0; i < rotation; i++) {
            tempSquare.rotateSquare();
        }
        return tempSquare;
    }



    /*  #   #
        #   #
        #   #
     */
    private Square setSquare1 () {
        return new SquareStraight();
    }

    /* #   #
       #
       # # #
    */
    private Square setSquare2 () {
        return new SquareTurn();
    }

    /* #   #
       #
       #   #
    */
    private Square setSquare3 () {
        return new SquareJunction();
    }

}
