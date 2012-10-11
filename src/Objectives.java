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
    public int getInsImage() {
        return insertionObjective;
    }

    private void initObjectives() {
        for (int i = 0; i < size - 3; i++) {
            myObjBoard[i][6] = i;
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
