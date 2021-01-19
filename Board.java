package chessgui;

import chessgui.pieces.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class Board extends JComponent {
    public int limit = 60;
    public static Timer timer;
    public static Timer timer2;
    
    public int turnCounter = 0;
    private static Image NULL_IMAGE = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

    private final int Square_Width = 77;
    public ArrayList<Piece> Red_Pieces;
    public ArrayList<Piece> Blue_Pieces;

    public ArrayList<DrawingShape> Static_Shapes;
    public ArrayList<DrawingShape> Piece_Graphics;

    public Piece Active_Piece;

    private final int rows = 9;
    private final int cols = 10;
    private Integer[][] BoardGrid;
    private String board_file_path = "images" + File.separator + "chessBoard.png";
    private String active_square_file_path = "images" + File.separator + "active_square.png";
    
    public void checkWinner() {
        //create some variables for later use
        boolean redGeneral = false;
        boolean blueGeneral = false;
        int winner;
        
        //check if red general still on the chess board
        for (int i = 0; i < Red_Pieces.size(); i++) {
            String path = Red_Pieces.get(i).getFilePath();
            if (path.equals("General.png")) {
                redGeneral = true;
            }
        }
        //check if blue general still on the chess board
        for (int i = 0; i < Blue_Pieces.size(); i++) {
            String path = Blue_Pieces.get(i).getFilePath();
            if (path.equals("General.png")) {
                blueGeneral = true;
            }
        }
        //if red general is not on the chess board, blue wins
        if (!redGeneral) {
            JOptionPane.showMessageDialog(null, "Blue wins.\nConfirm to exit the game.");
            System.exit(0);
        } else if (!blueGeneral) {
            JOptionPane.showMessageDialog(null, "Red wins.\nConfirm to exit the game.");
            System.exit(0);
        }
        //because the general is always the first item in this ArrayList, check the place of first variable
        int redKingY = Red_Pieces.get(0).getY();
        int blueKingY = Blue_Pieces.get(0).getY();
        int redKingX = Red_Pieces.get(0).getX();
        int blueKingX = Blue_Pieces.get(0).getX();
        
        //count are there any piece in between
        int countPiece = 0;
        if(redKingX == blueKingX){
            for (int i = redKingY + 1; i < blueKingY; i++){
                Piece p = getPiece(redKingX, i);
                if (p != null) {
                    countPiece++;
                }
            }
            //if the two general meets, return the winner situation and stop the program
            if (countPiece == 0) {
                if(turnCounter % 2 == 0) {
                    JOptionPane.showMessageDialog(null, "Blue General meets Red General.\nRed Loses.");
                    System.exit(0);
                } else if (turnCounter % 2 == 1) {
                    JOptionPane.showMessageDialog(null, "Blue General meets Red General.\nRed Loses.");
                    System.exit(0);
                }
            }
        }
    }

    public void initGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                BoardGrid[i][j] = 0;
            }
        }
        //Image white_piece = loadImage("images/white_pieces/" + piece_name + ".png");
        //Image black_piece = loadImage("images/black_pieces/" + piece_name + ".png");  

        Red_Pieces.add(new General(4, 0, true, "General.png", this));
        Red_Pieces.add(new Guard(3, 0, true, "Guard.png", this));
        Red_Pieces.add(new Guard(5, 0, true, "Guard.png", this));
        Red_Pieces.add(new Elephant(2, 0, true, "Elephant.png", this));
        Red_Pieces.add(new Elephant(6, 0, true, "Elephant.png", this));
        Red_Pieces.add(new Horse(1, 0, true, "Horse.png", this));
        Red_Pieces.add(new Horse(7, 0, true, "Horse.png", this));
        Red_Pieces.add(new Rook(0, 0, true, "Rook.png", this));
        Red_Pieces.add(new Rook(8, 0, true, "Rook.png", this));
        Red_Pieces.add(new Cannon(1, 2, true, "Cannon.png", this));
        Red_Pieces.add(new Cannon(7, 2, true, "Cannon.png", this));
        Red_Pieces.add(new Pawn(0, 3, true, "Pawn.png", this));
        Red_Pieces.add(new Pawn(2, 3, true, "Pawn.png", this));
        Red_Pieces.add(new Pawn(4, 3, true, "Pawn.png", this));
        Red_Pieces.add(new Pawn(6, 3, true, "Pawn.png", this));
        Red_Pieces.add(new Pawn(8, 3, true, "Pawn.png", this));

        Blue_Pieces.add(new General(4, 9, false, "General.png", this));
        Blue_Pieces.add(new Guard(3, 9, false, "Guard.png", this));
        Blue_Pieces.add(new Guard(5, 9, false, "Guard.png", this));
        Blue_Pieces.add(new Elephant(2, 9, false, "Elephant.png", this));
        Blue_Pieces.add(new Elephant(6, 9, false, "Elephant.png", this));
        Blue_Pieces.add(new Horse(1, 9, false, "Horse.png", this));
        Blue_Pieces.add(new Horse(7, 9, false, "Horse.png", this));
        Blue_Pieces.add(new Rook(0, 9, false, "Rook.png", this));
        Blue_Pieces.add(new Rook(8, 9, false, "Rook.png", this));
        Blue_Pieces.add(new Cannon(1, 7, false, "Cannon.png", this));
        Blue_Pieces.add(new Cannon(7, 7, false, "Cannon.png", this));
        Blue_Pieces.add(new Pawn(0, 6, false, "Pawn.png", this));
        Blue_Pieces.add(new Pawn(2, 6, false, "Pawn.png", this));
        Blue_Pieces.add(new Pawn(4, 6, false, "Pawn.png", this));
        Blue_Pieces.add(new Pawn(6, 6, false, "Pawn.png", this));
        Blue_Pieces.add(new Pawn(8, 6, false, "Pawn.png", this));

    }

    public Board() {

        BoardGrid = new Integer[rows][cols];
        Static_Shapes = new ArrayList();
        Piece_Graphics = new ArrayList();
        Red_Pieces = new ArrayList();
        Blue_Pieces = new ArrayList();

        initGrid();

        this.setBackground(new Color(37, 13, 84));
        this.setPreferredSize(new Dimension(850, 790));
        this.setMinimumSize(new Dimension(100, 100));
        this.setMaximumSize(new Dimension(1000, 1000));

        this.addMouseListener(mouseAdapter);
        this.addComponentListener(componentAdapter);
        this.addKeyListener(keyAdapter);

        this.setVisible(true);
        this.requestFocus();
        drawBoard();
    }

    private void drawBoard() {
        Piece_Graphics.clear();
        Static_Shapes.clear();
        //initGrid();

        Image board = loadImage(board_file_path);
        Static_Shapes.add(new DrawingImage(board, new Rectangle2D.Double(0, 0, board.getWidth(null), board.getHeight(null))));
        if (Active_Piece != null) {
            Image active_square = loadImage("images" + File.separator + "active_square.png");
            Static_Shapes.add(new DrawingImage(active_square, new Rectangle2D.Double((17 + Square_Width * Active_Piece.getX()), (10 + Square_Width * Active_Piece.getY()), active_square.getWidth(null), active_square.getHeight(null))));
        }
        for (int i = 0; i < Red_Pieces.size(); i++) {
            int COL = Red_Pieces.get(i).getX();
            int ROW = Red_Pieces.get(i).getY();
            Image piece = loadImage("images" + File.separator + "blue_pieces" + File.separator + Red_Pieces.get(i).getFilePath());
            Piece_Graphics.add(new DrawingImage(piece, new Rectangle2D.Double((17 + Square_Width * COL), (10 + Square_Width * ROW), piece.getWidth(null), piece.getHeight(null))));
        }
        for (int i = 0; i < Blue_Pieces.size(); i++) {
            int COL = Blue_Pieces.get(i).getX();
            int ROW = Blue_Pieces.get(i).getY();
            Image piece = loadImage("images" + File.separator + "red_pieces" + File.separator + Blue_Pieces.get(i).getFilePath());
            Piece_Graphics.add(new DrawingImage(piece, new Rectangle2D.Double((17 + Square_Width * COL), (10 + Square_Width * ROW), piece.getWidth(null), piece.getHeight(null))));
        }
        this.repaint();
    }

    public Piece getPiece(int x, int y) {
        for (Piece p : Red_Pieces) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        for (Piece p : Blue_Pieces) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }

    private MouseAdapter mouseAdapter = new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            int d_X = e.getX();
            int d_Y = e.getY();
            int Clicked_Row = d_Y / Square_Width;
            int Clicked_Column = d_X / Square_Width;
            boolean is_whites_turn = true;
            if (turnCounter % 2 == 1) {
                is_whites_turn = false;
            }
            
            

            Piece clicked_piece = getPiece(Clicked_Column, Clicked_Row);

            if (Active_Piece == null && clicked_piece != null
                    && ((is_whites_turn && clicked_piece.isBlue()) || (!is_whites_turn && clicked_piece.isRed()))) {
                Active_Piece = clicked_piece;
            } else if (Active_Piece != null && Active_Piece.getX() == Clicked_Column && Active_Piece.getY() == Clicked_Row) {
                Active_Piece = null;
            } else if (Active_Piece != null && Active_Piece.canMove(Clicked_Column, Clicked_Row)
                    && ((is_whites_turn && Active_Piece.isBlue()) || (!is_whites_turn && Active_Piece.isRed()))) {
                // if piece is there, remove it so we can be there
                if (clicked_piece != null) {
                    if (clicked_piece.isBlue()) {
                        Red_Pieces.remove(clicked_piece);
                    } else {
                        Blue_Pieces.remove(clicked_piece);
                    }
                }
                // do move
                Active_Piece.setX(Clicked_Column);
                Active_Piece.setY(Clicked_Row);

                // if piece is a pawn set has_moved to true
                if (Active_Piece.getClass().equals(Pawn.class)) {
                    Pawn castedPawn = (Pawn) (Active_Piece);
                    castedPawn.setHasMoved(true);
                }
                checkWinner();
                countDown();
                turnCounter++;
                Active_Piece = null;
            }

            drawBoard();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

    };

    private void adjustShapePositions(double dx, double dy) {

        Static_Shapes.get(0).adjustPosition(dx, dy);
        this.repaint();

    }

    private Image loadImage(String imageFile) {
        try {
            return ImageIO.read(new File(imageFile));
        } catch (IOException e) {
            return NULL_IMAGE;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        drawBackground(g2);
        drawShapes(g2);
    }

    private void drawBackground(Graphics2D g2) {
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawShapes(Graphics2D g2) {
        for (DrawingShape shape : Static_Shapes) {
            shape.draw(g2);
        }
        for (DrawingShape shape : Piece_Graphics) {
            shape.draw(g2);
        }
    }

    private ComponentAdapter componentAdapter = new ComponentAdapter() {

        @Override
        public void componentHidden(ComponentEvent e) {

        }

        @Override
        public void componentMoved(ComponentEvent e) {

        }

        @Override
        public void componentResized(ComponentEvent e) {

        }

        @Override
        public void componentShown(ComponentEvent e) {

        }
    };

    private KeyAdapter keyAdapter = new KeyAdapter() {

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    };

    /**
     * This timer will countdown for 60 seconds after either player 
     * move their pieces
     * @param black the side of the action performer
     * @return an integer for determaining the loser
     */
    public int countDown() {
        limit = 60;
        
        if (turnCounter == 0) {
            timer = new Timer();
            
            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {
                    limit--;
                    BoardFrame.timeSet(limit);//upload the remaining time to the GUI
                    if (limit == 0) {
                        timer.cancel();//stop the timer
                        System.out.println("1");
                        JOptionPane.showMessageDialog(null,"Time out!\nRound over.");
                        System.exit(0);
                    }
                }

            }, 0, 1000);//start 0 seconds later, repeat once per second
                
        } else if (turnCounter % 2 == 1) {
            timer.cancel();
            timer2 = new Timer();//create a timer for black team
            
            timer2.scheduleAtFixedRate(new TimerTask() {

                public void run() {
                    limit--;
                    BoardFrame.timeSet(limit);//upload the remaining time to the GUI
                    if (limit == 0) {
                        System.out.println("1");
                        timer2.cancel();//stop the timer
                        JOptionPane.showMessageDialog(null,"Red time out!\nBlue wins.");
                        System.exit(0);
                        
                    }
                }

            }, 0, 1000);//start 0 seconds later, repeat once per second

        } else if(turnCounter % 2 == 0) {
            timer2.cancel();
            timer = new Timer();//create a timer for red team
            
            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {
                    limit--;
                    BoardFrame.timeSet(limit);//upload the remaining time to the GUI
                    if (limit == 0) {
                        System.out.println("1");
                        timer.cancel();//stop the timer
                        JOptionPane.showMessageDialog(null,"Blue time out!\nRed wins.");
                        System.exit(0);
                        
                    }
                }

            }, 0, 1000);//start 0 seconds later, repeat once per second

        }
        
        if (limit == 0 && turnCounter % 2 == 0) {
            return 1; //black lose
        } else if (limit == 0 && turnCounter % 2 == 1) {
            return -1; //red lose
        } else {
            return 0; //no result
        }
        
    }
    
}



interface DrawingShape {

    boolean contains(Graphics2D g2, double x, double y);

    void adjustPosition(double dx, double dy);

    void draw(Graphics2D g2);
}

class DrawingImage implements DrawingShape {

    public Image image;
    public Rectangle2D rect;

    public DrawingImage(Image image, Rectangle2D rect) {
        this.image = image;
        this.rect = rect;
    }

    @Override
    public boolean contains(Graphics2D g2, double x, double y) {
        return rect.contains(x, y);
    }

    @Override
    public void adjustPosition(double dx, double dy) {
        rect.setRect(rect.getX() + dx, rect.getY() + dy, rect.getWidth(), rect.getHeight());
    }

    @Override
    public void draw(Graphics2D g2) {
        Rectangle2D bounds = rect.getBounds2D();
        g2.drawImage(image, (int) bounds.getMinX(), (int) bounds.getMinY(), (int) bounds.getMaxX(), (int) bounds.getMaxY(),
                0, 0, image.getWidth(null), image.getHeight(null), null);
    }
}
