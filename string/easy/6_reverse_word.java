/*Sample Input 1 :
Welcome to Coding Ninjas
Sample Output 1:
Ninjas Coding to Welcome */


class Solution {
    public String reverseWords(String str) {
        String[] arr = str.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].isEmpty()) {
                ans.append(arr[i]);
            }
            //if last word, dont append space
            if(i!=0){
               ans.append(" ");
            }
        }
        return ans.toString().trim();
    }
}

