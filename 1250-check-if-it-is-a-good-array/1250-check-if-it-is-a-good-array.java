class Solution {
    public boolean isGoodArray(int[] nums) {
        int x = nums[0];
        int temp;

        for(int num : nums){
          while(num > 0){
            temp = x%num;
            x = num;
            num = temp;
          }
          if( x == 1) return true;
        }
        return false;
    }
}