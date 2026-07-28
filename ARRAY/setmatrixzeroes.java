// it is an brute force logic which have time complexity O(N *times M *times (N + M)) and space complexity O(1) kisi extra memory array ka use nhi kiya 
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Step 1: Scan and mark
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) { // <-- Check agar 0 hai
                    markrow(matrix, m, i);
                    markcol(matrix, n, j);
                }
            }
        }

        // Step 2: Convert dummy values to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { // <-- 'int' added here
                if (matrix[i][j] == -999999) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    void markrow(int matrix[][], int m, int i) {
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -999999;
            }
        }
    }

    void markcol(int matrix[][], int n, int j) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -999999;
            }
        }
    }
}
// now it is a optimize approach rwhich have O(N * M) + O(N * M) = O(N * M) and space complexity isme bad jaygi O(N + M) kyuki do extra array bnaye he 
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n]; // Row tracking
        int[] col = new int[m]; // Col tracking

        // Step 1: Scan matrix & mark row and col arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Step 2: Modify matrix based on arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
