class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        //transpose the matrix]
        for(int i=0; i<n; i++){
            for(int j=i+1; j<m; j++){
                int temp =matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }

        }
        // Step 2: Reverse every row
        for(int i=0; i<n; i++){
            int start=0;
            int end=n-1;
            while(start<end){
                int tem=matrix[i][start];
                matrix[i][start]=matrix[i][end];
                matrix[i][end]=tem;
                start++;
                end--;
            }
         
        }
        
    }
}
