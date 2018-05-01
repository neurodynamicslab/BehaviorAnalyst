/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behavioranalyst;

import NDL_JavaClassLib.TraceData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.SwingUtilities.isEventDispatchThread;
import javax.swing.SwingWorker;
//import TraceData;

/**
 *
 * @author Balaji
 */
public class SchemaDataReader extends SwingWorker{

    String []  fileNames ;
    TraceData[] positionData;
    File [] dataFiles;
    private int [] startFrames;
    private boolean includeAllframes;
    private int dataLength = 0; //stores the number of frames (determined through time (in seconds) x framerate of video
    

    /**
     *
     * @return
     */
    @Override
    protected TraceData[] doInBackground(){ 
    //To change body of generated methods, choose Tools | Templates.
    
    //do status checks
    if (dataFiles == null || dataFiles.length == 0){ // the datafiles are not initialised let us check for fileNames
        if(fileNames != null || fileNames.length != 0){ // the file names are there let us populate the dataFiles
            //populate the dataFiles field.
            File file;
            for (int nameCount = 0 ; nameCount < fileNames.length ; nameCount ++){
                
               file = new File(fileNames[nameCount]);
               if( file.exists())
                   dataFiles[nameCount] = file;
            }
            
        } else{
            JOptionPane.showMessageDialog(null, this, "Error Processing Files: No fruitfull datafilenames to process", 0);
        }                                                                            
        
    }// by now the files should be populated and ready to process. 
    TraceData currData = null;
    for(int fileCount = 0 ; fileCount < dataFiles.length ; fileCount ++){
        currData = new TraceData(this.getDataLength());
        currData = readSchemaData(dataFiles[fileCount],startFrames[fileCount],(startFrames[fileCount]+1800)); 
                                                                                        //assumes the trial length is 60 s and 30 fps
    }
    
    return positionData;
    }
    public SchemaDataReader(String [] fileNames){
        this.fileNames = fileNames;
        this.includeAllframes = true;
        
    }
    public SchemaDataReader(File[] dataFiles){
        this.dataFiles = dataFiles;
        this.includeAllframes = true;
    }
    
    public SchemaDataReader(File[] dataFiles, int [] startFrames){
        this.dataFiles = dataFiles;
        this.setStartFrames(startFrames);
        this.includeAllframes = false;
    }
    public SchemaDataReader(String[] fileNames, int [] startFrames){
        this.fileNames = fileNames;
        this.setStartFrames(startFrames);
        this.includeAllframes = false;
    }
    
    /**
     * @param startFrames the startFrames to set the starting frame of trial. 
     * The instantiating class needs to set this first.
     */
    public void setStartFrames(int[] startFrames) {
        this.startFrames = startFrames;
        this.includeAllframes = false;
    }

    /**
     * @return the dataLength
     */
    public int getDataLength() {
        return dataLength;
    }

    /**
     * @param dataLength the dataLength to set
     */
    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    private TraceData readSchemaData(File dataFile, int startFrame, int endFrame) {
        TraceData data = new TraceData(this.getDataLength());
        FileReader in = null; 
        int currFrame = 0;
        try {
            in = new FileReader(dataFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SchemaDataReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(in);
        String line;                                   
        int prev_b = 0, prev_c = 0;
        try {
            while((line = br.readLine())!= null){
                
                // split string into small tokens and pass them as seperate x & y
                //String line = br.readLine();
                String [] token = line.split("\\s+");  // split the string into tokens seperated with the white spaces.\\s+
                float a = Float.parseFloat(token[0]); //frame number
                float b = Float.parseFloat(token[1]);//x coordinate of bounding box
                float c = Float.parseFloat(token[2]);//y coordinate of bounding box
                //float d = Float.parseFloat(token[3]);//width of bounding box
                //  float e = Float.parseFloat(token[4]);//height of bounding box
                //  int fNo = Math.round(a); //frame number
                //  int u =Math.round(d);
                //  int v = Math.round(e);
                //  int x = (int)b;
                //  int y = (int)c;
                currFrame = Math.round(a);
                if(currFrame >= startFrame && currFrame <= endFrame){
                    if(c != -1 || b != -1){
                        data.addData(prev_b, prev_c);           //does not take care of no tracking objects when it comes first 
                    }else{
                        data.addData(b, c);
                        prev_b = (int)b;
                        prev_c = (int)c;
                    }
                    
                }else{
                    return data;
                }
                   
               
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }   } catch (IOException ex) {
            Logger.getLogger(SchemaDataReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(currFrame < endFrame){           //the file terminated before the 60 s so padd the rest of the data with the last location.
                                            // number of frames to pad is endFrame - currFrame
        }
    return data; 
}
}
