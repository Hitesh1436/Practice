class FreqStack {
    int mf = 0;  // mf-> maximum frequency
    HashMap<Integer, Integer> fmap;
    HashMap<Integer, Stack<Integer>> data;
    
    public FreqStack() {
        mf = 0;
        fmap = new HashMap<>();
        data = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = fmap.getOrDefault(val, 0) + 1;
        fmap.put(val, freq);
        mf = Math.max(mf, freq);
        
        if(!data.containsKey(mf)){
            data.put(mf, new Stack<>());
        }
        data.get(freq).push(val);
    }
    
    public int pop() {
        int val = data.get(mf).pop();
        fmap.put(val, fmap.get(val) - 1);
        if(data.get(mf).size() == 0){
            mf--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */