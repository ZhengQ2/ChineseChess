/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesechess;

public class Pawn extends Chess {

    boolean riverSide;

    public Pawn(int xPos, int yPos, boolean red, boolean riverSide) {
        super(xPos, yPos, red);
        this.riverSide = riverSide;
    }

    public boolean move(int yMove, int xMove) {
        boolean canMove = false;
        
        if (red) {
            if (yMove == 1 && (yPos + yMove) >= 1 && (yPos + yMove) <= 10) {
                yPos += yMove;
                canMove = true;
            } else if (riverSide && (xMove == 1 || xMove == -1) && (xPos + xMove) >= 1 && (xPos + xMove) <= 9) {
                xPos += yMove;
                canMove = true;
            }
        } else {
            if (yMove == -1 && (yPos + yMove) >= 1 && (yPos + yMove) <= 10) {
                yPos += yMove;
                canMove = true;
            } else if (riverSide && (xMove == 1 || xMove == -1) && (xPos + xMove) >= 1 && (xPos + xMove) <= 9) {
                xPos += yMove;
                canMove = true;
            }
        }
        
        return canMove;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

}
