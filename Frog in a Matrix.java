    public int findDistance(int[][] grid, int k) {
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        if(grid == null || grid.length == 0 || k < 1)
            return -1;
        int m = grid.length-1;
        int n = grid[0].length-1;
        Set<String> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        set.add("0:0");
        int dist = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] info = queue.poll();
                if(info[0] == m && info[1] == n) {
                    return dist;
                }
                for(int[] d : dir) {
                    for(int i=1; i<=k; ++i) {
                        int x = i*d[0]+info[0];
                        int y = i*d[1]+info[1];
                        if(x>=0 && y>=0 && x<=m && y<=n) {
                            if(grid[x][y] == -1) break;
                            if(set.contains(x+":"+y)) continue;
                            queue.offer(new int[]{x, y});
                            set.add(x+":"+y);
                        }
                    }
                }
            }
            ++dist;
        }
        return -1;
    }