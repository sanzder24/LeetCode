class UndergroundSystem {

    Map<Integer,String[]> entry;
    Map<String,double[]> store;
	
    public UndergroundSystem() {
        entry = new HashMap<>();
        store = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        entry.put(id,new String[]{stationName,"" + t});
    }
    
    public void checkOut(int id, String stationName, int t) {
        String start = entry.get(id)[0];
        int check = Integer.parseInt(entry.get(id)[1]);
        String key = start + "-" + stationName;
        
        if(store.containsKey(key)){
            double temp[] = store.get(key);
            temp[0] += (double)(t - check);
            temp[1]++;
            store.put(key,temp);
        }else{
            store.put(key,new double[]{t-check,1});
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        return (double)(store.get(key)[0]/store.get(key)[1]);
    }
}
-------------------------------------------------------------------------
class UndergroundSystem2 {

    class Record {
        String stationName;
        int time;
        Record(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    class Average {
        int count;
        int sum;
    }

    private Map<Integer, Record> currentUsersMap;

    private Map<Pair<String, String>, Average> averageTimeMap;

    public UndergroundSystem() {
        this.currentUsersMap = new HashMap<>();
        this.averageTimeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Record record = new Record(stationName, t);
        currentUsersMap.put(id, record);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Record record = currentUsersMap.get(id);
        int duration = t - record.time;
        Pair<String, String> stations = new Pair<>(record.stationName, stationName);
        if (!averageTimeMap.containsKey(stations)) {
            averageTimeMap.put(stations, new Average());
        }
        Average average = averageTimeMap.get(stations);
        average.sum += duration;
        average.count++;
        currentUsersMap.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Average average = averageTimeMap.get(new Pair<>(startStation, endStation));
        return (double)average.sum / average.count;
    }
}
