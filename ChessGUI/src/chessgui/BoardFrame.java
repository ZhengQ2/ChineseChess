package chessgui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BoardFrame extends JFrame implements ActionListener {

    Component component;

    private JLabel time;
    private int x = 60;
    private final int DELAY = 1000;
    private Timer timer;

    

    public BoardFrame() {
        time = new JLabel("Time: \n" + x + " Seconds");
        
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        this.add(panel, BorderLayout.EAST);
        panel.add(time);
        panel.add(save);
        panel.add(load);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Chinese Chess");
        this.setResizable(false);
        component = new Board();
        this.add(component, BorderLayout.CENTER);

        this.setLocation(200, 50);
        this.pack();
        this.setVisible(true);
        this.setLayout(null);
    }
    
    JButton save = new JButton(new AbstractAction("Save") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // save Action
            
        }
    });

    JButton load = new JButton(new AbstractAction("Load") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // load Action
        }
    });
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
