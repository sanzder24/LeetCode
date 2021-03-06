class Solution {
    public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
        int i=0;
        while( i<asteroids.length){
            if(asteroids[i]>0){

            stack.push(asteroids[i]); //Just add
            }
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])){ //checking if there exists a right going asteroid
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0) { //if -ve massive asteroid raids all to the left
                    stack.push(asteroids[i]);
                } else if( stack.peek() == Math.abs(asteroids[i])){
                    stack.pop();
                }
            }
            i++;
        }
        int[] remaining = new int[stack.size()];
        for(i = stack.size()-1; i>=0; i--){
            remaining[i] = stack.pop();
        }
        return remaining;
    }
}