import java.util.ArrayList;
import java.util.List;

public class 1_GenerateBinaryStr {

    static void generate(String cur, int N, List<String> ans){
        if(cur.length()==N){
            ans.add(cur);
            return;
        }

        //adding 0 to cur
        generate(cur+"0", N, ans);

        //adding 1 if cur is empty or last character is not 1
        if(cur.length()==0 || cur.charAt(cur.length()-1)!='1'){
            generate(cur+"1", N, ans);
        }
    }
    public static List< String > generateString(int N) {
        List<String> ans=new ArrayList<>();
        generate("",N,ans);

        return ans;
    }
}
