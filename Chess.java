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
public abstract class Chess {
    protected int xPos;
    protected int yPos;
    public Chess (int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
