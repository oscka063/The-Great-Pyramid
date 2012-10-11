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
    public int insSquareType;
    public int insSquareRot;
    private int[] playerPositions;
    private int[][] objBoard;
    private int insObj;

    public void setInsSquare(int insType, int insRot) {
        insSquareRot = insRot;
        insSquareType = insType;
    }
    public void setInsObj(int objNumber) {
        insObj = objNumber;
    }

    public int[] getPositions() {
        return playerPositions;
    }
    public void setPositions(int[] pos) {
        playerPositions = pos;
    }
    public int[][] getTypeBoard() {
        return gameInfoTypeBoard;
    }
    public int[][] getRotBoard() {
        return gameInfoRotBoard;
    }
    public int[][] getObjBoard() {
        return objBoard;
    }
    public int getInsObj() {
        return insObj;
    }

    public int getInsType() {
        return insSquareType;
    }
    public int getInsRot() {
        return insSquareRot;
    }


    public GameInformation(int[][] myTypeBoard, int[][] myRotBoard, int[][] myObjBoard, int myInsSquareType, int myInsSquareRot, int myInsObj, int[] playerPositions) {
        this.gameInfoTypeBoard = myTypeBoard;
        this.gameInfoRotBoard = myRotBoard;
        this.insSquareRot = myInsSquareRot;
        this.insSquareType = myInsSquareType;
        this.playerPositions = playerPositions;
        this.objBoard = myObjBoard;
        this.insObj = myInsObj;
    }
}
