class Solution {
    public int hammingDistance(int x, int y) 
     {
          int w = x ^ y;
          int count = 0;
                  while(w!=0){
                  count++;  
                  w &= (w-1);
                  }
            return count;
        }
}