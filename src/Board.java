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

    public Board(int size) {
        this.size = size;
        this.myBoard = new Square[size][size];
        initBoard();
    }

    private void initBoard () {
        //Initializes the fixed squares on the board
        Square initSquare = new SquareTurn();
        initSquare.getFixedSquare(SquareGenerator.squareType.Turn, 1);
        myBoard[0][0] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 1);
        myBoard[2][0] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 1);
        myBoard[4][0] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Turn, 2);
        myBoard[6][0] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 0);
        myBoard[0][2] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 0);
        myBoard[2][2] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 1);
        myBoard[4][2] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 2);
        myBoard[6][2] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 1);
        myBoard[0][4] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 3);
        myBoard[2][4] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 2);
        myBoard[4][4] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 2);
        myBoard[6][4] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Turn, 0);
        myBoard[0][6] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 3);
        myBoard[2][6] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Junction, 3);
        myBoard[4][6] = initSquare;

        initSquare.getFixedSquare(SquareGenerator.squareType.Turn, 3);
        myBoard[6][6] = initSquare;


        //Randomizes the squares that are left on the board.
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < myBoard.length; y++) {
                  if (myBoard[x][y] != null) {

                      initSquare.getRandomSquare();
                      myBoard[x][y] = initSquare;
                  }
            }
        }

    }
    public Square getSquare(int x, int y) {
        return myBoard[x][y];
    }

}