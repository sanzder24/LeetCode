class Solution {
    int[][] dirs = {{-1, 0},{1, 0},{0, 1},{0, -1}};
    int m;
    int n;
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(); // key: island index, value: island area\
        int islandIdx = 2;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if( grid[i][j]==1 ){
                    int area = dfs(grid, i, j, islandIdx);
                    if( area==m*n ) return m*n; // max possible area
                    map.put(islandIdx, area);
                    islandIdx++;
                }
            }
        }
        int maxArea = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if( grid[i][j]==0 ){
                    Set<Integer> seen = new HashSet<Integer>();
                    int area = 1; // this cell itself
                    for(int[] d: dirs){
                        int newI = i+d[0];
                        int newJ = j+d[1];
                        if( newI>=0 && newI<m && newJ>=0 && newJ<n && 
                           grid[newI][newJ]!=0 && !seen.contains(grid[newI][newJ]) ){
                            area += map.get(grid[newI][newJ]);
                            seen.add(grid[newI][newJ]);
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    
    public int dfs(int[][] grid, int startI, int startJ, int islandIdx){
        if( startI<0 || startI>=m || startJ<0 || startJ>=n || grid[startI][startJ]!=1 ) return 0;
        grid[startI][startJ] = islandIdx;
        int res = 1; // isLand area
        res += dfs(grid, startI-1, startJ, islandIdx);
        res += dfs(grid, startI+1, startJ, islandIdx);
        res += dfs(grid, startI, startJ-1, islandIdx);
        res += dfs(grid, startI, startJ+1, islandIdx);
        return res;
    }
}