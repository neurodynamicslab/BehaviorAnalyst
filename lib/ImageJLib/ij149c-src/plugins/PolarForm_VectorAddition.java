/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins;

import ProgTools.MultiSelectFrame;
import ij.ImagePlus;
import ij.plugin.TextReader;
import ij.process.FloatProcessor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import javax.swing.JFileChooser;

/**
 *
 * @author Balaji
 */
public class PolarForm_VectorAddition extends javax.swing.JFrame {

    /**
     * Creates new form PolarForm_VectorAddition
     */
    public PolarForm_VectorAddition() {
        
        initComponents();
        setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SelectData = new javax.swing.JButton();
        Generate = new javax.swing.JButton();
        rScrollPane = new javax.swing.JScrollPane();
        rFileList = new javax.swing.JList();
        thetaScrollPane = new javax.swing.JScrollPane();
        thetaFileList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        isTextImage = new javax.swing.JCheckBox();
        jVectorFileCBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SelectData.setText("SelectDataFiles");
        SelectData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectDataActionPerformed(evt);
            }
        });

        Generate.setText("Generate Resultant r and theta ");
        Generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateActionPerformed(evt);
            }
        });

        rFileList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        rScrollPane.setViewportView(rFileList);

        thetaFileList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        thetaScrollPane.setViewportView(thetaFileList);

        jLabel1.setText("List of 'r' images");

        jLabel2.setText("List of 'theta' images");

        isTextImage.setSelected(true);
        isTextImage.setText("Text Images (Generated in MatLAB)");

        jVectorFileCBox.setSelected(true);
        jVectorFileCBox.setText(" Generate Vector File");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectData)
                    .addComponent(Generate)
                    .addComponent(isTextImage)
                    .addComponent(jVectorFileCBox))
                .addGap(28, 28, 28)
                .addComponent(rScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(thetaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(125, 125, 125)
                .addComponent(jLabel2)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thetaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SelectData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Generate)
                        .addGap(18, 18, 18)
                        .addComponent(isTextImage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jVectorFileCBox)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectDataActionPerformed
        // TODO add your handling code here:
        MultiSelectFrame Fsr = new MultiSelectFrame();
        MultiSelectFrame FsO = new MultiSelectFrame();
        Fsr.setOpenButtonTxt("Select the r files");
        Fsr.setVisible(true);
        int status = Fsr.getResult();
       //DefaultListModel lsModel1, lsModel2;
       //lsModel1 = (DefaultListModel) this.rFileList.getModel();
        //lsModel2 = (DefaultListModel) this.thetaFileList.getModel();
        
        if(status == MultiSelectFrame.EXIT){
                        return;
        }else{
           this.rFileList.setModel( Fsr.getList().getModel());
       }
                
        FsO.setOpenButtonTxt("Select the theta files");
        FsO.setVisible(true);
        status = FsO.getResult();
        
       if(status == MultiSelectFrame.EXIT){
        }else{
            //this.thetaFileList = FsO.getList();
            this.thetaFileList.setModel(FsO.getList().getModel());
        }
        
        
    }//GEN-LAST:event_SelectDataActionPerformed

    private void GenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateActionPerformed
        // TODO add your handling code here:
        ImagePlus resultR = null, resultT  = null,sumX = null, sumY = null;
        ImagePlus currentR, currentT;
        int rListSz = this.rFileList.getModel().getSize();
        int tListSz = this.thetaFileList.getModel().getSize();
        int noDataFiles = 0;
        if( rListSz != tListSz ){
            // List mismatch
            noDataFiles = (rListSz < tListSz)? rListSz : tListSz;
        }else
            noDataFiles = rListSz;
        
        //Assign the first viable file as the resultant
        
       // int StartIdx = 0;
       // boolean fileAssigned =false;
        String rFilePath, tFilePath;
        
        /*while(!fileAssigned){
            
           
            rFilePath = (String)this.rFileList.getModel().getElementAt(StartIdx);
            tFilePath = (String)this.thetaFileList.getModel().getElementAt(StartIdx);
            
            if(!isTextImage.isSelected()){
                resultR = new ImagePlus(rFilePath);
                resultT = new ImagePlus(tFilePath);
            }else{
                
                TextReader treader = new TextReader();
                
                FloatProcessor fpr = (FloatProcessor) treader.open(rFilePath);
                resultR = new ImagePlus();
                resultR.setProcessor(fpr);
                
                FloatProcessor fpt = (FloatProcessor) treader.open(tFilePath);
                resultT = new ImagePlus();
                resultT.setProcessor(fpt);
                
            }
            fileAssigned = (resultR != null && resultT != null) ? true : false ;
            StartIdx++;
        }*/
        int noImgProcessed = 0;
        int mRows = 0;//currentR.getHeight();
        int mCols = 0; //currentT.getWidth();
        
        rFilePath = (String)this.rFileList.getModel().getElementAt(0);
        tFilePath = (String)this.thetaFileList.getModel().getElementAt(0);
        
        if(!isTextImage.isSelected()){
                currentR = new ImagePlus(rFilePath);
                currentT = new ImagePlus(tFilePath);
        }else{
                
                TextReader treader = new TextReader();
                
                FloatProcessor fpr = (FloatProcessor) treader.open(rFilePath);
                currentR = new ImagePlus();
                currentR.setProcessor(fpr);
                
                FloatProcessor fpt = (FloatProcessor) treader.open(tFilePath);
                currentT = new ImagePlus();
                currentT.setProcessor(fpt);
                
        }
        
        mRows = currentR.getHeight();
        mCols = currentR.getWidth();
        
        float[][] X = new float[currentR.getWidth()][currentR.getHeight()];
        float[][] Y = new float[currentR.getWidth()][currentR.getHeight()];

        sumX = new ImagePlus("SumX",(new FloatProcessor(X)));
        sumY = new ImagePlus("SumY",(new FloatProcessor (Y)));    
        
        
        for(int fileCount = 0 ; fileCount < noDataFiles ; fileCount ++){
            
            rFilePath = (String)this.rFileList.getModel().getElementAt(fileCount);
            tFilePath = (String)this.thetaFileList.getModel().getElementAt(fileCount);
            
            if(!isTextImage.isSelected()){
                currentR = new ImagePlus(rFilePath);
                currentT = new ImagePlus(tFilePath);
            }else{
                
                TextReader treader = new TextReader();
                
                FloatProcessor fpr = (FloatProcessor) treader.open(rFilePath);
                currentR = new ImagePlus();
                currentR.setProcessor(fpr);
                
                FloatProcessor fpt = (FloatProcessor) treader.open(tFilePath);
                currentT = new ImagePlus();
                currentT.setProcessor(fpt);
                
            }
            
            if ( currentR != null && currentT != null){
                calResult(sumX, sumY, currentR, currentT);
                noImgProcessed++;
                
            }else{
                //Error Msg for file not good
            }
        }
      
        float[][] resR, resT;
        
        resR = new float[mCols][mRows];
        resT = new float[mCols][mRows];
        
        float aveR = 0, aveT = 0, curX = 0, curY = 0;
        
        FloatProcessor resXp = (FloatProcessor)sumX.getProcessor();
        FloatProcessor resYp = (FloatProcessor)sumY.getProcessor();
        
        String toWrite = "" ;
        File vecFile;
        FileWriter stringWriter = null;
        
        boolean genFile = jVectorFileCBox.isSelected();
        
        if(genFile){
            JFileChooser fs = new JFileChooser();
            fs.showSaveDialog(this);
            vecFile = fs.getSelectedFile();
            
            if(vecFile != null){
                try{
                    stringWriter = new FileWriter(vecFile);
                }catch(IOException e){
                    
                }
            }
            
        }
             
        
        for(int cRows = 0 ; cRows < mRows ; cRows++ )
            for(int cCols = 0 ; cCols < mCols ; cCols++){
                
                curX = resXp.getPixelValue(cCols, cRows);
                curY = resYp.getPixelValue(cCols,cRows);
                aveR = (float) (sqrt(curX*curX + curY*curY)/noImgProcessed);
                aveT = (float) ((curX == 0) ?  0 : atan(curY/curX));
                
                if(genFile){
                     
                    toWrite = "" + cCols + "\t" + cRows + "\t" + aveT + "\t" + aveR + "\n" ;
                    try{
                        stringWriter.append(toWrite);
                    } catch(IOException e){
                        
                    }
                }
               
                
                resR[cCols][cRows] = aveR;
                resT[cCols][cRows] = aveT;
            }
        
        
            
         resultR = new ImagePlus("rImage",(new FloatProcessor(resR)));
         resultT = new ImagePlus("tImage", (new FloatProcessor(resT)));
         resultR.show();
         resultT.show();
                
         ij.IJ.saveAsTiff(resultR,"");
         ij.IJ.saveAsTiff(resultT,"");
         
         sumX.show();
         sumY.show();
            
         ij.IJ.saveAsTiff(sumY, "");
         ij.IJ.saveAsTiff(sumX,"");
    }//GEN-LAST:event_GenerateActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Generate;
    private javax.swing.JButton SelectData;
    private javax.swing.JCheckBox isTextImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JCheckBox jVectorFileCBox;
    private javax.swing.JList rFileList;
    private javax.swing.JScrollPane rScrollPane;
    private javax.swing.JList thetaFileList;
    private javax.swing.JScrollPane thetaScrollPane;
    // End of variables declaration//GEN-END:variables

    private void calResult(ImagePlus sumX, ImagePlus sumY, ImagePlus currentR, ImagePlus currentT) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        FloatProcessor currentRP,currentTP;
        FloatProcessor sumXp,sumYp;
        
        float  xSum = 0, r2 = 0, ySum = 0, t2 = 0, newX = 0, newY = 0;
        
        sumXp = (FloatProcessor)sumX.getProcessor();
        sumYp = (FloatProcessor)sumY.getProcessor();
        currentRP = (FloatProcessor)currentR.getProcessor();
        currentTP = (FloatProcessor)currentT.getProcessor();
        
        int nRows = sumX.getHeight();
        int nCols = sumX.getWidth();
        //int PixelCount = nRows * nCols;
        float [][] resX, resY;
        resX = new float[nCols][nRows];
        resY = new float[nCols][nRows];
        //float [][] rPixels = currentRP.getFloatArray();
        //float [][] tPixels = currentTP.getFloatArray();
        //currentRP.getPi
        if (currentR.getHeight() == nRows && currentR.getWidth() == nCols){
            
            for(int cRow = 0 ; cRow < nRows ; cRow ++){
                for(int cCol = 0 ; cCol < nCols ; cCol ++){
                            
                            xSum = sumXp.getPixelValue(cCol,cRow);
                            r2 = currentRP.getPixelValue(cCol, cRow);
                            ySum = sumYp.getPixelValue(cCol,cRow);
                            t2 = currentTP.getPixelValue(cCol, cRow);
                                               
                            newX = (float) ((xSum + (r2*cos(t2))));
                            newY = (float) (ySum + (r2*sin(t2)));
                            
                           /*// newR = (float) java.lang.Math.sqrt((((cos(t1)*r1 )+ (cos(t2)*r2))*((cos(t1)*r1) + (cos(t2)*r2))) + (((sin(t1)*r1) + (sin(t2)*r2))*((sin(t1)*r1) + (sin(t2)*r2)) )) ;
                            newR = (float) java.lang.Math.sqrt(newX*newX  + newY*newY);
                            newT = (float) ((newR == 0 ) ?  0 : java.lang.Math.acos(newX /newR));*/
                            
                            resX[cCol][cRow] = newX;
                            resY[cCol][cRow] = newY;
                            
                            //resR[cCol][cRow] = 
                            
                }                
            }
           
            
            sumX.setProcessor(new FloatProcessor(resX));
            sumY.setProcessor(new FloatProcessor(resY));
            sumX.setTitle("xRes");
            sumY.setTitle("yRes");
            
            //resultR.show();
            //resultT.show();
        } else {
            //Message neglecting the incompatible sizes

        }
        
        
    }
}
