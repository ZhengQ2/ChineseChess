package com.zetcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BoardGUI extends JPanel implements ActionListener {

    private final int B_WIDTH = 850;
    private final int B_HEIGHT = 791;
    private final int INITIAL_X = 60;
    private final int DELAY = 1000;

    private Image ChessBoard;
    private Image cannonR;
    private Image elephantR;
    private Image generalR;
    private Image guardR;
    private Image horseR;
    private Image pawnR;
    private Image rookR;
    private Image cannonB;
    private Image elephantB;
    private Image generalB;
    private Image guardB;
    private Image horseB;
    private Image pawnB;
    private Image rookB;
    private Timer timer;
    private int x;
    JLabel label;
    JButton moveButton;
    JPanel panel;

    public BoardGUI() {
        initBoard();
        moveButton = new JButton();
        moveButton.setText("move");
        moveButton.setPreferredSize(new Dimension(90, 40));
        moveButton.setLocation(600, 90);//cannot change location
        moveButton.addActionListener(this);
        this.add(moveButton);
    }

    private void loadImage() {

        ImageIcon cb = new ImageIcon("src/resources/chessBoard.png");
        ChessBoard = cb.getImage();

        ImageIcon cannonR = new ImageIcon("src/resources/cannon1.png");
        ImageIcon elephantR = new ImageIcon("src/resources/elephant1.png");
        ImageIcon generalR = new ImageIcon("src/resources/general1.png");
        ImageIcon guardR = new ImageIcon("src/resources/guard1.png");
        ImageIcon horseR = new ImageIcon("src/resources/horse1.png");
        ImageIcon pawnR = new ImageIcon("src/resources/pawn1.png");
        ImageIcon rookR = new ImageIcon("src/resources/rook1.png");
        ImageIcon cannonB = new ImageIcon("src/resources/cannon2.png");
        ImageIcon elephantB = new ImageIcon("src/resources/elephant2.png");
        ImageIcon generalB = new ImageIcon("src/resources/general2.png");
        ImageIcon guardB = new ImageIcon("src/resources/guard2.png");
        ImageIcon horseB = new ImageIcon("src/resources/horse2.png");
        ImageIcon pawnB = new ImageIcon("src/resources/pawn2.png");
        ImageIcon rookB = new ImageIcon("src/resources/rook2.png");

        this.cannonR = cannonR.getImage();
        this.elephantR = elephantR.getImage();
        this.generalR = generalR.getImage();
        this.guardR = guardR.getImage();
        this.horseR = horseR.getImage();
        this.pawnR = pawnR.getImage();
        this.rookR = rookR.getImage();

        this.generalB = generalB.getImage();
        this.cannonB = cannonB.getImage();
        this.elephantB = elephantB.getImage();
        this.rookB = rookB.getImage();
        this.guardB = guardB.getImage();
        this.horseB = horseB.getImage();
        this.pawnB = pawnB.getImage();

    }

    private void initBoard() {

        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage();
        x = INITIAL_X;

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawChess(g);
    }

    private void drawChess(Graphics g) {
        g.drawImage(ChessBoard, 0, 5, this);
        //Blue side
        //车
        g.drawImage(rookB, 15, 20, null);
        g.drawImage(rookB, 630, 20, null);
        //马
        g.drawImage(horseB, 90, 20, null);
        g.drawImage(horseB, 545, 20, null);
        //士
        g.drawImage(guardB, 245, 20, null);
        g.drawImage(guardB, 400, 20, null);
        //象
        g.drawImage(elephantB, 165, 20, null);
        //兵
        g.drawImage(pawnB, 700, 20, null);
    }

    private void drawChess(Graphics g, int[][] a) {//need image input
        int xPos;
        int yPos;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                xPos = xAxis(a, a[i][j]);
                yPos = yAxis(a, a[i][j]);
                if (a[i][j] > 0) {//if it is red
                    if (a[i][j] == 1 || a[i][j] == 2) {
                        g.drawImage(rookR, xPos, yPos, null);
                    }else if(a[i][j] == 3 || a[i][j] == 4){
                        g.drawImage(horseR, xPos, yPos, null);
                    }else if (a[i][j] == 5 || a[i][j] == 6){
                        g.drawImage(elephantR, xPos, yPos, null);
                    }else if (a[i][j] == 7 || a[i][j] == 8){
                        g.drawImage(guardR, xPos, yPos, null);
                    }else if(a[i][j] == 9){
                        g.drawImage(generalR, xPos, yPos, null);
                    }else if (a[i][j] == 10 || a[i][j] == 11){
                        g.drawImage(cannonR, xPos, yPos, null);
                    }else if (a[i][j] >11  && a[i][j] <17){
                        g.drawImage(pawnR, xPos, yPos, null);
                    }
                }else if(a[i][j]<0){//if it is blue
                    if (a[i][j] == -1 || a[i][j] == -2) {
                        g.drawImage(rookB, xPos, yPos, null);
                    }else if(a[i][j] == -3 || a[i][j] == -4){
                        g.drawImage(horseB, xPos, yPos, null);
                    }else if (a[i][j] == -5 || a[i][j] == -6){
                        g.drawImage(elephantB, xPos, yPos, null);
                    }else if (a[i][j] == -7 || a[i][j] == -8){
                        g.drawImage(guardB, xPos, yPos, null);
                    }else if(a[i][j] == -9){
                        g.drawImage(generalB, xPos, yPos, null);
                    }else if (a[i][j] == -10 || a[i][j] == -11){
                        g.drawImage(cannonB, xPos, yPos, null);
                    }else if (a[i][j] <-11  && a[i][j] >-17){
                        g.drawImage(pawnB, xPos, yPos, null);
                    }
                }
            }
        }
    }

    private void drawBoard(Graphics g) {
        label = new JLabel("Time: " + x);
        label.setLocation(700, 80);
        panel = new JPanel();
        panel.add(label);
        Toolkit.getDefaultToolkit().sync();
    }

    private int xAxis(int[][] array, int element) {
        int xA;
        int a = findIndex(array, element, "xAxis");
        if (a > 0) {
            xA = 15 + 75 * a;
        } else {
            xA = -700;
        }
        return xA;
    }

    private int yAxis(int[][] array, int element) {
        int yA;
        int a = findIndex(array, element, "yAxis");
        if (a > 0) {
            yA = 85 * a + 20;
        } else {
            yA = -700;
        }
        return yA;
    }

    // Function to find the index of an element in a primitive array in Java
    public int findIndex(int[][] a, int target, String axis) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == target) {
                    if (axis.equals("xAxis")) {
                        return i;
                    } else if (axis.equals("yAxis")) {
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* x -= 1;
        if (x < 0) {
            x = INITIAL_X;
        }
        repaint();
         */
    }
}
