package chessgui.pieces;

import chessgui.Board;

public class General extends Piece {

    public General(int x, int y, boolean is_white, String file_path, Board board) {
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
            }
            if (possiblePiece.isBlack() && this.isBlack()) {
                return false;
            }
        }

        //The piece can only go straight, cannot go oblique
        if (this.getX() != destination_x && this.getY() != destination_y) {
            return false;
        }

        //check the horizontal and verticle distance it moves
        int distanceX = Math.abs(destination_x - this.getX());
        int distanceY = Math.abs(destination_y - this.getY());

        //the general can only move 1 step
        if (distanceX + distanceY != 1) {
            return false;
        }

        //and the general can only move in his palace
        if (this.isWhite()) {
            if (destination_x < 3 || destination_x > 5 || destination_y < 0 || destination_y > 2) {
                return false;
            }
        } else {
            if (destination_x < 3 || destination_x > 5 || destination_y < 7 || destination_y > 9) {
                return false;
            }
        }

        return true;
    }
}
