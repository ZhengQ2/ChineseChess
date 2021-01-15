/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesechess;

public class Pawn extends Chess {
    public Pawn(int xPos, int yPos, boolean red) {
        super(xPos, yPos, red);
    }

    public boolean move(int yMove, int xMove) {
        boolean moved = false;
        boolean riverSide = false;
        if (red) {
            if (yPos >= 6 && yPos <= 10){
                riverSide = true;
            }
        } else {
            if (yPos >= 1 && yPos <= 5){
                riverSide = true;
            }
        }
        
        if (red) {
            if (yMove == 1 && (yPos + yMove) >= 1 && (yPos + yMove) <= 10) {
                yPos += yMove;
                moved = true;
            } else if (riverSide && (xMove == 1 || xMove == -1) && (xPos + xMove) >= 1 && (xPos + xMove) <= 9) {
                xPos += yMove;
                moved = true;
            }
        } else {
            if (yMove == -1 && (yPos + yMove) >= 1 && (yPos + yMove) <= 10) {
                yPos += yMove;
                moved = true;
            } else if (riverSide && (xMove == 1 || xMove == -1) && (xPos + xMove) >= 1 && (xPos + xMove) <= 9) {
                xPos += yMove;
                moved = true;
            }
        }
        
        return moved;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

}
