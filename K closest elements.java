class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int left =0, right = arr.length-k; //account for size - k
        int m=0;
        while(left<right){
            m = left + (right-left)/2 ;
            if(x - arr[m] > arr[m+k] - x) left = m + 1; //graph approach
            else right = m;
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int index = left; index < left + k; index++)
        {
            result.add(arr[index]);
        }
        return result;
    }
}
T: Log(N)
S: O(N)