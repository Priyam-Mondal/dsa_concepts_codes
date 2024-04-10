/*Example 1:

Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value 
8 is set on fire. 
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree. */



class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        if(root==null){
            return 0;
        }
        
        //create parent mapping
        HashMap<Node,Node> mpp=new HashMap<>();
        
        //create parent mapping 
        //also returning the target node pointer
        Node targetNode=mapParent(root,mpp,target);
        
        //find time
        int time=0;
        HashMap<Node,Integer> vis=new HashMap<>();
        
        Queue<Node> q=new LinkedList<>();
        q.offer(targetNode);
        vis.put(targetNode,1);
        
        while(!q.isEmpty()){
            
            boolean flag=false;
            int s=q.size();
            
            for(int i=0; i<s; i++){
                Node cur=q.poll();
                Node parent=mpp.get(cur);
                
                //burn parent
                if(vis.get(parent)==null && mpp.containsKey(cur)) {
                    flag=true;
                    q.offer(parent);
                    vis.put(parent,1);
                }
                
                //burn left child
                if(cur.left!=null && vis.get(cur.left)==null){
                    flag=true;
                    q.offer(cur.left);
                    vis.put(cur.left,1);
                }
                
                //burn right child
                if(cur.right!=null && vis.get(cur.right)==null){
                    flag=true;
                    q.offer(cur.right);
                    vis.put(cur.right,1);
                }
                
            }
            if(flag==true){
                time++;
            }
            
        }
        return time;
    }
    static Node mapParent(Node root, HashMap<Node,Node> mpp, int target){
        Queue<Node> q=new LinkedList<>();
        Node res=null;
        
        q.offer(root);
        while(!q.isEmpty()){
            Node t=q.poll();
            if(t.data==target){
                res=t;
            }
            if(t.left!=null){
                mpp.put(t.left,t);
                q.offer(t.left);
            }
            if(t.right!=null){
                mpp.put(t.right,t);
                q.offer(t.right);
            }
        }
        return res;
    }
}