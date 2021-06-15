class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        //x > top of stack
        int n = result.length-1;
    
        for(int i = n;i >= 0;i--){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
            result[i]= 0;
            }
            else{
            result[i]= stack.peek() - i;
            }
            stack.push(i);
            
        }
        return result;
    }
}