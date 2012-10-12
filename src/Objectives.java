import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-10
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class Objectives {
    public int[][] myObjBoard;
    private int size;
    public int insertionObjective;

    public Objectives(int size) {
        myObjBoard = new int[size][size];
        this.size = size;
        initObjectives();
    }

    private void initObjectives() {
        //Sets all objectives to 0
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                myObjBoard[i][j] = 0;
            }
        }
        //90 = blue home, 91 = red home
        myObjBoard[0][0] = 30;
        myObjBoard[size - 1][size - 1] = 31;

        Random rnd = new Random();
        int rndX, rndY;
        for (int i = 1; i <= 10; i++) {
            rndX = rnd.nextInt(size);
            rndY = rnd.nextInt(size);
            if(validSquare(rndX, rndY)) {
                myObjBoard[rndX][rndY] = i;
            } else {
                //If we cannot place the object, we need to random another place for it
                i--;
            }
        }

    }
    private boolean validSquare(int x, int y) {
        if (myObjBoard[x][y] != 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getObjNumber(int x, int y) {
        return myObjBoard[x][y];
    }

    public void insertSquare (int slot, char direction) {
        int tempObjective;
        switch (direction) {
            case 'N' : {
                tempObjective = myObjBoard[slot][0];
                for (int i = 0; i < size - 1; i++) {
                    myObjBoard[slot][i] = myObjBoard[slot][i + 1];
                }
                myObjBoard[slot][size - 1] = insertionObjective;
                insertionObjective = tempObjective;
            }
            break;
            case 'E' : {
                tempObjective = myObjBoard[size - 1][slot];
                for (int i = size - 1; i >= 1; i--) {
                    myObjBoard[i][slot] = myObjBoard[i - 1][slot];
                }
                myObjBoard[0][slot] = insertionObjective;
                insertionObjective = tempObjective;
            }
            break;
            case 'S' : {
                tempObjective = myObjBoard[slot][size - 1];
                for (int i = size - 1; i >= 1; i--) {
                    myObjBoard[slot][i] = myObjBoard[slot][i - 1];
                }
                myObjBoard[slot][0] = insertionObjective;
                insertionObjective = tempObjective;
            }
            break;
            case 'W' : {
                tempObjective = myObjBoard[0][slot];
                for (int i = 0; i < size - 1; i++) {
                    myObjBoard[i][slot] = myObjBoard[i + 1][slot];
                }
                myObjBoard[size - 1][slot] = insertionObjective;
                insertionObjective = tempObjective;
            }
            break;
            default :
                System.out.println("Invalid direction!");
        }

    }

}
