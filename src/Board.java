/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-09-28
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    int size;
    Square[][] myBoard;
    public int[][] myIntTypeBoard;
    public int[][] myIntRotBoard;
    public Square insertionSquare;
    public int myInsSquareRot;
    public int myInsSquareType;

    public Board(int size) {
        this.size = size;
        this.myIntRotBoard = new int[size][size];
        this.myIntTypeBoard = new int[size][size];
        this.myInsSquareRot = new Integer(0);
        this.myInsSquareType = new Integer(0);
        this.myBoard = new Square[size][size];
        initBoard();
        boardToInteger();
        insSquareToInteger();
    }
    public void boardToInteger() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                myIntTypeBoard[i][j] = myBoard[i][j].getType();
                myIntRotBoard[i][j] = myBoard[i][j].getRot();
                System.out.println(myIntTypeBoard[i][j]);
            }
        }
    }
    public void integerToBoard() {
        Square tempSquare = new SquareTurn();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (myIntTypeBoard[i][j]) {
                    case 0 :  myBoard[i][j] = tempSquare.getFixedSquare(SquareGenerator.squareType.Turn, myIntRotBoard[i][j]);
                        break;
                    case 1 :  myBoard[i][j] = tempSquare.getFixedSquare(SquareGenerator.squareType.Junction, myIntRotBoard[i][j]);
                        break;
                    case 2 :  myBoard[i][j] = tempSquare.getFixedSquare(SquareGenerator.squareType.Straight, myIntRotBoard[i][j]);
                        break;
                    default :
                        System.out.println("Invalid Type");
                }
            }
        }
    }
    public void insSquareToInteger() {
        myInsSquareRot = insertionSquare.getRot();
        myInsSquareType = insertionSquare.getType();
    }
    public void integerToInsSquare() {
        Square tempSquare = new SquareTurn();
        switch (myInsSquareType) {
            case 0 :  insertionSquare = tempSquare.getFixedSquare(SquareGenerator.squareType.Turn, myInsSquareRot);
                break;
            case 1 :  insertionSquare= tempSquare.getFixedSquare(SquareGenerator.squareType.Junction, myInsSquareRot);
                break;
            case 2 :  insertionSquare = tempSquare.getFixedSquare(SquareGenerator.squareType.Straight, myInsSquareRot);
                break;
            default :
                System.out.println("Invalid Type");
        }
    }


    private void initBoard () {
        //Initializes the fixed squares on the board
        Square initSquare = new SquareTurn();

        myBoard[0][0] = initSquare.getFixedSquare(SquareGenerator.squareType.Turn, 1);
        myBoard[2][0] = initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 1);
        myBoard[4][0] = initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 1);
        myBoard[6][0] =  initSquare.getFixedSquare(SquareGenerator.squareType.Turn, 2);
        myBoard[0][2] = initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 0);
        myBoard[2][2] =  initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 0);
        myBoard[4][2] =  initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 1);
        myBoard[6][2] =  initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 2);
        myBoard[0][4] =  initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 0);
        myBoard[2][4] = initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 3);
        myBoard[4][4] = initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 2);
        myBoard[6][4] = initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 2);
        myBoard[0][6] =   initSquare.getFixedSquare(SquareGenerator.squareType.Turn, 0);
        myBoard[2][6] =  initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 3);
        myBoard[4][6] =  initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 3);
        myBoard[6][6] =   initSquare.getFixedSquare(SquareGenerator.squareType.Turn, 3);


        //Randomizes the squares that are left on the board.
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < myBoard.length; y++) {
                  if (myBoard[x][y] == null) {


                      myBoard[x][y] = initSquare.getRandomSquare();
                  }
            }
        }

        //Makes insertionSquare
        insertionSquare = initSquare.getRandomSquare();

    }
    public Square getSquare(int x, int y) {
        return myBoard[x][y];
    }

    public void insertSquare (int slot, char direction) {
        Square tempSquare;
        switch (direction) {
            case 'N' : {
                tempSquare = myBoard[slot][0];
                for (int i = 0; i < size - 1; i++) {
                    myBoard[slot][i] = myBoard[slot][i + 1];
                }
                myBoard[slot][size - 1] = insertionSquare;
                insertionSquare = tempSquare;
                 }
            break;
            case 'E' : {
                tempSquare = myBoard[size - 1][slot];
                for (int i = size - 1; i >= 1; i--) {
                    myBoard[i][slot] = myBoard[i - 1][slot];
                }
                myBoard[0][slot] = insertionSquare;
                insertionSquare = tempSquare;
            }
            break;
            case 'S' : {
                tempSquare = myBoard[slot][size - 1];
                for (int i = size - 1; i >= 1; i--) {
                    myBoard[slot][i] = myBoard[slot][i - 1];
                }
                myBoard[slot][0] = insertionSquare;
                insertionSquare = tempSquare;
            }
            break;
            case 'W' : {
                tempSquare = myBoard[0][slot];
                for (int i = 0; i < size - 1; i++) {
                    myBoard[i][slot] = myBoard[i + 1][slot];
                }
                myBoard[size - 1][slot] = insertionSquare;
                insertionSquare = tempSquare;
            }
            break;
            default :
                System.out.println("Invalid direction!");
        }



    }

}