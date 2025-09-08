class Solution {
    public int[] getNoZeroIntegers(int n) {
       for(int i = 1; i<n; i++){
        int j=n-i;
        if(!String.vlueOf(i).contains("0") && !String.valueOf(j).contains("0")){
          retunr new int[]{i,j};
        }
       } 
       return new int[0];
    }
}