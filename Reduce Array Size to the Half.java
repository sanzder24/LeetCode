class Solution1 {
    public int minSetSize(int[] arr) {
        if(arr.length<2){
            return 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0) + 1 );
            //System.out.println(map.get(arr[i]));
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
        q.add(entry.getKey());
        }
          
        int k=arr.length, j=0;
        while( k > (arr.length/2)) {
            //System.out.println(map.get(q.peek()));
            System.out.println(k);
            k-= map.get(q.poll());
            System.out.println(k);
            j++;
        }
        return j;
    
}
}
              
class Solution2 {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int arrlen = arr.length;
        for(int i : arr){
          
            if(map.containsKey(i)){
                map.replace(i, map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        
     //  System.out.println(map.toString());
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
       System.out.println(list);
        int count = 0 , sum = 0, len = list.size();
       
        for(int i = 0; i<len ;i++){
            sum += list.get(i);
            count++;
            if(sum>=(arrlen/2)){
                
                break;
            }
            
        }
        
        
        return count;
    }
}