
//import ProgTools.MultiFileSelect;
import ProgTools.MultiSelectFrame;
import ij.WindowManager;
import ij.plugin.frame.PlugInFrame;
import java.awt.Frame;
//import javax.swing.JFileChooser;
//import javax.swing.JPanel;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Every one
 */
class TrialClass extends PlugInFrame{
    static Frame Instance;

    public TrialClass() {
        super ("TrialClass");
        
  //      JFileChooser fc = new JFileChooser();
 //       fc.showOpenDialog(this);

        WindowManager.addWindow(this);
        JPanel panel = new JPanel();
        JTextArea text = new JTextArea("Hello");
        panel.add(text);
       //
        panel.setVisible(true);

        this.add(panel);

        MultiSelectFrame FS = new MultiSelectFrame();
        WindowManager.addWindow(FS);
        text.setText(FS.getList().toString());
    }
}

