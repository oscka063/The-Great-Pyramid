import java.io.Serializable;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-04
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
public class Player implements Serializable{
    private int size;
    private Board myBoard;
    private int xPosition;
    private int yPosition;
    private int homeX;
    private int homeY;
    private int noOfObjectives = 10;
    public int[] playerObjectives = new int[noOfObjectives/2];
    public int goalObjIndex;
    public boolean collectedAll = false;
    public int objectivesLeft;

    public Player(int yPosition, int xPosition, Board board) {
        this.size = board.size;
        this.yPosition = homeY = yPosition;
        this.xPosition = homeX = xPosition;
        this.myBoard = board;
        this.goalObjIndex = 0;
        objectivesLeft = noOfObjectives/2;
    }
    public void setObjectives(int playerNumber) {
        for (int i = 0; i < noOfObjectives/2; i++) {
                playerObjectives[i] = 0;
        }

        Random rnd = new Random();
        int rndIndex;

        if (playerNumber == 0) {
            for (int i = 1; i < (noOfObjectives/2 + 1); i++) {
                rndIndex = rnd.nextInt(noOfObjectives/2);
                if (playerObjectives[rndIndex] == 0) {
                    playerObjectives[rndIndex] = i;
                } else {
                    i--;
                }
            }
        } else {
            for (int i = (noOfObjectives/2 + 1); i < (noOfObjectives+ 1); i++) {
                rndIndex = rnd.nextInt(noOfObjectives/2);
                if (playerObjectives[rndIndex] == 0) {
                    playerObjectives[rndIndex] = i;
                } else {
                    i--;
                }
            }
        }
    }


    public void visitedGoal() {
        if (goalObjIndex  == playerObjectives.length - 1) {
            collectedAll = true;
        } else {
            goalObjIndex++;
            objectivesLeft--;
        }
    }
    public boolean isHome() {
        return (xPosition == homeX && yPosition == homeY) ;
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

    public void moveNorth() {
        if (yPosition != 0) {
            if (myBoard.myBoard[xPosition][yPosition].north && myBoard.myBoard[xPosition][yPosition - 1].south) {
                yPosition--;
            }
        }
    }
    public void moveEast() {
        if (xPosition != size - 1) {
            if (myBoard.myBoard[xPosition][yPosition].east && myBoard.myBoard[xPosition + 1][yPosition].west) {
            xPosition++;
            }
        }
    }

    public void moveSouth() {
        if (yPosition != size - 1) {
            if (myBoard.myBoard[xPosition][yPosition].south && myBoard.myBoard[xPosition][yPosition + 1].north) {
            yPosition++;
            }
        }
    }
    public void moveWest() {
        if (xPosition != 0) {
            if (myBoard.myBoard[xPosition][yPosition].west && myBoard.myBoard[xPosition -1][yPosition].east) {
            xPosition--;
            }
        }
    }

    public void moveIfOutside () {
        if (xPosition < 0) {
            xPosition = size - 1;
        }
        else if (xPosition > size - 1) {
            xPosition = 0;
        }
        else if (yPosition < 0) {
            yPosition = size - 1;
        }
        else if (yPosition > size - 1) {
            yPosition = 0;
        }
    }

    public void insertMove (int slot, char direction) {
        switch (direction) {
            case 'N' : {
                if (slot == xPosition) {
                    yPosition--;
                }
            }
            break;
            case 'E' : {
                if (slot == yPosition) {
                    xPosition++;
                }
            }
            break;
            case 'S' : {
                if (slot == xPosition) {
                    yPosition++;
                }
            }
            break;
            case 'W' : {
              if (slot == yPosition) {
                  xPosition--;
              }
            }
            break;
            default :
                System.out.println("Invalid direction!");
        }
        moveIfOutside();
    }
}
