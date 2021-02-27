class Solution {
    public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
        if(numRows==0) return triangle;
    List<Integer> f_row= new ArrayList<>();
    f_row.add(1);
    triangle.add(f_row);
    for(int i=1;i<numRows;i++){
    List<Integer> prev_r = triangle.get(i-1); 
    List<Integer> row = new ArrayList<>(); 
        row.add(1);
    for(int j=1; j<i; j++){
        row.add(prev_r.get(j-1) + prev_r.get(j));
    }
     row.add(1);
     triangle.add(row);
    }
    return triangle;
    }
}