package FinalProj;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CellEditHighlight extends DefaultCellEditor {

    // Constructor to set up the text field with a border
    public CellEditHighlight() {
        super(new JTextField());
        JTextField editorComponent = (JTextField) getComponent();
        editorComponent.setBorder(BorderFactory.createLineBorder(ProgramColors.highlightColor)); 
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        // Get the editor component and set its background and foreground colors
        Component c = super.getTableCellEditorComponent(table, value, isSelected, row, column);
        
        c.setBackground(ProgramColors.highlightColor);
        c.setForeground(ProgramColors.lesserHighlightColor);
        ((JTextField) c).setHorizontalAlignment(SwingConstants.CENTER);
        return c;
    }
}



