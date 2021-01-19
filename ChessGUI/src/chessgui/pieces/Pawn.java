package chessgui.pieces;

import chessgui.Board;

public class Pawn extends Piece {

    private boolean has_moved;

    public Pawn(int x, int y, boolean is_white, String file_path, Board board) {
        super(x, y, is_white, file_path, board);
        has_moved = false;
    }

    public void setHasMoved(boolean has_moved) {
        this.has_moved = has_moved;
    }

    public boolean getHasMoved() {
        return has_moved;
    }

    @Override
    public boolean canMove(int destination_x, int destination_y) {
        //check what is the status for destination
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

        //check how long does it move
        int distanceX = Math.abs(destination_x - this.getX());
        int distanceY = Math.abs(destination_y - this.getY());

        //the pawn can only run 1 unit far each time
        if (distanceX + distanceY != 1) {
            return false;
        }

        //if the chess haven't cross the river, you cannot go vertically
        if (this.isWhite()) {
            if (destination_y < this.getY()) {
                return false;
            }
            if (destination_y < 5) {
                if (destination_x != this.getX()) {
                    return false;
                }
            }
        }

        if (this.isBlack()) {
            if (destination_y > this.getY()) {
                return false;
            }
            if (destination_y > 4) {
                if (destination_x != this.getX()) {
                    return false;
                }
            }
        }

        //if it does not obey any rule, allow it to move
        return true;
    }
}
