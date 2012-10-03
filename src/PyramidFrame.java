import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-09-28
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */
public class PyramidFrame extends JFrame{



    JPanel boardPanel = new JPanel();
    BoardViewer myBoardViewer;
    ArrowViewer myArrowViewerN, myArrowViewerE, myArrowViewerS, myArrowViewerW;
    //private LinkedList<ArrowViewer> myArrowViewers = new LinkedList() ;
    private JButton[] myArrowViewers = new JButton[12];    //Testa mer med JComponent

    MouseAdapter myMA = new MouseAdapterMod();

    private int aViewerCount = 0;


    public PyramidFrame(String title, Board pyramidBoard) throws HeadlessException  {
        super(title);
        myBoardViewer = new BoardViewer(pyramidBoard);
        setSize(1300, 630);
        setResizable(false);
        initLayout();
        createMenus();
    }


    private void initLayout() {
/*
        myArrowViewerN = new ArrowViewer('N');
        myArrowViewerE = new ArrowViewer('E');
        myArrowViewerS = new ArrowViewer('S');
        myArrowViewerW = new ArrowViewer('W');



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
        GridLayout mainLayout = new GridLayout(1,2);

        GridBagLayout gbl= new GridBagLayout();
        setLayout(mainLayout);
        boardPanel.setLayout(gbl);
        add(boardPanel);
        boardPanel.addMouseListener(myMA);
        add(new JTextArea(20, 100));
        GridBagConstraints c = new GridBagConstraints();



        //Sets the top row
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.anchor = GridBagConstraints.PAGE_START;
        boardPanel.add(new EmptySquare(), c);


        for (int i = 1; i < 8; i++) {
            if((i % 2) != 0) {
                c.fill =GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = 0;
                boardPanel.add(new EmptySquare(), c);
            }
            else {
                myArrowViewers[aViewerCount] = (new JButton("S"));
                c.fill =GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = 0;
                boardPanel.add(myArrowViewers[aViewerCount], c);
                aViewerCount++;
            }
        }
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 8;
        c.gridy = 0;
        boardPanel.add(new EmptySquare(), c);

        //Sets the left column
        c.weightx = 0.2;

        for (int i = 1; i < 8; i++) {
            if((i % 2) != 0) {
                c.fill =GridBagConstraints.BOTH;
                c.gridx = 0;
                c.gridy = i;
                boardPanel.add(new EmptySquare(), c);
            }
            else {
                myArrowViewers[aViewerCount] = (new JButton("E"));
                c.fill =GridBagConstraints.BOTH;
                c.gridx = 0;
                c.gridy = i;
                c.anchor = GridBagConstraints.CENTER;
                boardPanel.add(myArrowViewers[aViewerCount], c);
                aViewerCount++;
            }
        }
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 8;
        boardPanel.add(new EmptySquare(), c);

        //Sets the board in the center
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.2;
        c.weighty = 0.2;
        c.gridheight = 7;
        c.gridwidth = 7;
        c.anchor = GridBagConstraints.CENTER;
        boardPanel.add(myBoardViewer, c);


        //Sets the column to the right of the board

        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridheight = 1;
        c.gridwidth = 1;
        for (int i = 1; i < 8; i++) {
            if((i % 2) != 0) {
                c.fill =GridBagConstraints.BOTH;
                c.gridx = 8;
                c.gridy = i;
                boardPanel.add(new EmptySquare(), c);
            }
            else {
                myArrowViewers[aViewerCount] = (new JButton("W"));
                c.fill =GridBagConstraints.BOTH;
                c.gridx = 8;
                c.gridy = i;
                boardPanel.add(myArrowViewers[aViewerCount], c);
                aViewerCount++;
            }
        }

        //Sets the bottom row
        c.weightx = 0.2;
        c.weighty = 0.2;

        for (int i = 1; i < 8; i++) {
            if((i % 2) != 0) {
                c.fill =GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = 8;
                boardPanel.add(new EmptySquare(), c);
            }
            else {
                myArrowViewers[aViewerCount] = new JButton("N");
                c.fill =GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = 8;
                boardPanel.add(myArrowViewers[aViewerCount], c);
                aViewerCount++;
            }
        }
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 8;
        c.gridy = 8;
        boardPanel.add(new EmptySquare(), c);


    }

    class MouseAdapterMod extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            JButton clickArrow = (JButton)e.getSource();
            for (int i = 0; i < myArrowViewers.length; i++) {
                if (clickArrow == myArrowViewers[i]) {
                    System.out.println("Hallå");
                }

            }


        }
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
