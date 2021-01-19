package chessgui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BoardFrame extends JFrame implements ActionListener {
    Component component;
    private JButton read;
    private JLabel time;
    private int x = 60;
    private final int DELAY = 1000;
    private Timer timer;
    public BoardFrame()
    {
        time = new JLabel("Time: \n" + x + " Seconds");
        time.setBounds(50,50,70,30);

        read = new JButton("Read/Load");
        read.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        this.add(panel, BorderLayout.EAST);
        panel.add(time);
        panel.add(read);

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

    @Override 
    public void actionPerformed(ActionEvent e){

    }
    
    public void timeSet(String text) {
        time.setText(text);
    }
}