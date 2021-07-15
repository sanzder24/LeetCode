// "there is an interview"
// "ereht si na weivretni"
public class solution {
	public static String find_string(String str)
	{
	String[] words = str.split(" ");
	String[] res = new String[words.length];
	for(int i=0; i<words.length; i++){
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<words[i].length(); j++){

			sb.append(words[i].charAt(j));
		}
		res[i] = sb.reverse().toString();
	}
	String result ="";
	for( int i=0; i<res.length; i++){
			result += res[i] + " ";
	}
	return result;
   }

	public static void main( String[] Args){

		String str = "there is an interview";
		String result = find_string(str);
		System.out.println(result);
	} 
}
