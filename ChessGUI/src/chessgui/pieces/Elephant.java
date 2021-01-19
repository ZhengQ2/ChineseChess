package chessgui.pieces;

import chessgui.Board;

public class Elephant extends Piece {

    public Elephant(int x, int y, boolean is_white, String file_path, Board board) {
        super(x, y, is_white, file_path, board);
    }

    @Override
    public boolean canMove(int destination_x, int destination_y) {
        //check what is the status for destination
        Piece possiblePiece = board.getPiece(destination_x, destination_y);

        //the chess can only eat others, instead of himselves
        if (possiblePiece != null) {
            if (possiblePiece.isWhite() && this.isWhite()) {
                return false;
            } else if (possiblePiece.isBlack() && this.isBlack()) {
                return false;
            }
        }

        //the elephant can only move horizontally 2 units and vertically 2 units at the same time
        if (Math.abs(this.getX() - destination_x) != 2 || Math.abs(this.getY() - destination_y) != 2) {
            return false;
        }

        //the elephant cannot cross the river
        if (this.isWhite()) {
            if (destination_y > 4) {
                return false;
            }
        } else {
            if (destination_y < 5) {
                return false;
            }
        }

        //if that does not obey any rule, return true
        return true;
    }
}
