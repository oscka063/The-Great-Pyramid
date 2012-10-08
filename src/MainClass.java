import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-09-28
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public class MainClass {

    static private Board myBoard = new Board(7);
    static private PyramidFrame myFrame = new PyramidFrame("The Great Pyramid", myBoard);

    public static void main(String[] args) {
        boolean startBoolean;
        myFrame.setVisible(true);
        myFrame.updateArea();
        try {
        Socket s;
        ObjectOutputStream oops;
        ObjectInputStream oips;


        if (args.length == 0) {
            startBoolean = true;
        } else{
            startBoolean = false;
        }


        if (startBoolean) {
            s = (new ServerSocket(9283)).accept();
            oops = new ObjectOutputStream(s.getOutputStream());
            oops.writeObject(myFrame.gameInfo);
            myFrame.ready = false;
        } else {
            s = new Socket(args[0], 9283);
            myFrame.ready = true;
        }


            while (true) {

                oips = new ObjectInputStream(s.getInputStream());
                myFrame.gameInfo = (GameInformation)(oips.readObject());
                myBoard.integerToBoard();
                myFrame.updateArea();
                myFrame.ready = true;
                while(myFrame.ready) {
                    Thread.sleep(100);
                }
                oops = new ObjectOutputStream(s.getOutputStream());
                myBoard.boardToInteger();

                oops.writeObject(myFrame.gameInfo);
            }
    } catch (Exception e) {
            System.out.println("Fail" + e); System.exit(1);
        }
    }
}
