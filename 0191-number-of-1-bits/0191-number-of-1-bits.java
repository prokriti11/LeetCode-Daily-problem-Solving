class Solution{
  public int hammingWeight(int n){
    int hammingWeight = 0;
    while(n>0){
      hammingWeight += (n&1);
      n>>=1;
    }
    return hammingWeight;
  }
}