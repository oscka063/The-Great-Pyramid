

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-01
 * Time: 11:56
 * To change this template use File | Settings | File Templates.
 */
public class SquareTurn extends Square{
    public SquareTurn() {
        super(true, true, false, false);
    }
    private final int typeInt = 0;

    @Override
    public int getType () {
        return typeInt;
    }
    @Override
    public SquareImages.imageEnum getImage() {
        switch (rotation) {
            case 0 : return SquareImages.imageEnum.turnNE;
            case 1 : return SquareImages.imageEnum.turnSE;
            case 2 : return SquareImages.imageEnum.turnSW;
            case 3 : return SquareImages.imageEnum.turnNW;
            default : return null;
        }
    }
}
