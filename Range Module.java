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
----------------------------------------------------------------------------------------------
class RangeModule2 {
    TreeNode root;
    
    public RangeModule() {}
    
    public void addRange(int left, int right) {
        root = addRange(root, left, right);
    }
    
    public boolean queryRange(int left, int right) {
        return queryRange(root, left, right);
    }
    
    public void removeRange(int left, int right) {
        root = removeRange(root, left, right);
    }  
    
    private TreeNode removeRange(TreeNode root, int start, int end) {
        if (start >= end) return root;
        
        if (root == null) return root;
        
        if (root.end <= start) {
            root.right = removeRange(root.right, start, end);
        } else if (root.start >= end) {
            root.left = removeRange(root.left, start, end);
        } else {
            root.left = removeRange(root.left, start, root.start);  // if start >= root.start, no change on root.left
            root.right = removeRange(root.right, root.end, end);
            root.left = addRange(root.left, root.start, start);
            root.right = addRange(root.right, end, root.end);
            root = remove(root);
        }
        return root;
    }
    
    private TreeNode remove(TreeNode node) {
        if (node == null) return null;
        if (node.left == null) return node.right;
        TreeNode leftLargest = getLargest(node.left, node);
        leftLargest.left = node.left;
        leftLargest.right = node.right;
        return leftLargest;
    }    
    
    private TreeNode getLargest(TreeNode node, TreeNode parent) {
        while (node.right != null) {
            parent = node;
            node = node.right;
        }
        
        if (parent.left == node) parent.left = node.left;
        if (parent.right == node) parent.right = node.left;
        node.left = null;
        return node;
    }
    
    private boolean queryRange(TreeNode root, int start, int end) {
        if (start >= end) return true;  // See the last line of the function
        if (root == null) return false;
        
        if (start >= root.end) {
            return queryRange(root.right, start, end);
        } 
        
        if (end <= root.start) {
            return queryRange(root.left, start, end);
        }
        
        if (start >= root.start && end <= root.end) return true;
        
        // This implies it is true for range [root.start, root.end);
        return queryRange(root.left, start, root.start) && queryRange(root.right, root.end, end);
    }    
    
    private TreeNode addRange(TreeNode root, int start, int end) {
        if (start >= end) return root;
        
        if (root == null) return new TreeNode(start, end);
        
        if (root.start >= end) {
            root.left = addRange(root.left, start, end);
        }  else if (root.end <= start) {
            root.right = addRange(root.right, start, end);
        } else {
            root.left = addRange(root.left, start, root.start);  // if start >= root.start, no change on root.left !!
            root.right = addRange(root.right, root.end, end);    // if root.end >= end, no change on root.right !!
        }
        
        return root;
    }    
}

class TreeNode {
    int start, end;
    TreeNode left, right;
        
    public TreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}