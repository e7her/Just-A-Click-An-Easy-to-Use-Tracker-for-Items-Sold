package FinalProj;

import javax.swing.JOptionPane;

public class StuffTheButtonsDo {
    
    static String finalDate;
    static String toFileWriter;

    public static void putStuffIntoRecords() {

    finalDate = RecordGUI.recDay.getSelectedItem().toString() + " " + RecordGUI.recMonth.getSelectedItem().toString() + " " + RecordGUI.recYear.getSelectedItem();
    toFileWriter = finalDate + "," + MainGUI.munchkinsSoldCount + "," + MainGUI.donutsSoldCount + "," + MainGUI.sourStripsSoldCount + "," + MainGUI.friedOreosSoldCount;

    RecordsHandling.writeToFile();
    RecordsHandling.loadRecordsToTable(); 
    }

    public static void removeStuffFromRecords() {

        if (RecordGUI.recordsTable.getSelectedRowCount() == 1) { // single row delete

                RecordGUI.tableModel.removeRow(RecordGUI.recordsTable.getSelectedRow());
                RecordsHandling.lineDeletionUpdate();
                System.out.println("Row deleted");
                System.out.println("Deletion successful"); // debug print

            } else if (RecordGUI.recordsTable.getSelectedRowCount() > 1) { // multi-row delete

                for (int r = RecordGUI.recordsTable.getSelectedRowCount(); r > 0; r--) {

                    RecordGUI.tableModel.removeRow(RecordGUI.recordsTable.getSelectedRow());
                    System.out.println("Row deleted");
                }
                
                RecordsHandling.lineDeletionUpdate();
                System.out.println("Deletion successful"); // debug print

            } else {

                if (RecordGUI.recordsTable.getRowCount() == 0) {

                    JOptionPane.showMessageDialog(null, "Table is Empty", "No rows found", JOptionPane.ERROR_MESSAGE);
                }
            }
    }

    public static void editStuffInTheRecords() {

        if (RecordGUI.recordsTable.getRowCount() == 0) {

            JOptionPane.showMessageDialog(null, "Table is emtpy!", "No rows found", JOptionPane.ERROR_MESSAGE);

        } else if (RecordGUI.recordsTable.getSelectedRowCount() == 0) {

            JOptionPane.showMessageDialog(null, "Please select a single row", "No row selected", JOptionPane.ERROR_MESSAGE); 

        } else if (!RecordGUI.recordsTable.isEditing()) {


            JOptionPane.showMessageDialog(null, "No changes to table done", "No update", JOptionPane.ERROR_MESSAGE);

        } else {
            
            RecordsHandling.cellUpdate();
            RecordsHandling.loadRecordsToTable();
            System.out.println("Update successful"); // debug print
        }
    }
}
