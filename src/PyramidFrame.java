import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumMap;

/**
 * Created with IntelliJ IDEA.
 * User: oscka063
 * Date: 2012-09-28
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */
public class PyramidFrame extends JFrame{




    GraphicalViewer myViewer;

    public PyramidFrame(String title, Board pyramidBoard) throws HeadlessException  {
        super(title);

        myViewer = new GraphicalViewer(pyramidBoard);
        setLayout(new GridLayout());
        createMenus();
        setSize(1000, 1000);
        add(myViewer, "CENTER");
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
        myViewer.repaint();
    }

}
