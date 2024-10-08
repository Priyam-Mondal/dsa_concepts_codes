public class 7_swap {
    static List<Integer> get(int a,int b)
    {
        List<Integer> ans=new ArrayList<>();
        int x=a^b;  //x = a^b
        int y=x^b;  //y = x^b 
                    //  = a^b^b
                    //y = a

        x^=y;       //x = x^y
                    //  = a^b^a
                    //x = b    
        
        ans.add(x);
        ans.add(y);
        return ans;
    }
}
