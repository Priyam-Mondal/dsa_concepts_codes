/*
 base case : number of closing parentheses == n

 add open "(" : openCount < n
 add close ")" : closedCount < openCount
  
 */



import java.util.* ;
import java.io.*; 
public class Solution {
    static void generate(String cur, int openCnt, int closedCnt, int n, List<String> ans){
        if(closedCnt==n){
            ans.add(cur);
            return;
        }

        //taking (
        if(openCnt<n){
            generate(cur+"(", openCnt+1, closedCnt, n, ans);
        }
       
        //taking )
        if(closedCnt<openCnt){
            generate(cur+")", openCnt, closedCnt+1, n, ans);
        }
       
    }
    public static ArrayList<String> validParenthesis(int n){
        ArrayList<String> ans=new ArrayList<>();

        int openCnt=0, closedCnt=0;

        generate("", openCnt, closedCnt, n, ans);

        return ans;
    } 
}