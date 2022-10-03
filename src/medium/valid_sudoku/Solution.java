package medium.valid_sudoku;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] sudokus = new HashSet[9];

        for (int i = 0; i < sudokus.length; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            sudokus[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' &&
                        (!rows[i].add(board[i][j])
                                || !columns[j].add(board[i][j])
                                || !sudokus[getSudoku(i, j)].add(board[i][j])))
                    return false;
            }
        }
        return true;
    }

    private int getSudoku(int row, int col) {
        return row / 3 * 3 + col / 3;
    }

    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        new Solution().isValidSudoku(board);
    }
}
