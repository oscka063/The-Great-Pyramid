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
        myFrame.setVisible(true);
        myFrame.updateArea();
        // initiera spelplanen
    }
}
