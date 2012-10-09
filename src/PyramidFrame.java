import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-09-28
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */
public class PyramidFrame extends JFrame{

    public boolean ready;
    private final int SQUARE_SIZE = 64;
    private Board myBoard;
    JPanel boardPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    BoardViewer myBoardViewer;
    InsSquareViewer myInsSquareViewer;
    private JButton[] myArrowViewers = new JButton[12];
    private Player[] players = new Player[1];
    public GameInformation gameInfo;

    MouseAdapter myMA = new MouseAdapterMod();

    private int aViewerCount = 0;


    public PyramidFrame(String title, Board pyramidBoard) throws HeadlessException  {
        super(title);
        this.myBoard = pyramidBoard;
        initPlayers();
        this.myBoardViewer = new BoardViewer(pyramidBoard, players);
        setSize(1380, 709);
        setResizable(false);

        myInsSquareViewer = new InsSquareViewer(myBoardViewer.getInsertImage(myBoard.insertionSquare.getImage()));
        initLayout();
        createMenus();
        gameInfo = new GameInformation(myBoard.myIntTypeBoard, myBoard.myIntRotBoard, myBoard.myInsSquareType, myBoard.myInsSquareRot, players[0].getXPosition(), players[0].getYPosition());
    }


    private void initLayout() {
        //Adds the arrow buttons
        for (int i = 0; i < myArrowViewers.length; i++) {

            ImageIcon arrowIcon;
             final int j = i;
             final char dir;
             if (i < 3) {
                 dir = 'S';
                 arrowIcon = new ImageIcon("resources/arrow3.png");
             } else if (i < 6) {
                 dir = 'E';
                 arrowIcon = new ImageIcon("resources/arrow2.png");
             } else if (i < 9) {
                 dir = 'W';
                 arrowIcon = new ImageIcon("resources/arrow4.png");
             } else if (i < 12) {
                 dir = 'N';
                 arrowIcon = new ImageIcon("resources/arrow1.png");
             } else {
                 dir = 'F';
                 arrowIcon = new ImageIcon("resources/arrow1.png");
             }

            myArrowViewers[i] = new JButton(arrowIcon);
            myArrowViewers[i].setMargin(new Insets (0, 0, 0, 0));
            myArrowViewers[i].setBorder(null);
            myArrowViewers[i].setBackground(Color.DARK_GRAY);
            myArrowViewers[i].setMaximumSize(new Dimension(64, 64));

             myArrowViewers[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    myBoard.insertSquare(((j % 3) * 2)  + 1, dir);
                    myInsSquareViewer.repaint();
                    myInsSquareViewer.updateImage(myBoardViewer.getInsertImage(myBoard.insertionSquare.getImage()));
                    myBoardViewer.repaint();
                }
            });
        }

        GridLayout mainLayout = new GridLayout(1,2);

        GridBagLayout gbl= new GridBagLayout();
        setLayout(mainLayout);
        boardPanel.setLayout(gbl);
        boardPanel.setBackground(Color.DARK_GRAY);
        add(boardPanel);
        myBoardViewer.addMouseListener(myMA);
        gamePanel.setLayout(new GridLayout(2, 2));
        add(gamePanel);
        gamePanel.add(myInsSquareViewer);
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
                c.fill =GridBagConstraints.BOTH;
                c.gridx = 8;
                c.gridy = i;
                boardPanel.add(myArrowViewers[aViewerCount], c);
                aViewerCount++;
            }
        }

        //Sets the bottom row
        c.weightx = 0.1;
        c.weighty = 0.1;

        for (int i = 1; i < 8; i++) {
            if((i % 2) != 0) {
                c.fill =GridBagConstraints.BOTH;
                c.gridx = i;
                c.gridy = 8;
                boardPanel.add(new EmptySquare(), c);
            }
            else {
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

    //Initializes the players
    public void initPlayers () {
    players[0] = new Player(0, 0, 0);
    }


    public void implementGameInfo() {
        for (int i = 0; i < players.length; i++) {
            players[i].setPosition(gameInfo.getX(), gameInfo.getY());
        }
        myBoard.myIntRotBoard = gameInfo.getRotBoard();
        myBoard.myIntTypeBoard = gameInfo.getTypeBoard();
        myBoard.myInsSquareRot = gameInfo.getInsRot();
        myBoard.myInsSquareType = gameInfo.getInsType();
        myInsSquareViewer.updateImage(myBoardViewer.getInsertImage(myBoard.insertionSquare.getImage()));
    }

    //Player movement
    class MouseAdapterMod extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (ready) {
                players[0].setPosition((e.getX()* myBoard.size)/(myBoard.size * SQUARE_SIZE), (e.getY()*myBoard.size)/(myBoard.size * SQUARE_SIZE));
                gameInfo.setPositions(players[0].getXPosition(), players[0].getYPosition());
                updateArea();
                ready = false;
            }
        }
    }


    //Creates the menus
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
