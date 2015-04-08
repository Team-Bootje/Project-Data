/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teambootje;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import static teambootje.A1.db;

/**
 *
 * @author kevin
 */
public class A9 extends javax.swing.JFrame {

    /**
     * Creates new form A9
     */
    public A9() {
        initComponents();
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        //Create and set up the window.
        setTitle("SS Rotterdam Analyse || Analyse 9");
        ImageIcon icon = new ImageIcon("img/bootje.jpg");
        setIconImage(icon.getImage());
        
        // back BTN
        JButton back = new JButton("Back");
        add(back, BorderLayout.NORTH);
        
         back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
         
       // panel en Label
       JPanel ana = new JPanel();
       add(ana, BorderLayout.CENTER);
       
       //tabel
       String sql = "SELECT persoon.Name, COUNT(post) AS Aantal FROM persoon, posts WHERE persoon.AID = posts.AID GROUP BY persoon.Name";
       List<Object[]> list = new ArrayList<Object[]>();
       ResultSet rs = null;
       try {
           rs = db.runSql(sql);
           while (rs.next()) {
               String name = rs.getString("persoon.Name");
               int amount = rs.getInt("Aantal");
               String[] row = new String[rs.getMetaData().getColumnCount()];
               for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                   row[i-1] = rs.getString(i);
               }
               list.add(row);
               
               //chart
       JButton chart = new JButton("Chart");
       add(chart, BorderLayout.SOUTH);
       
       
       
       chart.addActionListener(new ActionListener()
        {
            String n1 = name;
            int a1 = amount;
            @Override
            public void actionPerformed(ActionEvent e) {
               DefaultPieDataset pieDataset = new DefaultPieDataset();
               pieDataset.setValue(n1, a1);
               pieDataset.setValue("WestCordHotels", new Integer(1));
               pieDataset.setValue("Voetbalr", new Integer(2));
               pieDataset.setValue("VeraBauman", new Integer(1));
               pieDataset.setValue("TonWesselink", new Integer(2));
               pieDataset.setValue("Stoomschip Rotterdam", new Integer(25));
               pieDataset.setValue("shirleys86", new Integer(2));
               pieDataset.setValue("SevereWeather_N", new Integer(2));
               pieDataset.setValue("SalvatoreOrtisi", new Integer(4));
               pieDataset.setValue("RuudvEck", new Integer(2));
               pieDataset.setValue("RuudvandenBos", new Integer(1));
               pieDataset.setValue("Roffa85", new Integer(1));
               pieDataset.setValue("RichardPh0t0", new Integer(2));
               pieDataset.setValue("RebekkaKadijk", new Integer(2));
               pieDataset.setValue("ray_rademaker", new Integer(6));
               pieDataset.setValue("PoushNL", new Integer(1));
               pieDataset.setValue("popupsquare", new Integer(2));
               pieDataset.setValue("Plan_78", new Integer(3));
               pieDataset.setValue("Petrahoogenboom", new Integer(1));
               pieDataset.setValue("PatriciaBenard", new Integer(2));
               pieDataset.setValue("OVKatendrecht", new Integer(2));
               pieDataset.setValue("OdileHemmen", new Integer(2));
               pieDataset.setValue("NLMaritiem", new Integer(2));
               pieDataset.setValue("Nellyvdvlies", new Integer(1));
               pieDataset.setValue("meerkatting", new Integer(2));
               pieDataset.setValue("MeerkatsNow", new Integer(2));
               pieDataset.setValue("marygoossens1", new Integer(1));
               pieDataset.setValue("MarjoleinNagel", new Integer(1));
               pieDataset.setValue("MaaikeMaasdijk", new Integer(1));
               pieDataset.setValue("KidsErOpUit", new Integer(2));
               pieDataset.setValue("Katendrechtnr1", new Integer(25));
               pieDataset.setValue("jpsoree", new Integer(2));
               pieDataset.setValue("JolandaBolscher", new Integer(2));
               pieDataset.setValue("jes4life", new Integer(1));
               pieDataset.setValue("JaccoScheer", new Integer(1));
               pieDataset.setValue("GwNpop", new Integer(2));
               pieDataset.setValue("Gerarddegraaff", new Integer(1));
               pieDataset.setValue("FR12Patrick", new Integer(3));
               pieDataset.setValue("FlorentinaNow", new Integer(1));
               pieDataset.setValue("FIVBWorldChamps", new Integer(2));
               pieDataset.setValue("FIVBVolleyball", new Integer(2));
               pieDataset.setValue("FeestdjNik", new Integer(1));
               pieDataset.setValue("ensanne", new Integer(1));
               pieDataset.setValue("elsekramer", new Integer(1));
               pieDataset.setValue("EelcoBeijl", new Integer(1));
               pieDataset.setValue("EdwindeKoning1", new Integer(2));
               pieDataset.setValue("DMiddelman", new Integer(3));
               pieDataset.setValue("de_rotterdam", new Integer(2));
               pieDataset.setValue("CvanAdrighem", new Integer(2));
               pieDataset.setValue("carolinedejager", new Integer(1));
               pieDataset.setValue("CaatVanEnst", new Integer(1));
               pieDataset.setValue("BotlekBusiness", new Integer(2));
               pieDataset.setValue("AnneWallisDeVri", new Integer(2));
               pieDataset.setValue("010byday", new Integer(4));
               JFreeChart chart = ChartFactory.createPieChart3D("Aantal posts per personen", pieDataset, true, true, true);
               PiePlot3D p = (PiePlot3D) chart.getPlot();
               //p.setForegroundAlpha(TOP_ALIGNMENT);
               ChartFrame pie = new ChartFrame("Aantal posts per personen", chart);
               pie.setVisible(true);
               pie.setSize(500,500);
               pie.setLocationRelativeTo(null);
               
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
           }
       }catch (SQLException e){
           JOptionPane.showMessageDialog(null, e);
                }
       
       Object[][] array = new Object[list.size()][];
       Object columnNames[] = {"Naam", "Aantal"};
       list.toArray(array);
       
       JTable table = new JTable(array, columnNames);
       JScrollPane scroll = new JScrollPane(table);
       scroll.setPreferredSize(new Dimension(400, 400));
       ana.add(scroll);
       
       
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
            java.util.logging.Logger.getLogger(A9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A9().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
