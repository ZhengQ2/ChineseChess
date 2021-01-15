package chinesechess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ChineseChess {

    int[][] chessBoard = new int[9][10];
    Chess[] redChess = new Chess[16];
    Chess[] blackChess = new Chess[16];
    int redSteps = 0;
    int blackSteps = 0;

    public static void main(String[] args) {
        // TODO code application logic here
    }

    public void pushButtons(int chessRule, boolean red, int chessNum, int xPosMove, int yPosMove) {
        //Chess Rule:
        //1 - Pawns; 2 - Elephants; 3 - Horses; 4 - Rooks; 5 - Canons; 6 - guards; 7 - kings
        boolean move;
        int oriXPos, oriYPos;

        if (red) {
            oriXPos = redChess[chessNum].getXPos();
            oriYPos = redChess[chessNum].getYPos();
        } else {
            oriXPos = blackChess[chessNum].getXPos();
            oriYPos = blackChess[chessNum].getYPos();
        }

        move = move(red, chessRule, xPosMove, yPosMove, chessNum);

        int newXPos, newYPos;

        if (move) {
            if (red) {
                newXPos = redChess[chessNum].getXPos();
                newYPos = redChess[chessNum].getYPos();
                countDown(60) throws InterruptedException; // check
                redSteps ++;
            } else {
                newXPos = blackChess[chessNum].getXPos();
                newYPos = blackChess[chessNum].getYPos();
                countDown(60) throws InterruptedException; // check
                blackSteps ++;
            }

            chessBoard[oriXPos + 1][oriYPos + 1] = 0;

            if (chessBoard[newXPos + 1][newYPos + 1] != 0) {
                recordEat();
            }

            checkWinner();

        }

    }

    public boolean move(boolean red, int chessRule, int xPosMove, int yPosMove, int chessNum) {
        boolean returnVal;
        if (chessRule == 3) {
            boolean canMove = checkHorseMove();
            if (red) {
                returnVal = redChess[chessNum].move(xPosMove, yPosMove, canMove);
            } else {
                returnVal = redChess[chessNum].move(xPosMove, yPosMove, canMove);
            }
        } else {
            if (red) {
                returnVal = redChess[chessNum].move(xPosMove, yPosMove);
            } else {
                returnVal = redChess[chessNum].move(xPosMove, yPosMove);
            }

        }
        return returnVal;
    }

    public boolean checkHorseMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getSteps(boolean red, int redSteps, int blackSteps) {
        if(red) {
            return redSteps;
        } else {
            return blackSteps;
        }
        
    public void save(int saveNum) {
        String gameChess = "";
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 10; column++) {
                gameChess += chessBoard[row][column] + "\n";
            }
        }
        File file;
        try {
            if (saveNum == 1) {
                file = new File("src//chinesechess//save1.txt");
            } else if (saveNum == 2) {
                file = new File("src//chinesechess//save2.txt");
            } else if (saveNum == 3) {
                file = new File("src//chinesechess//save3.txt");
            } else if (saveNum == 4) {
                file = new File("src//chinesechess//save4.txt");
            } else {
                file = new File("src//chinesechess//save5.txt");
            }
            PrintWriter fw = new PrintWriter(file);
            fw.write(gameChess);
            fw.flush();
            fw.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Error" + ex);
        }
    }
        
    public int checkWinner(boolean roundRed) {
        boolean redKing, blackKing;
        redKing = false;
        blackKing = false;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                if (chessBoard[i][j] == 1) {
                    redKing = true;
                } else if (chessBoard[i][j] == -1) {
                    blackKing = true;
                }
            }
        }

        if (!redKing) {
            return -1;//black wins
        } else if (!blackKing) {
            return 1;//red wins
        }

        boolean kingMeets = false;

        int redKingPos = redChess[0].getYPos();
        int blackKingPos = blackChess[0].getYPos();
        
        if (redKingPos == blackKingPos) {
            for (int i = 0; i < 10; i++) {
                if (chessBoard[redKingPos - 1][i] != 0) {
                    return 0;
                } 
                if (roundRed){
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        return 0;
    }

}
