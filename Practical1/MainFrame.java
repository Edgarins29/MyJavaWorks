/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktdarbs1;

import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author edgars
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        jLabel3.setText("");        // Tikko parādoties formai statusu teksts ir tukšs
        ShowInJList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Pievienot ierakstu");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel1.setText("Ieraksts:");

        jButton2.setText("Nodzēst");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Saglabāt failā");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jTextField2.setText("text.txt");

        jLabel2.setText("Faila nosaukums:");

        jLabel3.setText("jLabel3");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 163, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        AddToList();                // Pievienojam ierakstu sarakstam.
        jTextField1.grabFocus();    // Pēc pogas nospiešanas atgriežam fokusu jTextField1
        ShowInJList();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Clear();        // Notīra sarakstu.
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // Ja nospiež enter, kad jTextField1 ir fokusēts, tad pievieno ierakstu.
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AddToList();
        }
        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        SaveToFile();       // izsaucam funkciju, lai saglabātu failā.

    }//GEN-LAST:event_jButton3MouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    public StringBuilder sb = new StringBuilder();
    //public StringBuilder sorted_sb = new StringBuilder(); // šo neizmantojam
    
    String strLatvian = "< a, A < ā, Ā < b, B < c, C < č, Č < d, D" +
            " < e, E < ē, Ē < f, F < g, G < ģ, Ģ < h, H < i, I < ī, Ī < j, J " +
            " < k, K < ķ, Ķ < l, L < ļ, Ļ < m, M < n, N < ņ, Ņ < o, O < ō, Ō < p, P " + 
            "< q, Q < r, R < ŗ, Ŗ < s, S < š, Š < t, T < u, U < ū, Ū < v, V " + 
            " < w, W < x, X < y, Y < z, Z < ž, Ž";
    
    /*
    String strLatvian2 = "< a, A ; ā, Ā < b, B < c, C ; č, Č < d, D" +
            " < e, E ; ē, Ē < f, F < g, G ; ģ, Ģ < h, H < i, I ; ī, Ī < j, J " +
            " < k, K ; ķ, Ķ < l, L ; ļ, Ļ < m, M < n, N ; ņ, Ņ < o, O ; ō, Ō < p, P " + 
            "< q, Q < r, R ; ŗ, Ŗ < s, S ; š, Š < t, T < u, U ; ū, Ū < v, V " + 
            " < w, W < x, X < y, Y < z, Z ; ž, Ž";
    */
    
    List<String> strList = new ArrayList<>();           // Saraksts ar simbolu virknēm
    
    private DefaultListModel lm1 = new DefaultListModel();
    
    public void ShowInJList() {
        jList1.setModel(lm1);
        jList1 = new JList(strList.toArray());
    }
    
    // Simbolu virknes elementa pievienošanas funkcija
    public void AppendText(String str) {
        lm1.addElement(str);
        strList.add(str);                   // pievienojam simbolu virknes elementu sarakstam
        jTextField1.setText("");            // pēc pievienošanas notīram ievades tekstu
    }
    
    // Simbolu virknes saraksta izvadīšana jTextArea1
    public void DisplayList(List<String> list) {
        String tmp;                         // 
        StringBuilder sbx = new StringBuilder();
        // No simbolu virknes saraksta ievadam sarakstu pagaidu StringBuilderā.
        for (String str : list) {
            tmp = str + "\n";       // Katru ierakstu savā rindā.
            sbx.append(tmp);     
        }
        jTextArea1.setText(sbx.toString());
        
        // iestatam pagaidu StringBuilder vērtību publiskajam StringBuilder
        // šis paredzēts ir ierakstīšanai failā funkcijai SaveToFile();
        sb = sbx;     
        ShowInJList();
    }
    
    // Pievienošana sarakstam
    public void AddToList() {
        int charcount = jTextField1.getText().trim().length(); // iegūstam teksta garumu
        if (charcount > 0) {            // ja 0, tad ieraksts netiek pievienots
            this.AppendText(jTextField1.getText()); // ieraksts no jTextField1
            //lm1.addElement(jTextField1.getText());
            this.SortSB();                          // sakārtojam alfabēta secībā
            this.DisplayList(strList);              // parādam sarakstu
            //this.ShowInJList();
        }
    }
    
    // Sakārtojam alfabēta secībā
    public void SortSB() {
        
        // Izmantojam Collator instanci, lai vārdus ar garumzīmēm pareizi sakārtotu
        // un šņācekņiem sekotu aiz katra attiecīgā burta nevis virknes galā
        //Collator col = Collator.getInstance();      // iegūstam locale-sensitive sakārtošanu
        //col.setStrength(Collator.TERTIARY);
        //col.setDecomposition(Collator.FULL_DECOMPOSITION);
        
        RuleBasedCollator rbcLatvian;
        try {
            rbcLatvian = new RuleBasedCollator(strLatvian);
            Collections.sort(strList, rbcLatvian);             // sakārtojam
            //rbcLatvian.setStrength(RuleBasedCollator.SECONDARY);
            //rbcLatvian.setDecomposition(RuleBasedCollator.FULL_DECOMPOSITION);
            //Collections.reverse(strList);
        } catch (ParseException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // saraksta tīrīšanas funkcija
    public void Clear() {
        strList.clear();                        // iztīram sarakstu
        lm1.clear();
        DisplayList(strList);                   // parādam tukšo sarakstu
    }
    
    // saglabāšana failā
    public void SaveToFile() {
        File f = new File(jTextField2.getText());       // iegūstam faila nosaukumu
        if (!f.exists()) {                          // pārbaudam vai jau eksistē
            try {
                FileWriter fwr = new FileWriter(f);
                try (BufferedWriter bwr = new BufferedWriter(fwr)) {
                    bwr.write(sb.toString());
                }
                jLabel3.setText("Saglabāts!");
            } catch (Exception e) {
                jLabel3.setText("Kļūdains ceļš");
            }
        } else {
            jLabel3.setText("Jau fails eksistē, izmanto citu nosaukumu!");
        }
    }
}

