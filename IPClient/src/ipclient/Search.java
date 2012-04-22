/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ipclient;

import framework.hashing.Trigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramit
 */

class Ranking {

    public Integer ones;
    public String fileName;
    public String ip;
    public String abs; //abstract
    public String size;
    
    Ranking(String f, String i, String a, double size){
        fileName = f;
        ip = i;
        abs = a;
        this.size = size+"";
    }
    
    public static Comparator<Ranking> COMPARE_BY_ONES = new Comparator<Ranking>() {
        public int compare(Ranking one, Ranking other) {
            return one.ones.compareTo(other.ones);
        }
    };
}

public class Search extends javax.swing.JFrame {
    
    DashBoard parent;
    IPClient root;
    /**
     * Creates new form Search
     */
    public Search(DashBoard d, IPClient rt) {
        parent = d;
        root = rt;
        initComponents();
    }

    public String receiveSearchResult() {
        int c, i;
        String msg="";
        char [] ch = new char[1000];	
        try {
            i = 0;
            while (( c = root.in.read()) != '\n') {
                ch[i] = (char) c;
                i++;
                //System.out.print((char) c);
            }
            msg = new String(ch);
            msg = msg.trim();
            System.out.println("\nResponse from server: " + msg);
            StringTokenizer st = new StringTokenizer(msg,":");
            String msg_type = st.nextToken();
            int resultCount = Integer.parseInt(st.nextToken());
            if(msg_type.equals("69")){
                Vector vResult = new Vector();
                
                for(int k=0; k < resultCount; k++) {
                    msg="";
                    ch = new char[1000];	
                    i = 0;
                    while (( c = root.in.read()) != '\n') {
                        ch[i] = (char) c;
                        i++;
                    //System.out.print((char) c);
                    }
                    msg = new String(ch);
                    msg = msg.trim();
                    System.out.println("\nResponse from server: " + msg);
                    
                    st = new StringTokenizer(msg,":");
                    msg_type = st.nextToken();
                    String filename = st.nextToken();
                    String ip = st.nextToken();
                    String abs = st.nextToken();
                    String size = st.nextToken();
                    vResult.add(filename+"\t:\t"+abs);
                }
                jListResult.setListData(vResult);
            }
        }
        catch(Exception e){
            System.out.println("EXCEPTION:: receiveResponse :"+e.getMessage());
        }
        return msg;
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListResult = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jButtonDload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("GANGSHARE - Search");

        jLabel1.setText("Keywords:");

        jButtonSearch.setText("Search Gangshare");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jButtonSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSearch)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jListResult);

        jLabel2.setText("Search Results");

        jButtonDload.setText("Download File");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator1))
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDload)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDload)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        try {
            // TODO add your handling code here:
            String searchString = searchField.getText();
            
            //Trigest trigest = new Trigest(searchString);
            //byte[] signature = trigest.getSignature();
            
            String type = "05";
            String msg = type + ":" + searchString;
            root.sendMsg(msg);
            receiveSearchResult();
        } catch (Exception ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
   /*
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Search().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDload;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jListResult;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}