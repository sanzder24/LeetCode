class Solution1 {
    public int[] findBuildings(int[] heights) {
         Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        for( int i = heights.length -1; i>=0; i--){
            if(stack.isEmpty()){
                stack.push(i);
                result.addFirst(i);
                continue;
            }
            
            while(!stack.isEmpty() && heights[stack.peek()]< heights[i]){
              stack.pop();
            } 
            if(!stack.isEmpty() && heights[stack.peek()]>= heights[i]){
                continue;
            }
            stack.push(i);
            result.addFirst(i);
        }
     // Object[] objectAarray = list.toArray();
        Object[] ans = result.toArray();
      int length = ans.length;;
      int [] result1 = new int[length];
      for(int i =0; i < length; i++) {
         result1[i] = (int) ans[i];
      }
        return result1;
    }
}
class Solution2 {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i=heights.length-1; i>=0; i--) {
            if (heights[i] > max) {
                list.add(i);
                max = heights[i];
            }
        }
        int n = list.size();
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            res[i] = list.get(n-1-i);
        }
        return res;
    }
}