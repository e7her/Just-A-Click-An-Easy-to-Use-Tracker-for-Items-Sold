package FinalProj;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarculaLaf;

public class RecordGUI extends JFrame implements ActionListener, KeyListener {

    // frame
    public static JFrame recGUIframe;

    // panels
    private JPanel cmbbPanel, finalizePanel, tablePanel, deselectionPanel, optionsAndTablePanel, theOnePanel;

    // labels
    private JLabel deselectionLabel;

    // combobox
    public static JComboBox<Integer> recDay;
    public static JComboBox<String> recMonth;
    public static JComboBox<Integer> recYear;

    // buttons
    public static JButton maker, unmaker, remaker;

    // table stuff
    public static JTable recordsTable;
    public static DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    static RecordGUI onlyOneRecGUI = new RecordGUI();

    private RecordGUI() {

    try {
        UIManager.put("ComboBox.selectionBackground", new ColorUIResource(ProgramColors.highlightColor));
        UIManager.put("ComboBox.selectionForeground", new ColorUIResource(ProgramColors.lesserHighlightColor
        ));
        
    } catch (Exception e) {
        System.out.println("debug");
    }
    try {

        UIManager.setLookAndFeel( new FlatDarculaLaf() );
        System.out.println("LaF success");

    } catch( Exception ex ) {
        System.err.println( "Failed to initialize LaF" );
    }

        Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Integer[] years = {2020, 2021, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030, 2031, 2032, 2033, 2034, 2035,
                            2036, 2037, 2038, 2039, 2040, 2041, 2042, 2043, 2044, 2045, 2046, 2047, 2048, 2049, 2050};

        recGUIframe = new JFrame();
        cmbbPanel = new JPanel();
        finalizePanel = new JPanel();
        tablePanel = new JPanel();
        deselectionPanel = new JPanel();
        optionsAndTablePanel = new JPanel();
        recDay = new JComboBox<>(days);
        recMonth = new JComboBox<>(months);
        recYear = new JComboBox<>(years);
        maker = new JButton();
        unmaker = new JButton();
        remaker = new JButton();
        tableModel = new DefaultTableModel(new Object[]{"Date", "Munchkins", "Donuts", "Sour Strips", "Fried Oreos"}, 0);
        recordsTable = new JTable(tableModel);
        scrollPane = new JScrollPane(recordsTable);
        deselectionLabel = new JLabel();
        
        theOnePanel = new JPanel(); // One panel to rule them all...

        recGUIframe.setTitle("Records");
        recGUIframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        recGUIframe.setLayout(new FlowLayout());
        recGUIframe.setVisible(true);
        recGUIframe.add(theOnePanel);
        recGUIframe.setSize(new Dimension(140, 40));
        recGUIframe.setResizable(false);
        recGUIframe.setLocationRelativeTo(MainGUI.mainGUIframe);
        
        theOnePanel.setLayout(new BoxLayout(theOnePanel, BoxLayout.PAGE_AXIS));
        theOnePanel.add(cmbbPanel);
        theOnePanel.add(optionsAndTablePanel);
        theOnePanel.add(deselectionPanel);

        cmbbPanel.add(recDay);
        cmbbPanel.add(recMonth);
        cmbbPanel.add(recYear);

        finalizePanel.add(maker);
        finalizePanel.add(unmaker);
        finalizePanel.add(remaker);

        deselectionLabel.setText("Esc to deselect all selected rows");
        deselectionLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        deselectionLabel.setForeground(ProgramColors.bodyColor);
        deselectionPanel.add(deselectionLabel);
        
        scrollPane.setPreferredSize(new Dimension(550, 200));
        tablePanel.add(scrollPane);

        optionsAndTablePanel.setLayout(new BoxLayout(optionsAndTablePanel, BoxLayout.PAGE_AXIS));
        optionsAndTablePanel.add(finalizePanel);
        optionsAndTablePanel.add(tablePanel);

        maker.setText("Record");
        maker.setFocusable(false);
        maker.addActionListener(this);
        maker.setForeground(ProgramColors.highlightColor);
        maker.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));

        unmaker.setText("Delete");
        unmaker.setFocusable(false);
        unmaker.addActionListener(this);
        unmaker.setForeground(ProgramColors.highlightColor);
        unmaker.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));

        remaker.setText("Update");
        remaker.setFocusable(false);
        remaker.addActionListener(this);
        remaker.setForeground(ProgramColors.highlightColor);
        remaker.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));

        recordsTable.addKeyListener(this);
        recordsTable.setSelectionBackground(ProgramColors.lesserHighlightColor);
        recordsTable.setSelectionForeground(ProgramColors.highlightColor);
        recordsTable.setDefaultRenderer(Object.class, new CellRenderControl());
        recordsTable.setDefaultEditor(Object.class, new CellEditHighlight());

        scrollPane.setBorder(null);
        
        recDay.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        recDay.setMaximumRowCount(10);
        recDay.setFocusable(false);

        recMonth.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        recMonth.setMaximumRowCount(10);
        recMonth.setFocusable(false);

        recYear.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        recYear.setMaximumRowCount(10);
        recYear.setFocusable(false);

        RecordsHandling.loadRecordsToTable(); // loads existing data to table after opening FinalProj.RecordGUI
            
        recGUIframe.pack(); // put this on last so that window opens properly
        
    }


    public static RecordGUI getInstance() { // calls FinalProj.RecordGUI constructor if not instantiated
        if (onlyOneRecGUI == null) {
            onlyOneRecGUI = new RecordGUI();
        }
        return onlyOneRecGUI;
    }
    public void showRecGUIWindow() { // sets the record GUI frame visible
        if (recGUIframe != null) {
            recGUIframe.setVisible(true);
        }
    }
    public static boolean isInstantiated() { // checks if FinalProj.RecordGUI constructor is instantiated
        return onlyOneRecGUI != null;
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == maker) { // records data to csv file and loads it into the table

            StuffTheButtonsDo.putStuffIntoRecords();

        } else if (e.getSource() == unmaker) { // deletes row/s from the table and csv file
            
            StuffTheButtonsDo.removeStuffFromRecords();

        } else if (e.getSource() == remaker){ // edits data in the csv file

            StuffTheButtonsDo.editStuffInTheRecords();
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }


    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_ESCAPE: {
                if (RecordGUI.recordsTable.isEditing()) {
                    RecordGUI.recordsTable.getCellEditor().stopCellEditing();
                    RecordGUI.recordsTable.clearSelection();

                    System.out.println("Deselect successful"); // debug print
                }

            }
            break;
        }
    }
}
