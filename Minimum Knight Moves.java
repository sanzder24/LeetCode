class Solution {
    HashMap<Pair<Integer, Integer>, Integer> seen;
    int dx[]={1,1,2,2,-1,-1,-2,-2};
    int dy[]={-2,2,-1,1,2,-2,1,-1};
    public int minKnightMoves(int x, int y) {
        if(seen==null){
            seen = new HashMap<>();
            Queue<int[]> qq = new LinkedList<>();
            qq.add(new int[]{0,0,0});
            seen.put(new Pair(0,0), 0);
            
            while(!qq.isEmpty()){
                int c[]=qq.poll();
                for(int k=0;k<8;k++){
                    if(x>c[0]+1 && dx[k]<0)
                        continue;
                    if(x<c[0]+1 && dx[k]>0)
                        continue;
                    if(y>c[1]+1 && dy[k]<0)
                        continue;
                    if(y<c[1]+1 && dy[k]>0)
                        continue;
                    int ni = c[0]+dx[k];
                    int nj = c[1]+dy[k];
                    Pair<Integer, Integer> np = new Pair(ni, nj);
                    if(!seen.containsKey(np)){
                        qq.add(new int[]{ni, nj, c[2]+1});
                        seen.put(np, c[2]+1);
                    }
                }
            }
        }
        
        
        Pair<Integer, Integer> tp = new Pair(x, y);
        return seen.get(tp);
    }

}