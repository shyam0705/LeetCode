class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    HashSet<String>hs=new HashSet<>();
        int n=words.length;
        for(int i=0;i<n;i++)
        {
            String s=words[i];
            String tmp="";
            for(int j=0;j<s.length();j++)
            {
                tmp=tmp+arr[s.charAt(j)-'a'];
            }
            hs.add(tmp);
        }
        return hs.size();
    }
}