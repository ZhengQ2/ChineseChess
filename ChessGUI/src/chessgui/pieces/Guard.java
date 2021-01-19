package chessgui.pieces;

import chessgui.Board;

public class Guard extends Piece {

    public Guard(int x, int y, boolean is_white, String file_path, Board board) {
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

        //the guard should go 2 steps each time, one horizontal, one verticle
        if (Math.abs(this.getX() - destination_x) != 1 || Math.abs(this.getY() - destination_y) != 1) {
            return false;
        }

        //the guard also can only go in the general's palace
        if (this.isWhite()) {
            if (destination_x < 3 || destination_x > 5 || destination_y < 0 || destination_y > 2) {
                return false;
            }
        } else {
            if (destination_x < 3 || destination_x > 5 || destination_y < 7 || destination_y > 9) {
                return false;
            }
        }

        //if he does not obey these rule, he is abe to go
        return true;
    }
}