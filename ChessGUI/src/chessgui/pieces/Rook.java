package chessgui.pieces;

import chessgui.Board;

public class Rook extends Piece {

    public Rook(int x, int y, boolean is_white, String file_path, Board board) {
        super(x, y, is_white, file_path, board);
    }

    @Override
    public boolean canMove(int destination_x, int destination_y) {
        //check the status of its destination
        Piece possiblePiece = board.getPiece(destination_x, destination_y);

        //the chess can only eat others, instead of himselves
        if (possiblePiece != null) {
            if (possiblePiece.isWhite() && this.isWhite()) {
                return false;
            }
            if (possiblePiece.isBlack() && this.isBlack()) {
                return false;
            }
        }

        //if the chess go in a oblique line, reject it
        if (this.getX() != destination_x && this.getY() != destination_y) {
            return false;
        }

        String direction = "";

        //check the direction this chess goes
        if (destination_y > this.getY()) {
            direction = "south";
        }
        if (destination_y < this.getY()) {
            direction = "north";
        }
        if (destination_x > this.getX()) {
            direction = "east";
        }
        if (destination_x < this.getX()) {
            direction = "west";
        }

        //and check if any body blocks it using the same way in the cannon
        if (direction.equals("south")) {
            int spaceToMove = Math.abs(destination_y - this.getY());
            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(this.getX(), this.getY() + i);
                if (p != null) {
                    return false;
                }
            }
        }

        if (direction.equals("north")) {
            int spaceToMove = Math.abs(destination_y - this.getY());
            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(this.getX(), this.getY() - i);
                if (p != null) {
                    return false;
                }
            }
        }

        if (direction.equals("west")) {
            int spaceToMove = Math.abs(destination_x - this.getX());
            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(this.getX() + i, this.getY());
                if (p != null) {
                    return false;
                }
            }
        }

        if (direction.equals("east")) {
            int spaceToMove = Math.abs(destination_x - this.getX());
            for (int i = 1; i < spaceToMove; i++) {
                Piece p = board.getPiece(this.getX() - i, this.getY());
                if (p != null) {
                    return false;
                }
            }
        }

        //if they does not obey any rule, move it
        return true;
    }
}
