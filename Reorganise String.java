class Solution {
    public String reorganizeString(String S) {
    Map<Character, Integer> map = new HashMap<>();
    for( char c: S.toCharArray()){
        map.put(c, map.getOrDefault(c,0)+1);
    }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());
    StringBuilder sb = new StringBuilder();
    while(maxHeap.size()>1){
        char current = maxHeap.remove();
        char next = maxHeap.remove();
        sb.append(current);
        sb.append(next);
        map.put(current, map.get(current)-1);
        map.put(next, map.get(next)-1);
        if(map.get(current)> 0){
            maxHeap.add(current);
        }
        if(map.get(next)> 0){
            maxHeap.add(next);
        }
    }
    if(!maxHeap.isEmpty()){
        char c = maxHeap.remove();
    if(map.get(c) > 1){
        return "";
    }
        sb.append(c);
    }
        return sb.toString();
    }
}