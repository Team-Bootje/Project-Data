/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teambootje;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author kevin
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    JFrame mainPane;
    
    public Menu() {
        
        initComponents();
        setLocationRelativeTo(null);
        
        //Create and set up the window.
        setTitle("SS Rotterdam Analyse || Menu");
        ImageIcon icon = new ImageIcon("img/bootje.jpg");
        setIconImage(icon.getImage());
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GTD = new javax.swing.JButton();
        GFD = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        GB = new javax.swing.JButton();
        WS = new javax.swing.JButton();
        NP = new javax.swing.JButton();
        PP = new javax.swing.JButton();
        LB = new javax.swing.JButton();
        WBVK = new javax.swing.JButton();
        DG = new javax.swing.JButton();
        WZK = new javax.swing.JButton();
        MB = new javax.swing.JButton();
        Empty = new javax.swing.JButton();
        BD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GTD.setText("Get Twitter data");
        GTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GTDActionPerformed(evt);
            }
        });

        GFD.setText("Get Facebook Data");
        GFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GFDActionPerformed(evt);
            }
        });

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        GB.setText("Geslacht bezoeker");
        GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GBActionPerformed(evt);
            }
        });

        WS.setText("Welk seizoen");
        WS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WSActionPerformed(evt);
            }
        });

        NP.setText("Negative post");
        NP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NPActionPerformed(evt);
            }
        });

        PP.setText("Positive post");
        PP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPActionPerformed(evt);
            }
        });

        LB.setText("Leeftijd bezoekers");
        LB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LBActionPerformed(evt);
            }
        });

        WBVK.setText("Waar bezoeker vandaan komt");
        WBVK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WBVKActionPerformed(evt);
            }
        });

        DG.setText("Doelgoep");
        DG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DGActionPerformed(evt);
            }
        });

        WZK.setText("Waarom ze komen");
        WZK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WZKActionPerformed(evt);
            }
        });

        MB.setText("Meeste berichten");
        MB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBActionPerformed(evt);
            }
        });

        Empty.setText("?");
        Empty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmptyActionPerformed(evt);
            }
        });

        BD.setText("Bekijk data");
        BD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(GB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(WBVK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(WS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(WZK)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BD, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(GTD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(GFD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Empty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GTD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GFD)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GB)
                    .addComponent(WS)
                    .addComponent(NP)
                    .addComponent(PP)
                    .addComponent(LB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WBVK)
                    .addComponent(DG)
                    .addComponent(WZK)
                    .addComponent(MB)
                    .addComponent(Empty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(BD)
                .addGap(32, 32, 32)
                .addComponent(Exit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GTDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GTDActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GBActionPerformed

    private void WSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WSActionPerformed

    private void NPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NPActionPerformed

    private void PPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PPActionPerformed

    private void LBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LBActionPerformed

    private void WBVKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WBVKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WBVKActionPerformed

    private void DGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DGActionPerformed

    private void WZKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WZKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WZKActionPerformed

    private void MBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MBActionPerformed

    private void EmptyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmptyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmptyActionPerformed

    private void GFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GFDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GFDActionPerformed

    private void BDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Data().setVisible(true);
            }
        });
    }//GEN-LAST:event_BDActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BD;
    private javax.swing.JButton DG;
    private javax.swing.JButton Empty;
    private javax.swing.JButton Exit;
    private javax.swing.JButton GB;
    private javax.swing.JButton GFD;
    private javax.swing.JButton GTD;
    private javax.swing.JButton LB;
    private javax.swing.JButton MB;
    private javax.swing.JButton NP;
    private javax.swing.JButton PP;
    private javax.swing.JButton WBVK;
    private javax.swing.JButton WS;
    private javax.swing.JButton WZK;
    // End of variables declaration//GEN-END:variables
}
