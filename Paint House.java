class Solution {
public int minCost(int[][] costs) {
    //incrementing the leetcode solution
    int[][] memo = new int[costs.length][costs[0].length];
    //stores the cost of [house][cost] min total cost till we reach that point
    
    int r0 = findMinCost(costs, 0, 0, memo);
    int r1 = findMinCost(costs, 0, 1, memo);
    int r2 = findMinCost(costs, 0, 2, memo);
    
    
    return Math.min(r0, Math.min(r2, r1));
}

private int findMinCost(int[][] costs, int house, int color, int[][] memo){
    if( memo[house][color] != 0){
        return memo[house][color];
    }
    
    int total = costs[house][color];
    
    if(house == costs.length - 1){
        //we are at the last house and we do nothing
    }else if(color == 0){
        //red color
        total += Math.min(findMinCost(costs, house + 1, 1, memo), findMinCost(costs, house + 1, 2, memo));
    }else if(color == 1){
        //green color
        total += Math.min(findMinCost(costs, house + 1, 0, memo), findMinCost(costs, house + 1, 2, memo));
    }else if(color == 2){
        //blue color
        total += Math.min(findMinCost(costs, house + 1, 0, memo), findMinCost(costs, house + 1, 1, memo));
    }
    
    //finally 
    memo[house][color] = total;
    return total;
}
}