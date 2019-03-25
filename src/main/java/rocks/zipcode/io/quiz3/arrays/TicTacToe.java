package rocks.zipcode.io.quiz3.arrays;

/**
 * @author leon on 09/12/2018.
 */
public class TicTacToe {
    private String[][] board;

    public TicTacToe(String[][] board) {
        this.board = board;
    }

    public TicTacToe() {
        this.board = new String[3][3];
    }

    public String[] getRow(Integer value) {
        return board[value];
    }

    public String[] getColumn(Integer value) {
        return new String[]{board[0][value], board[1][value], board[2][value]};
    }

    public Boolean isRowHomogenous(Integer rowIndex) {
        return (board[rowIndex][0] == board[rowIndex][1] && board[rowIndex][2] == board[rowIndex][1]);
    }

    public Boolean isColumnHomogeneous(Integer columnIndex) {
        return (board[0][columnIndex] == board[1][columnIndex] && board[2][columnIndex] == board[1][columnIndex]);
    }

    public Boolean isDiagonalHomogenous() {
        return (board[0][0] == board[1][1] && board[2][2] == board[1][1]) ||
                (board[2][0] == board[1][1] && board[0][2] == board[1][1]);
    }

    public String getWinner() {
        String result = "Tie";
        if (isDiagonalHomogenous()) {
            result = board[1][1];
        } else {
            for (int i = 0; i < board.length; i++) {
                if (isColumnHomogeneous(i) || isRowHomogenous(i)) {
                    result = board[i][i];
                }
            }
        }
        return result;
    }

    public String[][] getBoard() {
        return board;
    }
}
