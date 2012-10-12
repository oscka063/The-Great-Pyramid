import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-10
 * Time: 16:15
 * To change this template use File | Settings | File Templates.
 */
public class ObjectiveViewer extends JComponent {

    private int SQUARE_SIZE = 64;
    Image objImg;

    public ObjectiveViewer() {
    }

    public void updateObjective(Image objectiveImg) {
        this.objImg = objectiveImg;
    }

    public void paintComponent(Graphics g) {
        final Graphics2D objective = (Graphics2D) g;
        objective.drawImage(objImg, 0, 0, null);
    }
}
