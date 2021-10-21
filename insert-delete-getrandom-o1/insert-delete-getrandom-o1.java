class RandomizedSet {

    HashMap<Integer,Integer>mp;
    ArrayList<Integer>l;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        mp=new HashMap<>();
        l=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(mp.containsKey(val))
        {
            return false;
        }
        l.add(val);
        mp.put(val,l.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!mp.containsKey(val))
        {
            return false;
        }
        int index1=mp.get(val);
        if(index1<l.size()-1)
        {
            l.set(index1,l.get(l.size()-1));
            mp.put(l.get(l.size()-1),index1);
        }
        mp.remove(val);
        l.remove(l.size()-1);
        return true;
        
    }
    
    public int getRandom() {
       
        int index=rand.nextInt(l.size());
        return l.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */