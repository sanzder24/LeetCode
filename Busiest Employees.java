public static EmployeeNode getBusiestNode(EmployeeNode president){
        Map<EmployeeNode, Double> map=new HashMap();
        find(president,map);
        
        double max=Double.MIN_VALUE;
        EmployeeNode result=null;
        
        for(Map.Entry<EmployeeNode,Double> entry:map.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                result=entry.getKey();
            }
        }
        
        return result;   
    }
    
    
    public static int[] find(EmployeeNode node, Map<EmployeeNode, Double> map){
        if(node==null)
            return new int[]{};
        
        if(node.subEmployeeNode.size()==0){
            return new int[]{node.value,1};
        }
        
        int sum=node.value;
        int count=1;
        for(EmployeeNode n:node.subEmployeeNode){
            int[] result=find(n, map);
            sum+=result[0];
            count+=result[1];
        }
        
        map.put(node,sum*1.0/count);
        return new int[]{sum,count};
    }