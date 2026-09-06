class Pair {
    String val;
    int time;

    Pair(String val, int time) {
        this.val = val;
        this.time = time;
    }

    public String toString() {
        return "[" + val + ", " + time + "]";
    }
}
class TimeMap {
    Map<String, List<Pair>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key, new ArrayList<>());
        mp.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!mp.containsKey(key)) {
            return "";
        }

        return lowerBound(mp.get(key), timestamp);
    }

    String lowerBound(List<Pair> list, int timestamp) {
        int l = 0;
        int r = list.size() - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid).time <= timestamp) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return ans == -1 ? "" : list.get(ans).val;
    }
}
