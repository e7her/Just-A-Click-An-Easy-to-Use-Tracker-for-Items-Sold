package FinalProj;

import java.awt.Color;

import javax.swing.UIManager;

public class ProgramColors {
    
    // made this class cuz its annoying to keep creating new Color objects

    public static Color highlightColor = new Color(255, 213, 94); // light orange
    public static Color lesserHighlightColor = new Color(50, 50, 50);
    public static Color bodyColor = new Color(255, 255, 240); // white
    public static Color defaultBorderColor = UIManager.getColor("Button.borderColor"); // dark mode color

}
