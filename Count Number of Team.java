class Solution {
    public int numTeams(int[] rating) {
        int result =0;
        for(int i =1; i<rating.length-1; i++){
            int leftLess=0, leftGreat=0, rightLess =0, rightGreat =0;
            for( int j=i-1; j>=0; j--){
                if(rating[i]>rating[j]){
                    leftLess++;
                } else {
                    leftGreat++;
                }
            }
            for( int j=i+1; j<rating.length; j++){
                
                if(rating[i]<rating[j]){
                    rightGreat++;
                }else {
                    rightLess++;
                }
            }
            result += leftLess*rightGreat + leftGreat*rightLess;
        }
        return result;
    }
}