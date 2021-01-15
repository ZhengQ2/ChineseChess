/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesechess;

public class Rook extends Chess {

    public Rook(int xPos, int yPos, boolean red) {
        super(xPos, yPos, red);
    }

    public boolean move(int yMove, int xMove) {
        boolean canMove = false;

        if (Math.abs(yMove) != 0 && (yPos + yMove) >= 1 && (yPos + yMove) <= 10) {
            yPos += yMove;
            canMove = true;
        } else if (Math.abs(xMove) != 0 && (xPos + xMove) >= 1 && (xPos + xMove) <= 9) {
            yPos += yMove;
            canMove = true;
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
