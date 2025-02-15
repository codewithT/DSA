class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        ArrayList<Integer> lis = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
             if(i+k< nums.length && i-k>=0){
                 if(nums[i+k] < nums[i] && nums[i-k] < nums[i]){
                     lis.add(nums[i]);
                 }
             }
            else if(i-k<0 && i+k <nums.length){
                if(nums[i+k] < nums[i]){
                    lis.add(nums[i]);
                }
            }
            else if(i+k>=nums.length && i-k>=0){
                if(nums[i-k] < nums[i]){
                    lis.add(nums[i]);
                }
            }
            else if(i+k>=nums.length && i-k <0){
                lis.add(nums[i]);
            }
        }
        int sum =0;
        for(int i = 0;i<lis.size();i++){
            sum+= lis.get(i);
        }
        return sum;
    }
}

