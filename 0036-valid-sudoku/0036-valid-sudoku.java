class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.') {
                    char ch = board[i][j];

                    for(int row = 0; row < 9; row++) {
                        if(row != i && board[row][j] == ch) {
                            return false;
                        }
                    }

                    for(int col = 0; col < 9; col++) {
                        if(col != j && board[i][col] == ch) {
                            return false;
                        }
                    }

                    int startRow = (i / 3) * 3;
                    int startCol = (j / 3) * 3;

                    for(int row = startRow; row < startRow + 3; row++) {
                        for(int col = startCol; col < startCol + 3; col++) {
                            if(i != row && j != col && board[row][col] == ch) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}