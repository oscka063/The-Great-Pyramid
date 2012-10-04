import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-09-28
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */
public class BoardViewer extends JComponent {

    private final int SQUARE_SIZE = 64;
    private Board myBoard;
    //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    public Image turn1, turn2, turn3, turn4, straight1, straight2, junction1, junction2, junction3, junction4, arrow1, arrow2, arrow3, arrow4, empty, player1, player2;
    private Player[] myPlayers;


    public EnumMap<SquareImages.imageEnum, Image> imageMap = new EnumMap<SquareImages.imageEnum, Image>(SquareImages.imageEnum.class);

    private void setImageMap() {
        imageMap.put(SquareImages.imageEnum.turnNE, turn1);
        imageMap.put(SquareImages.imageEnum.turnSE, turn2);
        imageMap.put(SquareImages.imageEnum.turnSW, turn3);
        imageMap.put(SquareImages.imageEnum.turnNW, turn4);
        imageMap.put(SquareImages.imageEnum.straightV, straight1);
        imageMap.put(SquareImages.imageEnum.straightH, straight2);
        imageMap.put(SquareImages.imageEnum.junctionE, junction1);
        imageMap.put(SquareImages.imageEnum.junctionS, junction2);
        imageMap.put(SquareImages.imageEnum.junctionW, junction3);
        imageMap.put(SquareImages.imageEnum.junctionN, junction4);
        imageMap.put(SquareImages.imageEnum.arrowN, arrow1);
        imageMap.put(SquareImages.imageEnum.arrowE, arrow2);
        imageMap.put(SquareImages.imageEnum.arrowS, arrow3);
        imageMap.put(SquareImages.imageEnum.arrowW, arrow4);
        imageMap.put(SquareImages.imageEnum.emptySquare, empty);
        imageMap.put(SquareImages.imageEnum.player1, player1);
        imageMap.put(SquareImages.imageEnum.player2, player2);
    }


    public BoardViewer(Board tempBoard, Player[] myPlayers) {
        this.myBoard = tempBoard;
        this.myPlayers = myPlayers;
        loadImages();
        setImageMap();
    }

    public void paintComponent(Graphics g){
        final Graphics2D mySquare = (Graphics2D) g;
        //Painting the board
        for (int i = 0; i < myBoard.size; i++) {
            for (int j = 0; j < myBoard.size; j++) {
                //mySquare.drawImage(turn1, 66*j, 66*i, null);
                Square testSquare = myBoard.getSquare(i, j);
                SquareImages.imageEnum testEnum = testSquare.getType();
                Image testImage = imageMap.get(testEnum);
                mySquare.drawImage(testImage, SQUARE_SIZE*i, SQUARE_SIZE*j, null);
            }
        }
        //Painting the players
        for (int i = 0; i < myPlayers.length; i++) {
            mySquare.drawImage(player1, myPlayers[i].getXPosition()*SQUARE_SIZE, myPlayers[i].getYPosition()*SQUARE_SIZE, null);

        }
    }

        private void loadImages() {
        try {
            turn1 = ImageIO.read(new File("resources/turn1.png"));
            turn2 = ImageIO.read(new File("resources/turn2.png"));
            turn3 = ImageIO.read(new File("resources/turn3.png"));
            turn4 = ImageIO.read(new File("resources/turn4.png"));
            straight1 = ImageIO.read(new File("resources/straight1.png"));
            straight2 = ImageIO.read(new File("resources/straight2.png"));
            junction1 = ImageIO.read(new File("resources/junction1.png"));
            junction2 = ImageIO.read(new File("resources/junction2.png"));
            junction3 = ImageIO.read(new File("resources/junction3.png"));
            junction4 = ImageIO.read(new File("resources/junction4.png"));
            arrow1 = ImageIO.read(new File("resources/arrow1.png"));
            arrow2 = ImageIO.read(new File("resources/arrow2.png"));
            arrow3 = ImageIO.read(new File("resources/arrow3.png"));
            arrow4 = ImageIO.read(new File("resources/arrow4.png"));
            empty = ImageIO.read(new File("resources/empty.png"));
            player1 = ImageIO.read(new File("resources/player1.gif"));
            player2 = ImageIO.read(new File("resources/player2.gif"));
        } catch (IOException e) {}
    }






        //InputStream input = classLoader.getResourceAsStream("turn.png");
        //Image tempSquare = ImageIO.read(input);

        //Rectangle2D tempSquare = new Rectangle2D.Float(0, 0, 64, 64);
        //mySquare.setColor(Color.BLUE);
        //mySquare.fill(tempSquare);
 }
