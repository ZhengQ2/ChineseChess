package chinesechess;

public class ChineseChess {

    int[][] chessBoard = new int[9][10];
    Chess[] redChess = new Chess[16];
    Chess[] blackChess = new Chess[16];

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
            } else {
                newXPos = blackChess[chessNum].getXPos();
                newYPos = blackChess[chessNum].getYPos();
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

}
