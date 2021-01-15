package com.zetcode;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ChessGUI extends JFrame{



    public ChessGUI() {

        initUI();

    }

    private void initUI() {
        add(new BoardGUI());
        setResizable(false);
        pack();

        setTitle("Chinese Chess");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }


    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ChessGUI ex = new ChessGUI();
            ex.setVisible(true);
        });
    }
}
