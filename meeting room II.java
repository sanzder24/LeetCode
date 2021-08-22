class Solution{
	public int minMeetingRooms( Interval[] intervals){
		if(intervals.length==0 || intervals ==null){
			return 0;
		}
		Arrays.sort(intervals, (a.b)-> a.start -b.start);
		PriorityQueue<Interval> minheap = new PriorityQueue <>((a,b)-> a.end -b.end);
		minheap.add(intervals[0]);
		for(int i =1; i<intervals.length; i++){
			Interval current = intervals[i];
			Interval earliest = minheap.remove();
			if(current.start>=earliest.end){
				earliest.end = current.end;
			}
			else {
				minheap.add(current);
			}
			minheap.add(earliest);
		}
		return minheap.size();
	}
}
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Integer[] startTimes = new Integer[intervals.length];
        Integer[] endTimes = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int endIndex = 0;
        int usedRooms = 0;

        for (int startIndex = 0; startIndex < intervals.length; startIndex += 1) {
            if (startTimes[startIndex] >= endTimes[endIndex]) {
                endIndex += 1;
            } else {
                usedRooms += 1;
            }
        }
        return usedRooms;
    }
}