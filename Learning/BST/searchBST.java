 
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        
        TreeNode cur = root;
        if(cur.val == val){
            return cur;
        }
        while(cur != null ){
            if(cur.val == val){
                return cur;
            }
            if(cur.val > val &&  cur.left != null){
                 cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        return null;
    }
}