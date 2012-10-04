import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-04
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
public class Player implements Serializable {
    private int xPosition;
    private int yPosition;
    private int homeX;
    private int homeY;
    private int playerNumber;

    public Player(int xPosition, int yPosition, int playerNumber) {
        this.homeX = this.xPosition = xPosition;
        this.homeY = this.yPosition = yPosition;
        this.playerNumber = playerNumber;
    }

    public int getXPosition() {
        return xPosition;
      }
    public int getYPosition() {
        return yPosition;
    }

    public void setPosition(int x, int y) {
        xPosition = x;
        yPosition = y;
    }
}
