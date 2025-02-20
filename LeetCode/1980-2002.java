class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        Set<String> numSet = new HashSet<>();
        for(String e: nums){
            numSet.add(e);
        }
        solve(nums, set, 0,"" );
        // System.out.println(set);
        for(String e : set){
             if(!numSet.contains(e)){
                return e;
             }
        }
        return "";
    }
    public void solve(String[] nums, Set<String> set, int index, String res){
        if(res.length() == nums.length){
            set.add(res);
            return;
        }
        solve(nums,set, index+1, res + 1);
        solve(nums, set, index+1, res + 0);
    }
}