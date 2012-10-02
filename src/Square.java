/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-09-28
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
public abstract class Square {
    private boolean north, east, south, west;
    protected int rotation = 0;

    private SquareGenerator myGenerator = new SquareGenerator();

    public Square(boolean north, boolean east, boolean south, boolean west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public void rotateSquare() {
        rotation = (rotation + 1) % 4;
        boolean tempDir;
        tempDir = north;
        north = west;
        west = south;
        south = east;
        east = tempDir;
    }
    public abstract SquareImages.imageEnum getType();

    public Square getFixedSquare(SquareGenerator.squareType type, int rotation) {
        return myGenerator.getFixedSquare(type, rotation);

    }
    public Square getRandomSquare() {
        return myGenerator.getRandomSquare();
    }
}
