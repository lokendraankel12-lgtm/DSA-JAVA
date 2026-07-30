//this is the most optimize solution for this question which have O(m*n) time complexity ;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //logic boundaries 
        // while condition
        // corner case 
        ArrayList<Integer>list=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int startrow=0;
        int startcol=0;
        int endrow=n-1;
        int endcol=m-1;
        // jb start row or end row overlap kre or startcol or endcol overlap kre jb value duplicate print na ho isliye while condition
        while(startrow<=endrow && startcol<=endcol){
             //top boundary
        for( int j=startrow; j<=endcol; j++){
            list.add(matrix[startrow][j]);
        }
        // right  boundary 
        for(int i=startrow+1; i<=endrow; i++){
            list.add( matrix[i][endcol]);
        }
        //botom boundary 
        for(int j=endcol-1; j>=startcol; j--){
            //corner case
            if(startrow==endrow){
                break;
            }
            list.add(matrix[endrow][j]);
        }
        //left boundary 
        for(int i=endrow-1; i>=startrow+1; i--){
          //  corner case jb dono brabr ho to sirf ek bar hi baoundary print ho dubara se nhi 
            if(startcol==endcol){
                break;
            }
            list.add(matrix[i][startcol]);
        }

        startrow++;
        endcol--;
        endrow--;
        startcol++;
    }
    return list;
}
}
