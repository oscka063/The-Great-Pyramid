import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-02
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public class EmptySquare extends JComponent{

    private Image emptyImg;

    public EmptySquare() {
        try {
            emptyImg = ImageIO.read(new File("resources/empty.png"));
        } catch (IOException e) {}
    }

    public void paintComponent(Graphics g){
        final Graphics2D emptySquare = (Graphics2D) g;
        emptySquare.drawImage(emptyImg, 0, 0, null);
    }

}
