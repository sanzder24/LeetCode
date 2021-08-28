Check if shuffled in order?

public boolean check( int[] elements){
	for(int i =0; i<elements.length; i++){
		int pre = i>0? i-1:elements.length-1; 
		int pos = i<elements.length-1? i+1:0;
		if(elements[i]+1 != elements[pos]) return false;
		if(elements[i]-1 != elements[pre]) return false;
	}
	return true;
}