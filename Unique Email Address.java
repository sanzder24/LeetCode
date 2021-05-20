class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String email: emails){
            StringBuilder address = new StringBuilder();
            for(int i=0; i < email.length(); i++){
                char c = email.charAt(i);
                if(c == '.'){
                    continue;
                } else if( c == '+')
                            {
                    while(email.charAt(i) !='@'){
                        i++;
                    }   
                    address.append(email.substring(i));
                    break;
                } else if (c=='@'){
                address.append(email.substring(i));
                break;
                }
                else{
                    address.append(c);
                }
                
            }
            
            set.add(address.toString());
            
        }
        Iterator itr = set.iterator();
  
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }      
        return set.size();
    }
}