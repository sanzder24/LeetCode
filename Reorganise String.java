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
Solution 2 {
        public String reorganizeString(String S) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : S.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int len = S.length();
            for (char c : map.keySet()) {
                if ((len % 2 == 0 && map.get(c) > len / 2) || (len % 2 != 0 && map.get(c) >= len / 2 + 2)) {
                    return "";
                }
            }
            PriorityQueue<CustChar> queue = new PriorityQueue<>((a, b) -> b.count - a.count);
            for (char c : map.keySet()) {
                queue.offer(new CustChar(c, map.get(c)));
            }

            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                CustChar curr = queue.poll();
                char c = curr.c;
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) != c) {
                    sb.append(c);
                    if (curr.count > 1) {
                        queue.offer(new CustChar(c, curr.count - 1));
                    }
                } else if (sb.length() == 0) {
                    sb.append(c);
                    if (curr.count > 1) {
                        queue.offer(new CustChar(c, curr.count - 1));
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c && !queue.isEmpty()) {
                    CustChar next = queue.poll();
                    sb.append(next.c);
                    if (next.count > 1) {
                        queue.offer(new CustChar(next.c, next.count - 1));
                    }
                    queue.offer(curr);
                }
            }
            return sb.toString();
        }

        class CustChar {
            Character c;
            int count;

            public CustChar(Character c, int count) {
                this.c = c;
                this.count = count;
            }
        }
}