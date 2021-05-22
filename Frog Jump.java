class Solution {
    public boolean canCross(int[] stones) {
        for(int i =3; i<stones.length; i++){
            if(stones[i]>stones[i-1]*2){
                return false;
            }
        }
     Stack<Integer> positions = new Stack<>();
     Stack<Integer> jumps = new Stack<>();
     HashSet<Integer> set = new HashSet<>();
        for(int i: stones){
            set.add(i);
        }
     positions.add(0);
     jumps.add(0);
     int lastpos = stones[stones.length -1];
     while(!positions.isEmpty()){
         int position = positions.pop();
         int jump = jumps.pop();
         for(int i = jump -1; i<= jump +1; i++){
            if(i<=0){
                continue;
            }
             int nextpos = position +i; 
             if( position ==lastpos ){
                 return true;
             } else if(set.contains(nextpos)){
                positions.add(nextpos);
                 System.out.println(" ");
                System.out.println(nextpos);
                System.out.println(" ");
                 System.out.println(i);
                jumps.add(i);
             }
         }
     }
        return false;
    }
}