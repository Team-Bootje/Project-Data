/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teambootje;

import facebookapi.FacebookAPI;
import facebookapi.*;
import javax.swing.ImageIcon;
import facebook4j.Facebook; 
import facebook4j.FacebookException; 
import facebook4j.FacebookFactory;
import facebook4j.Post; 
import facebook4j.ResponseList; 
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import static facebookapi.FacebookAPI.getFacebookPostes;

/**
 *
 * @author kevin
 */
public class FacebookGui extends javax.swing.JFrame {

    /**
     * Creates new form FacebookGui
     */
    public FacebookGui() throws FacebookException {
       initComponents();
        setLocationRelativeTo(null);
        
        //Create and set up the window.
        setTitle("SS Rotterdam Analyse || Get Facebook Data");
        ImageIcon icon = new ImageIcon("img/bootje.jpg");
        setIconImage(icon.getImage());
        
        
        
        
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder(); 
        configurationBuilder.setDebugEnabled(true); 
        configurationBuilder.setOAuthAppId("476059649213785"); 
        configurationBuilder.setOAuthAppSecret("88eacd3eec295028a3f56ca4b7cc69ef"); 
        configurationBuilder.setOAuthAccessToken("CAAGwZBUZAIhVkBAKTrnvgZConGF4l1ZAABE1AhC7e245J9s8LcbIdGmQzZAO4PcRgvkt2uHzW2hRdSp4UVQN6xDIz4wI32UsQbtBicQD2lD9PNEZBlgZBE9f0VwPtZAsumz1KwNOcoZCF2R7jc2wCPG1JRRyZCjzuQeQhQ4jlEeXh0LQI53jh24ZCvj5PVGPPpbKQYZD"); 
        configurationBuilder.setOAuthPermissions("email, publish_stream, id, name, first_name, last_name, read_stream , generic"); 
        configurationBuilder.setUseSSL(true); 
        configurationBuilder.setJSONStoreEnabled(true); 
        Configuration configuration = configurationBuilder.build();
        FacebookFactory ff = new FacebookFactory(configuration);
        Facebook Facebook = ff.getInstance();
        String searchPost = "ssRotterdam";
       // String results = getFacebookPostes(Facebook, searchPost);
        
        
        FacebookAPI fbookAPI = new FacebookAPI();
        FacebookAPI.getFacebookFeed(Facebook, searchPost);
      
       
        

    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FacebookGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacebookGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacebookGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacebookGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacebookGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
