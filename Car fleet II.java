class Solution {
    public double[] getCollisionTimes(int[][] A) {
    int n = A.length;
    Deque<Integer> stack = new LinkedList<>();
    double[] res = new double[n];
    for (int i = n - 1; i >= 0; --i) {
        res[i] = -1.0;
        int p = A[i][0], s = A[i][1];
        while (stack.size() > 0) {
            int j = stack.peekLast(), p2 = A[j][0], s2 = A[j][1];
            if (s <= s2 || 1.0 * (p2 - p) / (s - s2) >= res[j] && res[j] > 0){
                System.out.println("popping :"+stack.peekLast()); 
                stack.pollLast();
}
               
            else
                break;
        }
        if (stack.size() > 0) {
            int j = stack.peekLast(), p2 = A[j][0], s2 = A[j][1];
            res[i] = 1.0 * (p2 - p) / (s - s2);
            System.out.println(res[i]);
        }
        System.out.println(" adding :" +i);
        stack.add(i);
    }
        //System.out.println(" 1");
    return res;
  }
}