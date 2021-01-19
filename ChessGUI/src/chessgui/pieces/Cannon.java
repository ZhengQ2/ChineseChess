package chessgui.pieces;

import chessgui.Board;

public class Cannon extends Piece {

    public Cannon(int x, int y, boolean is_white, String file_path, Board board) {
        super(x, y, is_white, file_path, board);
    }

    @Override
    public boolean canMove(int destination_x, int destination_y) {
        //check what is the status for destination
        Piece possiblePiece = board.getPiece(destination_x, destination_y);

        //The piece can only go straight, cannot go oblique
        if (this.getX() != destination_x && this.getY() != destination_y) {
            return false;
        }

        //get the direction for later use
        String direction = "";

        //check the direction of the movement
        if (destination_y > this.getY()) {
            direction = "south";
        } else if (destination_y < this.getY()) {
            direction = "north";
        } else if (destination_x > this.getX()) {
            direction = "east";
        } else if (destination_x < this.getX()) {
            direction = "west";
        }

        //check any piece is in the middle
        int middle = 0;

        //Based on the direction, check how many pieces is in between
        if (direction.equals("south")) {
            //first get how long does it move
            int spaceToMove = Math.abs(destination_y - this.getY());
            for (int i = 1; i < spaceToMove; i++) {
                //and check each spaces, are there ant chess or not.
                Piece p = board.getPiece(this.getX(), this.getY() + i);
                //if there is anything in the middle, count it.
                if (p != null) {
                    middle++;
                }
            }
        } else if (direction.equals("north")) {
            int spaceToMove = Math.abs(destination_y - this.getY());
            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(this.getX(), this.getY() - i);
                if (p != null) {
                    middle++;
                }
            }
        } else if (direction.equals("west")) {
            int spaceToMove = Math.abs(destination_x - this.getX());
            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(this.getX() + i, this.getY());
                if (p != null) {
                    middle++;
                }
            }
        } else if (direction.equals("east")) {
            int spaceToMove = Math.abs(destination_x - this.getX());
            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(this.getX() - i, this.getY());
                if (p != null) {
                    middle++;
                }
            }
        }

        //If there is no chess in the middle, the cannon can only move
        if (middle == 0) {
            if (possiblePiece != null) {
                return false;
            }
            return true;

            //If there is one chess in the middle, the cannon can only eat
        } else if (middle == 1) {
            if (possiblePiece != null) {
                //but it cannot eat itself
                if (possiblePiece.isWhite() && this.isWhite()) {
                    return false;
                }else if (possiblePiece.isBlack() && this.isBlack()) {
                    return false;
                }
            }

            return true;

            //If other cases, the chess can neither move nor eat
        } else {
            return false;
        }
    }
}
