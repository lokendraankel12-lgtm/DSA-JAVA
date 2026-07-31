// space complexity=O(l) time com=O(m*N*4L)
class Solution {
    public boolean exist(char[][] board, String word) {
     int rows = board.length;
        int cols = board[0].length;

        // 1. Grid ke har cell ko starting point bana kar try karenge
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Agar pehla letter match hota hai, tabhi DFS start karenge
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false; // Kahin se bhi word nahi mila
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Line A: Base Case - Agar poora word match ho gaya
        if (index == word.length()) {
            return true;
        }

        // Line B: Boundary Check + Mismatch Check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Line C: Current cell ko visit mark kar do (Temp value se replace karo)
        char temp = board[r][c];
        board[r][c] = '#'; // '#' ka matlab ye cell abhi path mein used hai

        // Line D: Charo directions (Neeche, Upar, Right, Left) mein agla letter dhoondho
        boolean found = dfs(board, word, r + 1, c, index + 1) || // Down
                        dfs(board, word, r - 1, c, index + 1) || // Up
                        dfs(board, word, r, c + 1, index + 1) || // Right
                        dfs(board, word, r, c - 1, index + 1);   // Left

        // Line E: Backtrack - Cell ko wapas original letter do
        board[r][c] = temp;

        return found;
    }
}
