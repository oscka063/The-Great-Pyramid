import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-04
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
public class Player implements Serializable{
    private int xPosition;
    private int yPosition;
    private int homeX;
    private int homeY;

    public Player(int yPosition, int xPosition) {
        this.yPosition = yPosition;
        this.xPosition = xPosition;
    }

    public int getXPosition() {
        return xPosition;
      }
    public int getYPosition() {
        return yPosition;
    }

    public void setHome(int x, int y) {
        this.homeX = x;
        this.xPosition = x;
        this.homeY = y;
        this.yPosition = y;
    }

    public void setPosition(int x, int y) {
        xPosition = x;
        yPosition = y;
    }
}
