import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-09
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 */
public class InsSquareViewer extends JComponent {
    private Image myImg;

    public InsSquareViewer(Image tempImg) {
        updateImage(tempImg);
    }
    public void updateImage(Image tempImg) {
        this.myImg = tempImg;
    }

    public void paintComponent(Graphics g) {
        final Graphics2D mySquare = (Graphics2D) g;
        mySquare.drawImage(myImg, 0, 0, null);
    }
}
