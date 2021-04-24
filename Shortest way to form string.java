class solution {
	public int shortestWay(String source, String target){
		int numsub =0;
		String remaining = target;
		while(remaining.length()>0){
			StringBuilder sb = new StringBuilder();
			int i=0, j=0;
			while(i<source.length() && j< remaining.length()){
				if(source.charAt(i++) == remaining.charAt(j)){
					sb.append(remaining.charAt(j++));
				}
			}
			if(sb.length()==0){
				return -1;
			}
			numsub++;
			remaining=remaining.substring(sb.length());
		}
		return numsub;
	}
}