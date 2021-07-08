import java.util.*;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    // TODO: Write your code here
    int matched =0, ws=0;
    HashMap<Character, Integer> map = new HashMap<>();
    for(char ch: pattern.toCharArray()){
      map.put(ch, map.getOrDefault(ch,0)+1);
    }
    for(int wend =0; wend<str.length();wend++){
      char right = str.charAt(wend);
      if(map.containsKey(right)){
        map.put(right, map.get(right)-1);
        if(map.get(right)==0)
          matched++;
      } 
      if(matched == map.size()){
        return true;
      }
      if(wend >= pattern.length()-1){
        char left = str.charAt(ws++);
        if(map.containsKey(left)){
          if(map.get(left)==0)
          matched--;
          map.put(left, map.get(left) +1);
        }
      }
    }
    return false;
  }
}
