class LRUCache {
    class Node{
    int key, value;
    Node prev;
    Node next;
    }
    final Node head = new Node();
    final Node tail = new Node();
    int cache_capacity;
    Map <Integer, Node> node_map;
    
    public LRUCache(int capacity) {
        this.cache_capacity = capacity;
        node_map = new HashMap(capacity);
        head.next= tail;
        tail.prev = head;
    }
    
    public void add(Node node){
    Node head_next = head.next;
    head.next = node;
    node.prev = head;
    node.next = head_next;
    head_next.prev = node;    
    }
    public void remove(Node node){
    Node node_next = node.next;
    Node node_prev = node.prev;
    node_next.prev = node_prev;
    node_prev.next = node_next;    
    }
    
    public int get(int key) {
        int result = -1;
        Node node = node_map.get(key);
        if(node!=null){
            result = node.value;
            remove(node);
            add(node);
        }
        return result;
    }
    
    public void put(int key, int value) {
        Node node = node_map.get(key);
        if(node != null){
            remove(node);
            node.value =value;
            add(node);
        } else {
            if(node_map.size()==cache_capacity){
                node_map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node new_node = new Node();
            new_node.key = key;
            new_node.value = value;
            node_map.put(key, new_node);
            add(new_node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
