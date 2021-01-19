package chessgui.pieces;

import chessgui.Board;

public class Horse extends Piece {

    public Horse(int x, int y, boolean is_white, String file_path, Board board) {
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

        //the horse cannot move simply horizontally or vertically.
        if (this.getX() == destination_x || this.getY() == destination_y) {
            return false;
        }

        //check the verticle and horizontal distance
        int distanceX = destination_x - this.getX();
        int distanceY = destination_y - this.getY();

        //the horse can only move in a "日" shape, so the sum of distance is always 3
        if (Math.abs(distanceX) + Math.abs(distanceY) != 3) {
            return false;
        }

        //check which is the longer side, and the middle intersection cannot have any other chess
        //otherwise the horse's leg has been blocked
        if (distanceX == 2) {
            Piece horseLeg = board.getPiece(this.getX() + 1, this.getY());
            if (horseLeg != null) {
                return false;
            }
        } else if (distanceX == -2) {
            Piece horseLeg = board.getPiece(this.getX() - 1, this.getY());
            if (horseLeg != null) {
                return false;
            }
        } else if (distanceY == 2) {
            Piece horseLeg = board.getPiece(this.getX(), this.getY() + 1);
            if (horseLeg != null) {
                return false;
            }
        } else {
            Piece horseLeg = board.getPiece(this.getX(), this.getY() - 1);
            if (horseLeg != null) {
                return false;
            }
        }

        //if there is nothing obey the rule, return true to move
        return true;
    }
}
