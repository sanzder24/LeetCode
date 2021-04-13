class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    HashSet<Integer> visited = new HashSet<>();
    Stack <Integer> stack = new Stack<>();
    visited.add(0);
    stack.add(0);
        
        while(!stack.isEmpty()){
            List<Integer> keys = rooms.get(stack.pop());
            for(int key : keys){
                if(!visited.contains(key)){
                    visited.add(key);
                    stack.add(key);
                }
            }
        }
        return visited.size() == rooms.size() ? true: false;
    }
}