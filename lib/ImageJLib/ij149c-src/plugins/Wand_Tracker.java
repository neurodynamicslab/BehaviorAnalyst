/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package plugins;

import ij.ImagePlus;
import ij.ImageStack;
import ij.WindowManager;
import ij.plugin.PlugIn;
import ij.plugin.frame.PlugInFrame;
import ij.plugin.frame.RoiManager;

/**
 *
 * @author Balaji
 */
public class Wand_Tracker implements PlugIn {

    private ImagePlus imp;
    private WandTrackerGUI tracker;
    private RoiManager Manager;

    public void startTracker() {
              
       ImageStack Stk = imp.getImageStack();
       int nSlices = Stk.getSize();
       int CurrSlice = imp.getCurrentSlice();
       int StartPos = 0;        //The slice number at which the tracking should start. This coresponds to the slice number where the object is selected. 
       int EndPos = 0;          // The slice number at which the tracking should end. This is usally end of stack (if the object was choosen at the first slice )or StartPos - 1.
       
       StartPos = CurrSlice;
       
       EndPos = (CurrSlice !=1 ) ? CurrSlice-1 : nSlices;
       
       
    }

    
    public void run(String arg) {
        
        Manager = new RoiManager();
        imp = WindowManager.getCurrentImage();
        tracker = new WandTrackerGUI();
        tracker.setVisible(true);
        WindowManager.addWindow(tracker);
        if(imp != null){
       
        if(imp.getStackSize() <= 1){
            ij.IJ.showMessage("OOPS!", "You need  a stack of images to  track the objects !!");
        }
        else{
            startTracker();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
    
      
     
}
