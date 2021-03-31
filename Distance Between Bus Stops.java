class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if( start> destination){
            int temp = start;
            start= destination;
            destination =temp;
                
        }
        int clock=0;
        for ( int i =start ;i< destination; i++){
            clock += distance[i];
        }
        int anticlock=0;
        for(int i =destination;i<distance.length; i++){
            anticlock += distance[i];
        }
        for( int i =0; i<start; i++){
            anticlock += distance[i];
        }
        return Math.min(clock, anticlock);
        
    }
}