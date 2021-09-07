//Input: words = ["w","wo","wor","worl","world"]
//Output: "world
class Solution{

	public static List<String> Longest(List<String> words, String str){
		List<String> result = new ArrayList<>();
		Collections.sort(words,(a ,b)-> b.length() - a.length());
		bfs(result, words, 0);
		return result;
	}
	public void bfs(List<String> result, List<String> words, int index, String str){
		if(index == str.length()){
			return ;
		}
		String cur = check(Str, words[index]);
		if(cur.length() == Str.length) bfs(result, words, index +1, cur);
		else {
			result.append(words[index]);
			bfs(result, words, index+1. cur);
		}

	}
	public String check(String Str, String word){
		char[] str1 = str.toCharArray();
		char[] str2 = word.toCharArray();
		int i =0, j=0;
		StringBuilder sb = new StringBuilder();
		while(i<str1.length() &&j<str2.length()){
			if(str1[i]==str2[j]){
				i++; 
				j++
			}
			else {
				sb.append(str1[i]);
				i++
			}
		}
		return j==str2.length()? sb.toString(): str;
	}
}