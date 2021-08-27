class Solution {
public int numTeams(int[] a) {
    
    int n = a.length;
    int count = 0;
    int dp_small[] = new int[n];
    int dp_large[] = new int[n];
    Arrays.fill(dp_large,0);
    Arrays.fill(dp_small,0);
    for(int i=1 ; i < n ; i++){
        for(int j=0 ; j <i ; j++){
            if(a[i] > a[j]){
                dp_large[i] = dp_large[i]+1;
                count += dp_large[j];
            }
            
            if(a[i] < a[j]){
                dp_small[i] = dp_small[i]+1;
                 count += dp_small[j];
            }
        }
    }
    return count;
    
}
}
