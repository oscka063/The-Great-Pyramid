import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-09-28
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */
public class PyramidFrame extends JFrame{

    private int columns = 3;
    private int rows = 3;


    BoardViewer myBoardViewer;
    //ArrowViewer myArrowViewerN, myArrowViewerE, myArrowViewerS, myArrowViewerW;
    private LinkedList<ArrowViewer> myArrowViewers = new LinkedList() ;
    private int aViewerCount = 0;

    public PyramidFrame(String title, Board pyramidBoard) throws HeadlessException  {
        super(title);
        myBoardViewer = new BoardViewer(pyramidBoard);
        setSize(970, 1000);

        initLayout();
        createMenus();
    }


    private void initLayout() {
        /*
        myArrowViewerN = new ArrowViewer('N');
        myArrowViewerE = new ArrowViewer('E');
        */
        //myArrowViewerS = new ArrowViewer('S');
        //myArrowViewerW = new ArrowViewer('W');

        GridBagLayout gbl= new GridBagLayout();
        setLayout(gbl);
        GridBagConstraints c = new GridBagConstraints();
/*
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 7;
        c.gridheight = 1;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.anchor = GridBagConstraints.PAGE_START;

        add(myArrowViewerS, c);

        c.fill =GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridheight = 7;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.LINE_END;

        add(myArrowViewerE, c);

        c.fill =GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.72;
        c.weighty = 0.72;
        c.gridheight = 7;
        c.gridwidth = 7;
        c.anchor = GridBagConstraints.LINE_END;
        add(myBoardViewer, c);

        c.fill =GridBagConstraints.BOTH;
        c.gridx = 9;
        c.gridy = 1;
        c.gridheight = 7;
        c.gridwidth = 1;
        add(myArrowViewerW, c);

        c.fill =GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 9;
        c.gridwidth = 7;
        c.gridheight = 1;
        add(myArrowViewerN, c);
        */



        //Sets the top row
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.anchor = GridBagConstraints.CENTER;
        add(new EmptySquare());

        for (int i = 1; i < 8; i++) {
            if((i % 2) != 0) {
                c.fill =GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = 0;
                add(new EmptySquare(), c);
            }
            else {
                myArrowViewers.addFirst(new ArrowViewer('S'));
                c.fill =GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = 0;
                add(myArrowViewers.peek(), c);
                aViewerCount++;
            }
        }
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 8;
        c.gridy = 0;
        add(new EmptySquare());

        //Sets the left column
        for (int i = 1; i < 8; i++) {
            if((i % 2) != 0) {
                c.fill =GridBagConstraints.BOTH;
                c.gridx = 0;
                c.gridy = i;
                add(new EmptySquare(), c);
            }
            else {
                myArrowViewers.addFirst(new ArrowViewer('E'));
                c.fill =GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = 0;
                c.weightx = 0.2;
                c.weighty = 0.2;
                c.anchor = GridBagConstraints.CENTER;
                add(myArrowViewers.peek(), c);
                aViewerCount++;
            }
        }
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 8;
        add(new EmptySquare(), c);

        //Sets the board in the center
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.2;
        c.weighty = 0.5;
        c.gridheight = 7;
        c.gridwidth = 7;
        c.anchor = GridBagConstraints.CENTER;
        add(myBoardViewer, c);


        //Sets the column to the right of the board
        for (int i = 1; i < 8; i++) {
            if((i % 2) != 0) {
                c.fill =GridBagConstraints.BOTH;
                c.gridx = 8;
                c.gridy = i;
                add(new EmptySquare(), c);
            }
            else {
                myArrowViewers.addFirst(new ArrowViewer('W'));
                c.fill =GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = 0;
                add(myArrowViewers.peek(), c);
                aViewerCount++;
            }
        }

        //Sets the bottom row
        for (int i = 1; i < 8; i++) {
            if((i % 2) != 0) {
                c.fill =GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = 8;
                add(new EmptySquare(), c);
            }
            else {
                myArrowViewers.addFirst(new ArrowViewer('N'));
                c.fill =GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = 0;
                add(myArrowViewers.peek(), c);
                aViewerCount++;
            }
        }
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 8;
        c.gridy = 8;
        add(new EmptySquare(), c);

    }




    public void createMenus() {
        final JMenu file = new JMenu("File");
        JMenuItem fileExit = new JMenuItem("Exit");
        file.add(fileExit);
        final JMenuBar bar = new JMenuBar();
        bar.add(file);
        setJMenuBar(bar);
        fileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int reply = JOptionPane.showConfirmDialog(null, "Really exit the pyramid?", "Quit", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }

            }
        });
    }
    public void updateArea() {
        myBoardViewer.repaint();
    }

}
