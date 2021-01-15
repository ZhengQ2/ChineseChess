/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesechess;

public class General extends Chess {

    public General(int xPos, int yPos, boolean red) {
        super(xPos, yPos, red);
    }

    public boolean move(int yMove, int xMove) {
        boolean canMove = false;

        if (red) {
            if (((Math.abs(yMove) == 1 || Math.abs(xMove) == 1)) && canMove && (yPos + yMove) >= 1 && (yPos + yMove) <= 3 && (xPos + xMove) >= 4 && (xPos + xMove) <= 6) {
                xPos += xMove;
                yPos += yMove;
                canMove = true;
            }
        } else {
            if (((Math.abs(yMove) == 1 || Math.abs(xMove) == 1)) && canMove && (yPos + yMove) >= 8 && (yPos + yMove) <= 10 && (xPos + xMove) >= 4 && (xPos + xMove) <= 6) {
                xPos += xMove;
                yPos += yMove;
                canMove = true;
            }
        }
        return canMove;
    }

}
