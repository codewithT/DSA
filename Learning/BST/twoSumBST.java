
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode rem = q.remove();
            if(search(root, k-rem.val, rem.val)){
                return true;
            }
            if(rem.left != null){
                q.offer(rem.left);
            }
            if(rem.right != null){
                q.offer(rem.right);
            }
        }
        return false;
    }
    public boolean search(TreeNode root, int compli, int pres){
        TreeNode cur = root;
        while(cur != null){
            if(cur.val != pres && cur.val == compli){
                return true;
            }
            if(cur.val> compli){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
         return false;
    }
   
}