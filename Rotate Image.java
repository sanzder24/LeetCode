class Solution {
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        int temp;
        for( int i=0; i<len;i++){
            for( int j=i; j<len;j++){
                temp = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        for(int i =0; i<len; i++){
            int left=0;
            int right=len-1;
            while (left<right){
                temp = matrix[i][right];
                matrix[i][right]= matrix[i][left];
                matrix[i][left]=temp;
                left++;
                right--;
            }
        }
    }
}