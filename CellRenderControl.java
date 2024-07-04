package FinalProj;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

// made this class to create a custom color for the border whenever a cell is in focus

public class CellRenderControl extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { 
        // the things shown in the cell when its clicked, i.e. the border around the cell

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        // calling the superclass DefaultTableCellRenderer to allow for the editing of the component's properties

        setHorizontalAlignment(SwingConstants.CENTER);
        setForeground(ProgramColors.bodyColor);
        
        if (hasFocus) {
            
            setBorder(BorderFactory.createLineBorder(ProgramColors.highlightColor));

        }
        return this;
    }
}
