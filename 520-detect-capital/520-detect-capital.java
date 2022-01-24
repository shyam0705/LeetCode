class Solution {
    public boolean detectCapitalUse(String word) {
        String tmp=word.toUpperCase();
        String tmp1=word.toLowerCase();
        String tmp3=word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase();
        // System.out.println(tmp3);
        if(word.equals(tmp) || word.equals(tmp1) || word.equals(tmp3))
        {
            return true;
        }
        return false;
    }
}