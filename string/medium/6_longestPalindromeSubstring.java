class Solution {

    static String palindrome(String str, int left, int right){
        if(left>right){
            return null;
        }

        // starting from center, checking outwards
        while(left>=0 && right<=str.length()-1 
            && str.charAt(left)==str.charAt(right)){

                left--;
                right++;
        }

        return str.substring(left+1,right);
    }
    public String longestPalindrome(String s) {
        
        String longest=s.substring(0,1);

        for(int i=0; i<s.length(); i++){
            // odd length, center is the same point
            String temp=palindrome(s,i,i);
            if(temp.length()>longest.length()){
                longest=temp;
            }

            //even length, center can not be a single point
            temp=palindrome(s,i,i+1);
            if(temp.length()>longest.length()){
                longest=temp;
            }
        }

        return longest;

    }
}