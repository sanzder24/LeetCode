class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
                return 0;
            }
        char prev = chars[0];
        int count =1;
        StringBuilder sb = new StringBuilder();
        for( int i=1; i<chars.length; i++){
            if(chars[i]==prev){
                count++;
            } else {
                if(count>1){
                    sb.append(prev);
                    sb.append(count);
                } else if(count==1) sb.append(prev);
                prev= chars[i];
                count =1;
            }
        }
        sb.append(prev);
        if(count>1){
            sb.append(count);
        }
        int i=0;
        for( char c: sb.toString().toCharArray()){
            chars[i++] = c;
        }
        return sb.length();
    }
}