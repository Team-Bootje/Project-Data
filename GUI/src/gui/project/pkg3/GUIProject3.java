package gui.project.pkg3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import org.jfree.*;
import org.jfree.chart.*;
import org.jfree.data.*;

/**
 * @author Roy van den Heuvel
 */
public class GUIProject3 {

    static int x;

    private static void createAndShowGUI() {
        Image im = Toolkit.getDefaultToolkit().getImage("img/bootje.jpg");
        JFrame frame = new JFrame("ss Rotterdam Analyse");
        final JTextArea textArea = new JTextArea(50, 200);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        JButton button = new JButton("Klik hier.");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(800, 600));
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        frame.setIconImage(im);

        ActionListener myActon = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Er is " + x + " geklikt.");
                x++;
            }
        };
        button.addActionListener(myActon);
        frame.add(button);
        frame.add(textArea);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
