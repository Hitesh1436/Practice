class FreqStack {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> map = new HashMap<>();
    int maxfreq = 0;

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        maxfreq = Math.max(maxfreq, f);
        if (!map.containsKey(f)){
             map.put(f, new Stack<Integer>());
        }
        map.get(f).add(x);
    }

    public int pop() {
        int x = map.get(maxfreq).pop();
        freq.put(x, maxfreq - 1);
        if (map.get(maxfreq).size() == 0){
             maxfreq--;
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */