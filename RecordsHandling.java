package FinalProj;

import java.io.*;

public class RecordsHandling {

    public static File file;

    public static void writeToFile() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(StuffTheButtonsDo.toFileWriter);
            writer.write(System.getProperty("line.separator"));
            System.out.println("Data recorded successfully"); // debug print
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addHeadersIfNotExist() { 

        file = new File("src/records.csv");

        if (!file.exists()) {

            try (FileWriter writer = new FileWriter(file)) {

                writer.write("Date, Munchkins, Donuts, Sour Strips, Fried Oreos");
                writer.write(System.getProperty("line.separator"));
                System.out.println("Header written to new file"); // debug print

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void loadRecordsToTable() {

        RecordGUI.tableModel.setRowCount(0); 
        try {

            BufferedReader recordReader = new BufferedReader(new FileReader(file));
            recordReader.readLine();
  
            String placeholderLineLR = null;

            while ((placeholderLineLR = recordReader.readLine()) != null) {

                String[] data = placeholderLineLR.split(",");
                RecordGUI.tableModel.addRow(data);
            }
            recordReader.close();
            System.out.println("Records loaded to table"); // debug print
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void lineDeletionUpdate() { // delete and rewrites the csv file (only good for small scale)

            try {
                
                file.delete();

                BufferedWriter lineDeletionUpdater = new BufferedWriter(new FileWriter(file, true));
                lineDeletionUpdater.write("Date, Munchkins, Donuts, Sour Strips, Fried Oreos \n");
 
                    for (int i = 0; i < RecordGUI.recordsTable.getRowCount(); i++ ){
                        for (int j = 0; j < RecordGUI.recordsTable.getColumnCount(); j++) {
                            lineDeletionUpdater.write(RecordGUI.recordsTable.getValueAt(i, j).toString() + ",");

                        } 
                        lineDeletionUpdater.newLine();
                    } 
                    lineDeletionUpdater.close();

            } catch (IOException e) {
                e.printStackTrace();
        }
        
    }
    public static void cellUpdate() { // i cloned and renamed the lineDeletionUpdate() method for clarity purposes

        try {
            
            RecordGUI.recordsTable.getCellEditor().stopCellEditing();
            RecordGUI.recordsTable.clearSelection();
            file.delete();

            BufferedWriter cellChange = new BufferedWriter(new FileWriter(file, true));
            cellChange.write("Date, Munchkins, Donuts, Sour Strips, Fried Oreos \n");

                for (int i = 0; i < RecordGUI.recordsTable.getRowCount(); i++ ){
                    for (int j = 0; j < RecordGUI.recordsTable.getColumnCount(); j++) {
                        cellChange.write(RecordGUI.recordsTable.getValueAt(i, j).toString() + ",");

                    } 
                    cellChange.newLine();
                } 
                cellChange.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


    