import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-04
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public class GameInformation implements Serializable {
    private int[][] gameInfoTypeBoard;
    private int[][] gameInfoRotBoard;
    private int insSquareType;
    private int insSquareRot;
    private int playerXPosition;
    private int playerYPosition;


    public int getX() {
        return playerXPosition;
    }
    public int getY() {
        return playerYPosition;
    }
    public void setPositions(int x, int y) {
        playerXPosition = x;
        playerYPosition = y;
    }
    public int[][] getTypeBoard() {
        return gameInfoTypeBoard;
    }
    public int[][] getRotBoard() {
        return gameInfoRotBoard;
    }
    public int getInsType() {
        return insSquareType;
    }
    public int getInsRot() {
        return insSquareRot;
    }


    public GameInformation(int[][] myTypeBoard, int[][] myRotBoard, int myInsSquareType, int myInsSquareRot, int playerXPosition, int playerYPosition) {
        this.gameInfoTypeBoard = myTypeBoard;
        this.gameInfoRotBoard = myRotBoard;
        this.insSquareRot = myInsSquareRot;
        this.insSquareType = myInsSquareType;
        this.playerXPosition = playerXPosition;
        this.playerYPosition = playerYPosition;
    }
}
