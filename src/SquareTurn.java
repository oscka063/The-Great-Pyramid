/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-01
 * Time: 11:56
 * To change this template use File | Settings | File Templates.
 */
public class SquareTurn extends Square {
    public SquareTurn() {
        super(true, true, false, false);
    }
    @Override
    public SquareImages.imageEnum getType() {
        System.out.println("rotationen är: " + rotation);
        switch (rotation) {
            case 0 : return SquareImages.imageEnum.turnNE;
            case 1 : return SquareImages.imageEnum.turnSE;
            case 2 : return SquareImages.imageEnum.turnSW;
            case 3 : return SquareImages.imageEnum.turnNW;
            default : return null;
        }
    }
}
