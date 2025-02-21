/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    List<Integer> lis;
    public FindElements(TreeNode root) {
         
        root.val = 0;
        lis =new LinkedList<>();
        bfs( root , lis);
        
    }
    public void bfs(TreeNode root, List<Integer> lis  ){
        Queue<TreeNode> q = new LinkedList<>();
       
        q.offer(root);
        lis.add(root.val);
        while(q.size()> 0){
          
            for(int i =0;i<q.size();i++){
                  TreeNode rem = q.remove();
                  if(rem.left != null){
                    rem.left.val = 2 *(rem.val)+1;
                    lis.add(rem.left.val);
                    q.offer(rem.left);
                  }
                  if(rem.right != null){
                    rem.right.val = 2*(rem.val) +2;
                    lis.add(rem.right.val);
                    q.offer(rem.right);
                    
                  }
            }
        }
    }
    
    public boolean find(int target) {
        // System.out.println(lis);
        if(lis.contains(target)){
            return true;
        }
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */