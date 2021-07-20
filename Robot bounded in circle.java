class Solution {
    public boolean isRobotBounded(String instructions) {
        int direction[][] = {{0,1}, {-1,0}, {0, -1}, {1 ,0}}; //up, left, down, right
        int i =0, x=0, y=0;
        for(int j=0; j<instructions.length(); j++){
            if(instructions.charAt(j)=='L'){
             i= (i+1)%4; //since 4 is the size and out of bound check
            } else if (instructions.charAt(j)=='R'){
               i= (i+3)%4;
            } else {
                x = x + direction[i][0];
                y = y + direction[i][1];
            }
        }
        return x==0 && y==0 || i!=0; //if rotation exist such as GL where 4 repetition is needed so chck i
        
    }
}