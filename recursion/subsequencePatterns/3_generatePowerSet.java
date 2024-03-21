import java.util.ArrayList;
import java.util.List;
public class Solution {

    static void generate(String cur, String s, int index, List<String> ans){
        if(index==s.length()){
            ans.add(cur);
            return;
        }

        //including current character
        generate(cur+s.charAt(index), s, index+1, ans);

        //excluding current character
        generate(cur, s, index+1, ans);

    }
    public static List<String> generateSubsequences(String s) {
        
        List<String> ans=new ArrayList<>();

        generate("", s, 0, ans);

        return ans;
    }
}