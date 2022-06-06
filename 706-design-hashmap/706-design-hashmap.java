class MyHashMap {

    int[] map;
    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map,-1);
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
     //   System.out.println(map[key]);
        if(map[key] != -1)
            return map[key];
        else
            return -1;
        
    }
    
    public void remove(int key) {
         if(map[key] != -1)
             map[key] = -1;
    }
}