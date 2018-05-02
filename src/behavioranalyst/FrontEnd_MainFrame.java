/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behavioranalyst;

import NDL_JavaClassLib.MultiSelectFrame;



/**
 *
 * @author Balaji
 */
public class FrontEnd_MainFrame extends javax.swing.JFrame {

    private String[] fNames; //File Names of the data for Schema Analyser. The data format is frame number space x space y space newline. 
    private SchemaDataReader analyst;

    /**
     * Creates new form FrontEnd_MainFrame
     */
    public FrontEnd_MainFrame() {
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        filesReadyStatus = new javax.swing.JLabel();
        dataReadyStatus = new javax.swing.JLabel();
        mapsReadyStatus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        MenuBar_FrontEnd = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        OpenVideoMenu = new javax.swing.JMenuItem();
        OpenTrackDataMenu = new javax.swing.JMenuItem();
        ImportSchemaAnalyser = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        AnalysisMenu = new javax.swing.JMenu();
        TrackMenu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        MapsMenu = new javax.swing.JMenu();
        GenerateHMaps = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Status Lights");

        filesReadyStatus.setBackground(new java.awt.Color(255, 0, 0));
        filesReadyStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        filesReadyStatus.setEnabled(false);
        filesReadyStatus.setFocusable(false);
        filesReadyStatus.setOpaque(true);

        dataReadyStatus.setBackground(new java.awt.Color(255, 0, 0));
        dataReadyStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dataReadyStatus.setEnabled(false);
        dataReadyStatus.setFocusable(false);
        dataReadyStatus.setOpaque(true);

        mapsReadyStatus.setBackground(new java.awt.Color(255, 0, 0));
        mapsReadyStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mapsReadyStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mapsReadyStatus.setEnabled(false);
        mapsReadyStatus.setFocusable(false);
        mapsReadyStatus.setOpaque(true);

        jLabel1.setText("Files Ready");

        jLabel3.setText("Data Ready");

        jLabel4.setText("Maps Ready");

        FileMenu.setText("File");

        OpenVideoMenu.setText("Open Video");
        OpenVideoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenVideoMenuActionPerformed(evt);
            }
        });
        FileMenu.add(OpenVideoMenu);

        OpenTrackDataMenu.setText("Open Track Data");
        FileMenu.add(OpenTrackDataMenu);

        ImportSchemaAnalyser.setText("Import SchemaAnalyser Positions");
        ImportSchemaAnalyser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportSchemaAnalyserActionPerformed(evt);
            }
        });
        FileMenu.add(ImportSchemaAnalyser);

        jMenuItem1.setText("Export Track Data");
        FileMenu.add(jMenuItem1);

        MenuBar_FrontEnd.add(FileMenu);

        AnalysisMenu.setText("Analysis");
        MenuBar_FrontEnd.add(AnalysisMenu);

        TrackMenu.setText("Track");

        jMenuItem3.setText("Object Settings");
        TrackMenu.add(jMenuItem3);

        jMenuItem2.setText("Start Tracking");
        TrackMenu.add(jMenuItem2);

        MenuBar_FrontEnd.add(TrackMenu);

        MapsMenu.setText("Maps");

        GenerateHMaps.setText("Generate HMaps");
        MapsMenu.add(GenerateHMaps);

        MenuBar_FrontEnd.add(MapsMenu);

        setJMenuBar(MenuBar_FrontEnd);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(552, 552, 552)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dataReadyStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(filesReadyStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mapsReadyStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(filesReadyStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataReadyStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mapsReadyStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenVideoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenVideoMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OpenVideoMenuActionPerformed

    private void ImportSchemaAnalyserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportSchemaAnalyserActionPerformed
        // TODO add your handling code here:
        MultiSelectFrame Fs = new MultiSelectFrame();
        Fs.setVisible(true);
        
        this.fNames = Fs.getSelectionArray();
        
        analyst = new SchemaDataReader(fNames);
        analyst.setDataLength(1800);
        
        analyst.doInBackground();
        //analyst.run();
        
    }//GEN-LAST:event_ImportSchemaAnalyserActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AnalysisMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem GenerateHMaps;
    private javax.swing.JMenuItem ImportSchemaAnalyser;
    private javax.swing.JMenu MapsMenu;
    private javax.swing.JMenuBar MenuBar_FrontEnd;
    private javax.swing.JMenuItem OpenTrackDataMenu;
    private javax.swing.JMenuItem OpenVideoMenu;
    private javax.swing.JMenu TrackMenu;
    private javax.swing.JLabel dataReadyStatus;
    private javax.swing.JLabel filesReadyStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mapsReadyStatus;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the fNames : fNames is a string array with file Names of the data for Schema Analyser. The data format is frame number space x space y space newline. 
     *                       x and y co-ordinates are stored as float !!! (Not required and over kill)
     */
    public String[] getfNames() {
        return fNames;
    }
}
