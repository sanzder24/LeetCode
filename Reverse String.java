class Solution {
    public void reverseString(char[] s) {
        int len=s.length;
        char temp;
        int left=0, right=len-1;
        while(left<right){
            temp=s[right];
            s[right]=s[left];
            s[left]=temp;
            right--;
            left++;
            
        }
    }
}