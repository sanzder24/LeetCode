class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] numberOfA = new int[7];
        int[] numberOfB = new int[7];
        int[] same = new int[7];
        for(int i = 0; i < A.length; i++) {
            numberOfA[A[i]]++;
            numberOfB[B[i]]++;
            if(A[i] == B[i]) same[A[i]]++;
        }
        
        for(int i = 1; i <= 6; i++) {
            if(numberOfA[i] + numberOfB[i] - same[i] == A.length) {
                return Math.min(numberOfA[i] - same[i], numberOfB[i] - same[i]);
            }
        }
        return -1;
    }
}