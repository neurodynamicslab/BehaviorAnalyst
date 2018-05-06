/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Scoring_Assistant.java
 *
 * Created on Apr 19, 2011, 4:48:42 PM
 */

package ProgTools;

import ij.ImagePlus;
import ij.ImageStack;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Every one
 */
public class Scoring_Assistant extends java.awt.Frame implements MouseListener ,KeyListener{

    File DataFile, ImgFile = null;
    ImageStack Stack = null;
    ImagePlus imp = null;
    boolean Error = false;

    /** Creates new form Scoring_Assistant */
    public Scoring_Assistant() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nImgs = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nImgAdv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mThreshold = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nConsecutive = new javax.swing.JTextField();
        DataBrowse = new javax.swing.JButton();
        ResultBrowse = new javax.swing.JButton();
        Score = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(236, 233, 216));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jLabel1.setText("Number of Images to score");

        jLabel2.setText("Motion Threshold");

        jLabel3.setText("Number of frames to advance");

        jLabel4.setText("Number of people scoring");

        jLabel5.setText("Number of consecutive frames");

        DataBrowse.setText("Select Data file");
        DataBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataBrowseActionPerformed(evt);
            }
        });

        ResultBrowse.setText("Export Results File");
        ResultBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultBrowseActionPerformed(evt);
            }
        });

        Score.setText("Start_Scoring");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Score)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(ResultBrowse)
                                .addGap(57, 57, 57))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nConsecutive, 0, 0, Short.MAX_VALUE)
                                        .addComponent(mThreshold, 0, 0, Short.MAX_VALUE)
                                        .addComponent(nImgAdv, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nImgs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(DataBrowse)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(133, 133, 133)
                        .addComponent(DataBrowse))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nImgs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nImgAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nConsecutive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Score)
                    .addComponent(ResultBrowse))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void DataBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataBrowseActionPerformed
        
        JFileChooser Fc = new JFileChooser();
        Fc.setDialogType(Fc.OPEN_DIALOG);
        Fc.setMultiSelectionEnabled(false);
        Fc.setVisible(true);
        ImgFile = Fc.getSelectedFile();
        if(ImgFile.exists() && ImgFile.isFile() ){
            imp = new ImagePlus(ImgFile.getPath());
        }
        if (imp == null)
            Error = true;
        else
            Stack = imp.getImageStack();

    }//GEN-LAST:event_DataBrowseActionPerformed

    private void ResultBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultBrowseActionPerformed

        JFileChooser res = new JFileChooser();
        res.setDialogType(res.SAVE_DIALOG);
        res.setVisible(true);

        //File

    }//GEN-LAST:event_ResultBrowseActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scoring_Assistant().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DataBrowse;
    private javax.swing.JButton ResultBrowse;
    private javax.swing.JButton Score;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField mThreshold;
    private javax.swing.JTextField nConsecutive;
    private javax.swing.JTextField nImgAdv;
    private javax.swing.JTextField nImgs;
    // End of variables declaration//GEN-END:variables

    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
