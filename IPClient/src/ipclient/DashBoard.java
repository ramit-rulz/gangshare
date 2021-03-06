/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ipclient;

import java.io.File;
import java.io.InputStream;

/**
 *
 * @author Aswin
 */
public class DashBoard extends javax.swing.JFrame {
    
    IPClient parent;
    /**
     * Creates new form DashBoard
     */
    public DashBoard(IPClient par) {
        initComponents();
        parent = par;
        parent.setVisible(false);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PublishButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gangshare-C Dashboard");

        PublishButton.setText("Publish a File");
        PublishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublishButtonActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("What do you want to do?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PublishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(PublishButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchButton)
                .addGap(34, 34, 34)
                .addComponent(LogoutButton)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
        Search s = new Search(this,parent);
        s.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_SearchButtonActionPerformed

    private void PublishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublishButtonActionPerformed

        new PublishFrame(this,parent);
    }//GEN-LAST:event_PublishButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // Send logout message to server
        String hostIP = parent.host.getHostAddress();
        String msg = "100:"+hostIP;
        parent.sendMsg(msg);
        parent.setVisible(true);
        this.setVisible(false);
        this.dispose();
        deleteSharedFiles();
    }//GEN-LAST:event_LogoutButtonActionPerformed

    public void deleteSharedFiles()
    {
        String path = "C:/GangsharedFiles";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for(int i = 0; i<listOfFiles.length;i++)
        {
            listOfFiles[i].delete();
        }
    }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton PublishButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
