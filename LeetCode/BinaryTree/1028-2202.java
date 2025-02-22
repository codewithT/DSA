 

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        HashMap<Integer, List<TreeNode>> h = new HashMap<>();
        int i = 0;
        int num = 0;
        
        while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
            num = num * 10 + (traversal.charAt(i) - '0');
            i++;
        }

        TreeNode root = new TreeNode(num);
        h.put(0, new ArrayList<>());
        h.get(0).add(root);

        int prev = 0;
        
        while (i < traversal.length()) {
            int cnt = 0;
            
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                cnt++;
                i++;
            }

            num = 0;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                num = num * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode newNode = new TreeNode(num);
            h.putIfAbsent(cnt, new ArrayList<>());
            h.get(cnt).add(newNode);

            if (cnt > 0) {
                TreeNode cur = h.get(cnt - 1).get(h.get(cnt - 1).size() - 1);
                
                if (cur.left == null) {
                    cur.left = newNode;
                } else {
                    cur.right = newNode;
                }
            }
            
            prev = cnt;
        }

        return root;
    }

    

   
}
