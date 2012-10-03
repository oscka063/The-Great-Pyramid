import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-10-02
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */
public class ArrowViewer extends JComponent {

    private int mySlot;
    private Image arrowImg;
    private char myDirection;

    public ArrowViewer(char direction, int slot) {
        this.myDirection = direction;
        this.mySlot = slot;

        switch(myDirection) {
            case 'N' : try {
                arrowImg = ImageIO.read(new File("resources/arrow1.png"));
            } catch (IOException e) {}
                break;
            case 'E' : try {
                arrowImg = ImageIO.read(new File("resources/arrow2.png"));
            } catch (IOException e) {}
                break;
            case 'S' : try {
                arrowImg = ImageIO.read(new File("resources/arrow3.png"));
            } catch (IOException e) {}
                break;
            case 'W' : try {
                arrowImg = ImageIO.read(new File("resources/arrow4.png"));
            } catch (IOException e) {}
                break;
            default :
                System.out.println("Invalid direction!");
            }


    }




    public int getSlot() {
        return mySlot;
    }
    public char getDirection() {
        return myDirection;
    }

    public void paintComponent(Graphics g){
        final Graphics2D arrowSquare = (Graphics2D) g;

        arrowSquare.drawImage(arrowImg, 0, 0, null);

/*
        if (myDirection == 'N' | myDirection == 'S') {
            for (int i = 0; i < 7; i++) {
                if((i % 2) == 0) {
                    arrowSquare.drawImage(emptySquare, i*64, 0, null);
                }
                else {
                    arrowSquare.drawImage(arrowImg, i*64, 0, null);
                }
            }
        }
        else {
            for (int i = 0; i < 7; i++) {
                if((i % 2) == 0) {
                    arrowSquare.drawImage(emptySquare, 0, i*64, null);
                }
                else {
                    arrowSquare.drawImage(arrowImg, 0, i*64, null);
                }
            }
        }
        */

        }
    }