class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int points =0, maxPoints =0;
        int i=0, j= tokens.length - 1;
        while(i<=j){
            if(P>=tokens[i]){
                points++;
                P -= tokens[i++];
                maxPoints = Math.max(maxPoints, points);
            }
            else if( points > 0){
                points--;
                P += tokens[j--];
            }
            else {
                return maxPoints;
            }
        }
        return maxPoints;
    }
}