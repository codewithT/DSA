class Solution {
    public int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        boolean[] used = new boolean[n + 1];  
        
        backtrack(res, used, 0, n);
        return res;
    }

    private boolean backtrack(int[] res, boolean[] used, int index, int n) {
        if (index == res.length) {
            return true;  
        }
        
        if (res[index] != -1) {
            return backtrack(res, used, index + 1, n); 
        }
      
        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;

            if (num == 1) {  
                res[index] = 1;
                used[1] = true;
                if (backtrack(res, used, index + 1, n)) return true;
                res[index] = -1;
                used[1] = false;
            } else {  
                int secondPos = index + num;
                if (secondPos < res.length && res[secondPos] == -1) {
                    res[index] = num;
                    res[secondPos] = num;
                    used[num] = true;

                    if (backtrack(res, used, index + 1, n)) return true;

                    
                    res[index] = -1;
                    res[secondPos] = -1;
                    used[num] = false;
                }
            }
        }
        return false;  
    }
}
