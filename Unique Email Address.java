class Solution {
public int numUniqueEmails(String[] emails) {
    
    Set<String> uniqueEmails = new HashSet<>();
    
    for (String rawEmail : emails) { 
        
        StringBuilder cleanMail = new StringBuilder();
        
        // compute local name (substring up to the first '+' or '@', remove all '.')
        int i = 0;
        while (i < rawEmail.length()) {
            
            char currChar = rawEmail.charAt(i);

            if (currChar == '+' || currChar == '@') break;      // end of clean local part                
            if (currChar != '.') cleanMail.append(currChar);
            i++;
        }
        
        // compute domain name (substring from '@' to end)
        while (i < rawEmail.length()) {
            
            char currChar = rawEmail.charAt(i);
            if (currChar == '@') {
                cleanMail.append(rawEmail.substring(i));
                break;
            }
            
            i++;
        }
        System.out.println(cleanMail.toString());
        uniqueEmails.add(cleanMail.toString());
    }
    
    return uniqueEmails.size();
}
}