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
    private Objectives myObjectives;
    private int numberOfObjectives;
    private Image mummy, spider, snake, goldMask, spire,jar, scarab, coins, ring, emerald, ruby, sapphire, amethyst, coffin, throne, key, eye, bottle, ankh, papyrus, axe, sword, cane, hat;

    public ObjectiveViewer(Objectives myObjectives) {
        this.myObjectives = myObjectives;
        numberOfObjectives = 24;
        loadImages();
    }

    private void loadImages() {
        try  {
            hat = ImageIO.read(new File("resources/hat.gif"));
            snake = ImageIO.read(new File("resources/snake.gif"));
            key = ImageIO.read(new File("resources/key.gif"));
        } catch (IOException e) {}

    }

    public void paintComponent(Graphics g) {
        final Graphics2D objective = (Graphics2D) g;

        Image tempImage;

        for (int i = 0; i < numberOfObjectives; i++) {
            boolean hasObjective;
            for (int j = 0; j < numberOfObjectives; j++) {
                hasObjective = true;
                switch(myObjectives.getObjNumber(i, j)) {
                    case 1 : tempImage = key;
                        break;
                    case 2 : tempImage = snake;
                        break;
                    case 3 : tempImage = hat;
                        break;
                    default :
                        tempImage = hat;
                        hasObjective = false;
                }
                if (hasObjective) {
                    objective.drawImage(tempImage, SQUARE_SIZE*i, SQUARE_SIZE*j, null);
                }
            }

    }
}
}
