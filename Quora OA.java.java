class Solution{
	Public static String[] check(String[] a ){
	String[] result = new String[a.length];
	
	for(int i =0; i<a.length-1; i++){
		String current ="";
		current += a[i].charAt(0) + a[i+1].charAt(a[i+1].length-1);
		result[i]= current;
	}
	result[a.length-1] =a[a.length-1].charAt(0) + 
	return result;

}
}


public static int[] check ( int[] numbers ){
	Boolean deleted = false;
	int[] result= new int[numbers.length];
	int i =0, k=0;
	while(i==0 || deleted==true){
		deleted = false;
		for(; i<numbers.length; i++){
			Boolean pre = false;
			Boolean pos = false;
			if(i==0 || numbers[i]>numbers[i-1]){
				pre = true;
			}
			if(i==numbers.length-1 || numbers[i]>numbers[i+1]){
				pre = true;
			}
			if(pre && pos){
				result[k++]=numbers[i];
				numbers = delete(numbers, i);
				deleted = true;
			}

		}
		for(; i<numbers.length; i++){
			result[k++]= numbers[i];
		}
	}
	return result;
	
}

public static int[] delete(int[] arr,int index)
    {

        if (arr == null
            || index < 0
            || index >= arr.length) {
  
            return arr;
        }
        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        } 
        return anotherArray;
    }


public static long check(int[] a)
{
	HashSet<Integer> set = new HashSet<>();
	long m=0;
	for(int i =0; i<a.length; i++){
		int k = count(Integer.toBinaryString(a[i]));
		set.add(k);
		if(set.contains(k)){
			m++;
		}
	}
	return m;
}
public int count(String str){
	int k=0;
	for(int i=0; i<str.length(); i++){
		if(str.charAt(i)=='1'){
			k++;
		}
	}
	return k;
}