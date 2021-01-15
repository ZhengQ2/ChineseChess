/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesechess;

public abstract class Chess {
    protected int xPos;
    protected int yPos;
    protected boolean red;
    
    public Chess (int xPos, int yPos, boolean red) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.red = red;
    }
    
    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}
