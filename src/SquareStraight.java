/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-01
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */
public class SquareStraight extends Square {
    public SquareStraight() {
        super(true, false, true, false);
    }
    @Override
    public SquareImages.imageEnum getType() {
        switch (rotation) {
            case 0 : return SquareImages.imageEnum.straightV;
            case 1 : return SquareImages.imageEnum.straightH;
            case 2 : return SquareImages.imageEnum.straightV;
            case 3 : return SquareImages.imageEnum.straightH;
            default : return null;
        }
    }

}
