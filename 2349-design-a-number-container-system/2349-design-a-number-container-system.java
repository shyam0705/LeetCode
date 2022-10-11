class NumberContainers {

    HashMap<Integer,TreeSet<Integer>>num_indexes;
    HashMap<Integer,Integer>index_to_num;
    public NumberContainers() {
        num_indexes=new HashMap<>();
        index_to_num=new HashMap<>();
    }
    
    public void change(int index, int number) {
        
        if(index_to_num.containsKey(index))
        {
            int tmp=index_to_num.get(index);
            num_indexes.get(tmp).remove(index);
        }
        
        if(num_indexes.containsKey(number))
        {
            num_indexes.get(number).add(index);
        }
        else
        {
            TreeSet<Integer>tmp=new TreeSet<>();
            tmp.add(index);
            num_indexes.put(number,tmp);
        }
        
        index_to_num.put(index,number);
    }
    
    public int find(int number) 
    {
        if(num_indexes.containsKey(number) && num_indexes.get(number).size()>0)
            return num_indexes.get(number).first();
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */