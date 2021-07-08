class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
    int wstart= 0, wend=0;
    int onecount=0, maxlength=-1;
    for(wend =0; wend<arr.length; wend++){
      if(arr[wend]==1){
        onecount++;
      }
      if(wend - wstart +1 - onecount > k){ // count the 1's and remove to find the window
        if(arr[wstart]==1) onecount--;
        wstart++;
      }
      maxlength = Math.max(maxlength, wend - wstart +1);
    }
    return maxlength;
  }
}
T : O(N)
S : (1)