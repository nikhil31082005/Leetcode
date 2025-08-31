class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }
    public boolean solveSudoku(char[][] board, int row, int col) {
        if (col == 9) {
            row++;
            col = 0;
        }
        if (row == 9) {
            return true;
        }

        if (board[row][col] == '.') {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isValid(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (solveSudoku(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        } else {
            return solveSudoku(board, row, col + 1);
        }
    }
    public boolean isValid(char[][] board, int row, int col, char ch) {
        for(int i = 0; i < 9; i++) {
            if(i != row && board[i][col] == ch) {
                return false;
            }
        }

        for(int i = 0; i < 9; i++) {
            if(i != col && board[row][i] == ch) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(i != row && j != col && board[i][j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}