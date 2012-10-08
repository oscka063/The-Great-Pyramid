import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-04
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public class GameInformation implements Serializable {
    public int[][] gameInfoBoard;
    private int playerXPosition;
    private int playerYPosition;

    public int getX() {
        return playerXPosition;
    }
    public int getY() {
        return playerYPosition;
    }

    public GameInformation(int[][] myBoard, int playerXPosition, int playerYPosition) {
        this.gameInfoBoard = myBoard;
        this.playerXPosition = playerXPosition;
        this.playerYPosition = playerYPosition;
    }
}
