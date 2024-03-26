class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
class MyComparator implements Comparator<Node>{
    public int compare(Node a, Node b){
        if(a.data>=b.data)   return 1;
        else    return -1;
    }
}
class Solution {
    
    static void preOrder(Node root, String temp, ArrayList<String> ans){
        if(root.left==null && root.right==null){
            ans.add(temp);
            return;
        }
        preOrder(root.left, temp+"0", ans);
        preOrder(root.right, temp+"1", ans);
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        PriorityQueue<Node> pq=new PriorityQueue<Node>(new MyComparator());
        for(int i=0; i<N; i++){
            pq.add(new Node(f[i]));
        }
        
        while(pq.size() > 1){

            //pop two min nodes
            Node a=pq.poll();
            Node b=pq.poll();
            
            //add them
            Node newNode=new Node(a.data+b.data);
            newNode.left=a;
            newNode.right=b;
            
            //push back into pq
            pq.add(newNode);
            
        }
        Node root=pq.poll();
        
        ArrayList<String> ans=new ArrayList<>();
        String temp="";
        
        preOrder(root, temp, ans);
        
        return ans;
    }
}