class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int row = 0; row < m; row++){
            sort(mat, row, 0, m,n);
        }
        for(int col = 0; col < n; col++){
            sort(mat, 0,col,m,n);
        }
        return mat;
    }
    
    void sort (int[][] mat, int rowStart, int colStart, int m, int n){
        int row = rowStart;
        int col = colStart;
       int[] bucket = new int[101];
        while(row < m && col < n){
            bucket[mat[row][col]]++;
            row++;
            col++;
        }
        row = rowStart;
        col = colStart;
           for(int i = 0; i<bucket.length; i++){
            if(bucket[i] > 0){
                int count = bucket[i];
                while(count > 0){
                    mat[row][col] = i;
                    bucket[i]--;
                    count--;
                    row++;
                    col++;   
                }
            }
        }
    }
}
class Solution2 {
       public int[][] diagonalSort(int[][] A) {
        int m = A.length, n = A[0].length;
        HashMap<Integer, PriorityQueue<Integer>> d = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                d.putIfAbsent(i - j, new PriorityQueue<>());
                d.get(i - j).add(A[i][j]);
            }
        }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                A[i][j] = d.get(i - j).poll();
        return A;
    }
}