/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journeyms;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.*;

/**
 *
 * @author Group_94
 */
public class StationControlUI extends javax.swing.JFrame {

    /**
     *
     */
    public static DefaultComboBoxModel StationListModel;
    /**
     * Creates new form StationControlUI
     */
    public StationControlUI() {
        StationListModel = new DefaultComboBoxModel();
        if (CentralControl.stationList.size()!=0)
        {
            for (int i=0;i<CentralControl.stationList.size();i++)
            {
                if (CentralControl.stationList.get(i).getStation().equals("A")) 
                    StationListModel.addElement("Central Station");
                else
                    StationListModel.addElement("Train Stop "+CentralControl.stationList.get(i).getStation());
            }
          //  System.out.println(StationListModel.getSelectedItem(i));
        }
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

        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TrainViewPanel = new javax.swing.JPanel();
        javax.swing.JLabel l=new javax.swing.JLabel();
        Icon icon=new ImageIcon("Station.png");     //在此直接创建对象
        l.setIcon(icon);
        l.setBounds(0, 0, icon.getIconWidth(),icon.getIconHeight());
        TrainViewPanel.add(l,new Integer(Integer.MIN_VALUE));
        canvas1 = new java.awt.Canvas();
        TimeLabel3 = new javax.swing.JLabel();
        StationList = new javax.swing.JComboBox<>();
        StationNameLabel = new javax.swing.JLabel();
        StationSignLabelTop = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        StationSignLabel = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(1000, 485));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel9.setText("Choose Station:");

        javax.swing.GroupLayout TrainViewPanelLayout = new javax.swing.GroupLayout(TrainViewPanel);
        TrainViewPanel.setLayout(TrainViewPanelLayout);
        TrainViewPanelLayout.setHorizontalGroup(
            TrainViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrainViewPanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(501, Short.MAX_VALUE))
        );
        TrainViewPanelLayout.setVerticalGroup(
            TrainViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TrainViewPanelLayout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        TimeLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TimeLabel3.setText("SystemTime");
        TimeLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        StationList.setModel(StationListModel);
        StationList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                StationListItemStateChanged(evt);
            }
        });
        StationList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StationListActionPerformed(evt);
            }
        });

        StationNameLabel.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        StationNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        StationNameLabel.setText("Central Station");

        StationSignLabelTop.setEditable(false);
        StationSignLabelTop.setBackground(new java.awt.Color(0, 0, 0));
        StationSignLabelTop.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        StationSignLabelTop.setForeground(new java.awt.Color(255, 255, 255));
        StationSignLabelTop.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        StationSignLabelTop.setText("Welcome to the Central Station!");
        StationSignLabelTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StationSignLabelTopActionPerformed(evt);
            }
        });

        StationSignLabel.setBackground(new java.awt.Color(0, 0, 0));
        StationSignLabel.setColumns(20);
        StationSignLabel.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        StationSignLabel.setForeground(new java.awt.Color(255, 255, 255));
        StationSignLabel.setLineWrap(true);
        StationSignLabel.setRows(4);
        jScrollPane1.setViewportView(StationSignLabel);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StationList, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TimeLabel3))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(StationNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addComponent(TrainViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StationSignLabelTop, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimeLabel3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StationList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StationNameLabel)
                .addGap(4, 4, 4)
                .addComponent(TrainViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(StationSignLabelTop, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StationListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StationListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StationListActionPerformed

    private void StationListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_StationListItemStateChanged
        this.StationLabelRefresh();
    }//GEN-LAST:event_StationListItemStateChanged

    private void StationSignLabelTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StationSignLabelTopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StationSignLabelTopActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
 
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
            this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StationControlUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StationControlUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StationControlUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StationControlUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StationControlUI().setVisible(true);
            }
        });
    }
    
    /**
     *
     */
    public void StationLabelRefresh()
    {
        int StationIndex = StationList.getSelectedIndex();
        Station s = null;
        if (StationIndex != -1)
        {
            StationSignLabelTop.setText("Welcome to "+StationList.getSelectedItem().toString());
            StationNameLabel.setText(StationList.getSelectedItem().toString());
            s=CentralControl.stationList.get(StationIndex);
            //System.out.println(s.getStation());
            List<Journey> ComingTrainsInJourneys = new ArrayList<Journey>();
            String StationSign;
            for (int i=0;i<CentralControl.journeyList.size();i++)
                if ((CentralControl.journeyList.get(i).IsFinished()==false)&&(CentralControl.journeyList.get(i).IsJourneyStarted()==true))
                    if (CentralControl.journeyList.get(i).getNextStation().getStation().equals(s.getStation())) //See if there is any train coming
                    {   
                        ComingTrainsInJourneys.add(CentralControl.journeyList.get(i));
                    
                    }
            if(ComingTrainsInJourneys.isEmpty()!=true)
            {
                StationSign = "There are "+(ComingTrainsInJourneys.size())+" train(s) coming.\n";
                for (int i=0;i<ComingTrainsInJourneys.size();i++)
                {
                    Journey j = ComingTrainsInJourneys.get(i);
                    if (j.getTimeToNextOperation()!=null)
                    {
                        if (j.getTrain().getStatus()==true)//If the train is arriving
                            StationSign+= j.getTrain().getID()+" will arrive at "+ j.getTimeToNextOperation().getTimeInString()+"\n";
                        else //If the train is arrived
                            StationSign+= j.getTrain().getID()+" has arrived, and will leave at " +j.getTimeToNextOperation().getTimeInString()+"\n";               
                    }
                    else //If the train is mannually stopped
                        StationSign+=j.getTrain().getID()+" will arrive behind schedule\n";
                }
            }
            else StationSign = "There is no train comming to this station";
            StationSignLabel.setText(StationSign);
        }   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> StationList;
    private javax.swing.JLabel StationNameLabel;
    private javax.swing.JTextArea StationSignLabel;
    private javax.swing.JTextField StationSignLabelTop;
    public static javax.swing.JLabel TimeLabel3;
    private javax.swing.JPanel TrainViewPanel;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}