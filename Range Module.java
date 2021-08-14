class RangeModule {
    List<Interval> list;
    public RangeModule() {
       list = new ArrayList<>();
    }
    
    public void addRange(int left, int right) {
        List<Interval> temp = new ArrayList<>();
        int index = 0;
        
        while(index < list.size() && list.get(index).right < left) {
            temp.add(list.get(index));
            index++;
        }
        
        while(index < list.size() && list.get(index).left <= right) {
            Interval cur = list.get(index);
            
            left = Math.min(left, cur.left);
            right = Math.max(right, cur.right);
            index++;
        }
        
        temp.add(new Interval(left, right));
        
        while(index < list.size()) {
            temp.add(list.get(index));
            index++;
        }
        
        list = temp;
    }
    
    public boolean queryRange(int left, int right) {
        int index = 0;
        
        while(index < list.size()) {
            if(list.get(index).left <= left && list.get(index).right >= right) {
                return true;
            }
            index++;
        }
        
       
        return false;
    }
    
    public void removeRange(int left, int right) {
        List<Interval> temp = new ArrayList<>();
        int index = 0;
        while(index < list.size() && list.get(index).right < left) {
            temp.add(list.get(index));
            index++;
        }
        
        if(index < list.size() && list.get(index).left < left) {
            temp.add(new Interval(list.get(index).left, left));
        }
        
        while(index < list.size() && list.get(index).right <= right ) {
            index++;
        }
        
        if(index < list.size() && right < list.get(index).right) {
            temp.add(new Interval(Math.max(right, list.get(index).left), list.get(index).right));
            index++;
        }
        
        while(index < list.size()) {
            temp.add(list.get(index));
            index++;
        }
        
        list = temp;
    }
    
    class Interval {
        int left;
        int right;
        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}