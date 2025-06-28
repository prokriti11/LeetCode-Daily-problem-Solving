class Pair{
    int idx1 = 0;
    int idx2 = 0;
    int sum = 0;
    Pair(int idx1,int idx2,int sum)
    {
        this.idx1 = idx1;
        this.idx2 = idx2;
        this.sum = sum;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
       List<List<Integer>> result = new ArrayList<>();
       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.sum-b.sum);
       for(int i = 0;i<nums1.length;i++)
       {
           pq.offer(new Pair(i,0,nums1[i]+nums2[0]));
       }
       while(pq.size() > 0 && result.size() < k)
       {
           int i = pq.peek().idx1;
           int j = pq.peek().idx2;
           pq.remove();
           result.add(Arrays.asList(nums1[i],nums2[j]));
           if(j < nums2.length-1)
                pq.offer(new Pair(i,j+1,nums1[i]+nums2[j+1]));
       }
       return result; 
    }
}