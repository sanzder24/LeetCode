class Solution1 {
    public String minRemoveToMakeValid(String s) {
      StringBuilder sb = new StringBuilder(s);
      Stack<Integer> st = new Stack<>();
      for (int i = 0; i < sb.length(); ++i) {
        if (sb.charAt(i) == '(') st.add(i);
        if (sb.charAt(i) == ')') {
          if (!st.empty()) st.pop();
          else sb.setCharAt(i, '*');
        }
      }
      while (!st.empty())
        sb.setCharAt(st.pop(), '*');
        
      return sb.toString().replaceAll("\\*", "");
    }
}

class Solution2 {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                open++;
            }else if(arr[i] == ')'){
                if(open > 0){
                    open--;
                }else{
                    arr[i] = '$';
                }
            }
        }
        
        int i = arr.length - 1;
        while(open > 0){
            while(arr[i] != '(') i--;
            arr[i--] = '$';
            open--;
        }
        
        int len = 0;
        for(i = 0; i < arr.length; i++){
            if(arr[i] != '$'){
                arr[len++] = arr[i];
            }
        }
        
        return new String(arr, 0, len);
    }
}