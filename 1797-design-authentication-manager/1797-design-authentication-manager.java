class AuthenticationManager {

    
    HashMap<String,Integer>mp;
    int timeToLive;
    public AuthenticationManager(int timeToLive) {
        mp=new HashMap<>();
        this.timeToLive=timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        mp.put(tokenId,currentTime+timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(mp.containsKey(tokenId) && mp.get(tokenId)>currentTime)
        {
            mp.put(tokenId,currentTime+timeToLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count=0;
        for(Map.Entry<String,Integer>e:mp.entrySet())
        {
            int v=e.getValue();
            if(v>currentTime)
            {
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */