/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-01
 * Time: 11:53
 * To change this template use File | Settings | File Templates.
 */
public class SquareJunction extends Square {
    public SquareJunction() {
        super(true, true, true, false);
    }
    @Override
    public SquareImages.imageEnum getType() {
        switch (rotation) {
            case 0 : return SquareImages.imageEnum.junctionE;
            case 1 : return SquareImages.imageEnum.junctionS;
            case 2 : return SquareImages.imageEnum.junctionW;
            case 3 : return SquareImages.imageEnum.junctionN;
            default : return null;
        }
    }
}