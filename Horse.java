/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesechess;

public class Horse extends Chess {

    public Horse(int xPos, int yPos, boolean red) {
        super(xPos, yPos, red);
    }

    public boolean move(int yMove, int xMove, boolean canMove) {

        if (((Math.abs(yMove) == 2 && Math.abs(xMove) == 1) || (Math.abs(yMove) == 1 && Math.abs(xMove) == 2)) && canMove && (yPos + yMove) >= 1 && (yPos + yMove) <= 10) {
            xPos += xMove;
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
