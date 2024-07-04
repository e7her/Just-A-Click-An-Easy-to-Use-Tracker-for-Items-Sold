package FinalProj;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;

public class MainGUI extends JFrame implements KeyListener{

    // frame
    public static JFrame mainGUIframe;

    // panels
    private JPanel itemsSoldPanel, instructionsPanel;

    // labels
    public static JLabel usageInstructions, munchkinsSoldLabel, donutsSoldLabel, sourStripsSoldLabel, friedOreosSoldLabel;
    public static int munchkinsSoldCount, donutsSoldCount, sourStripsSoldCount, friedOreosSoldCount;

    public MainGUI() {

    try {

        UIManager.setLookAndFeel( new FlatDarculaLaf() );
        System.out.println("LaF success");

    } catch( Exception ex ) {
        System.err.println( "Failed to initialize LaF" );
    }

        mainGUIframe = new JFrame();
        itemsSoldPanel = new JPanel();
        instructionsPanel = new JPanel();
        munchkinsSoldLabel = new JLabel("Munchkins sold: 0");
        donutsSoldLabel = new JLabel("Donuts sold: 0");
        sourStripsSoldLabel = new JLabel("Sour Strips sold: 0");
        friedOreosSoldLabel = new JLabel("Fried Oreos sold: 0");
        usageInstructions = new JLabel("<html>1 for Munchkin<br/>2 for Donut<br/>3 for Sour Strip<br/>4 for Fried Oreo<br/>" +
                                        "F keys 1 to 4 to delete count<br/>0 to reset all counts<br/>Enter to access data records</html>");

        mainGUIframe.setTitle("Just A Click");
        mainGUIframe.setSize(250, 270);
        mainGUIframe.add(itemsSoldPanel);
        mainGUIframe.add(instructionsPanel);
        mainGUIframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainGUIframe.setVisible(true);
        mainGUIframe.addKeyListener(this);
        mainGUIframe.setLayout(new FlowLayout());
        mainGUIframe.setMinimumSize(new Dimension(250, 270));
        mainGUIframe.setResizable(false);
        mainGUIframe.setLocationRelativeTo(null);

        itemsSoldPanel.add(munchkinsSoldLabel);
        itemsSoldPanel.add(donutsSoldLabel);
        itemsSoldPanel.add(sourStripsSoldLabel);
        itemsSoldPanel.add(friedOreosSoldLabel);
        itemsSoldPanel.setLayout(new GridLayout(0, 1));

        instructionsPanel.add(usageInstructions);
        usageInstructions.setForeground(ProgramColors.bodyColor);

        munchkinsSoldLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        donutsSoldLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        sourStripsSoldLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        friedOreosSoldLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        usageInstructions.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        munchkinsSoldLabel.setForeground(ProgramColors.highlightColor);
        donutsSoldLabel.setForeground(ProgramColors.highlightColor);
        sourStripsSoldLabel.setForeground(ProgramColors.highlightColor);
        friedOreosSoldLabel.setForeground(ProgramColors.highlightColor);
    }

    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {

    }
    public void keyReleased(KeyEvent e) { // main controls

        switch (e.getKeyCode()) {

            case KeyEvent.VK_1: { 

                munchkinsSoldCount++;
                munchkinsSoldLabel.setText("Munchkins sold: " + munchkinsSoldCount);
            }
            break;
            case KeyEvent.VK_F1: { 

                if (munchkinsSoldCount == 0) {

                } else {

                    munchkinsSoldCount--;
                    munchkinsSoldLabel.setText("Munchkins sold: " + munchkinsSoldCount); 
                }
            }
            break;
            case KeyEvent.VK_2: { 

                donutsSoldCount++;
                donutsSoldLabel.setText("Donuts sold: " + donutsSoldCount);
            }
            break;
            case KeyEvent.VK_F2: {

                if (donutsSoldCount == 0) {

                } else {

                    donutsSoldCount--;
                    donutsSoldLabel.setText("Donuts sold: " + donutsSoldCount); 
                }
            }
            break;
            case KeyEvent.VK_3: { 
                
                sourStripsSoldCount++;
                sourStripsSoldLabel.setText("Sour Strips sold: " + sourStripsSoldCount);
            }
            break;
            case KeyEvent.VK_F3: { 

                if (sourStripsSoldCount == 0) {

                } else {

                    sourStripsSoldCount--;
                    sourStripsSoldLabel.setText("Sour Strips sold: " + sourStripsSoldCount);
                }
            }
            break;
            case KeyEvent.VK_4: { 

                friedOreosSoldCount++;
                friedOreosSoldLabel.setText("Fried Oreos sold: " + friedOreosSoldCount);
            }
            break;
            case KeyEvent.VK_F4: { 

                if (friedOreosSoldCount == 0) {

                } else {

                    friedOreosSoldCount--;
                    friedOreosSoldLabel.setText("Fried Oreos sold: " + friedOreosSoldCount);
                }
            }
            break;
            case KeyEvent.VK_ENTER: { 

                if (RecordGUI.isInstantiated()) {
                    RecordGUI.getInstance().showRecGUIWindow();
                } else {
                    RecordGUI.getInstance();
                }
            }
                
            break;
            case KeyEvent.VK_0: { 

                munchkinsSoldCount = 0;
                munchkinsSoldLabel.setText("Munchkins sold: " + munchkinsSoldCount);

                donutsSoldCount = 0;
                donutsSoldLabel.setText("Donuts sold: " + donutsSoldCount);

                sourStripsSoldCount = 0;
                sourStripsSoldLabel.setText("Sour Strips sold: " + sourStripsSoldCount);

                friedOreosSoldCount = 0;
                friedOreosSoldLabel.setText("Fried Oreos sold: " + friedOreosSoldCount);
            }
            break;
        }

    }
}
