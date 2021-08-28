class Solution {
    String createKey(List<Integer> needs) {
        String res = new String();
        for(Integer i : needs) {
            res+=Integer.toString(i)+"_";
        }
        //System.out.println(res);
        return res;
    }
    int findMinBuyCost(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<String, Integer> dp ) {
        String key = createKey(needs);
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        int maxPrice = 0, offerPrice = Integer.MAX_VALUE;
        for(int i = 0;i<price.size();i++) {
            maxPrice+= needs.get(i) * price.get(i);
        }
            for(int j = 0; j<special.size();j++) {
                boolean canAvailOffer = true;
                List<Integer> newNeed = new ArrayList<>();
                for(int k = 0;k<needs.size();k++) {
                    if(special.get(j).get(k) > needs.get(k)) {
                        canAvailOffer = false;
                        break;
                    } 
                    newNeed.add(needs.get(k) - special.get(j).get(k));
                }
                if(canAvailOffer) {
                    //for(int i=0; i<newNeed.size();i++) System.out.println(newNeed.get(i));
                    //System.out.println(" ");
                    offerPrice = Math.min(offerPrice, special.get(j).get(needs.size()) + findMinBuyCost(price, special, newNeed, dp));
                }
            }
        dp.put(key, Math.min(maxPrice, offerPrice));
        //System.out.println("key :" + key  + " value :" +  Math.min(maxPrice, offerPrice));
        return dp.get(key);
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<String, Integer> dp = new HashMap<>();
        return findMinBuyCost(price, special, needs, dp);
    }
}
