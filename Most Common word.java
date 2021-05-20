class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban = new HashSet<>();
        for(String word: banned){
            ban.add(word);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: paragraph.replaceAll("[^a-zA-Z]"," ").toLowerCase().split(" ")){
            if(!ban.contains(word)){
                map.put(word, map.getOrDefault(word,0) +1);
            }
        }
        String s = "";
        for(String word: map.keySet()){
            if(s.equals("") || map.get(word)>map.get(s) ){
                s = word;
            }
        }
        return s;
    }
}