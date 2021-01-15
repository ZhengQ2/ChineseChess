/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesechess;

/**
 *
 * @author Zheng Qiu
 */
public class Elephant extends Chess{

    public Elephant(int xPos, int yPos, boolean red) {
        super(xPos, yPos, red);
    }

    public boolean move(int yMove, int xMove) {
        boolean canMove = false;
        
        if (red) {
            if (Math.abs(yMove) == 2 && Math.abs(xMove) == 2 && (yPos + yMove) >= 1 && (yPos + yMove) <= 5) {
                xPos += xMove;
                yPos += yMove;
                canMove = true;
            }
        } else {
            if (Math.abs(yMove) == 2 && Math.abs(xMove) == 2 && (yPos + yMove) >= 6 && (yPos + yMove) <= 10) {
                xPos += xMove;
                yPos += yMove;
                canMove = true;
            }
        }
        return canMove;
    }

}
