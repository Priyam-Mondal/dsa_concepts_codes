/*Until the queue is not empty, store the node  and line no. in 2 separate variable .
Then check if that line is present in the map or not
If not present then store the line and the node->val to the map
Otherwise store the node->left and node->right along with there line nos. to the queue. */

import java.util.*;

class Pair{
    TreeNode node;
    int hd;
    Pair(){}
    Pair(TreeNode node, int hd){
        this.node=node;
        this.hd=hd;
    }
}
public class Solution {
    public static List<Integer> getTopView(TreeNode root) {
        
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        
        //map to store node horizontal distance and node val
        TreeMap<Integer,Integer> map=new TreeMap<>();

        Queue<Pair> q=new LinkedList<Pair>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode node=p.node;
            int hd=p.hd;

            //adding only first node val for each horizontal distance
            if(!map.containsKey(hd)){
                map.put(hd,node.data);
            }

            if(node.left!=null){
                //for left x axis will be decremented
                q.offer(new Pair(node.left, hd-1));
            }
            if(node.right!=null){
                //for left x axis will be incremented
                q.offer(new Pair(node.right, hd+1));
            }
        }

        //adding into ans
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
} 