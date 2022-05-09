class Solution {
    public void letter(String digits,int i,String current,List<String>ans,int n,String[] table)
    {
        if(i==n){
            ans.add(current);
            return;
        }
        int index=Character.getNumericValue(digits.charAt(i));
        String tmp=table[index];
        for(char c:tmp.toCharArray()){
            letter(digits,i+1,current+c,ans,n,table);
        }
        
        
    }
    public List<String> letterCombinations(String digits) {
        String[] table
            = { "0",   "1",   "abc",  "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String>ans=new ArrayList<>();
        if(digits.length()==0)
        {
            return ans;
        }
        letter(digits,0,"",ans,digits.length(),table);
        return ans;
    }
}