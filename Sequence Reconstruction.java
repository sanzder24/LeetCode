class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int orgLen = org.length;
        int[] idx = new int[orgLen+1];
        for(int i=0; i<orgLen; i++){
            if( org[i]<=0 || org[i]>orgLen ) return false;
            idx[org[i]] = i;
        }
        boolean[] consecu = new boolean[orgLen];
        for(List<Integer> s: seqs){
            for(int i=0; i<s.size(); i++){
                if( s.get(i)<=0 || s.get(i)>orgLen ) return false; // invalid number
                // check the first number in org
                if( i==0 && s.get(i)<=orgLen && idx[s.get(i)]==0 ) consecu[i] = true;
                // check that s is a subseq of org (Note that there is "=")
                if( i>0 && idx[s.get(i-1)]>=idx[s.get(i)] ) return false;
                // check that numbers consecutive in org is also consecutive in seqs
                if( i>0 && idx[s.get(i-1)]+1==idx[s.get(i)] ) consecu[idx[s.get(i)]] = true;
            }
        }
        for(int i=0; i<orgLen; i++){
            if( !consecu[i] ) return false;
        }
        return true;
    }
}