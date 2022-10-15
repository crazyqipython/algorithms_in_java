import java.util.*;
public class WordSearch {

    public boolean exist(char[][] board, String word){

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(i, j, board, word, 0, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean backtracking(int r, int c, char[][] board, String word, int index, boolean[][] visited) {

        if (index == word.length())
            return true;

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || word.charAt(index) != board[r][c]
                || visited[r][c])
            return false;

        visited[r][c] = true;

        boolean res = backtracking(r + 1, c, board, word, index + 1, visited) ||
                backtracking(r - 1, c, board, word, index + 1, visited) ||
                backtracking(r, c + 1, board, word, index + 1, visited) ||
                backtracking(r, c - 1, board, word, index + 1, visited);

        visited[r][c] = false;

        return res;
    }
}
