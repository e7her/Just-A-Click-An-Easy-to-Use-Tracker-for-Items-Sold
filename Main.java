package FinalProj;

public class Main {

    public static void main(String[] args) {
            
        new MainGUI(); // calls FinalProj.MainGUI

        RecordsHandling.addHeadersIfNotExist(); // creates the CSV file that records data and adds a header to it
    }
}
